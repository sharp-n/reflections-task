package org.example;


public class TestObject {

    private long longPrimitiveValue;
    private int intPrimitiveValue;


    public long getLongPrimitiveValue() {
        return longPrimitiveValue;
    }

    public void setLongPrimitiveValue(long longPrimitiveValue) {
        registerSetter(long.class);
        this.longPrimitiveValue = longPrimitiveValue;
    }


    public void setLongPrimitiveValue(int intPrimitiveValue) {
        registerSetter(int.class);
        this.longPrimitiveValue = intPrimitiveValue;
    }

    public void setLongPrimitiveValue(float intPrimitiveValue) {
        registerSetter(float.class);
        this.longPrimitiveValue = (long) intPrimitiveValue;
    }

    public void setLongPrimitiveValue(double intPrimitiveValue) {
        registerSetter(double.class);
        this.longPrimitiveValue = (long) intPrimitiveValue;
    }

//    public void setLongPrimitiveValue(char primitiveValue) {
//        registerSetter(char.class);
//        this.longPrimitiveValue = primitiveValue;
//    }

    public void setLongPrimitiveValue(short primitiveValue) {
        registerSetter(short.class);
        this.longPrimitiveValue = primitiveValue;
    }

    public void setLongPrimitiveValue(byte primitiveValue) {
        registerSetter(byte.class);
        this.longPrimitiveValue = primitiveValue;
    }

    public void setLongPrimitiveValue(Integer objectValue) {
        registerSetter(Integer.class);
        this.longPrimitiveValue = objectValue;
    }

    public void setLongPrimitiveValue(Long objectValue) {
        registerSetter(Long.class);
        this.longPrimitiveValue = objectValue;
    }

//    public void setLongPrimitiveValue(Byte primitiveValue) {
//        registerSetter(Byte.class);
//        this.longPrimitiveValue = primitiveValue;
//    }

    public void setLongPrimitiveValue(Character objectValue) {
        registerSetter(objectValue.getClass());
        this.longPrimitiveValue = objectValue;
    }

    public void setLongPrimitiveValue(Short objectValue) {
        registerSetter(objectValue.getClass());
        this.longPrimitiveValue = objectValue;
    }

    public void setLongPrimitiveValue(Float objectValue) {
        registerSetter(objectValue.getClass());
        this.longPrimitiveValue = Long.getLong(Float.toString(objectValue));
    }

    public void setLongPrimitiveValue(Double objectValue) {
        registerSetter(objectValue.getClass());
        this.longPrimitiveValue = Long.getLong(Double.toString(objectValue));
    }

//    public void setLongPrimitiveValue(String objectValue) {
//        registerSetter(objectValue.getClass());
//        this.longPrimitiveValue = Long.parseLong(objectValue);
//    }

    public void setLongPrimitiveValue(Object objectValue) {
        registerSetter(Object.class);
        this.longPrimitiveValue = (long) objectValue;
    }

    public void setLongPrimitiveValue(Number objectValue) {
        registerSetter(Number.class);
        this.longPrimitiveValue = (objectValue).longValue();
    }

    public void setIntPrimitiveValue(int intPrimitiveValue) {
        this.intPrimitiveValue = intPrimitiveValue;
    }

    public void setIntPrimitiveValue(long primitiveValue) {
        this.intPrimitiveValue = intPrimitiveValue;
    }

    private Class<?> registeredType;

    private void registerSetter(Class<?> classType){
        this.registeredType = classType;
    }

    public Class<?> getRegisteredType() {
        return registeredType;
    }
}
