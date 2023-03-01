package org.example;

import org.example.classes_for_hierarchy_tests.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Method;
import java.util.stream.Stream;

class TypeHierarchyReflectionTest {

    private final String METHOD_FOR_SEARCHING = "setLongPrimitiveValue";

    private final Class<?> testClassWithoutPrimitivesClass = TestClassWithoutPrimitives.class;

    private final Class<?> testClassWithoutWrappersClass = TestClassWithoutWrappers.class;

    private final Class<?> testClassWithoutNumberClass = TestClassWithoutNumber.class;

    private final Class<?> testEmptyClass = TestClassEmpty.class;

    private final Class<?> testClassForPrimitivesChecking = TestClassForPrimitivesChecking.class;

    @ParameterizedTest
    @MethodSource("providePrimitivesWithWrappers")
    void primitivesInClassWithoutPrimitivesTest(Class<?> primitiveClass, Class<?> wrapperClass) throws NoSuchMethodException {
        Method expectedMethod = testClassWithoutPrimitivesClass.getMethod(METHOD_FOR_SEARCHING,wrapperClass);
        Method providedMethod = MethodsHandler.getMethod(testClassWithoutPrimitivesClass, METHOD_FOR_SEARCHING, primitiveClass);
        Assertions.assertNotNull(providedMethod);
        Assertions.assertEquals(expectedMethod,providedMethod);
    }

    private static Stream<Arguments> providePrimitivesWithWrappers() {
        return Stream.of(
                Arguments.of(int.class,Integer.class),
                Arguments.of(long.class,Long.class),
                Arguments.of(byte.class,Byte.class),
                Arguments.of(short.class,Short.class),
                Arguments.of(char.class,Character.class)
        );
    }

    @ParameterizedTest
    @MethodSource("providePrimitivesAndWrappers")
    void primitivesAndWrappersInCLassWithoutWrappersTest(Class<?> typeOfValue) throws NoSuchMethodException {
        Method expectedMethod = testClassWithoutWrappersClass.getMethod(METHOD_FOR_SEARCHING,Number.class);
        Method providedMethod = MethodsHandler.getMethod(testClassWithoutWrappersClass, METHOD_FOR_SEARCHING, typeOfValue);
        Assertions.assertNotNull(providedMethod);
        Assertions.assertEquals(expectedMethod,providedMethod);
    }



    @ParameterizedTest
    @MethodSource("providePrimitivesAndWrappersAndNumber")
    void primitivesAndWrappersAneNumberInClassWithoutNumberTest(Class<?> typeOfValue) throws NoSuchMethodException {
        Method expectedMethod =testClassWithoutNumberClass.getMethod(METHOD_FOR_SEARCHING,Object.class);
        Method providedMethod = MethodsHandler.getMethod(testClassWithoutNumberClass, METHOD_FOR_SEARCHING, typeOfValue);
        Assertions.assertNotNull(providedMethod);
        Assertions.assertEquals(expectedMethod,providedMethod);
    }

    @ParameterizedTest
    @MethodSource("provideValuesAllTypes")
    void allTypesInEmptyClass(Class<?> typeOfValue){
        Method providedMethod = MethodsHandler.getMethod(testEmptyClass, METHOD_FOR_SEARCHING, typeOfValue);
        Assertions.assertNull(providedMethod);
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
                Arguments.of(int.class),
                Arguments.of(long.class),
                Arguments.of(byte.class),
                Arguments.of(short.class),
                Arguments.of(char.class),
                Arguments.of(Integer.class),
                Arguments.of(Long.class),
                Arguments.of(Short.class),
                Arguments.of(Byte.class),
                Arguments.of(Character.class)
        );
    }
    private static Stream<Arguments> providePrimitivesAndWrappersAndNumber() {
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
                Arguments.of(Number.class)
        );
    }

    @ParameterizedTest
    @MethodSource("providePrimitives")
    void primitivesHierarchyInClassForPrimitivesCheckingTest(Class<?> typeOfValue, Class<?> expectedTypeOfValue) throws NoSuchMethodException {
        Method expectedMethod = testClassForPrimitivesChecking.getMethod(METHOD_FOR_SEARCHING,expectedTypeOfValue);
        Method providedMethod = MethodsHandler.getMethod(testClassForPrimitivesChecking, METHOD_FOR_SEARCHING, typeOfValue);
        Assertions.assertNotNull(providedMethod);
        Assertions.assertEquals(expectedMethod,providedMethod);
    }

    private static Stream<Arguments> providePrimitives() {
        return Stream.of(
                Arguments.of(int.class,char.class),
                Arguments.of(byte.class,byte.class),
                Arguments.of(short.class,char.class),
                Arguments.of(char.class,char.class),
                Arguments.of(long.class,char.class)
        );
    }

}
