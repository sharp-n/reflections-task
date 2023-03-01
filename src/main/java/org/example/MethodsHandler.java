package org.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class MethodsHandler {

    private MethodsHandler(){}

    public static Method getMethod(Class<?> classForMethodSearching, String methodName, Class<?> valueType) {
        List<Method> methods = Arrays.stream(classForMethodSearching.getMethods())
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

    static Object invokeMethodWithOnePrimitiveParameter(Method method, Object object, int value) throws InvocationTargetException, IllegalAccessException {
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

    static Object invokeMethodWithOnePrimitiveParameter(Method method, Object object, short value) throws InvocationTargetException, IllegalAccessException {
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

    static Object invokeMethodWithOnePrimitiveParameter(Method method, Object object, byte value) throws InvocationTargetException, IllegalAccessException {
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

    static Object invokeMethodWithOnePrimitiveParameter(Method method, Object object, char value) throws InvocationTargetException, IllegalAccessException {
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

    static Object invokeMethodWithOnePrimitiveParameter(Method method, Object object, long value) throws InvocationTargetException, IllegalAccessException {

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

    static Object invokeMethodWithOnePrimitiveParameter(Method method, Object object, float value) throws InvocationTargetException, IllegalAccessException {
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

    static Object invokeMethodWithOnePrimitiveParameter(Method method, Object object, double value) throws InvocationTargetException, IllegalAccessException {
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

    static Object invokeMethodWithOnePrimitiveParameter(Method method, Object object, String value) throws InvocationTargetException, IllegalAccessException {
        try {
            Class<?> classType = method.getParameterTypes()[0];
            if (Integer.class.equals(classType)) {
                method.invoke(object, Integer.parseInt(value));
            } else if (Long.class.equals(classType)) {
                method.invoke(object, Long.parseLong(value));
            } else if (Byte.class.equals(classType)) {
                method.invoke(object, Byte.parseByte(value));
            } else if (Short.class.equals(classType)) {
                method.invoke(object, Short.parseShort(value));
            } else if (Character.class.equals(classType)) {
                method.invoke(object, Character.forDigit(Integer.parseInt(value), 10));
            } else if (Float.class.equals(classType)) {
                method.invoke(object, Float.parseFloat(value));
            } else if (Double.class.equals(classType)) {
                method.invoke(object, Double.parseDouble(value));
            }
            return object;
        } catch (NumberFormatException numberFormatException){
            return object;
        }
    }

}
