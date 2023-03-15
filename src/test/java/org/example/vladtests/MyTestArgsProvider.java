package org.example.vladtests;

public class MyTestArgsProvider {

    // TODO refactor class

    public static Object object_ShortSetter() {
        return new TestObject() {
            public void setSomeVar(Short someVar) {
                registerValue(someVar);
            }
        };
    }

    public static Object object_ByteSetter() {
        return new TestObject() {
            public void setSomeVar(Byte someVar) {
                registerValue(someVar);
            }
        };
    }

    public static Object object_BooleanSetter() {
        return new TestObject() {
            public void setSomeVar(Boolean someVar) {
                registerValue(someVar);
            }
        };
    }

    public static Object object_floatSetter() {
        return new TestObject() {
            public void setSomeVar(float someVar) {
                registerValue(someVar);
            }
        };
    }

    public static Object object_FloatSetter() {
        return new TestObject() {
            public void setSomeVar(Float someVar) {
                registerValue(someVar);
            }
        };
    }

    public static Object object_longSetter() {
        return new TestObject() {
            public void setSomeVar(long someVar) {
                registerValue(someVar);
            }
        };
    }

    public static Object object_charSetter() {
        return new TestObject() {
            public void setSomeVar(char someVar) {
                registerValue(someVar);
            }
        };
    }

    public static Object object_doubleSetter() {
        return new TestObject() {
            public void setSomeVar(double someVar) {
                registerValue(someVar);
            }
        };
    }

    public static Object object_MyNumberSetter() {
        return new TestObject() {
            public void setSomeVar(MyNumber someVar) {
                registerValue(someVar);
            }
        };
    }

    public static Object object_MyNumber2Setter() {
        return new TestObject() {
            public void setSomeVar(MyNumber2 someVar) {
                registerValue(someVar);
            }
        };
    }

    public static Object object_intSetter() {
        return new TestObject() {
            public void setSomeVar(int someVar) {
                registerValue(someVar);
            }
        };
    }

    public static Object object_shortSetter() {
        return new TestObject() {
            public void setSomeVar(short someVar) {
                registerValue(someVar);
            }
        };
    }

    public static Object object_booleanSetter() {
        return new TestObject() {
            public void setSomeVar(boolean someVar) {
                registerValue(someVar);
            }
        };
    }

    public static Object object_byteSetter() {
        return new TestObject() {
            public void setSomeVar(byte someVar) {
                registerValue(someVar);
            }
        };
    }

    public static Object object_IntegerSetter() {
        return new TestObject() {
            public void setSomeVar(Integer someVar) {
                registerValue(someVar);
            }
        };
    }

    public static Object object_LongSetter() {
        return new TestObject() {
            public void setSomeVar(Long someVar) {
                registerValue(someVar);
            }
        };
    }

    public static Object object_NumberSetter() {
        return new TestObject() {
            public void setSomeVar(Number someVar) {
                registerValue(someVar);
            }
        };
    }

    public static Object object_DoubleSetter() {
        return new TestObject() {
            public void setSomeVar(Double someVar) {
                registerValue(someVar);
            }
        };
    }

    public static Object object_CharacterSetter() {
        return new TestObject() {
            public void setSomeVar(Character someVar) {
                registerValue(someVar);
            }
        };
    }

    public static Object object_ObjectSetter() {
        return new TestObject() {
            public void setSomeVar(Object someVar) {
                registerValue(someVar);
            }
        };
    }

    static TestObject object_charPrimitiveAndWrapperSetter() {
        return new TestObject() {
            public void setSomeVar(Character someVar) {
                registerValue(someVar);
            }

            public void setSomeVar(char someVar) {
                registerValue(someVar);
            }
        };
    }

    static TestObject object_doublePrimitiveAndWrapperSetter() {
        return new TestObject() {
            public void setSomeVar(Double someVar) {
                registerValue(someVar);
            }

            public void setSomeVar(double someVar) {
                registerValue(someVar);
            }
        };
    }

    static TestObject object_floatPrimitiveAndWrapperSetter() {
        return new TestObject() {
            public void setSomeVar(Float someVar) {
                registerValue(someVar);
            }

            public void setSomeVar(float someVar) {
                registerValue(someVar);
            }
        };
    }

    static TestObject object_longPrimitiveAndWrapperSetter() {
        return new TestObject() {
            public void setSomeVar(Long someVar) {
                registerValue(someVar);
            }

            public void setSomeVar(long someVar) {
                registerValue(someVar);
            }
        };
    }

