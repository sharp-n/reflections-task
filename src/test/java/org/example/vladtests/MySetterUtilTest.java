package org.example.vladtests;

import org.example.SetterUtil;
import org.example.vladtests.SetterUtilImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.example.vladtests.MyTestArgsProvider.*;

public class MySetterUtilTest {

    public static final String PROPERTY_NAME = "someVar";
    static Boolean nullBoolean = null;
    static Byte nullByte = null;
    static Short nullShort = null;
    static Integer nullInteger = null;
    static Long nullLong = null;
    static Character nullCharacter = null;
    static Float nullFloat = null;
    static Double nullDouble = null;
    static Object nullObject = null;

    protected SetterUtil getSetterUtil() {
        return new SetterUtilImpl();
    }

    private static Stream<Arguments> providedArgs_testParamsWithObj() {
        return Stream.of(
                // Wrapper to primitive setter
                Arguments.of((byte) 1, object_byteSetter(), true),
                Arguments.of((short) 2, object_shortSetter(), true),
                Arguments.of(3, object_intSetter(), true),
                Arguments.of(4L, object_longSetter(), true),
                Arguments.of((char) 5, object_charSetter(), true),
                Arguments.of(6.0F, object_floatSetter(), true),
                Arguments.of(7.0D, object_doubleSetter(), true),
                // Object hierarchy
                Arguments.of(new MyNumber(8), object_ObjectSetter(), true),
                Arguments.of(new MyNumber2(9), object_ObjectSetter(), true),
                Arguments.of(new MyNumber2(10), object_NumberSetter(), true),
                Arguments.of(new MyNumber2(11), object_MyNumberSetter(), true),
                Arguments.of(new MyNumber2(12), object_MyNumber2Setter(), true),
                Arguments.of(new MyNumber2(13), object_IntegerSetter(), false),
                // BYTE
                Arguments.of((byte) 14, object_shortSetter(), true),
                Arguments.of((byte) 15, object_intSetter(), true),
                Arguments.of((byte) 16, object_longSetter(), true),
                Arguments.of((byte) 17, object_floatSetter(), true),
                Arguments.of((byte) 18, object_doubleSetter(), true),
                Arguments.of((byte) 19, object_charSetter(), false),
                Arguments.of((byte) 20, object_booleanSetter(), false),
                // SHORT
                Arguments.of((short) 21, object_shortSetter(), true),
                Arguments.of((short) 22, object_intSetter(), true),
                Arguments.of((short) 23, object_longSetter(), true),
                Arguments.of((short) 24, object_floatSetter(), true),
                Arguments.of((short) 25, object_doubleSetter(), true),
                Arguments.of((short) 26, object_charSetter(), false),
                Arguments.of((short) 27, object_booleanSetter(), false),
                Arguments.of((short) 28, object_byteSetter(), false),
                // INTEGER
                Arguments.of(29, object_intSetter(), true),
                Arguments.of(30, object_longSetter(), true),
                Arguments.of(31, object_floatSetter(), true),
                Arguments.of(32, object_doubleSetter(), true),
                Arguments.of(33, object_charSetter(), false),
                Arguments.of(34, object_booleanSetter(), false),
                Arguments.of(35, object_byteSetter(), false),
                Arguments.of(36, object_shortSetter(), false),
                // LONG
                Arguments.of(37L, object_longSetter(), true),
                Arguments.of(38L, object_floatSetter(), true),
                Arguments.of(39L, object_doubleSetter(), true),
                Arguments.of(40L, object_charSetter(), false),
                Arguments.of(41L, object_booleanSetter(), false),
                Arguments.of(42L, object_byteSetter(), false),
                Arguments.of(43L, object_shortSetter(), false),
                Arguments.of(44L, object_intSetter(), false),
                // FLOAT
                Arguments.of(45F, object_floatSetter(), true),
                Arguments.of(46F, object_doubleSetter(), true),
                Arguments.of(47F, object_charSetter(), false),
                Arguments.of(48F, object_booleanSetter(), false),
                Arguments.of(49F, object_byteSetter(), false),
                Arguments.of(50F, object_shortSetter(), false),
                Arguments.of(51F, object_intSetter(), false),
                Arguments.of(52F, object_longSetter(), false),
                // DOUBLE
                Arguments.of(53D, object_doubleSetter(), true),
                Arguments.of(54D, object_charSetter(), false),
                Arguments.of(55D, object_booleanSetter(), false),
                Arguments.of(56D, object_byteSetter(), false),
                Arguments.of(57D, object_shortSetter(), false),
                Arguments.of(58D, object_intSetter(), false),
                Arguments.of(59D, object_longSetter(), false),
                Arguments.of(60D, object_floatSetter(), false),
                // CHARACTER
                Arguments.of((char) 61, object_charSetter(), true),
                Arguments.of((char) 62, object_intSetter(), true),
                Arguments.of((char) 63, object_longSetter(), true),
                Arguments.of((char) 64, object_floatSetter(), true),
                Arguments.of((char) 65, object_doubleSetter(), true),
                Arguments.of((char) 66, object_booleanSetter(), false),
                Arguments.of((char) 67, object_byteSetter(), false),
                Arguments.of((char) 68, object_shortSetter(), false),
                // BOOLEAN
                Arguments.of(true, object_booleanSetter(), true),// 69
                Arguments.of(true, object_byteSetter(), false),// 70
                Arguments.of(true, object_shortSetter(), false),// 71
                Arguments.of(true, object_charSetter(), false),// 72
                Arguments.of(true, object_intSetter(), false),// 73
                Arguments.of(true, object_longSetter(), false),// 74
                Arguments.of(true, object_floatSetter(), false),// 75
                Arguments.of(true, object_doubleSetter(), false),// 76
                // WRAPPER Boolean
                Arguments.of(true, object_BooleanSetter(), true),// 77
                Arguments.of(false, object_ObjectSetter(), true),// 78
                // WRAPPER Byte
                Arguments.of((byte) 79, object_ByteSetter(), true),
                Arguments.of((byte) 80, object_NumberSetter(), true),
                Arguments.of((byte) 81, object_ObjectSetter(), true),
                // WRAPPER Short
                Arguments.of((short) 79, object_ShortSetter(), true),
                Arguments.of((short) 80, object_NumberSetter(), true),
                Arguments.of((short) 81, object_ObjectSetter(), true),
                // WRAPPER Integer
                Arguments.of(82, object_IntegerSetter(), true),
                Arguments.of(83, object_NumberSetter(), true),
                Arguments.of(84, object_ObjectSetter(), true),
                // WRAPPER Long
                Arguments.of(85L, object_LongSetter(), true),
                Arguments.of(86L, object_NumberSetter(), true),
                Arguments.of(87L, object_ObjectSetter(), true),
                // Primitive and wrapper setters
                Arguments.of(true, object_booleanPrimitiveAndWrapperSetter(), true),
                Arguments.of((byte) 89, object_bytePrimitiveAndWrapperSetter(), true),
                Arguments.of((short) 90, new ShortPrimitiveAndWrapperSetter(), true),
                Arguments.of(91, object_intPrimitiveAndWrapperSetter(), true),
                Arguments.of(92L, object_longPrimitiveAndWrapperSetter(), true),
                Arguments.of(93F, object_floatPrimitiveAndWrapperSetter(), true),
                Arguments.of(94D, object_doublePrimitiveAndWrapperSetter(), true),
                Arguments.of((char) 95, object_charPrimitiveAndWrapperSetter(), true),
                // NO setters
                Arguments.of(false, new TestObject(), false),// 96
                Arguments.of((byte) 97, new TestObject(), false),
                Arguments.of((short) 98, new TestObject(), false),
                Arguments.of(99, new TestObject(), false),
                Arguments.of(100L, new TestObject(), false),
                Arguments.of(101F, new TestObject(), false),
                Arguments.of(102D, new TestObject(), false),
                Arguments.of((char) 103, new TestObject(), false),
                Arguments.of(new Object(), new TestObject(), false),
                Arguments.of(null, new TestObject(), false),
                // No suitable setter
                Arguments.of(106L, object_booleanPrimitiveAndWrapperSetter(), false),
                Arguments.of((byte) 107L, new TestObject(), false),
                Arguments.of(108L, object_caseSensitiveSetterTesting(), false),
                // + Wrappers
                Arguments.of((char) 109, object_CharacterSetter(), true),
                Arguments.of(110F, object_FloatSetter(), true),
                Arguments.of(111D, object_DoubleSetter(), true),
                // Object is null
                Arguments.of(nullObject, object_ObjectSetter(), false),
                Arguments.of(nullObject, object_booleanSetter(), false),
                Arguments.of(nullObject, object_byteSetter(), false),
                Arguments.of(nullObject, object_shortSetter(), false),
                Arguments.of(nullObject, object_intSetter(), false),
                Arguments.of(nullObject, object_longSetter(), false),
                Arguments.of(nullObject, object_charSetter(), false),
                Arguments.of(nullObject, object_floatSetter(), false),
                Arguments.of(nullObject, object_doubleSetter(), false),
                Arguments.of(nullObject, object_BooleanSetter(), false),
                Arguments.of(nullObject, object_ByteSetter(), false),
                Arguments.of(nullObject, object_ShortSetter(), false),
                Arguments.of(nullObject, object_IntegerSetter(), false),
                Arguments.of(nullObject, object_LongSetter(), false),
                Arguments.of(nullObject, object_CharacterSetter(), false),
                Arguments.of(nullObject, object_FloatSetter(), false),
                Arguments.of(nullObject, object_DoubleSetter(), false)
        );
    }

