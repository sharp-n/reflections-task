package org.example.vladtests;

import org.example.ConvertableTypes;
import org.example.ConvertableValueType;
import org.example.SetterUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SetterUtilImpl implements SetterUtil {
    @Override
    public boolean setValue(boolean value, Object targetObject, String propertyName) {
        if(targetObject==null||propertyName==null||propertyName.trim().length()==0){
            return false;
        }
        return invokeMethod(value,targetObject,propertyName,boolean.class);
    }

    @Override
    public boolean setValue(byte value, Object targetObject, String propertyName) {
        if(targetObject==null||propertyName==null||propertyName.trim().length()==0){
            return false;
        }
        return invokeMethod(value,targetObject,propertyName,byte.class);
    }

    @Override
    public boolean setValue(short value, Object targetObject, String propertyName) {
        if(targetObject==null||propertyName==null||propertyName.trim().length()==0){
            return false;
        }
        return invokeMethod(value,targetObject,propertyName,short.class);
    }

    @Override
    public boolean setValue(int value, Object targetObject, String propertyName) {
        if(targetObject==null||propertyName==null||propertyName.trim().length()==0){
            return false;
        }
        return invokeMethod(value,targetObject,propertyName,int.class);
    }

    @Override
    public boolean setValue(long value, Object targetObject, String propertyName) {
        if(targetObject == null || propertyName == null||propertyName.trim().length()==0){
            return false;
        }
        return invokeMethod(value,targetObject,propertyName,long.class);
    }

    @Override
    public boolean setValue(char value, Object targetObject, String propertyName) {
        if(targetObject==null||propertyName==null||propertyName.trim().length()==0){
            return false;
        }
        return invokeMethod(value,targetObject,propertyName,char.class);
    }

    @Override
    public boolean setValue(float value, Object targetObject, String propertyName) {
        if(targetObject==null||propertyName==null||propertyName.trim().length()==0){
            return false;
        }
        return invokeMethod(value,targetObject,propertyName,float.class);
    }

    @Override
    public boolean setValue(double value, Object targetObject, String propertyName) {
        if(targetObject==null||propertyName==null||propertyName.trim().length()==0){
            return false;
        }
        return invokeMethod(value,targetObject,propertyName,double.class);
    }

    @Override
    public boolean setValue(Object value, Object targetObject, String propertyName) {
        if(value==null||targetObject==null||propertyName==null||propertyName.trim().length()==0){
            return false;
        }
        return invokeMethodIfNotNull(value,targetObject,propertyName);
    }

    @Override
    public boolean setValue(Object value, Object targetObject, String propertyName, Class<?> valueType) {
        if(targetObject==null||propertyName==null||valueType==null||propertyName.trim().length()==0){
            return false;
        }
        return invokeMethod(value,targetObject,propertyName,valueType);
    }

    private Method getSetter(Object targetObject, String propertyName, Class<?> valueType){
        String methodName = "set" + Character.toString(propertyName.charAt(0)).toUpperCase()+propertyName.substring(1);
        List<Method> methods = Arrays.stream(targetObject.getClass().getMethods())
                .filter(method -> methodName.equals(method.getName())&& method.getParameterTypes().length == 1)
                .collect(Collectors.toList());

        Method method = null;
        Class<?> bufferValueType = valueType;
        while(method==null&&bufferValueType!=null){
            method = findMatches(valueType,methods);
            bufferValueType = bufferValueType.getSuperclass();
        }
        if(method == null&&valueType != null && !valueType.isPrimitive()) {
            ConvertableValueType type = findConvertableType(valueType, methods);
            if (type != null) {
                method = type.getMethod();
            }
        }
        return method;
    }

    private Method findMatches(Class<?> valueType, List<Method> methods){
        for (Method method : methods) {
            if (method.getParameterTypes()[0].equals(valueType)) {
                return method;
            }
        }
        if(ConvertableTypes.convertableTypesMap.containsKey(valueType)) {
            for (Class<?> classType : ConvertableTypes.convertableTypesMap.get(valueType)) {
                for (Method method : methods) {
                    if (classType.equals(method.getParameterTypes()[0])) {
                        return method;
                    }
                }
            }
        }
        return null;
    }

    private boolean invokeMethodIfNotNull(Object value, Object targetObject, String propertyName) {
        try {
            Method method = getSetter(targetObject,propertyName,value.getClass());
            if(method==null){
                return false;
            }
            method.invoke(targetObject, value);
            return true;
        } catch (InvocationTargetException | IllegalAccessException exception){
            return false;
        }
    }

    private Method getSetterIfValueIsNullAndPrimitive(Object targetObject, String propertyName, Class<?> valueType) {
        List<Class<?>> convertableTypes = ConvertableTypes.convertableTypesMap.get(valueType);
        for (Class<?> convertableType : convertableTypes) {
            if (!convertableType.isPrimitive()) {
                return getSetter(targetObject, propertyName, convertableType);
            }
        }
        return null;
    }

    private Method getSetterIfCanBeNull(Object value,Object targetObject, String propertyName, Class<?> valueType){
        if(value==null&&valueType.isPrimitive()) {
            return getSetterIfValueIsNullAndPrimitive(targetObject,propertyName,valueType);
        } else {
            return getSetter(targetObject, propertyName, valueType);
        }
    }

    private boolean invokeMethod(Object value, Object targetObject, String propertyName, Class<?> valueType) { // todo refactor this method
        Method method = getSetterIfCanBeNull(value,targetObject, propertyName, valueType);
        if (method == null || (value == null && method.getParameterTypes()[0].isPrimitive())) {
            return false;
        }
        return invokeSetter(method, targetObject, value, valueType);
    }

    private boolean invokeSetter(Method method, Object targetObject, Object value, Class<?> valueType ){
        try {
            boolean isInvoked = false;
            if (value != null) {
                if (valueType.isPrimitive() && method.getParameterTypes()[0].isPrimitive()) {
                    isInvoked = invokeMethodIfPrimitive(method, targetObject, value, method.getParameterTypes()[0]);
                } else if (valueType.isPrimitive() || method.getParameterTypes()[0].isPrimitive()) {
                    isInvoked = invokeMethodIfPrimitive(method, targetObject, value, valueType);
                }
            }
            if (!isInvoked) {
                method.invoke(targetObject, value); // todo refactor
            }
            return true;

        } catch (InvocationTargetException | IllegalAccessException exception){
            exception.printStackTrace();
            return false;
        }
    }

//    private boolean invokeSetterIfTheresInheritance(ConvertableValueType convertableValueType, Object targetObject, Object value) throws InvocationTargetException, IllegalAccessException {
//        convertableValueType.getMethod().invoke(targetObject,value);
//        return true;
//    }


    private boolean invokeMethodIfPrimitive(Method method, Object targetObject, Object value, Class<?> typeOfValue) throws InvocationTargetException, IllegalAccessException {
        if(typeOfValue.equals(byte.class)){
            method.invoke(targetObject,((Number)value).byteValue());
        } else if(typeOfValue.equals(short.class)){
            short shortValue = ((Number)value).shortValue();
            method.invoke(targetObject, shortValue);
        } else if(typeOfValue.equals(char.class)){
            if(method.getParameterTypes()[0].equals(Character.class)){
                method.invoke(targetObject, value);
            } else {
                char val = (char) value;
                method.invoke(targetObject, val);
            }
        } else if(typeOfValue.equals(int.class)){
            if(value.getClass().equals(Character.class)){
                method.invoke(targetObject,Character.digit((Character) value,10));
            } else {
                method.invoke(targetObject, ((Number) value).intValue());
            }
        } else if(typeOfValue.equals(long.class)){
            if(value.getClass().equals(Character.class)){
                method.invoke(targetObject,(long)Character.digit((Character) value,10));
            } else {
                method.invoke(targetObject, ((Number) value).longValue());
            }
        } else if(typeOfValue.equals(float.class)){
            if(value.getClass().equals(Character.class)){
                method.invoke(targetObject,(float)Character.digit((Character) value,10));
            } else {
                method.invoke(targetObject, ((Number) value).floatValue());
            }
        } else if(typeOfValue.equals(double.class)){
            if(value.getClass().equals(Character.class)){
                method.invoke(targetObject,(double)Character.digit((Character) value,10));
            } else {
                method.invoke(targetObject, ((Number) value).doubleValue());
            }
        } else {
            return false;
        }
        return true;
    }

    private ConvertableValueType findConvertableType(Class<?> typeOfValue, List<Method> methods){
        ConvertableValueType convertableParentClassType = findClassesHierarchy(typeOfValue, methods);
        ConvertableValueType convertableInterfaceType = findInterfacesHierarchy(typeOfValue,methods);
        return getTypeWithMinDistance(convertableInterfaceType,convertableParentClassType);
    }

    private ConvertableValueType findInterfacesHierarchy(Class<?> valueType, List<Method> methods){
        Method resultMethod = null;
        int collision = 0;
        int distance = 0;
        Class<?> [] interfaceType = valueType.getInterfaces();
        for (Method method : methods) {
            distance = 0;
            for(Class<?> typeOfInterface : interfaceType){
                distance++;
                if(method.getParameterTypes()[0].equals(typeOfInterface)){
                    collision++;
                    resultMethod = method;
                    valueType = typeOfInterface;
                } else{
                    for(Class<?> type : typeOfInterface.getInterfaces()){
                        ConvertableValueType foundType = findInterfacesHierarchy(type,methods);
                        if(foundType!=null){
                            return foundType;
                        }
                    }
                }
            }
        }
        if(collision==1){
            return new ConvertableValueType(valueType,distance,resultMethod);
        }
        return null;
    }

    private ConvertableValueType findClassesHierarchy(Class<?> valueType, List<Method> methods){
        List<Class<?>> superclasses = new ArrayList<>();
        Class<?> superclass = valueType;
        while(superclass != null) {
            superclass = superclass.getSuperclass();
            superclasses.add(superclass);
        }
        for (Class<?> superclassType: superclasses) {
            for (Method method : methods) {
                int distance = 0;
                distance++;
                if (method.getParameterTypes()[0].equals(superclassType)) {
                    return new ConvertableValueType(superclassType, distance, method);
                } else {
                    if(superclassType!=null) {
                        Class<?>[] interfaces = superclassType.getInterfaces();
                        for (Class<?> anInterface : interfaces) {
                            ConvertableValueType convertableValueType = findInterfacesHierarchy(anInterface,methods);
                            if (convertableValueType!=null){
                                convertableValueType.setDistance(distance+convertableValueType.getDistance());
                                return convertableValueType;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    private ConvertableValueType getTypeWithMinDistance(ConvertableValueType firstValue, ConvertableValueType secondValue){
        if(firstValue==secondValue){
            return null;
        }
        if(firstValue==null){
            return secondValue;
        }
        if(secondValue==null){
            return firstValue;
        }
        if(firstValue.getDistance()>secondValue.getDistance()){
            return firstValue;
        } else {
            return secondValue;
        }

    }

}