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
}
