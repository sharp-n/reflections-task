package org.example.mytests;

import org.example.RegisterType;
import org.example.SetterUtil;
import org.example.SetterUtilImpl;
import org.example.classes_for_hierarchy_tests.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class TypeHierarchyReflectionTest {

    @ParameterizedTest
    @MethodSource("providePrimitivesWithWrappers")
    void primitivesInClassWithoutPrimitivesTest(Object value, Class<?> primitiveClass, Class<?> wrapperClass) throws NoSuchMethodException {
        SetterUtil setterUtil = new SetterUtilImpl();
        TestCaseClassWithoutPrimitives testCaseClassWithoutPrimitives = new TestCaseClassWithoutPrimitives();
        setterUtil.setValue(value,testCaseClassWithoutPrimitives,"LongPrimitiveValue",primitiveClass);
        Assertions.assertEquals(wrapperClass,testCaseClassWithoutPrimitives.getRegisteredType().getRegisteredType());
    }

    private static Stream<Arguments> providePrimitivesWithWrappers() {
        return Stream.of(
                Arguments.of(35,int.class,Integer.class),
                Arguments.of((long)35,long.class,Long.class),
                Arguments.of((byte)35,byte.class,Byte.class),
                Arguments.of((short)35,short.class,Short.class),
                Arguments.of('5',char.class,Character.class)
        );
    }

    @ParameterizedTest
    @MethodSource("providePrimitivesAndWrappers")
    void primitivesAndWrappersInCLassWithoutWrappersTest(Object value, Class<?> typeOfValue) throws NoSuchMethodException {
        SetterUtil setterUtil = new SetterUtilImpl();
        TestCaseClassWithoutWrappers testCaseClassWithoutWrappers = new TestCaseClassWithoutWrappers();
        setterUtil.setValue(value,testCaseClassWithoutWrappers,"LongPrimitiveValue",typeOfValue);
        Assertions.assertEquals(Number.class,testCaseClassWithoutWrappers.getRegisteredType().getRegisteredType());
    }

    @ParameterizedTest
    @MethodSource("providePrimitivesAndWrappersAndNumber")
    void primitivesAndWrappersAndNumberInClassWithoutNumberTest(Object value, Class<?> typeOfValue) throws NoSuchMethodException {
        SetterUtil setterUtil = new SetterUtilImpl();
        TestCaseClassWithoutNumber testCaseClassWithoutNumber = new TestCaseClassWithoutNumber();
        setterUtil.setValue(value,testCaseClassWithoutNumber,"LongPrimitiveValue",typeOfValue);
        printMessage(Object.class,testCaseClassWithoutNumber.getRegisteredType(),typeOfValue);
        Assertions.assertEquals(Object.class,testCaseClassWithoutNumber.getRegisteredType().getRegisteredType());
    }

    @ParameterizedTest
    @MethodSource("provideValuesAllTypes")
    void allTypesInEmptyClass(Class<?> typeOfValue){
        SetterUtil setterUtil = new SetterUtilImpl();
        TestCaseClassEmpty testCaseClassEmpty = new TestCaseClassEmpty();
        setterUtil.setValue(null,testCaseClassEmpty,"LongPrimitiveValue",typeOfValue);
        Assertions.assertNull(testCaseClassEmpty.getRegisteredType().getRegisteredType());
    }

    private static Stream<Arguments> provideValuesAllTypes() {
        return Stream.of(
                Arguments.of(int.class),
                Arguments.of(long.class),
                Arguments.of(byte.class),
                Arguments.of(short.class),
                Arguments.of(char.class),
                Arguments.of(Integer.class),
                Arguments.of(Long.class),
                Arguments.of(Short.class),
                Arguments.of(Byte.class),
                Arguments.of(Character.class),
                Arguments.of(Number.class),
                Arguments.of(Object.class)
        );
    }

    private static Stream<Arguments> providePrimitivesAndWrappers() {
        return Stream.of(
                Arguments.of(56,int.class),
                Arguments.of((long)56,long.class),
                Arguments.of((byte)56,byte.class),
                Arguments.of((short)56,short.class),
                Arguments.of(56,Integer.class),
                Arguments.of(56,Long.class),
                Arguments.of(56,Short.class),
                Arguments.of(56,Byte.class)
        );
    }
    private static Stream<Arguments> providePrimitivesAndWrappersAndNumber() {
        return Stream.of(
                Arguments.of(56,int.class),
                Arguments.of((long)56,long.class),
                Arguments.of((byte)56,byte.class),
                Arguments.of((short)56,short.class),
                Arguments.of('5',char.class),
                Arguments.of(56,Integer.class),
                Arguments.of(56,Long.class),
                Arguments.of(56,Short.class),
                Arguments.of(56,Byte.class),
                Arguments.of(56,Character.class),
                Arguments.of((Number)56,Number.class)
        );
    }

    @ParameterizedTest
    @MethodSource("providePrimitives")
    void primitivesHierarchyInClassForPrimitivesCheckingTest(Object value, Class<?> typeOfValue, Class<?> expectedTypeOfValue) throws NoSuchMethodException {
        SetterUtil setterUtil = new SetterUtilImpl();
        TestCaseClassForPrimitivesChecking testCaseClassForPrimitivesChecking = new TestCaseClassForPrimitivesChecking();
        setterUtil.setValue(value,testCaseClassForPrimitivesChecking,"LongPrimitiveValue", typeOfValue);
        Assertions.assertNotNull(testCaseClassForPrimitivesChecking.getRegisteredType().getRegisteredType());
        Assertions.assertEquals(expectedTypeOfValue,testCaseClassForPrimitivesChecking.getRegisteredType().getRegisteredType());
    }

    private static Stream<Arguments> providePrimitives() {
        return Stream.of(
                Arguments.of(56,int.class,int.class),
                Arguments.of((byte)56,byte.class,int.class),
                Arguments.of((short)56,short.class,int.class),
                Arguments.of('5',char.class,int.class),
                Arguments.of((long)56,long.class,double.class),
                Arguments.of((float)56,float.class,double.class),
                Arguments.of(56.56,double.class,double.class)
        );
    }

    @ParameterizedTest
    @MethodSource("provideClasses")
    void collisionAndHierarchyTest(Object value, boolean expected){
        TestCaseClassForHierarchyChecking testObject = new TestCaseClassForHierarchyChecking();
        SetterUtilImpl setterUtil = new SetterUtilImpl();
        boolean isSet = setterUtil.setValue(value,testObject,"value");
        Assertions.assertEquals(expected,isSet);
//        Assertions.assertEquals(TestCaseClassForInterfacesHierarchy.MyClass.class,testObject.getRegisterType().getRegisteredType());
    }

    private static Stream<Arguments> provideClasses() {
        return Stream.of(
                Arguments.of(new TestCaseClassForHierarchyChecking.MyClass1(), true),
                Arguments.of(new TestCaseClassForHierarchyChecking.MyClass2(), false),
                Arguments.of(new TestCaseClassForHierarchyChecking.MyClass3(), false),
                Arguments.of(new TestCaseClassForHierarchyChecking.MyClass4(), true),
                Arguments.of(new TestCaseClassForHierarchyChecking.MyClass5(), true),
                Arguments.of(new TestCaseClassForHierarchyChecking.MyClassWithMultipleInterfaces(), false),
                Arguments.of(new TestCaseClassForHierarchyChecking.MyCollection(),true)
        );
    }


    void printMessage(Class<?> expectedTypeOfValue, RegisterType testObject, Class<?> originalTypeOfValue){
        if(expectedTypeOfValue!=null) {
            System.out.println(
                    "Expected: " + expectedTypeOfValue.getName() +
                            " Provided: " + testObject.getRegisteredType() +
                            " Original type of value: " + originalTypeOfValue.getName());
        } else {
            System.out.println(
                    "Expected: " + null +
                            " Provided: " + testObject.getRegisteredType());
        }
    }

}
