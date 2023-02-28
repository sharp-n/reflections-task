package org.example.classes_for_hierarchy_tests;

public class TestClassWithoutWrappers {

    private long longPrimitiveValue;

    public void setLongPrimitiveValue(Number objectValue) {
        this.longPrimitiveValue = (long)objectValue;
    }

    public void setLongPrimitiveValue(Object objectValue) {
        this.longPrimitiveValue = (long)objectValue;
    }

}
