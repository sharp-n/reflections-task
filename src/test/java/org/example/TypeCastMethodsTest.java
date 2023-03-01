package org.example;

import org.example.classes_for_cast_checking.TestClassForDifferentCastsChecking;
import org.example.classes_for_cast_checking.TestClassForIntCastChecking;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Stream;

class TypeCastMethodsTest {

    private final String METHOD_FOR_SEARCHING = "setLongPrimitiveValue";

    private final Class<?> testClassForIntCastCheckingClass = TestClassForIntCastChecking.class;

    private final Class<?> testClassForDifferentCastsCheckingClass = TestClassForDifferentCastsChecking.class;
    @Test
    void byteCastTest() throws InvocationTargetException, IllegalAccessException {
        byte providedValue = '5';
        Method providedMethod = MethodsHandler.getMethod(testClassForIntCastCheckingClass, METHOD_FOR_SEARCHING, byte.class);
        Assertions.assertNotNull(providedMethod);
        Assertions.assertEquals(int.class,((TestClassForIntCastChecking) MethodsHandler.invokeMethodWithOnePrimitiveParameter(providedMethod, new TestClassForIntCastChecking(), providedValue)).getRegisteredType());
    }

    @Test
    void shortCastTest() throws InvocationTargetException, IllegalAccessException {
        short providedValue = '5';
        Method providedMethod = MethodsHandler.getMethod(testClassForIntCastCheckingClass, METHOD_FOR_SEARCHING, short.class);
        Assertions.assertNotNull(providedMethod);
        Assertions.assertEquals(int.class,((TestClassForIntCastChecking) MethodsHandler.invokeMethodWithOnePrimitiveParameter(providedMethod, new TestClassForIntCastChecking(), providedValue)).getRegisteredType());
    }

    @Test
    void charCastTest() throws InvocationTargetException, IllegalAccessException {
        short providedValue = 12;
        Method providedMethod = MethodsHandler.getMethod(testClassForIntCastCheckingClass, METHOD_FOR_SEARCHING, char.class);
        Assertions.assertNotNull(providedMethod);
        Assertions.assertEquals(int.class,((TestClassForIntCastChecking) MethodsHandler.invokeMethodWithOnePrimitiveParameter(providedMethod, new TestClassForIntCastChecking(), providedValue)).getRegisteredType());
    }

    @Test
    void longCastTest() throws InvocationTargetException, IllegalAccessException {
        long providedValue = 297;
        Method providedMethod = MethodsHandler.getMethod(testClassForIntCastCheckingClass, METHOD_FOR_SEARCHING, long.class);
        Assertions.assertNotNull(providedMethod);
        Assertions.assertEquals(int.class,((TestClassForIntCastChecking) MethodsHandler.invokeMethodWithOnePrimitiveParameter(providedMethod, new TestClassForIntCastChecking(), providedValue)).getRegisteredType());
    }

