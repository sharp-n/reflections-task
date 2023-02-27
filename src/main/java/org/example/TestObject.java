package org.example;


public class TestObject {

    private long longPrimitiveValue;
    private int intPrimitiveValue;


    public long getLongPrimitiveValue() {
        return longPrimitiveValue;
    }

    public void setLongPrimitiveValue(long longPrimitiveValue) {
        this.longPrimitiveValue = longPrimitiveValue;
    }


    public void setLongPrimitiveValue(int intPrimitiveValue) {
        this.longPrimitiveValue = intPrimitiveValue;
    }

    public void setLongPrimitiveValue(char primitiveValue) {
        this.longPrimitiveValue = primitiveValue;
    }

    public void setLongPrimitiveValue(short primitiveValue) {
        this.longPrimitiveValue = primitiveValue;
    }

    public void setLongPrimitiveValue(byte primitiveValue) {
        this.longPrimitiveValue = primitiveValue;
    }

    public void setLongPrimitiveValue(Integer objectValue) {
        this.longPrimitiveValue = objectValue;
    }

    public void setLongPrimitiveValue(Long objectValue) {
        this.longPrimitiveValue = objectValue;
    }

    public void setLongPrimitiveValue(Byte primitiveValue) {
        this.longPrimitiveValue = primitiveValue;
    }

    public void setLongPrimitiveValue(Character objectValue) {
        this.longPrimitiveValue = objectValue;
    }

    public void setLongPrimitiveValue(Short objectValue) {
        this.longPrimitiveValue = objectValue;
    }

    public void setLongPrimitiveValue(String objectValue) {
        this.longPrimitiveValue = Long.parseLong(objectValue);
    }

    public void setLongPrimitiveValue(Object objectValue) {
        this.longPrimitiveValue = (long) objectValue;
    }

    public void setIntPrimitiveValue(int intPrimitiveValue) {
        this.intPrimitiveValue = intPrimitiveValue;
    }

    public void setIntPrimitiveValue(long primitiveValue) {
        this.intPrimitiveValue = intPrimitiveValue;
    }
}