    @ParameterizedTest
    @MethodSource("providedArgs_testParamsWithObj")
    void testObjectAndWrappers(Object value,
                               TestObject testObject,
                               boolean expectedResult) {
        SetterUtil mySetterUtil = getSetterUtil();
        assertEquals(expectedResult, mySetterUtil.setValue(value, testObject, PROPERTY_NAME));
        baseTest(testObject, mySetterUtil);

        if (value != null) {
            // TODO refactor
            assertEquals(expectedResult, mySetterUtil.setValue(value, testObject, PROPERTY_NAME, value.getClass()));
        }
    }

    private static Stream<Arguments> providedArgs_testWrapperIsNull() {
        return Stream.of(
                // Wrapper is null
                Arguments.of(nullBoolean, object_booleanSetter(), false, Boolean.class),
                Arguments.of(nullByte, object_byteSetter(), false, Byte.class),
                Arguments.of(nullShort, object_shortSetter(), false, Short.class),
                Arguments.of(nullInteger, object_intSetter(), false, Integer.class),
                Arguments.of(nullLong, object_longSetter(), false, Long.class),
                Arguments.of(nullCharacter, object_charSetter(), false, Character.class),
                Arguments.of(nullFloat, object_floatSetter(), false, Float.class),
                Arguments.of(nullDouble, object_doubleSetter(), false, Double.class),
                Arguments.of(nullBoolean, object_BooleanSetter(), true, Boolean.class),
                Arguments.of(nullObject, object_ObjectSetter(), true, Object.class),
                Arguments.of(nullByte, object_ByteSetter(), true, Byte.class),
                Arguments.of(nullShort, object_ShortSetter(), true, Short.class),
                Arguments.of(nullInteger, object_IntegerSetter(), true, Integer.class),
                Arguments.of(nullLong, object_LongSetter(), true, Long.class),
                Arguments.of(nullCharacter, object_CharacterSetter(), true, Character.class),
                Arguments.of(nullFloat, object_FloatSetter(), true, Float.class),
                Arguments.of(nullDouble, object_DoubleSetter(), true, Double.class)
        );
    }

