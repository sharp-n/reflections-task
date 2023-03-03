package org.example;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class SetValueTest {

    SetterUtil setterUtil = new SetterUtilImpl();


    @Test
    void test(){
        SetterUtil setterUtil = new SetterUtilImpl();
        int i = 10;
        TestObject testObject = new TestObject();
        System.out.println(setterUtil.setValue(i,testObject,"LongPrimitiveValue"));
        System.out.println(testObject.getRegisteredType());
    }

    @Test
    void setIntPrimitiveValueTest(){
        int intValue = 10;
        TestObject testObject = new TestObject();
        Class<?> expectedTypeOfValue = getExpectedTypeOfValue(int.class);
        printMessage(expectedTypeOfValue,testObject);
        if(expectedTypeOfValue!=null) {
            Assertions.assertTrue(setterUtil.setValue(intValue, testObject, "LongPrimitiveValue"));
        }
        Assertions.assertEquals(expectedTypeOfValue, testObject.getRegisteredType());
    }

    void printMessage(Class<?> expectedTypeOfValue, TestObject testObject){
        if(expectedTypeOfValue!=null) {
            System.out.println(
                    "Expected: " + expectedTypeOfValue.getName() +
                            " Provided: " + testObject.getRegisteredType());
        } else {
            System.out.println(
                    "Expected: " + null +
                            " Provided: " + testObject.getRegisteredType());
        }
    }

    @Test
    void setShortPrimitiveValueTest(){
        short shortValue = 10;
        TestObject testObject = new TestObject();
        Class<?> expectedTypeOfValue = getExpectedTypeOfValue(short.class);
        printMessage(expectedTypeOfValue,testObject);
        if(expectedTypeOfValue!=null) {
            Assertions.assertTrue(setterUtil.setValue(shortValue, testObject, "LongPrimitiveValue"));
        }
        Assertions.assertEquals(expectedTypeOfValue, testObject.getRegisteredType());
    }

    @Test
    void setCharPrimitiveValueTest(){
        char charValue = 10;
        TestObject testObject = new TestObject();
        Class<?> expectedTypeOfValue = getExpectedTypeOfValue(char.class);
        printMessage(expectedTypeOfValue,testObject);
        if(expectedTypeOfValue!=null) {
            Assertions.assertTrue(setterUtil.setValue(charValue, testObject, "LongPrimitiveValue"));
        }
        Assertions.assertEquals(expectedTypeOfValue, testObject.getRegisteredType());
    }

    @Test
    void setLongPrimitiveValueTest(){
        long longValue = 10;
        TestObject testObject = new TestObject();
        Class<?> expectedTypeOfValue = getExpectedTypeOfValue(long.class);
        printMessage(expectedTypeOfValue,testObject);
        if(expectedTypeOfValue!=null) {
            Assertions.assertTrue(setterUtil.setValue(longValue, testObject, "LongPrimitiveValue"));
        }
        Assertions.assertEquals(expectedTypeOfValue, testObject.getRegisteredType());
    }
    @Test
    void setFloatPrimitiveValueTest(){
        float value = 10;
        TestObject testObject = new TestObject();
        Class<?> expectedTypeOfValue = getExpectedTypeOfValue(float.class);
        printMessage(expectedTypeOfValue,testObject);
        if(expectedTypeOfValue!=null) {
            Assertions.assertTrue(setterUtil.setValue(value, testObject, "LongPrimitiveValue"));
        }
        Assertions.assertEquals(expectedTypeOfValue, testObject.getRegisteredType());
    }
    @Test
    void setDoublePrimitiveValueTest(){
        double value = 10;
        TestObject testObject = new TestObject();
        Class<?> expectedTypeOfValue = getExpectedTypeOfValue(double.class);
        printMessage(expectedTypeOfValue,testObject);
        if(expectedTypeOfValue!=null) {
            Assertions.assertTrue(setterUtil.setValue(value, testObject, "LongPrimitiveValue"));
        }
        Assertions.assertEquals(expectedTypeOfValue, testObject.getRegisteredType());
    }
    @Test
    void setBooleanPrimitiveValueTest(){
        boolean value = true; // todo add boolean to convertable types
        TestObject testObject = new TestObject();

        Class<?> expectedTypeOfValue = getExpectedTypeOfValue(boolean.class);
        printMessage(expectedTypeOfValue, testObject);
        if(expectedTypeOfValue!=null) {
            Assertions.assertTrue(setterUtil.setValue(value, testObject, "LongPrimitiveValue"));
        }
        Assertions.assertEquals(expectedTypeOfValue, testObject.getRegisteredType());

    }

    @ParameterizedTest
    @MethodSource("provideObjectsAndTypes")
    void setObjectValueTest(Object object, Class<?> typeOfValue) {
        TestObject testObject = new TestObject();
        setterUtil.setValue(object, testObject, "LongPrimitiveValue");
        Class<?> expectedTypeOfValue = getExpectedTypeOfValue(typeOfValue);
        Assertions.assertEquals(expectedTypeOfValue, testObject.getRegisteredType());
        printMessage(expectedTypeOfValue, testObject);
        printMessage(null,testObject);
    }

    private static Stream<Arguments> provideObjectsAndTypes() {
        return Stream.of(
                Arguments.of(true, Boolean.class),
                Arguments.of((byte) 3, Byte.class),
                Arguments.of((short) 4, Short.class),
                Arguments.of((char) 5, Character.class),
                Arguments.of(6, Integer.class),
                Arguments.of((long) 7, Long.class),
                Arguments.of((float) 8, Float.class),
                Arguments.of((double) 9, Double.class)
        );
    }

    @ParameterizedTest
    @MethodSource("provideNullObjectsAndTypes")
    void setNullObjectTest(Class<?> typeOfValue){
        TestObject testObject = new TestObject();
        setterUtil.setValue(null, testObject, "LongPrimitiveValue", typeOfValue);
        Class<?> expectedTypeOfValue = getExpectedTypeOfValue(typeOfValue);
        printMessage(expectedTypeOfValue, testObject);
        Assertions.assertEquals(expectedTypeOfValue,testObject.getRegisteredType());
    }

    private static @NotNull Stream<Arguments> provideNullObjectsAndTypes() {
        return Stream.of(
                Arguments.of(Boolean.class),
                Arguments.of(Byte.class),
                Arguments.of(Short.class),
                Arguments.of(Character.class),
                Arguments.of(Integer.class),
                Arguments.of(Long.class),
                Arguments.of(Float.class),
                Arguments.of(Double.class),
                Arguments.of(Object.class),
                Arguments.of(Number.class)
        );
    }

    Class<?> getExpectedTypeOfValue(Class<?> valueType){

        String methodName = "setLongPrimitiveValue";
        List<Method> methods = Arrays.stream(TestObject.class.getMethods())
                .filter(method -> methodName.equals(method.getName())&& method.getParameterTypes().length == 1)
                .collect(Collectors.toList());
        for (Method method : methods) {
            if (method.getParameterTypes()[0].equals(valueType)) {
                return method.getParameterTypes()[0];
            }
        }
        if(ConvertableTypes.convertableTypesMap.containsKey(valueType)){
            for(Class<?> classType : ConvertableTypes.convertableTypesMap.get(valueType)){
                for (Method method : methods){
                    if(classType.equals(method.getParameterTypes()[0])){
                        return method.getParameterTypes()[0];
                    }
                }
            }
        }
        return null;
    }


}
