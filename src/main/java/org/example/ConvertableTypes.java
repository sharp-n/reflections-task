package org.example;

import java.util.*;

public class ConvertableTypes {

    static final List<Class<?>> baseHierarchyForInt = new ArrayList<>(Arrays.asList(Integer.class,Number.class,Object.class));
    static final List<Class<?>> baseHierarchyForByte = new ArrayList<>(Arrays.asList(Byte.class,Number.class,Object.class));
    static final List<Class<?>> baseHierarchyForShort = new ArrayList<>(Arrays.asList(Short.class,Number.class,Object.class));
    static final List<Class<?>> baseHierarchyForChar = new ArrayList<>(Arrays.asList(Character.class,Number.class,Object.class));
    static final List<Class<?>> baseHierarchyForLong = new ArrayList<>(Arrays.asList(Long.class,Number.class,Object.class));
    static final List<Class<?>> baseHierarchyForFloat = new ArrayList<>(Arrays.asList(Float.class,Number.class,Object.class));
    static final List<Class<?>> baseHierarchyForDouble = new ArrayList<>(Arrays.asList(Double.class,Number.class,Object.class));

    static final List<Class<?>> baseHierarchyForString = new ArrayList<>(Arrays.asList(
            Long.class,Float.class,Double.class,Integer.class,Character.class,Short.class,Byte.class,Number.class,Object.class));

    static final List<Class<?>> primitives = new ArrayList<>(Arrays.asList(
            byte.class,short.class,char.class,int.class,long.class,float.class,double.class
    ));

    static final List<Class<?>> primitivesForByte = new ArrayList<>(Arrays.asList(
            byte.class,short.class,char.class,int.class,long.class,float.class,double.class
    ));

    static final List<Class<?>> primitivesForShort = new ArrayList<>(Arrays.asList(
            short.class,int.class,long.class,float.class,double.class,char.class,byte.class
    ));

    static final List<Class<?>> primitivesForChar = new ArrayList<>(Arrays.asList(
           char.class,int.class,long.class,float.class,double.class,short.class,byte.class
    ));

    static final List<Class<?>> primitivesForInt = new ArrayList<>(Arrays.asList(
            int.class,long.class,float.class,double.class,char.class,short.class,byte.class
    ));

    static final List<Class<?>> primitivesForLong = new ArrayList<>(Arrays.asList(
            long.class,float.class,double.class,int.class,char.class,short.class,byte.class
    ));

    static final List<Class<?>> primitivesForFloat = new ArrayList<>(Arrays.asList(
            float.class,double.class,long.class,int.class,char.class,short.class,byte.class
    ));

    static final List<Class<?>> primitivesForDouble = new ArrayList<>(Arrays.asList(
            double.class,float.class,long.class,int.class,char.class,short.class,byte.class
    ));

    static Map<Class<?>, List<Class<?>>> convertableTypesMap = new HashMap<>();

    static {
        convertableTypesMap.put(byte.class,concatLists(baseHierarchyForByte,primitivesForByte));
        convertableTypesMap.put(short.class,concatLists(baseHierarchyForShort,primitivesForShort));
        convertableTypesMap.put(char.class,concatLists(baseHierarchyForChar,primitivesForChar));
        convertableTypesMap.put(int.class,concatLists(baseHierarchyForInt,primitivesForInt));
        convertableTypesMap.put(long.class,concatLists(baseHierarchyForLong,primitivesForLong));
        convertableTypesMap.put(float.class,concatLists(baseHierarchyForFloat,primitivesForFloat));
        convertableTypesMap.put(double.class,concatLists(baseHierarchyForDouble,primitivesForDouble));
        convertableTypesMap.put(Integer.class, baseHierarchyForInt);
        convertableTypesMap.put(Byte.class,baseHierarchyForByte);
        convertableTypesMap.put(Short.class,baseHierarchyForShort);
        convertableTypesMap.put(Character.class,baseHierarchyForChar);
        convertableTypesMap.put(Long.class, baseHierarchyForLong);
        convertableTypesMap.put(Float.class, baseHierarchyForFloat);
        convertableTypesMap.put(Number.class, Collections.singletonList(Object.class));
        convertableTypesMap.put(String.class, baseHierarchyForString);
    }

    @SafeVarargs
    private static <T> List<T> concatLists(List<T> ... lists){
        List<T> resultList = new ArrayList<>();
        Arrays.stream(lists).forEach(resultList::addAll);
        return resultList;
    }

}
