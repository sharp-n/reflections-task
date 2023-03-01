package org.example.classes_for_cast_checking;

public class TestClassForIntCastChecking {

    private long longPrimitiveValue;

    public void setLongPrimitiveValue(int longPrimitiveValue) {
        registerSetter(int.class);
        this.longPrimitiveValue = longPrimitiveValue;
    }

    private Class<?> registeredType;

    private void registerSetter(Class<?> classType){
        this.registeredType = classType;
    }

    public Class<?> getRegisteredType() {
        return registeredType;
    }

}
