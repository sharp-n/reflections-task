package org.example.classes_for_hierarchy_tests;

import org.example.RegisterType;

public class TestCaseClassWithoutPrimitives {

    private long longPrimitiveValue;

    private final RegisterType registeredType = new RegisterType();

    public void setLongPrimitiveValue(Long objectValue) {
        registeredType.registerSetter(Long.class);
        this.longPrimitiveValue = objectValue;
    }

    public void setLongPrimitiveValue(Integer objectValue) {
        registeredType.registerSetter(Integer.class);
        this.longPrimitiveValue = objectValue;
    }

    public void setLongPrimitiveValue(Byte objectValue) {
        registeredType.registerSetter(Byte.class);
        this.longPrimitiveValue = objectValue;
    }

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
        this.longPrimitiveValue = objectValue.longValue();
    }

    public void setLongPrimitiveValue(Double objectValue) {
        registeredType.registerSetter(Double.class);
        this.longPrimitiveValue = objectValue.longValue();
    }

    public void setLongPrimitiveValue(Number objectValue) {
        registeredType.registerSetter(Number.class);
        this.longPrimitiveValue = (long)objectValue;
    }

    public void setLongPrimitiveValue(Object objectValue) {
        registeredType.registerSetter(Object.class);
        this.longPrimitiveValue = (long)objectValue;
    }



    public RegisterType getRegisteredType() {
        return registeredType;
    }

}
