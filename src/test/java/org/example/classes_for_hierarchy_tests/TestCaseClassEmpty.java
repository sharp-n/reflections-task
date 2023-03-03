package org.example.classes_for_hierarchy_tests;

import org.example.RegisterType;

public class TestCaseClassEmpty {

    private long longPrimitiveValue;

    private final RegisterType registeredType = new RegisterType();

    public RegisterType getRegisteredType() {
        return registeredType;
    }
}
