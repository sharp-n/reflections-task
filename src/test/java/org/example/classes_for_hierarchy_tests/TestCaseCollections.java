package org.example.classes_for_hierarchy_tests;

import org.example.RegisterType;

import java.awt.*;
import java.util.*;
import java.util.List;

public class TestCaseCollections {

    public static class GenericsTest{

        public static void main(String [] args){
            new GenericsTest().setValue("2");
        }

        public <T> void setValue(T value){
            value.getClass().getGenericSuperclass();
            System.out.println(value.getClass());
        }

    }

    public static class CollectionsTest{

        public static void main(String [] args){
            setValue(new ArrayList<>());
        }

        public static void setValue(AbstractList<?> value){
            System.out.println(AbstractList.class.getName());
        }


        public static void setValue(List<?> value){
            System.out.println(List.class.getName());
        }


    }

    public static class CollectionsSetter{
        RegisterType registerType = new RegisterType();

        public void setValue(Stack<?> value){
            registerType.registerSetter(Stack.class);
        }

        public void setValue(LinkedList<?> value){
            registerType.registerSetter(LinkedList.class);
        }

        public void setValue(ArrayList<?> value){
            registerType.registerSetter(ArrayList.class);
        }

        public void setValue(ArrayDeque<?> value){
            registerType.registerSetter(ArrayDeque.class);
        }

        public void setValue(Vector<?> value){
            registerType.registerSetter(Vector.class);
        }

        public void setValue(TreeSet<?> value){
            registerType.registerSetter(TreeSet.class);
        }

        public void setValue(HashSet<?> value){
            registerType.registerSetter(HashSet.class);
        }

        public void setValue(LinkedHashSet<?> value){
            registerType.registerSetter(LinkedHashSet.class);
        }

    }

    public static class CollectionsSetterWithGenericDefinedType {

        public static void main(String [] args){
            CollectionsSetterWithGenericDefinedType obj = new CollectionsSetterWithGenericDefinedType();
//            obj.setValue(new ArrayList<>(Arrays.asList("1","2")));
        }

        RegisterType registerType = new RegisterType();

        public RegisterType getRegisterType() {
            return registerType;
        }

        public void setValue(Stack<Integer> value){
            registerType.registerSetter(Stack.class);
        }

        public void setValue(LinkedList<Integer> value){
            registerType.registerSetter(LinkedList.class);
        }

        public void setValue(ArrayList<Integer> value){
            registerType.registerSetter(ArrayList.class);
        }

        public void setValue(ArrayDeque<Integer> value){
            registerType.registerSetter(ArrayDeque.class);
        }

        public void setValue(Vector<Integer> value){
            registerType.registerSetter(Vector.class);
        }

        public void setValue(TreeSet<Integer> value){
            registerType.registerSetter(TreeSet.class);
        }

        public void setValue(HashSet<Integer> value){
            registerType.registerSetter(HashSet.class);
        }

        public void setValue(LinkedHashSet<Integer> value){
            registerType.registerSetter(LinkedHashSet.class);
        }

    }


    public static class CollectionsSetterWithGenericType <T> {

        public static void main(String [] args){
            CollectionsSetterWithGenericType<Integer> obj = new CollectionsSetterWithGenericType<>();
//            obj.setValue(new ArrayList<>(Arrays.asList("1","2")));

        }

        RegisterType registerType = new RegisterType();

        public RegisterType getRegisterType() {
            return registerType;
        }

        public void setValue(Stack<T> value){
            registerType.registerSetter(Stack.class);
        }

        public void setValue(LinkedList<T> value){
            registerType.registerSetter(LinkedList.class);
        }

        public void setValue(ArrayList<T> value){
            registerType.registerSetter(ArrayList.class);
        }

        public void setValue(ArrayDeque<T> value){
            registerType.registerSetter(ArrayDeque.class);
        }

        public void setValue(Vector<T> value){
            registerType.registerSetter(Vector.class);
        }

        public void setValue(TreeSet<T> value){
            registerType.registerSetter(TreeSet.class);
        }

        public void setValue(HashSet<T> value){
            registerType.registerSetter(HashSet.class);
        }

        public void setValue(LinkedHashSet<T> value){
            registerType.registerSetter(LinkedHashSet.class);
        }

    }

}