    @ParameterizedTest
    @MethodSource("providePrimitiveClassesForLongCast")
    void castLongToPrimitivesTest(Class<?> typeOfValue) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        long providedValue = 297;
        Method providedMethod = testClassForDifferentCastsCheckingClass.getMethod(METHOD_FOR_SEARCHING,typeOfValue);
        Assertions.assertNotNull(providedMethod);
        Assertions.assertEquals(typeOfValue,((TestClassForDifferentCastsChecking) MethodsHandler.invokeMethodWithOnePrimitiveParameter(providedMethod, new TestClassForDifferentCastsChecking(), providedValue)).getRegisteredType());
    }

    private static Stream<Arguments> providePrimitiveClassesForLongCast() {
        return Stream.of(
                Arguments.of(int.class),
                Arguments.of(byte.class),
                Arguments.of(short.class),
                Arguments.of(char.class),
                Arguments.of(float.class),
                Arguments.of(double.class)
        );
    }

    @ParameterizedTest
    @MethodSource("providePrimitiveClassesForIntCast")
    void castIntToPrimitivesTest(Class<?> typeOfValue) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        int providedValue = 297;
        Method providedMethod = testClassForDifferentCastsCheckingClass.getMethod(METHOD_FOR_SEARCHING,typeOfValue);
        Assertions.assertNotNull(providedMethod);
        Assertions.assertEquals(typeOfValue,((TestClassForDifferentCastsChecking) MethodsHandler.invokeMethodWithOnePrimitiveParameter(providedMethod, new TestClassForDifferentCastsChecking(), providedValue)).getRegisteredType());
    }

    private static Stream<Arguments> providePrimitiveClassesForIntCast() {
        return Stream.of(
                Arguments.of(long.class),
                Arguments.of(byte.class),
                Arguments.of(short.class),
                Arguments.of(char.class),
                Arguments.of(float.class),
                Arguments.of(double.class)
        );
    }


    @ParameterizedTest
    @MethodSource("providePrimitiveClassesForShortCast")
    void castShortToPrimitivesTest(Class<?> typeOfValue) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        short providedValue = 297;
        Method providedMethod = testClassForDifferentCastsCheckingClass.getMethod(METHOD_FOR_SEARCHING,typeOfValue);
        Assertions.assertNotNull(providedMethod);
        Assertions.assertEquals(typeOfValue,((TestClassForDifferentCastsChecking) MethodsHandler.invokeMethodWithOnePrimitiveParameter(providedMethod, new TestClassForDifferentCastsChecking(), providedValue)).getRegisteredType());
    }

    @ParameterizedTest
    @MethodSource("providePrimitiveClassesForByteCast")
    void castByteToPrimitivesTest(Class<?> typeOfValue) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        byte providedValue = 127;
        Method providedMethod = testClassForDifferentCastsCheckingClass.getMethod(METHOD_FOR_SEARCHING,typeOfValue);
        Assertions.assertNotNull(providedMethod);
        Assertions.assertEquals(typeOfValue,((TestClassForDifferentCastsChecking) MethodsHandler.invokeMethodWithOnePrimitiveParameter(providedMethod, new TestClassForDifferentCastsChecking(), providedValue)).getRegisteredType());
    }

    @ParameterizedTest
    @MethodSource("providePrimitiveClassesForCharCast")
    void castCharToPrimitivesTest(Class<?> typeOfValue) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        char providedValue = 297;
        Method providedMethod = testClassForDifferentCastsCheckingClass.getMethod(METHOD_FOR_SEARCHING,typeOfValue);
        Assertions.assertNotNull(providedMethod);
        Assertions.assertEquals(typeOfValue,((TestClassForDifferentCastsChecking) MethodsHandler.invokeMethodWithOnePrimitiveParameter(providedMethod, new TestClassForDifferentCastsChecking(), providedValue)).getRegisteredType());
    }
    @ParameterizedTest
    @MethodSource("providePrimitiveClassesForDoubleCast")
    void castDoubleToPrimitivesTest(Class<?> typeOfValue) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        double providedValue = 234.2332;
        Method providedMethod = testClassForDifferentCastsCheckingClass.getMethod(METHOD_FOR_SEARCHING,typeOfValue);
        Assertions.assertNotNull(providedMethod);
        Assertions.assertEquals(typeOfValue,((TestClassForDifferentCastsChecking) MethodsHandler.invokeMethodWithOnePrimitiveParameter(providedMethod, new TestClassForDifferentCastsChecking(), providedValue)).getRegisteredType());
    }

    @ParameterizedTest
    @MethodSource("providePrimitiveClassesForFloatCast")
    void castFloatToPrimitivesTest(Class<?> typeOfValue) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        float providedValue = 132;
        Method providedMethod = testClassForDifferentCastsCheckingClass.getMethod(METHOD_FOR_SEARCHING,typeOfValue);
        Assertions.assertNotNull(providedMethod);
        Assertions.assertEquals(typeOfValue,((TestClassForDifferentCastsChecking) MethodsHandler.invokeMethodWithOnePrimitiveParameter(providedMethod, new TestClassForDifferentCastsChecking(), providedValue)).getRegisteredType());
    }


    private static Stream<Arguments> providePrimitiveClassesForShortCast() {
        return Stream.of(
                Arguments.of(long.class),
                Arguments.of(byte.class),
                Arguments.of(int.class),
                Arguments.of(char.class),
                Arguments.of(float.class),
                Arguments.of(double.class)
        );
    }
    private static Stream<Arguments> providePrimitiveClassesForByteCast() {
        return Stream.of(
                Arguments.of(long.class),
                Arguments.of(int.class),
                Arguments.of(short.class),
                Arguments.of(char.class),
                Arguments.of(float.class),
                Arguments.of(double.class)
        );
    }
    private static Stream<Arguments> providePrimitiveClassesForCharCast() {
        return Stream.of(
                Arguments.of(long.class),
                Arguments.of(byte.class),
                Arguments.of(short.class),
                Arguments.of(int.class),
                Arguments.of(float.class),
                Arguments.of(double.class)
        );
    }

    private static Stream<Arguments> providePrimitiveClassesForFloatCast() {
        return Stream.of(
                Arguments.of(long.class),
                Arguments.of(byte.class),
                Arguments.of(short.class),
                Arguments.of(char.class),
                Arguments.of(int.class),
                Arguments.of(double.class)
        );
    }

    private static Stream<Arguments> providePrimitiveClassesForDoubleCast() {
        return Stream.of(
                Arguments.of(long.class),
                Arguments.of(byte.class),
                Arguments.of(short.class),
                Arguments.of(char.class),
                Arguments.of(float.class),
                Arguments.of(int.class)
        );
    }

}
