package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Stream;
import java.lang.Integer;

class ReflectionTest {

    private final String METHOD_NAME = "setLongPrimitiveValue";

    private final Class<TestObject> CLASS_FOR_METHOD_SEARCHING = TestObject.class;

    @Test
    void valueIntPrimitiveTest() throws InvocationTargetException, IllegalAccessException {
        Method method = MethodsHandler.getMethod(METHOD_NAME,CLASS_FOR_METHOD_SEARCHING,int.class);
        Method expectedMethod = getMethodForTests(int.class);
        if (method!=null&&expectedMethod!=null){
            int value = 52;
            TestObject testObject = new TestObject();
            if(method.getParameterTypes()[0].isPrimitive()) {
                testObject = (TestObject) MethodsHandler.setWithSetterMethod(new TestObject(),method, value);
            } else{
                method.invoke(testObject,value);
            }
            Assertions.assertEquals(value, testObject.getLongPrimitiveValue());
            Assertions.assertEquals(expectedMethod.getParameterTypes()[0],testObject.getRegisteredType());
        } else {
            Assertions.assertEquals(expectedMethod,method);
        }
    }



    @Test
    void valueLongPrimitiveTest() throws InvocationTargetException, IllegalAccessException {
        Method method = MethodsHandler.getMethod(METHOD_NAME,CLASS_FOR_METHOD_SEARCHING,long.class);
        Method expectedMethod = getMethodForTests(long.class);
        if (method!=null&&expectedMethod!=null) {
            System.out.println("Type: long "
                    + " Expected: " + expectedMethod.getParameterTypes()[0]
                    + " Provided: " + method.getParameterTypes()[0]);
            long value = 12L;
            TestObject testObject = new TestObject();
            if(method.getParameterTypes()[0].isPrimitive()){
                testObject = (TestObject) MethodsHandler.setWithSetterMethod(new TestObject(),method, value);
            } else{
                method.invoke(testObject,value);
            }

            Assertions.assertEquals(value, testObject.getLongPrimitiveValue());
            Assertions.assertEquals(expectedMethod.getParameterTypes()[0],testObject.getRegisteredType());
        } else {
            Assertions.assertEquals(expectedMethod,method);
        }
    }

    @Test
    void valueCharPrimitiveTest() throws InvocationTargetException, IllegalAccessException {
        Method method = MethodsHandler.getMethod(METHOD_NAME,CLASS_FOR_METHOD_SEARCHING,char.class);
        Method expectedMethod = getMethodForTests(char.class);
        if (method!=null&&expectedMethod!=null){
            char [] values = {1, '5', 'e'};
            for (char value : values) {
                System.out.println("Type: char "
                        + " Expected: " + expectedMethod.getParameterTypes()[0]
                        + " Provided: " + method.getParameterTypes()[0]);
                TestObject testObject = new TestObject();
                if(method.getParameterTypes()[0].isPrimitive()) {
                     testObject = (TestObject) MethodsHandler.setWithSetterMethod(new TestObject(),method, value);
                } else {
                    method.invoke(testObject,value);
                }
                Assertions.assertEquals(value,testObject.getLongPrimitiveValue());
                Assertions.assertEquals(expectedMethod.getParameterTypes()[0],testObject.getRegisteredType());
            }
        } else {
            Assertions.assertEquals(expectedMethod,method);
        }
    }

    @Test
    void valueBytePrimitiveTest() throws InvocationTargetException, IllegalAccessException {
        Method method = MethodsHandler.getMethod(METHOD_NAME,CLASS_FOR_METHOD_SEARCHING,byte.class);
        Method expectedMethod = getMethodForTests(byte.class);
        if (method!=null&&expectedMethod!=null){
            byte [] values = {1, '5', 'e',Byte.parseByte("19")};
            for (byte value : values) {
                TestObject testObject = new TestObject();
                if(method.getParameterTypes()[0].isPrimitive()) {
                    testObject = (TestObject) MethodsHandler.setWithSetterMethod(new TestObject(),method, value);
                } else {
                    method.invoke(testObject,value);
                }
                Assertions.assertEquals(value,testObject.getLongPrimitiveValue());
                Assertions.assertEquals(expectedMethod.getParameterTypes()[0],testObject.getRegisteredType());
            }
        } else {
            Assertions.assertEquals(expectedMethod,method);
        }
    }

    @Test
    void valueFloatPrimitiveTest() throws InvocationTargetException, IllegalAccessException {
        Method method = MethodsHandler.getMethod(METHOD_NAME,CLASS_FOR_METHOD_SEARCHING,float.class);
        Method expectedMethod = getMethodForTests(float.class);
        if (method!=null&&expectedMethod!=null){
            float [] values = {Float.intBitsToFloat(34), 35};
            for (float value : values) {
                TestObject testObject = new TestObject();
                if(method.getParameterTypes()[0].isPrimitive()) {
                    testObject = (TestObject) MethodsHandler.setWithSetterMethod(new TestObject(),method, value);
                } else {
                    method.invoke(testObject,value);
                }
                Assertions.assertEquals((long)value,testObject.getLongPrimitiveValue());
                Assertions.assertEquals(expectedMethod.getParameterTypes()[0],testObject.getRegisteredType());
            }
        } else {
            Assertions.assertEquals(expectedMethod,method);
        }
    }

