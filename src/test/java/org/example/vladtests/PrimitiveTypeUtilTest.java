//package org.example.vladtests;
//
//import  org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;
//
//import java.util.stream.Stream;
//
//class PrimitiveTypeUtilTest {
//
//    private static Stream<Arguments> providedArgs_testGetWrapperClass() {
//        return Stream.of(
//                Arguments.of(boolean.class, Boolean.class),
//                Arguments.of(byte.class, Byte.class),
//                Arguments.of(short.class, Short.class),
//                Arguments.of(int.class, Integer.class),
//                Arguments.of(long.class, Long.class),
//                Arguments.of(char.class, Character.class),
//                Arguments.of(float.class, Float.class),
//                Arguments.of(double.class, Double.class),
//                Arguments.of(Double.class, Double.class),
//                Arguments.of(Object.class, Object.class)
//        );
//    }
//
//    @ParameterizedTest
//    @MethodSource("providedArgs_testGetWrapperClass")
//    void testGetWrapperClass(Class<?> primitiveClass, Class<?> expectedClass) {
//        Class<?> wrapperClass = PrimitiveTypeUtil.getWrapperByPrimitiveClass(primitiveClass);
//
//        Assertions.assertEquals(expectedClass, wrapperClass);
//    }
//
//}
