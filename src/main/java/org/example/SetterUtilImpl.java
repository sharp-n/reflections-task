package org.example;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SetterUtilImpl implements SetterUtil{
    @Override
    public boolean setValue(boolean value, Object targetObject, String propertyName) {
        return invokeMethod(value,targetObject,propertyName,boolean.class);
    }

    @Override
    public boolean setValue(byte value, Object targetObject, String propertyName) {
        return invokeMethod(value,targetObject,propertyName,byte.class);
    }

    @Override
    public boolean setValue(short value, Object targetObject, String propertyName) {
        return invokeMethod(value,targetObject,propertyName,short.class);
    }

    @Override
    public boolean setValue(int value, Object targetObject, String propertyName) {
        return invokeMethod(value,targetObject,propertyName,int.class);
    }

    @Override
    public boolean setValue(long value, Object targetObject, String propertyName) {
        return invokeMethod(value,targetObject,propertyName,long.class);
    }

    @Override
    public boolean setValue(char value, Object targetObject, String propertyName) {
        return invokeMethod(value,targetObject,propertyName,char.class);
    }

    @Override
    public boolean setValue(float value, Object targetObject, String propertyName) {
        return invokeMethod(value,targetObject,propertyName,float.class);
    }

    @Override
    public boolean setValue(double value, Object targetObject, String propertyName) {
        return invokeMethod(value,targetObject,propertyName,double.class);
    }

    @Override
    public boolean setValue(Object value, Object targetObject, String propertyName) {
        if (value!=null){
            return invokeMethod(value,targetObject,propertyName);
        }
        return false;
    }

    @Override
    public boolean setValue(Object value, Object targetObject, String propertyName, Class<?> valueType) {
        return invokeMethod(value,targetObject,propertyName,valueType);
    }

    private Method getSetter(Object targetObject, String propertyName, Class<?> valueType){
        String methodName = "set" + propertyName;
        List<Method> methods = Arrays.stream(targetObject.getClass().getMethods())
                .filter(method -> methodName.equals(method.getName())&& method.getParameterTypes().length == 1)
                .collect(Collectors.toList());
        for (Method method : methods) {
            if (method.getParameterTypes()[0].equals(valueType)) {
                return method;
            }
        }
        if(ConvertableTypes.convertableTypesMap.containsKey(valueType)){
            for(Class<?> classType : ConvertableTypes.convertableTypesMap.get(valueType)){
                for (Method method : methods){
                    if(classType.equals(method.getParameterTypes()[0])){
                        return method;
                    }
                }
            }
        }
        return null;
    }

    private boolean invokeMethod(Object value, Object targetObject, String propertyName) {
        try {
            Method method = getSetter(targetObject, propertyName, value.getClass());
            if(method==null){
                return false;
            }
            method.invoke(targetObject, value);
            return true;
        } catch (InvocationTargetException | IllegalAccessException exception){
            return false;
        }
    }

    private boolean invokeMethod(Object value, Object targetObject, String propertyName, Class<?> valueType) {
        try {
            Method method = getSetter(targetObject, propertyName, valueType);
            if(method==null){
                return false;
            }
            boolean isInvoked = false;

            if (valueType.isPrimitive()&&method.getParameterTypes()[0].isPrimitive()){
                isInvoked = invokeMethodIfPrimitive(method, targetObject,value,method.getParameterTypes()[0]);
            } else if(valueType.isPrimitive()){
                isInvoked = invokeMethodIfPrimitive(method, targetObject,value,valueType);
            }
            if (!isInvoked){
                method.invoke(targetObject, value); // todo refactor
            }
            return true;
        } catch (InvocationTargetException | IllegalAccessException exception){
            return false;
        }
    }

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
                method.invoke(targetObject, Character.digit((Character) value, 10));
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


}