    @Test
    void valueDoublePrimitiveTest() throws InvocationTargetException, IllegalAccessException {
        Method method = MethodsHandler.getMethod(METHOD_NAME,CLASS_FOR_METHOD_SEARCHING,double.class);
        Method expectedMethod = getMethodForTests(double.class);
        if (method!=null&&expectedMethod!=null){
            double [] values = {45.56, 1234.23, 34};
            for (double value : values) {
                TestObject testObject = new TestObject();
                if(method.getParameterTypes()[0].isPrimitive()) {
                    testObject = (TestObject) MethodsHandler.setWithSetterMethod(new TestObject(),method, value);
                } else {
                    method.invoke(testObject,value);
                }
                Assertions.assertEquals((long)value,testObject.getLongPrimitiveValue());
                Assertions.assertEquals(expectedMethod.getParameterTypes()[0],testObject.getRegisteredType());
            }
        } else {
            Assertions.assertEquals(expectedMethod,method);
        }
    }

    @Test
    void valueShortPrimitiveTest() throws InvocationTargetException, IllegalAccessException {
        Method method = MethodsHandler.getMethod(METHOD_NAME,CLASS_FOR_METHOD_SEARCHING,short.class);
        Method expectedMethod = getMethodForTests(short.class);
        if (method!=null&&expectedMethod!=null){
            short [] values = {1, '5', 'e',Short.parseShort("19")};
            for (short value : values) {
                TestObject testObject = new TestObject();
                if(method.getParameterTypes()[0].isPrimitive()) {
                    testObject = (TestObject) MethodsHandler.setWithSetterMethod(new TestObject(),method, value);
                } else {
                    method.invoke(testObject,value);
                }
                Assertions.assertEquals(value,testObject.getLongPrimitiveValue());
                Assertions.assertEquals(expectedMethod.getParameterTypes()[0],testObject.getRegisteredType());
            }
        } else {
            Assertions.assertEquals(expectedMethod,method);
        }
    }

    @ParameterizedTest
    @MethodSource("provideObjects")
    void valueObjectTest(Object object) throws InvocationTargetException, IllegalAccessException {
        Method method = MethodsHandler.getMethod(METHOD_NAME,CLASS_FOR_METHOD_SEARCHING,object.getClass());
        Method expectedMethod = getMethodForTests(object.getClass());
        if(expectedMethod!=null&&method!=null) {
            TestObject testObject = new TestObject();
            method.invoke(testObject, object);
            Assertions.assertEquals(getObjectHashCode(object), getObjectHashCode(testObject.getLongPrimitiveValue()));
            Assertions.assertEquals(expectedMethod.getParameterTypes()[0],testObject.getRegisteredType());
        }else {
            Assertions.assertEquals(expectedMethod,method);
        }
    }

    private static Stream<Arguments> provideObjects() {
        return Stream.of(
                Arguments.of(1),
                Arguments.of(22L),
                Arguments.of(Byte.parseByte("34")),
                Arguments.of('m'),
                Arguments.of(Short.parseShort("8")),
//                Arguments.of("9092"),
                Arguments.of((Object) 679)
        );
    }

    int getObjectHashCode(Object object){
        if (object instanceof String){
            return Integer.parseInt((String) object);
        }
        return object.hashCode();
    }

    @ParameterizedTest
    @MethodSource("provideCLassTypes")
    void methodsHandlerTest(Class<?> classType){
        Method provided = MethodsHandler.getMethod(METHOD_NAME,CLASS_FOR_METHOD_SEARCHING,classType);
        Method method = getMethodForTests(classType);
        if(method!=null){
            System.out.println("СlassType: " + classType.getName() + " Expected: " + method.getParameterTypes()[0] + " Provided: " + method.getParameterTypes()[0]);
        } else if(provided==null){
            System.out.println("СlassType: " + classType.getName() + " Expected: null Provided: null");
        }
        Assertions.assertEquals(method, provided);
    }

    Method getMethodForTests(Class<?> classType){
        Method [] methods = TestObject.class.getMethods();
        for (Method method : methods) {
            if ("setLongPrimitiveValue".equals(method.getName())
                    &&method.getParameterTypes()[0].equals(classType)) {
                return method;
            }
        }
        if(ConvertableTypes.convertableTypes.containsKey(classType)){
            for(Class<?> classTypeForSearching : ConvertableTypes.convertableTypes.get(classType)){
                for(Method method : methods){
                    if("setLongPrimitiveValue".equals(method.getName())
                            && classTypeForSearching.equals(method.getParameterTypes()[0])){
                        return method;
                    }
                }
            }
        }
        return null;
    }

    private static Stream<Arguments> provideCLassTypes() {
        return Stream.of(
                Arguments.of(int.class),
                Arguments.of(long.class),
                Arguments.of(byte.class),
                Arguments.of(short.class),
                Arguments.of(char.class),
                Arguments.of(double.class),
                Arguments.of(float.class),
                Arguments.of(Integer.class),
                Arguments.of(Long.class),
                Arguments.of(Short.class),
                Arguments.of(Byte.class),
                Arguments.of(Character.class),
                Arguments.of(Float.class),
                Arguments.of(Double.class),
                Arguments.of(Object.class)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCLassTypes")
    void parametersNumberMethodsHandlerTest(Class<?> classType){
        Method method = MethodsHandler.getMethod(METHOD_NAME,CLASS_FOR_METHOD_SEARCHING,classType);
        Method expected = getMethodForTests(classType);
        if(method!=null&&expected!=null){
            Assertions.assertEquals(expected.getParameterTypes().length, method.getParameterTypes().length);
        }
    }

}