    @ParameterizedTest
    @MethodSource("providedArgs_testWrapperIsNull")
    void testWrapperIsNull(Object value,
                           TestObject testObject,
                           boolean expectedResult,
                           Class<?> valueType) {
        SetterUtil mySetterUtil = getSetterUtil();
        assertEquals(expectedResult, mySetterUtil.setValue(value, testObject, PROPERTY_NAME, valueType));
        // baseTest(testObject, mySetterUtil);
    }

    private static Stream<Arguments> providedArgs_testSetNull() {
        return Stream.of(
                // value is null
                Arguments.of(object_allSetters(), true, Object.class),
                Arguments.of(object_allSetters(), true, Number.class),
                Arguments.of(object_allSetters(), true, Boolean.class),
                Arguments.of(object_allSetters(), true, Byte.class),
                Arguments.of(object_allSetters(), true, Short.class),
                Arguments.of(object_allSetters(), true, Integer.class),
                Arguments.of(object_allSetters(), true, Long.class),
                Arguments.of(object_allSetters(), true, Character.class),
                Arguments.of(object_allSetters(), true, Float.class),
                Arguments.of(object_allSetters(), true, Double.class),
                Arguments.of(object_allSetters(), true, boolean.class),
                Arguments.of(object_allSetters(), true, byte.class),
                Arguments.of(object_allSetters(), true, short.class),
                Arguments.of(object_allSetters(), true, int.class),
                Arguments.of(object_allSetters(), true, long.class),
                Arguments.of(object_allSetters(), true, char.class),
                Arguments.of(object_allSetters(), true, float.class),
                Arguments.of(object_allSetters(), true, double.class),
                Arguments.of(object_booleanSetter(), false, boolean.class),
                Arguments.of(object_shortSetter(), false, short.class),
                Arguments.of(object_intSetter(), false, int.class),
                Arguments.of(object_longSetter(), false, long.class),
                Arguments.of(object_charSetter(), false, char.class),
                Arguments.of(object_floatSetter(), false, float.class),
                Arguments.of(object_doubleSetter(), false, double.class)
        );
    }

