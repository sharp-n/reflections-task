package org.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class MethodsHandler {

    private MethodsHandler(){}

    public static Method getMethod(String methodName, Class<?> classForMethodSearching, Class<?> valueType) {
//        Class<TestObject> testObjectClass = TestObject.class;
        List<Method> methods = Arrays.stream(classForMethodSearching.getMethods())
                .filter(method -> methodName.equals(method.getName())&& method.getParameterTypes().length == 1)
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

//    public static TestObject invokeMethod(Class<?> classType, Object value) throws InvocationTargetException, IllegalAccessException {
//        TestObject testObject = new TestObject();
//        Method method = MethodsHandler.getMethod(classType);
//        method.invoke(testObject,value);
//        return testObject;
//    }

    static Object setWithSetterMethod(Object object, Method method, int value) throws InvocationTargetException, IllegalAccessException {
        Class<?> classType = method.getParameterTypes()[0];
        if (int.class.equals(classType)) {
            method.invoke(object, value);
        } else if (long.class.equals(classType)) {
            method.invoke(object, (long) value);
        } else if (byte.class.equals(classType)) {
            method.invoke(object, (byte) value);
        } else if (short.class.equals(classType)) {
            method.invoke(object, (short) value);
        } else if (char.class.equals(classType)) {
            method.invoke(object, (char) value);
        } else if (float.class.equals(classType)) {
            method.invoke(object, (float) value);
        } else if (double.class.equals(classType)) {
            method.invoke(object, (double) value);
        }
        return object;
    }

    static Object setWithSetterMethod(Object object, Method method, short value) throws InvocationTargetException, IllegalAccessException {
        Class<?> classType = method.getParameterTypes()[0];
        if (int.class.equals(classType)) {
            method.invoke(object, (int) value);
        } else if (long.class.equals(classType)) {
            method.invoke(object, (long) value);
        } else if (byte.class.equals(classType)) {
            method.invoke(object, (byte) value);
        } else if (short.class.equals(classType)) {
            method.invoke(object, value);
        } else if (char.class.equals(classType)) {
            method.invoke(object, (char) value);
        } else if (float.class.equals(classType)) {
            method.invoke(object, (float) value);
        } else if (double.class.equals(classType)) {
            method.invoke(object, (double) value);
        }
        return object;
    }

    static Object setWithSetterMethod(Object object,Method method, byte value) throws InvocationTargetException, IllegalAccessException {
        Class<?> classType = method.getParameterTypes()[0];
        if (int.class.equals(classType)) {
            method.invoke(object, (int) value);
        } else if (long.class.equals(classType)) {
            method.invoke(object, (long) value);
        } else if (byte.class.equals(classType)) {
            method.invoke(object, value);
        } else if (short.class.equals(classType)) {
            method.invoke(object, (short) value);
        } else if (char.class.equals(classType)) {
            method.invoke(object, (char) value);
        } else if (float.class.equals(classType)) {
            method.invoke(object, (float) value);
        } else if (double.class.equals(classType)) {
            method.invoke(object, (double) value);
        }
        return object;
    }

    static Object setWithSetterMethod(Object object, Method method, char value) throws InvocationTargetException, IllegalAccessException {
        Class<?> classType = method.getParameterTypes()[0];
        if (int.class.equals(classType)) {
            method.invoke(object, (int) value);
        } else if (long.class.equals(classType)) {
            method.invoke(object, (long) value);
        } else if (byte.class.equals(classType)) {
            method.invoke(object, (byte) value);
        } else if (short.class.equals(classType)) {
            method.invoke(object, (short) value);
        } else if (char.class.equals(classType)) {
            method.invoke(object, value);
        } else if (float.class.equals(classType)) {
            method.invoke(object, (float) value);
        } else if (double.class.equals(classType)) {
            method.invoke(object, (double) value);
        }
        return object;
    }

    static Object setWithSetterMethod(Object object, Method method, long value) throws InvocationTargetException, IllegalAccessException {

        Class<?> classType = method.getParameterTypes()[0];
        if (int.class.equals(classType)) {
            method.invoke(object, (int) value);
        } else if (long.class.equals(classType)) {
            method.invoke(object, value);
        } else if (byte.class.equals(classType)) {
            method.invoke(object, (byte) value);
        } else if (short.class.equals(classType)) {
            method.invoke(object, (short) value);
        } else if (char.class.equals(classType)) {
            method.invoke(object, (char) value);
        } else if (float.class.equals(classType)) {
            method.invoke(object, (float) value);
        } else if (double.class.equals(classType)) {
            method.invoke(object, (double) value);
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
        return object;
    }

    static Object setWithSetterMethod(Object object, Method method, float value) throws InvocationTargetException, IllegalAccessException {
        Class<?> classType = method.getParameterTypes()[0];
        if (int.class.equals(classType)) {
            method.invoke(object, (int) value);
        } else if (long.class.equals(classType)) {
            method.invoke(object, (long) value);
        } else if (byte.class.equals(classType)) {
            method.invoke(object, (byte) value);
        } else if (short.class.equals(classType)) {
            method.invoke(object, (short) value);
        } else if (char.class.equals(classType)) {
            method.invoke(object, (char) value);
        } else if (float.class.equals(classType)) {
            method.invoke(object, value);
        } else if (double.class.equals(classType)) {
            method.invoke(object, (double) value);
        }
        return object;
    }

    static Object setWithSetterMethod(Object object, Method method, double value) throws InvocationTargetException, IllegalAccessException {
        Class<?> classType = method.getParameterTypes()[0];
        if (int.class.equals(classType)) {
            method.invoke(object, (int) value);
        } else if (long.class.equals(classType)) {
            method.invoke(object, (long) value);
        } else if (byte.class.equals(classType)) {
            method.invoke(object, (byte) value);
        } else if (short.class.equals(classType)) {
            method.invoke(object, (short) value);
        } else if (char.class.equals(classType)) {
            method.invoke(object, (char) value);
        } else if (float.class.equals(classType)) {
            method.invoke(object, (float) value);
        } else if (double.class.equals(classType)) {
            method.invoke(object, value);
        }
        return object;
    }

}
