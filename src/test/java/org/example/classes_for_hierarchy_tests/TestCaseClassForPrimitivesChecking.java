package org.example.classes_for_hierarchy_tests;

import org.example.RegisterType;

public class TestCaseClassForPrimitivesChecking {

    private final RegisterType registeredType = new RegisterType();

    public void setLongPrimitiveValue(int longPrimitiveValue) {
        registeredType.registerSetter(int.class);
    }

    public void setLongPrimitiveValue(double longPrimitiveValue) {
        registeredType.registerSetter(double.class);
    }

    public RegisterType getRegisteredType() {
        return registeredType;
    }
}
