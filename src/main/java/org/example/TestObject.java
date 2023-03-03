package org.example;


public class TestObject {

    private long longPrimitiveValue;
    private int intPrimitiveValue;


    private final RegisterType registeredType = new RegisterType();

    public RegisterType getRegisteredType() {
        return registeredType;
    }

    public long getLongPrimitiveValue() {
        return longPrimitiveValue;
    }

    public void setLongPrimitiveValue(long longPrimitiveValue) {
        registeredType.registerSetter(long.class);
        this.longPrimitiveValue = longPrimitiveValue;
    }


    public void setLongPrimitiveValue(int intPrimitiveValue) {
        registeredType.registerSetter(int.class);
        this.longPrimitiveValue = intPrimitiveValue;
    }

    public void setLongPrimitiveValue(float intPrimitiveValue) {
        registeredType.registerSetter(float.class);
        this.longPrimitiveValue = (long) intPrimitiveValue;
    }

    public void setLongPrimitiveValue(double intPrimitiveValue) {
        registeredType.registerSetter(double.class);
        this.longPrimitiveValue = (long) intPrimitiveValue;
    }

//    public void setLongPrimitiveValue(char primitiveValue) {
//        registerSetter(char.class);
//        this.longPrimitiveValue = primitiveValue;
//    }

    public void setLongPrimitiveValue(short primitiveValue) {
        registeredType.registerSetter(short.class);
        this.longPrimitiveValue = primitiveValue;
    }

    public void setLongPrimitiveValue(byte primitiveValue) {
        registeredType.registerSetter(byte.class);
        this.longPrimitiveValue = primitiveValue;
    }

    public void setLongPrimitiveValue(Integer objectValue) {
        registeredType.registerSetter(Integer.class);
        this.longPrimitiveValue = objectValue;
    }

    public void setLongPrimitiveValue(Long objectValue) {
        registeredType.registerSetter(Long.class);
        this.longPrimitiveValue = objectValue;
    }

//    public void setLongPrimitiveValue(Byte primitiveValue) {
//        registerSetter(Byte.class);
//        this.longPrimitiveValue = primitiveValue;
//    }

    public void setLongPrimitiveValue(Character objectValue) {
        registeredType.registerSetter(Character.class);
        this.longPrimitiveValue = objectValue;
    }

    public void setLongPrimitiveValue(Short objectValue) {
        registeredType.registerSetter(Short.class);
        this.longPrimitiveValue = objectValue;
    }

    public void setLongPrimitiveValue(Float objectValue) {
        registeredType.registerSetter(Float.class);
        this.longPrimitiveValue = Long.getLong(Float.toString(objectValue));
    }

    public void setLongPrimitiveValue(Double objectValue) {
        registeredType.registerSetter(Double.class);
        this.longPrimitiveValue = Long.getLong(Double.toString(objectValue));
    }

//    public void setLongPrimitiveValue(String objectValue) {
//        registerSetter(objectValue.getClass());
//        this.longPrimitiveValue = Long.parseLong(objectValue);
//    }

    public void setLongPrimitiveValue(Object objectValue) {
        registeredType.registerSetter(Object.class);
        this.longPrimitiveValue = (long) objectValue;
    }

    public void setLongPrimitiveValue(Number objectValue) {
        registeredType.registerSetter(Number.class);
        this.longPrimitiveValue = (objectValue).longValue();
    }

    public void setIntPrimitiveValue(int intPrimitiveValue) {
        this.intPrimitiveValue = intPrimitiveValue;
    }

    public void setIntPrimitiveValue(long primitiveValue) {
        this.intPrimitiveValue = (int) primitiveValue;
    }

}