    @ParameterizedTest
    @MethodSource("providedArgs_testSetNull")
    void testSetNull(TestObject testObject,
                     boolean expectedResult,
                     Class<?> valueType) {
        SetterUtil mySetterUtil = getSetterUtil();
        assertEquals(expectedResult, mySetterUtil.setValue(null, testObject, PROPERTY_NAME, valueType));
//        if (mySetterUtil instanceof MySetterUtil) {
//            List<Class<?>> utilClassTypeList = new ArrayList<>(((MySetterUtil) mySetterUtil).getClassTypeSet());
//            List<Class<?>> testObjectClassTypeList = testObject.getInfoClassTypeList();
//            assertTrue(utilClassTypeList.contains(valueType));
//            if (expectedResult) {
//                assertEquals(Object.class, testObjectClassTypeList.get(testObjectClassTypeList.size() - 1));
//            } else {
//                assertTrue(testObjectClassTypeList.isEmpty());
//            }
//        }

    }

    private static Stream<Arguments> providedArgs_testBooleanPrimitive() {
        return Stream.of(
                Arguments.of(true, object_booleanSetter(), true),
                Arguments.of(true, object_byteSetter(), false),
                Arguments.of(true, object_shortSetter(), false),
                Arguments.of(true, object_intSetter(), false),
                Arguments.of(true, object_longSetter(), false),
                Arguments.of(true, object_floatSetter(), false),
                Arguments.of(true, object_doubleSetter(), false),
                Arguments.of(true, object_charSetter(), false),
                Arguments.of(true, object_ObjectSetter(), true),
                Arguments.of(true, object_NumberSetter(), false),
                Arguments.of(true, object_BooleanSetter(), true)
        );
    }

    @ParameterizedTest
    @MethodSource("providedArgs_testBooleanPrimitive")
    void testBooleanPrimitive(boolean value,
                              TestObject testObject,
                              boolean expectedResult) {
        SetterUtil mySetterUtil = getSetterUtil();
        assertEquals(expectedResult, mySetterUtil.setValue(value, testObject, PROPERTY_NAME));
        baseTest(testObject, mySetterUtil);
    }

    private static Stream<Arguments> providedArgs_testBytePrimitive() {
        return Stream.of(
                Arguments.of((byte) 1, object_booleanSetter(), false),
                Arguments.of((byte) 2, object_byteSetter(), true),
                Arguments.of((byte) 3, object_shortSetter(), true),
                Arguments.of((byte) 4, object_intSetter(), true),
                Arguments.of((byte) 5, object_longSetter(), true),
                Arguments.of((byte) 6, object_floatSetter(), true),
                Arguments.of((byte) 7, object_doubleSetter(), true),
                Arguments.of((byte) 8, object_charSetter(), false),
                Arguments.of((byte) 9, object_ObjectSetter(), true),
                Arguments.of((byte) 10, object_NumberSetter(), true),
                Arguments.of((byte) 11, object_ByteSetter(), true)
        );
    }

    @ParameterizedTest
    @MethodSource("providedArgs_testBytePrimitive")
    void testBytePrimitive(byte value,
                           TestObject testObject,
                           boolean expectedResult) {
        SetterUtil mySetterUtil = getSetterUtil();
        assertEquals(expectedResult, mySetterUtil.setValue(value, testObject, PROPERTY_NAME));
        baseTest(testObject, mySetterUtil);
    }

    private static Stream<Arguments> providedArgs_testShortPrimitive() {
        return Stream.of(
                Arguments.of((short) 1, object_booleanSetter(), false),
                Arguments.of((short) 2, object_byteSetter(), false),
                Arguments.of((short) 3, object_shortSetter(), true),
                Arguments.of((short) 4, object_intSetter(), true),
                Arguments.of((short) 5, object_longSetter(), true),
                Arguments.of((short) 6, object_floatSetter(), true),
                Arguments.of((short) 7, object_doubleSetter(), true),
                Arguments.of((short) 8, object_charSetter(), false),
                Arguments.of((short) 9, object_ObjectSetter(), true),
                Arguments.of((short) 10, object_NumberSetter(), true),
                Arguments.of((short) 11, object_ShortSetter(), true)
        );
    }

