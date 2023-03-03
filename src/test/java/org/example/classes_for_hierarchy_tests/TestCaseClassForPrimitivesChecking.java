package org.example.classes_for_hierarchy_tests;

import org.example.RegisterType;

public class TestCaseClassForPrimitivesChecking {

    private long longPrimitiveValue;

    private final RegisterType registeredType = new RegisterType();

    public void setLongPrimitiveValue(int longPrimitiveValue) {
        registeredType.registerSetter(int.class);
        this.longPrimitiveValue = longPrimitiveValue;
    }

    public void setLongPrimitiveValue(double longPrimitiveValue) {
        registeredType.registerSetter(double.class);
        this.longPrimitiveValue = (long)longPrimitiveValue;
    }

    public RegisterType getRegisteredType() {
        return registeredType;
    }
}
