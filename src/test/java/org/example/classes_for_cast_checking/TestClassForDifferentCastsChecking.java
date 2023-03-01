package org.example.classes_for_cast_checking;

public class TestClassForDifferentCastsChecking {

    private long longPrimitiveValue;

    public void setLongPrimitiveValue(int longPrimitiveValue) {
        registerSetter(int.class);
        this.longPrimitiveValue = longPrimitiveValue;
    }
    public void setLongPrimitiveValue(long longPrimitiveValue) {
        registerSetter(long.class);
        this.longPrimitiveValue = longPrimitiveValue;
    }
    public void setLongPrimitiveValue(byte longPrimitiveValue) {
        registerSetter(byte.class);
        this.longPrimitiveValue = longPrimitiveValue;
    }
    public void setLongPrimitiveValue(short longPrimitiveValue) {
        registerSetter(short.class);
        this.longPrimitiveValue = longPrimitiveValue;
    }
    public void setLongPrimitiveValue(char longPrimitiveValue) {
        registerSetter(char.class);
        this.longPrimitiveValue = longPrimitiveValue;
    }

    public void setLongPrimitiveValue(double longPrimitiveValue) {
        registerSetter(double.class);
        this.longPrimitiveValue = (long) longPrimitiveValue;
    }

    public void setLongPrimitiveValue(float longPrimitiveValue) {
        registerSetter(float.class);
        this.longPrimitiveValue = (long) longPrimitiveValue;
    }

    private Class<?> registeredType;

    private void registerSetter(Class<?> classType){
        this.registeredType = classType;
    }

    public Class<?> getRegisteredType() {
        return registeredType;
    }


}