    @ParameterizedTest
    @MethodSource("providedArgs_testShortPrimitive")
    void testShortPrimitive(short value,
                            TestObject testObject,
                            boolean expectedResult) {
        SetterUtil mySetterUtil = getSetterUtil();
        assertEquals(expectedResult, mySetterUtil.setValue(value, testObject, PROPERTY_NAME));
        baseTest(testObject, mySetterUtil);
    }

    private static Stream<Arguments> providedArgs_testIntPrimitive() {
        return Stream.of(
                Arguments.of(1, object_booleanSetter(), false),
                Arguments.of(2, object_byteSetter(), false),
                Arguments.of(3, object_shortSetter(), false),
                Arguments.of(4, object_intSetter(), true),
                Arguments.of(5, object_longSetter(), true),
                Arguments.of(6, object_floatSetter(), true),
                Arguments.of(7, object_doubleSetter(), true),
                Arguments.of(8, object_charSetter(), false),
                Arguments.of(9, object_ObjectSetter(), true),
                Arguments.of(10, object_NumberSetter(), true),
                Arguments.of(11, object_IntegerSetter(), true)
        );
    }

    @ParameterizedTest
    @MethodSource("providedArgs_testIntPrimitive")
    void testIntPrimitive(int value,
                          TestObject testObject,
                          boolean expectedResult) {
        SetterUtil mySetterUtil = getSetterUtil();
        assertEquals(expectedResult, mySetterUtil.setValue(value, testObject, PROPERTY_NAME));
        baseTest(testObject, mySetterUtil);
    }

    private static Stream<Arguments> providedArgs_testLongPrimitive() {
        return Stream.of(
                Arguments.of(1L, object_booleanSetter(), false),
                Arguments.of(2L, object_byteSetter(), false),
                Arguments.of(3L, object_shortSetter(), false),
                Arguments.of(4L, object_intSetter(), false),
                Arguments.of(5L, object_longSetter(), true),
                Arguments.of(6L, object_floatSetter(), true),
                Arguments.of(7L, object_doubleSetter(), true),
                Arguments.of(8L, object_charSetter(), false),
                Arguments.of(9L, object_ObjectSetter(), true),
                Arguments.of(10L, object_NumberSetter(), true),
                Arguments.of(11L, object_LongSetter(), true)
        );
    }

    @ParameterizedTest
    @MethodSource("providedArgs_testLongPrimitive")
    void testLongPrimitive(long value,
                           TestObject testObject,
                           boolean expectedResult) {
        SetterUtil mySetterUtil = getSetterUtil();
        assertEquals(expectedResult, mySetterUtil.setValue(value, testObject, PROPERTY_NAME));
        baseTest(testObject, mySetterUtil);
    }

    private static Stream<Arguments> providedArgs_testFloatPrimitive() {
        return Stream.of(
                Arguments.of(1F, object_booleanSetter(), false),
                Arguments.of(2F, object_byteSetter(), false),
                Arguments.of(3F, object_shortSetter(), false),
                Arguments.of(4F, object_intSetter(), false),
                Arguments.of(5F, object_longSetter(), false),
                Arguments.of(6F, object_floatSetter(), true),
                Arguments.of(7F, object_doubleSetter(), true),
                Arguments.of(8F, object_charSetter(), false),
                Arguments.of(9F, object_ObjectSetter(), true),
                Arguments.of(10F, object_NumberSetter(), true),
                Arguments.of(11F, object_FloatSetter(), true)
        );
    }

    @ParameterizedTest
    @MethodSource("providedArgs_testFloatPrimitive")
    void testFloatPrimitive(float value,
                            TestObject testObject,
                            boolean expectedResult) {
        SetterUtil mySetterUtil = getSetterUtil();
        assertEquals(expectedResult, mySetterUtil.setValue(value, testObject, PROPERTY_NAME));
        baseTest(testObject, mySetterUtil);
    }

