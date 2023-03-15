package org.example.mytests;

import org.example.*;
import org.example.classes_for_hierarchy_tests.*;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class SetValueTest {

    SetterUtil setterUtil = new SetterUtilImpl();

    private static TestCaseClassWithoutPrimitives nullTestObject = null;

//    @Test
//    void test(){
//        SetterUtil setterUtil = new SetterUtilImpl();
//        int i = 10;
//        TestObject testObject = new TestObject();
//        System.out.println(setterUtil.setValue(i,testObject,"LongPrimitiveValue"));
//        System.out.println(testObject.getRegisteredType());
//    }

    @Test
    void setIntPrimitiveValueTest(){
        int intValue = 1;
        TestObject testObject = new TestObject();
        Class<?> expectedTypeOfValue = getExpectedTypeOfValue(int.class);
        printMessage(expectedTypeOfValue,testObject);
        if(expectedTypeOfValue!=null) {
            Assertions.assertTrue(setterUtil.setValue(intValue, testObject, "LongPrimitiveValue"));
        }
        Assertions.assertEquals(expectedTypeOfValue, testObject.getRegisteredType().getRegisteredType());
    }

    void printMessage(Class<?> expectedTypeOfValue, TestObject testObject){
        if(expectedTypeOfValue!=null) {
            System.out.println(
                    "Expected: " + expectedTypeOfValue.getName() +
                            " Provided: " + testObject.getRegisteredType().getRegisteredType());
        } else {
            System.out.println(
                    "Expected: " + null +
                            " Provided: " + testObject.getRegisteredType().getRegisteredType());
        }
    }

    @Test
    void setShortPrimitiveValueTest(){
        short shortValue = 2;
        TestObject testObject = new TestObject();
        Class<?> expectedTypeOfValue = getExpectedTypeOfValue(short.class);
        printMessage(expectedTypeOfValue,testObject);
        if(expectedTypeOfValue!=null) {
            Assertions.assertTrue(setterUtil.setValue(shortValue, testObject, "LongPrimitiveValue"));
        }
        Assertions.assertEquals(expectedTypeOfValue, testObject.getRegisteredType().getRegisteredType());
    }

    @Test
    void setCharPrimitiveValueTest(){
        char charValue = 3;
        TestObject testObject = new TestObject();
        Class<?> expectedTypeOfValue = getExpectedTypeOfValue(char.class);
        printMessage(expectedTypeOfValue,testObject);
        if(expectedTypeOfValue!=null) {
            Assertions.assertTrue(setterUtil.setValue(charValue, testObject, "LongPrimitiveValue"));
        }
        Assertions.assertEquals(expectedTypeOfValue, testObject.getRegisteredType().getRegisteredType());
    }

    @Test
    void setLongPrimitiveValueTest(){
        long longValue = 4;
        TestObject testObject = new TestObject();
        Class<?> expectedTypeOfValue = getExpectedTypeOfValue(long.class);
        printMessage(expectedTypeOfValue,testObject);
        if(expectedTypeOfValue!=null) {
            Assertions.assertTrue(setterUtil.setValue(longValue, testObject, "LongPrimitiveValue"));
        }
        Assertions.assertEquals(expectedTypeOfValue, testObject.getRegisteredType().getRegisteredType());
    }
    @Test
    void setFloatPrimitiveValueTest(){
        float value = 5;
        TestObject testObject = new TestObject();
        Class<?> expectedTypeOfValue = getExpectedTypeOfValue(float.class);
        printMessage(expectedTypeOfValue,testObject);
        if(expectedTypeOfValue!=null) {
            Assertions.assertTrue(setterUtil.setValue(value, testObject, "LongPrimitiveValue"));
        }
        Assertions.assertEquals(expectedTypeOfValue, testObject.getRegisteredType().getRegisteredType());
    }
    @Test
    void setDoublePrimitiveValueTest(){
        double value = 6;
        TestObject testObject = new TestObject();
        Class<?> expectedTypeOfValue = getExpectedTypeOfValue(double.class);
        printMessage(expectedTypeOfValue,testObject);
        if(expectedTypeOfValue!=null) {
            Assertions.assertTrue(setterUtil.setValue(value, testObject, "LongPrimitiveValue"));
        }
        Assertions.assertEquals(expectedTypeOfValue, testObject.getRegisteredType().getRegisteredType());
    }
    @Test
    void setBooleanPrimitiveValueTest(){
        boolean value = true;
        TestObject testObject = new TestObject();

        Class<?> expectedTypeOfValue = getExpectedTypeOfValue(boolean.class);
        printMessage(expectedTypeOfValue, testObject);
        if(expectedTypeOfValue!=null) {
            Assertions.assertTrue(setterUtil.setValue(value, testObject, "LongPrimitiveValue"));
        }
        Assertions.assertEquals(expectedTypeOfValue, testObject.getRegisteredType().getRegisteredType());
    }

    @ParameterizedTest
    @MethodSource("provideObjectsAndTypes")
    void setObjectValueTest(Object object, Class<?> typeOfValue) {
        TestObject testObject = new TestObject();
        setterUtil.setValue(object, testObject, "LongPrimitiveValue");
        Class<?> expectedTypeOfValue = getExpectedTypeOfValue(typeOfValue);
        Assertions.assertEquals(expectedTypeOfValue, testObject.getRegisteredType().getRegisteredType());
        printMessage(expectedTypeOfValue, testObject);
        printMessage(null,testObject);
    }

    private static Stream<Arguments> provideObjectsAndTypes() {
        return Stream.of(
                Arguments.of(true, Boolean.class),
                Arguments.of((byte) 9, Byte.class),
                Arguments.of((short) 10, Short.class),
                Arguments.of((char) 11, Character.class),
                Arguments.of(12, Integer.class),
                Arguments.of((long) 13, Long.class),
                Arguments.of((float) 14, Float.class),
                Arguments.of((double) 15, Double.class)
        );
    }

    @ParameterizedTest
    @MethodSource("provideNullObjectsAndTypes")
    void setNullObjectTest(Class<?> typeOfValue){
        TestCaseClassWithoutPrimitives testObject = new TestCaseClassWithoutPrimitives();
        Assertions.assertTrue(setterUtil.setValue(null, testObject, "LongPrimitiveValue", typeOfValue));
    }

    private static @NotNull Stream<Arguments> provideNullObjectsAndTypes() {
        return Stream.of(
                Arguments.of(Boolean.class), // todo check it
                Arguments.of(Byte.class), // todo check it
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

    // ===================================== NULL TESTS ==================================================

    @ParameterizedTest
    @MethodSource("provideNulls")
    void nullWithNullValuePossibleTest(Object targetObject, String propertyName, Class<?> typeOfValue){
        Assertions.assertFalse(setterUtil.setValue(22,targetObject,propertyName,typeOfValue));
    }

    private static @NotNull Stream<Arguments> provideNulls() {
        return Stream.of(
                Arguments.of(nullTestObject, "value", Integer.class),
                Arguments.of(null, "value", Integer.class),
                Arguments.of(new TestCaseClassWithoutPrimitives(),"", Integer.class),
                Arguments.of(new TestCaseClassWithoutPrimitives(),null, Integer.class),
                Arguments.of(new TestCaseClassWithoutPrimitives()," ", Integer.class),
                Arguments.of(new TestCaseClassWithoutPrimitives(),new String(), Integer.class),
                Arguments.of(new TestCaseClassWithoutPrimitives(),"value",null),
                Arguments.of(new TestCaseClassEmpty(),"value",Integer.class)
        );
    }

    @ParameterizedTest
    @MethodSource("provideNulls")
    void nullMethodWithObjectWithoutNullValuePossibleTest(Object targetObject, String propertyName){
        Integer value = 1;
        Assertions.assertFalse(setterUtil.setValue(value,targetObject,propertyName));
    }

    @ParameterizedTest
    @MethodSource("provideNulls")
    void nullMethodWithPrimitiveByteTest(Object targetObject, String propertyName){
        Assertions.assertFalse(setterUtil.setValue((byte)16,targetObject,propertyName));
    }

    @ParameterizedTest
    @MethodSource("provideNulls")
    void nullMethodWithPrimitiveShortTest(Object targetObject, String propertyName){
        Assertions.assertFalse(setterUtil.setValue((short)17,targetObject,propertyName));
    }

    @ParameterizedTest
    @MethodSource("provideNulls")
    void nullMethodWithPrimitiveCharTest(Object targetObject, String propertyName){
        Assertions.assertFalse(setterUtil.setValue((char)18,targetObject,propertyName));
    }

    @ParameterizedTest
    @MethodSource("provideNulls")
    void nullMethodWithPrimitiveIntTest(Object targetObject, String propertyName){
        Assertions.assertFalse(setterUtil.setValue(19,targetObject,propertyName));
    }

    @ParameterizedTest
    @MethodSource("provideNulls")
    void nullMethodWithPrimitiveLongTest(Object targetObject, String propertyName){
        Assertions.assertFalse(setterUtil.setValue((long)20,targetObject,propertyName));
    }

    @ParameterizedTest
    @MethodSource("provideNulls")
    void nullMethodWithPrimitiveFloatTest(Object targetObject, String propertyName){
        Assertions.assertFalse(setterUtil.setValue((float)21,targetObject,propertyName));
    }

    @ParameterizedTest
    @MethodSource("provideNulls")
    void nullMethodWithPrimitiveDoubleTest(Object targetObject, String propertyName){
        Assertions.assertFalse(setterUtil.setValue((double) 22,targetObject,propertyName));
    }

    @ParameterizedTest
    @MethodSource("provideNulls")
    void nullMethodWithPrimitiveBooleanTest(Object targetObject, String propertyName){
        Assertions.assertFalse(setterUtil.setValue(true,targetObject,propertyName));
    }

    @ParameterizedTest
    @MethodSource("providePrimitiveTypes")
    void setNullObjectValueToSetterWithPrimitiveTest(Class<?> typeOfValue,Object value){
        Assertions.assertFalse(setterUtil.setValue(value,new TestCaseClassForHierarchyChecking(),"value", typeOfValue));
    }

    private static @NotNull Stream<Arguments> providePrimitiveTypes() {
        return Stream.of(
                Arguments.of(byte.class,null),
                Arguments.of(short.class, null),
                Arguments.of(char.class, null),
                Arguments.of(int.class, null),
                Arguments.of(long.class, null),
                Arguments.of(float.class, null),
                Arguments.of(double.class, null),
                Arguments.of(boolean.class, null)
                );
    }

    @ParameterizedTest
    @MethodSource("providePrimitiveTypes")
    void setNullValueToSetterWithPrimitiveTest(Class<?> typeOfValue){
        Assertions.assertFalse(setterUtil.setValue(null,new TestCaseClassForHierarchyChecking(),"value", typeOfValue));
    }

    // ============================================= COLLECTIONS TESTS ===================================================================

    @ParameterizedTest
    @MethodSource("provideCollections")
    void setCollectionTest(Collection<?> collection){
        TestCaseCollections.CollectionsSetterWithGenericDefinedType obj = new TestCaseCollections.CollectionsSetterWithGenericDefinedType();
        boolean isSet = setterUtil.setValue(collection,obj,"value");
        RegisterType registerType = obj.getRegisterType();
        System.out.println(registerType.getRegisteredType().getName());
        Assertions.assertTrue(isSet);
        Assertions.assertEquals(collection.getClass(),obj.getRegisterType().getRegisteredType());
    }

    private static @NotNull Stream<Arguments> provideCollections() {
        return Stream.of(
                Arguments.of(new Stack<>()),
                Arguments.of(new LinkedList<>()),
                Arguments.of(new ArrayList<>()),
                Arguments.of(new Vector<>()),
                Arguments.of(new ArrayDeque<>()),
                Arguments.of(new TreeSet<>()),
                Arguments.of(new LinkedHashSet<String>()),
                Arguments.of(new HashSet<>()),
                Arguments.of(new ArrayList<>(Arrays.asList("1","2"))) // HOW???...
        );
    }

    @ParameterizedTest
    @MethodSource("provideCollections")
    void setCollectionTest2(Collection<?> collection){
        TestCaseCollections.CollectionsSetterWithGenericType<Integer> obj = new TestCaseCollections.CollectionsSetterWithGenericType<>();
        boolean isSet = setterUtil.setValue(collection,obj,"value");
        RegisterType registerType = obj.getRegisterType();
        System.out.println(registerType.getRegisteredType().getName());
        Assertions.assertTrue(isSet);
        Assertions.assertEquals(collection.getClass(),obj.getRegisterType().getRegisteredType());
    }

    // todo write tests for collections

    // ================================================= Enums ========================================================

    @ParameterizedTest
    @MethodSource("provideEnumsWithInvoked")
    void enumInvokeTest(Enum<?> testEnum, boolean expectedInvoked){
        TestCaseEnums obj = new TestCaseEnums();
        boolean isInvoked = setterUtil.setValue(testEnum,obj,"value");
        Assertions.assertEquals(expectedInvoked,isInvoked);
    }

    private static @NotNull Stream<Arguments> provideEnumsWithInvoked() {
        return Stream.of(
                Arguments.of(TestCaseEnums.TestEnum.TEST_ENUM, true),
                Arguments.of(TestCaseEnums.TestEnum2.TEST_ENUM_INTERFACE, true),
                Arguments.of(TestCaseEnums.TestEnum3.TEST_ENUM_INTERFACE, false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideEnumsWithTypeOfExpectedSetterTypeOfValue")
    void enumTypeOfSetterValueTest(Enum<?> testEnum,Class<?> expectedTypeOfSetterValue){
        TestCaseEnums obj = new TestCaseEnums();
        setterUtil.setValue(testEnum,obj,"value");
        Assertions.assertEquals(expectedTypeOfSetterValue,obj.getRegisterType().getRegisteredType());
    }

    private static @NotNull Stream<Arguments> provideEnumsWithTypeOfExpectedSetterTypeOfValue() {
        return Stream.of(
                Arguments.of(TestCaseEnums.TestEnum.TEST_ENUM, TestCaseEnums.TestEnum.class),
                Arguments.of(TestCaseEnums.TestEnum2.TEST_ENUM_INTERFACE, TestCaseEnums.InterfaceForEnum.class),
                Arguments.of(TestCaseEnums.TestEnum3.TEST_ENUM_INTERFACE, null)
        );
    }


}