    static TestObject object_intPrimitiveAndWrapperSetter() {
        return new TestObject() {
            public void setSomeVar(Integer someVar) {
                registerValue(someVar);
            }

            public void setSomeVar(int someVar) {
                registerValue(someVar);
            }
        };
    }

    static class ShortPrimitiveAndWrapperSetter extends TestObject {
        public void setSomeVar(Short someVar) {
            registerValue(someVar);
        }

        public void setSomeVar(short someVar) {
            registerValue(someVar);
        }
    }

    static TestObject object_bytePrimitiveAndWrapperSetter() {
        return new TestObject() {
            public void setSomeVar(Byte someVar) {
                registerValue(someVar);
            }

            public void setSomeVar(byte someVar) {
                registerValue(someVar);
            }
        };
    }

    static TestObject object_booleanPrimitiveAndWrapperSetter() {
        return new TestObject() {
            public void setSomeVar(Boolean someVar) {
                registerValue(someVar);
            }

            public void setSomeVar(boolean someVar) {
                registerValue(someVar);
            }
        };
    }

    static TestObject object_caseSensitiveSetterTesting() {
        return new TestObject() {
            public void setSOmeVar(Boolean someVar) {
                registerValue(someVar);
            }

            public void setsomevar(boolean someVar) {
                registerValue(someVar);
            }

            public void SETSOMEWAR(boolean someVar) {
                registerValue(someVar);
            }

            public void setSOMEWAR(boolean someVar) {
                registerValue(someVar);
            }
        };
    }

    static TestObject object_ComparableInterface() {
        return new TestObject() {
            public void setSOmeVar(Comparable<?> someVar) {
                registerValue(someVar);
            }
        };
    }

    static TestObject object_noSetter() {
        return new TestObject();
    }

    static TestObject object_enumSetter() {
        return new TestObject() {
            public void setSomeVar(Enum someVar) {
                registerValue(someVar);
            }
        };
    }

    static TestObject object_testEnumSetter() {
        return new TestObject() {
            public void setSomeVar(TestEnum someVar) {
                registerValue(someVar);
            }
        };
    }

    static TestObject object_testEnum2Setter() {
        return new TestObject() {
            public void setSomeVar(TestEnum2 someVar) {
                registerValue(someVar);
            }
        };
    }

    static TestObject object_allSetters() {
        return new TestObject() {
            public void setSomeVar(boolean someVar) {
                registerValue(someVar);
            }

            public void setSomeVar(byte someVar) {
                registerValue(someVar);
            }

            public void setSomeVar(short someVar) {
                registerValue(someVar);
            }

            public void setSomeVar(int someVar) {
                registerValue(someVar);
            }

            public void setSomeVar(long someVar) {
                registerValue(someVar);
            }

            public void setSomeVar(char someVar) {
                registerValue(someVar);
            }

            public void setSomeVar(float someVar) {
                registerValue(someVar);
            }

            public void setSomeVar(double someVar) {
                registerValue(someVar);
            }

            public void setSomeVar(Boolean someVar) {
                registerValue(someVar);
            }

            public void setSomeVar(Byte someVar) {
                registerValue(someVar);
            }

            public void setSomeVar(Short someVar) {
                registerValue(someVar);
            }

            public void setSomeVar(Integer someVar) {
                registerValue(someVar);
            }

            public void setSomeVar(Long someVar) {
                registerValue(someVar);
            }

            public void setSomeVar(Character someVar) {
                registerValue(someVar);
            }

            public void setSomeVar(Float someVar) {
                registerValue(someVar);
            }

            public void setSomeVar(Double someVar) {
                registerValue(someVar);
            }

            public void setSomeVar(Number someVar) {
                registerValue(someVar);
            }

            public void setSomeVar(Object someVar) {
                registerValue(someVar);
            }

            public void setSomeVar(Enum someVar) {
                registerValue(someVar);
            }

            public void setSomeVar(TestEnum someVar) {
                registerValue(someVar);
            }

            public void setSomeVar(TestEnum2 someVar) {
                registerValue(someVar);
            }
        };
    }

    public static class MyNumber extends Number {

        private int value;

        public MyNumber(int value) {
            this.value = value;
        }

        @Override
        public int intValue() {
            return 0;
        }

        @Override
        public long longValue() {
            return 0;
        }

        @Override
        public float floatValue() {
            return 0;
        }

        @Override
        public double doubleValue() {
            return 0;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

    }

    public static class MyNumber2 extends MyNumber {

        public MyNumber2(int value) {
            super(value);
        }

    }

    public enum TestEnum {
        SOME_VALUE,
        ANOTHER_VALUE
    }

    public enum TestEnum2 {
        SOME_VALUE,
        ANOTHER_VALUE
    }

}