    private static Stream<Arguments> providedArgs_testDoublePrimitive() {
        return Stream.of(
                Arguments.of(1D, object_booleanSetter(), false),
                Arguments.of(2D, object_byteSetter(), false),
                Arguments.of(3D, object_shortSetter(), false),
                Arguments.of(4D, object_intSetter(), false),
                Arguments.of(5D, object_longSetter(), false),
                Arguments.of(6D, object_floatSetter(), false),
                Arguments.of(7D, object_doubleSetter(), true),
                Arguments.of(8D, object_charSetter(), false),
                Arguments.of(9D, object_ObjectSetter(), true),
                Arguments.of(10D, object_NumberSetter(), true),
                Arguments.of(11D, object_DoubleSetter(), true)
        );
    }

    @ParameterizedTest
    @MethodSource("providedArgs_testDoublePrimitive")
    void testDoublePrimitive(double value,
                             TestObject testObject,
                             boolean expectedResult) {
        SetterUtil mySetterUtil = getSetterUtil();
        assertEquals(expectedResult, mySetterUtil.setValue(value, testObject, PROPERTY_NAME));
        baseTest(testObject, mySetterUtil);
    }

    private static Stream<Arguments> providedArgs_testCharPrimitive() {
        return Stream.of(
                Arguments.of((char) 1, object_booleanSetter(), false),
                Arguments.of((char) 2, object_byteSetter(), false),
                Arguments.of((char) 3, object_shortSetter(), false),
                Arguments.of((char) 4, object_intSetter(), true),
                Arguments.of((char) 5, object_longSetter(), true),
                Arguments.of((char) 6, object_floatSetter(), true),
                Arguments.of((char) 7, object_doubleSetter(), true),
                Arguments.of((char) 8, object_charSetter(), true),
                Arguments.of((char) 9, object_ObjectSetter(), true),
                Arguments.of((char) 10, object_NumberSetter(), false),
                Arguments.of((char) 11, object_CharacterSetter(), true)
        );
    }

    @ParameterizedTest
    @MethodSource("providedArgs_testCharPrimitive")
    void testCharPrimitive(char value,
                           TestObject testObject,
                           boolean expectedResult) {
        SetterUtil mySetterUtil = getSetterUtil();
        assertEquals(expectedResult, mySetterUtil.setValue(value, testObject, PROPERTY_NAME));
        baseTest(testObject, mySetterUtil);
    }

    private static void baseTest(TestObject testObject, SetterUtil mySetterUtil) {
//        if (mySetterUtil instanceof MySetterUtil) {
//            List<Class<?>> utilClassTypeList = new ArrayList<>(((MySetterUtil) mySetterUtil).getClassTypeSet());
//            List<Class<?>> testObjectClassTypeList = testObject.getInfoClassTypeList();
//            assertTrue(utilClassTypeList.containsAll(testObjectClassTypeList));
//        }
    }

    private static Stream<Object> providedArgs_testValueIsNull() {
        return Stream.of(nullObject, nullBoolean, nullByte, nullShort, nullInteger, nullLong, nullCharacter, nullFloat, nullDouble, null);
    }

    @ParameterizedTest
    @MethodSource("providedArgs_testValueIsNull")
    void testValueIsNull(Object nullValueObject) {
        assertFalse(getSetterUtil().setValue(nullValueObject, object_allSetters(), PROPERTY_NAME));
    }

    private static Stream<String> providedArgs_testPropertyNameIsBlank() {
        return Stream.of("", "\n", null);
    }

    @ParameterizedTest
    @MethodSource("providedArgs_testPropertyNameIsBlank")
    void testPropertyNameIsBlank(String blankStr) {
        assertFalse(getSetterUtil().setValue(1, object_allSetters(), blankStr));
        assertFalse(getSetterUtil().setValue(2, object_allSetters(), blankStr, Object.class));
    }

    @Test
    void testTargetObjectIsNull() {
        assertFalse(getSetterUtil().setValue(1, null, PROPERTY_NAME));
    }

    private static Stream<Class<?>> providedArgs_testTargetObjectIsNull() {
        return Stream.of(
                boolean.class,
                byte.class,
                short.class,
                int.class,
                long.class,
                char.class,
                float.class,
                double.class,
                Object.class,
                Number.class,
                Boolean.class,
                Byte.class,
                Short.class,
                Integer.class,
                Long.class,
                Character.class,
                Float.class,
                Double.class
        );
    }

    @ParameterizedTest
    @MethodSource("providedArgs_testTargetObjectIsNull")
    void testTargetObjectIsNull(Class<?> valueType) {
        assertFalse(getSetterUtil().setValue(1, null, PROPERTY_NAME, valueType));
    }

}
