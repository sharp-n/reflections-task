package org.example.classes_for_hierarchy_tests;

import org.example.RegisterType;

import java.util.*;

public class TestCaseClassForHierarchyChecking {

    public static void main(String [] args){
        TestCaseClassForHierarchyChecking test = new TestCaseClassForHierarchyChecking();
        test.setValue(new MyClass4());
    }

    RegisterType registerType = new RegisterType();

    public RegisterType getRegisterType() {
        return registerType;
    }

    public interface MyInterface {}

    public interface MySecondInterface {}

    public interface MyThirdInterface {}

    public static class MyClassWithMultipleInterfaces implements MyInterface,MySecondInterface,MyThirdInterface{}

    public abstract static class MyAbstractClass{}

    public static class MyClass1 implements MyInterface {}

    public static class MyClass2 extends MyAbstractClass implements MyInterface, MySecondInterface {}

    public static class MyClass3 extends MyClass2{}

    public static class MyClass4 extends MyClass3{}

    public static class MyClass5 extends MyClass4{}

    public static class MyCollection extends ArrayList<String> {}

    public void setValue(MyInterface value){
        registerType.registerSetter(MyInterface.class);
    }

    public void setValue(MySecondInterface value){
        registerType.registerSetter(MySecondInterface.class);
    }

    public void setValue(MyClass4 value){
        registerType.registerSetter(MySecondInterface.class);
    }

    public void setValue(ArrayList<?> value){registerType.registerSetter(ArrayList.class);}

    public void setValue(Collection<?> value){registerType.registerSetter(Collection.class);}

    public void setValue(Set<?> value) {
        registerType.registerSetter(Set.class);
    }

    public void setValue(byte value){
        registerType.registerSetter(byte.class);
    }
    public void setValue(short value){
        registerType.registerSetter(short.class);
    }
    public void setValue(char value){
        registerType.registerSetter(char.class);
    }
    public void setValue(int value){
        registerType.registerSetter(int.class);
    }
    public void setValue(long value){
        registerType.registerSetter(long.class);
    }public void setValue(float value){
        registerType.registerSetter(float.class);
    }

    public void setValue(double value){
        registerType.registerSetter(double.class);
    }

    public void setValue(boolean value){
        registerType.registerSetter(boolean.class);
    }

}
