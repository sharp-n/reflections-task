package org.example.classes_for_hierarchy_tests;

import org.example.RegisterType;

public class TestCaseClassWithoutPrimitives {

    private final RegisterType registeredType = new RegisterType();

    public void setLongPrimitiveValue(Long objectValue) {
        registeredType.registerSetter(Long.class);
    }

    public void setLongPrimitiveValue(Integer objectValue) {
        registeredType.registerSetter(Integer.class);
    }

    public void setLongPrimitiveValue(Byte objectValue) {
        registeredType.registerSetter(Byte.class);
    }

    public void setLongPrimitiveValue(Character objectValue) {
        registeredType.registerSetter(Character.class);
    }

    public void setLongPrimitiveValue(Short objectValue) {
        registeredType.registerSetter(Short.class);
    }

    public void setLongPrimitiveValue(Float objectValue) {
        registeredType.registerSetter(Float.class);
    }

    public void setLongPrimitiveValue(Double objectValue) {
        registeredType.registerSetter(Double.class);
    }

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
