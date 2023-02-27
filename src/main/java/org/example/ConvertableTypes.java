package org.example;

import java.util.*;

public class ConvertableTypes {

    static final List<Class<?>> baseHierarchyForInt = new ArrayList<>(Arrays.asList(Integer.class,Number.class,Object.class));
    static final List<Class<?>> baseHierarchyForByte = new ArrayList<>(Arrays.asList(Byte.class,Number.class,Object.class));
    static final List<Class<?>> baseHierarchyForShort = new ArrayList<>(Arrays.asList(Short.class,Number.class,Object.class));
    static final List<Class<?>> baseHierarchyForChar = new ArrayList<>(Arrays.asList(Character.class,Number.class,Object.class));
    static final List<Class<?>> baseHierarchyForLong = new ArrayList<>(Arrays.asList(Long.class,Number.class,Object.class));
    static final List<Class<?>> baseHierarchyForFloat = new ArrayList<>(Arrays.asList(Float.class,Number.class,Object.class));
    static final List<Class<?>> allTypesList = new ArrayList<>(Arrays.asList(
            byte.class,short.class,char.class,int.class,long.class,float.class,double.class,
            Byte.class,Short.class,Character.class,Integer.class,Long.class, Float.class,Double.class,
            String.class,Number.class, Object.class
    ));

    static final List<Class<?>> primitives = new ArrayList<>(Arrays.asList(
            byte.class,short.class,char.class,int.class,long.class,float.class,double.class
    ));

    static Map<Class<?>, List<Class<?>>> convertableTypes = new HashMap<>();

    static {
        convertableTypes.put(byte.class,concatLists(baseHierarchyForByte,primitives));
        convertableTypes.put(short.class,concatLists(baseHierarchyForShort,primitives));
        convertableTypes.put(char.class,concatLists(baseHierarchyForChar,primitives));
        convertableTypes.put(int.class,concatLists(baseHierarchyForInt,primitives));
        convertableTypes.put(long.class,concatLists(baseHierarchyForLong,primitives));
        convertableTypes.put(float.class,concatLists(baseHierarchyForFloat,primitives));
        convertableTypes.put(Integer.class, baseHierarchyForInt);
        convertableTypes.put(Byte.class,baseHierarchyForByte);
        convertableTypes.put(Short.class,baseHierarchyForShort);
        convertableTypes.put(Character.class,baseHierarchyForChar);
        convertableTypes.put(Long.class, baseHierarchyForLong);
        convertableTypes.put(Float.class, baseHierarchyForFloat);
        convertableTypes.put(Object.class,allTypesList);
    }

    @SafeVarargs
    private static <T> List<T> concatLists(List<T> ... lists){
        List<T> resultList = new ArrayList<>();
        Arrays.stream(lists).forEach(resultList::addAll);
        return resultList;
    }


}
