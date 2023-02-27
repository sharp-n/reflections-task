package org.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class MethodsHandler {

    private MethodsHandler(){}

    public static Method getMethod(Class<?> valueType) {
        Class<TestObject> testObjectClass = TestObject.class;
        List<Method> methods = Arrays.stream(testObjectClass.getMethods())
                .filter(method -> "setLongPrimitiveValue".equals(method.getName())&& method.getParameterTypes().length == 1)
                .collect(Collectors.toList());
        for (Method method : methods) {
            if (method.getParameterTypes()[0].equals(valueType)) {
                return method;
            }
        }
        if(ConvertableTypes.convertableTypes.containsKey(valueType)){
            for(Class<?> classType : ConvertableTypes.convertableTypes.get(valueType)){
                for (Method method : methods){
                    if(classType.equals(method.getParameterTypes()[0])){
                        return method;
                    }
                }
            }
        }
        return null;
    }

    public static TestObject invokeMethod(Class<?> classType, Object value) throws InvocationTargetException, IllegalAccessException {
        TestObject testObject = new TestObject();
        Method method = MethodsHandler.getMethod(classType);
        method.invoke(testObject,value);
        return testObject;
    }

    static TestObject setWithSetterMethod(Method method, int value) throws InvocationTargetException, IllegalAccessException {
        Class<?> classType = method.getParameterTypes()[0];
        TestObject testObject = new TestObject();
        if (int.class.equals(classType)) {
            method.invoke(testObject, (int) value);
        } else if (long.class.equals(classType)) {
            method.invoke(testObject, (long) value);
        } else if (byte.class.equals(classType)) {
            method.invoke(testObject, (byte) value);
        } else if (short.class.equals(classType)) {
            method.invoke(testObject, (short) value);
        } else if (char.class.equals(classType)) {
            method.invoke(testObject, (char) value);
        }
        return testObject;
    }

    static TestObject setWithSetterMethod(Method method, short value) throws InvocationTargetException, IllegalAccessException {
        Class<?> classType = method.getParameterTypes()[0];
        TestObject testObject = new TestObject();
        if (int.class.equals(classType)) {
            method.invoke(testObject, (int) value);
        } else if (long.class.equals(classType)) {
            method.invoke(testObject, (long) value);
        } else if (byte.class.equals(classType)) {
            method.invoke(testObject, (byte) value);
        } else if (short.class.equals(classType)) {
            method.invoke(testObject, (short) value);
        } else if (char.class.equals(classType)) {
            method.invoke(testObject, (char) value);
        }
        return testObject;
    }

    static TestObject setWithSetterMethod(Method method, byte value) throws InvocationTargetException, IllegalAccessException {
        Class<?> classType = method.getParameterTypes()[0];
        TestObject testObject = new TestObject();
        if (int.class.equals(classType)) {
            method.invoke(testObject, (int) value);
        } else if (long.class.equals(classType)) {
            method.invoke(testObject, (long) value);
        } else if (byte.class.equals(classType)) {
            method.invoke(testObject, (byte) value);
        } else if (short.class.equals(classType)) {
            method.invoke(testObject, (short) value);
        } else if (char.class.equals(classType)) {
            method.invoke(testObject, (char) value);
        }
        return testObject;
    }

    static TestObject setWithSetterMethod(Method method, char value) throws InvocationTargetException, IllegalAccessException {
        Class<?> classType = method.getParameterTypes()[0];
        TestObject testObject = new TestObject();
        if (int.class.equals(classType)) {
            method.invoke(testObject, (int) value);
        } else if (long.class.equals(classType)) {
            method.invoke(testObject, (long) value);
        } else if (byte.class.equals(classType)) {
            method.invoke(testObject, (byte) value);
        } else if (short.class.equals(classType)) {
            method.invoke(testObject, (short) value);
        } else if (char.class.equals(classType)) {
            method.invoke(testObject, (char) value);
        }
        return testObject;
    }

    static TestObject setWithSetterMethod(Method method, long value) throws InvocationTargetException, IllegalAccessException {

        Class<?> classType = method.getParameterTypes()[0];
        TestObject testObject = new TestObject();
        if (int.class.equals(classType)) {
            method.invoke(testObject, (int) value);
        } else if (long.class.equals(classType)) {
            method.invoke(testObject, (long) value);
        } else if (byte.class.equals(classType)) {
            method.invoke(testObject, (byte) value);
        } else if (short.class.equals(classType)) {
            method.invoke(testObject, (short) value);
        } else if (char.class.equals(classType)) {
            method.invoke(testObject, (char) value);
        }
//        switch (classType){
//            case int.class:
//                method.invoke(testObject, (int) value);
//                break;
//            case long.class:
//                method.invoke(testObject, (long) value);
//                break;
//            case byte.class:
//                method.invoke(testObject, (byte) value);
//                break;
//            case short.class:
//                method.invoke(testObject, (short) value);
//                break;
//            case char.class:
//                method.invoke(testObject, (char) value);
//                break;
//        }
        return testObject;
    }

}
