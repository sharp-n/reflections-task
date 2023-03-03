package org.example;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class VhTest {

//    @Test
//    public void test() throws Exception {
//
//        Short s = (Short) null;
//        System.out.println(s.getClass());
//        Method method = VhTest.class.getMethod("method", Integer.class);
//        Byte b = null;
//        method(null);
//        method.invoke(null, b);
//        newArrayList();
//    }

//    public static void method(int o){
//        System.out.printf("int");
//    }

    public static void method(Integer o) {
        System.out.printf("Integer");
    }

    //    public static void method(Long o){
//        System.out.printf("Long");
//    }
    public static void method(long o) {
        System.out.printf("long");
    }

    static <T> List<T> newArrayList(Collection<T>... collections) {
        ArrayList<T> list = new ArrayList<>();
        for (Collection<T> collection : collections) {
            list.addAll(collection);
        }
        return list;
    }

    static <T> List<T> newArrayList(T... element) {
        ArrayList<T> list = new ArrayList<>();
        for (T t : element) {
            list.add(t);
        }
        return list;
    }


}
