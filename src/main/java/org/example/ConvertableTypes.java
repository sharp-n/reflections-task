package org.example;

import java.util.*;

public class ConvertableTypes {

    private ConvertableTypes(){}

    static final List<Class<?>> baseHierarchyForInt = new ArrayList<>(Arrays.asList(int.class,Integer.class,Number.class,Object.class));
    static final List<Class<?>> baseHierarchyForByte = new ArrayList<>(Arrays.asList(byte.class,Byte.class,Number.class,Object.class));
    static final List<Class<?>> baseHierarchyForShort = new ArrayList<>(Arrays.asList(short.class,Short.class,Number.class,Object.class));
    static final List<Class<?>> baseHierarchyForChar = new ArrayList<>(Arrays.asList(char.class,Character.class,Object.class));
    static final List<Class<?>> baseHierarchyForLong = new ArrayList<>(Arrays.asList(long.class,Long.class,Number.class,Object.class));
    static final List<Class<?>> baseHierarchyForFloat = new ArrayList<>(Arrays.asList(float.class,Float.class,Number.class,Object.class));
    static final List<Class<?>> baseHierarchyForDouble = new ArrayList<>(Arrays.asList(double.class,Double.class,Number.class,Object.class));
    static final List<Class<?>> baseHierarchyForBoolean = new ArrayList<>(Arrays.asList(boolean.class,Boolean.class,Object.class));

    static final List<Class<?>> baseHierarchyForString = new ArrayList<>(Arrays.asList(
            Long.class,Float.class,Double.class,Integer.class,Character.class,Short.class,Byte.class,Number.class,Object.class));

    static final List<Class<?>> primitives = new ArrayList<>(Arrays.asList(
            byte.class,short.class,char.class,int.class,long.class,float.class,double.class
    ));

    static final List<Class<?>> primitivesForByte = new ArrayList<>(Arrays.asList(
            byte.class,short.class,int.class,long.class,float.class,double.class
    ));

    static final List<Class<?>> primitivesForShort = new ArrayList<>(Arrays.asList(
            short.class,int.class,long.class,float.class,double.class
    ));

    static final List<Class<?>> primitivesForChar = new ArrayList<>(Arrays.asList(
           char.class,int.class,long.class,float.class,double.class
    ));

    static final List<Class<?>> primitivesForInt = new ArrayList<>(Arrays.asList(
            int.class,long.class,float.class,double.class
    ));

    static final List<Class<?>> primitivesForLong = new ArrayList<>(Arrays.asList(
            long.class,float.class,double.class
    ));

    static final List<Class<?>> primitivesForFloat = new ArrayList<>(Arrays.asList(
            float.class,double.class
    ));

    public static Map<Class<?>, List<Class<?>>> convertableTypesMap = new HashMap<>();

    static {
        genConvertableTypesMap();

        convertableTypesMap.put(Collections.class,Collections.singletonList(Iterable.class)); // todo divide it to lis for implementation and extending lists
    }

    private static void genConvertableTypesMap(){
        convertableTypesMap.put(boolean.class,baseHierarchyForBoolean);
        convertableTypesMap.put(byte.class,concatLists(primitivesForByte,baseHierarchyForByte));
        convertableTypesMap.put(short.class,concatLists(primitivesForShort,baseHierarchyForShort));
        convertableTypesMap.put(char.class,concatLists(primitivesForChar,baseHierarchyForChar));
        convertableTypesMap.put(int.class,concatLists(primitivesForInt,baseHierarchyForInt));
        convertableTypesMap.put(long.class,concatLists(primitivesForLong,baseHierarchyForLong));
        convertableTypesMap.put(float.class,concatLists(primitivesForFloat,baseHierarchyForFloat));
        convertableTypesMap.put(double.class,baseHierarchyForDouble);
        convertableTypesMap.put(Integer.class, concatLists(primitivesForInt,baseHierarchyForInt));
        convertableTypesMap.put(Byte.class,concatLists(primitivesForByte,baseHierarchyForByte));
        convertableTypesMap.put(Short.class,concatLists(primitivesForShort,baseHierarchyForShort));
        convertableTypesMap.put(Character.class,concatLists(primitivesForChar,baseHierarchyForChar));
        convertableTypesMap.put(Long.class, concatLists(primitivesForLong,baseHierarchyForLong));
        convertableTypesMap.put(Float.class, concatLists(primitivesForFloat,baseHierarchyForFloat));
        convertableTypesMap.put(Double.class,baseHierarchyForDouble);
        convertableTypesMap.put(Number.class, Collections.singletonList(Object.class));
        convertableTypesMap.put(Boolean.class,baseHierarchyForBoolean);
    }

    @SafeVarargs
    private static <T> List<T> concatLists(List<T> ... lists){
        List<T> resultList = new ArrayList<>();
        Arrays.stream(lists).forEach(resultList::addAll);
        return resultList;
    }

}
