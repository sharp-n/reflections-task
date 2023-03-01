package org.example.classes_for_hierarchy_tests;

public class TestCaseClassWithoutWrappers {

    private long longPrimitiveValue;

    public void setLongPrimitiveValue(Number objectValue) {
        this.longPrimitiveValue = (long)objectValue;
    }

    public void setLongPrimitiveValue(Object objectValue) {
        this.longPrimitiveValue = (long)objectValue;
    }

}
