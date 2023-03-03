package org.example.classes_for_hierarchy_tests;

import org.example.RegisterType;

public class TestCaseClassWithoutWrappers {

    private long longPrimitiveValue;

    private final RegisterType registeredType = new RegisterType();

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
