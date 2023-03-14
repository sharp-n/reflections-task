package org.example.classes_for_hierarchy_tests;

import org.example.RegisterType;

public class TestCaseClassWithoutWrappers {

    private final RegisterType registeredType = new RegisterType();

    public void setLongPrimitiveValue(Number objectValue) {
        registeredType.registerSetter(Number.class);
    }

    public void setLongPrimitiveValue(Object objectValue) {
        registeredType.registerSetter(Object.class);
    }

    public RegisterType getRegisteredType() {
        return registeredType;
    }

}
