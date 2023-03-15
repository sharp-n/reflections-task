package org.example.classes_for_hierarchy_tests;

import org.example.RegisterType;

public class TestCaseEnums {

    public enum TestEnum{
        TEST_ENUM()
    }

    public interface InterfaceForEnum{}

    public interface InterfaceForEnum2{}

    public enum TestEnum2 implements InterfaceForEnum {
        TEST_ENUM_INTERFACE()
    }

    public enum TestEnum3 implements InterfaceForEnum, InterfaceForEnum2 {
        TEST_ENUM_INTERFACE()
    }

    RegisterType registerType = new RegisterType();

    public RegisterType getRegisterType() {
        return registerType;
    }

    public void setValue(TestEnum value){
        registerType.registerSetter(TestEnum.class);
    }

    public void setValue(InterfaceForEnum value){
        registerType.registerSetter(InterfaceForEnum.class);
    }

    public void setValue(InterfaceForEnum2 value){
        registerType.registerSetter(InterfaceForEnum.class);
    }

}
