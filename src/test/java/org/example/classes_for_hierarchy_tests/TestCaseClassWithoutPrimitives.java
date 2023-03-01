package org.example.classes_for_hierarchy_tests;

public class TestCaseClassWithoutPrimitives {

    private long longPrimitiveValue;

    public void setLongPrimitiveValue(Long objectValue) {
        this.longPrimitiveValue = objectValue;
    }

    public void setLongPrimitiveValue(Integer objectValue) {
        this.longPrimitiveValue = objectValue;
    }

    public void setLongPrimitiveValue(Byte objectValue) {
        this.longPrimitiveValue = objectValue;
    }

    public void setLongPrimitiveValue(Character objectValue) {
        this.longPrimitiveValue = objectValue;
    }

    public void setLongPrimitiveValue(Short objectValue) {
        this.longPrimitiveValue = objectValue;
    }

    public void setLongPrimitiveValue(Float objectValue) {
        this.longPrimitiveValue = objectValue.longValue();
    }

    public void setLongPrimitiveValue(Double objectValue) {
        this.longPrimitiveValue = objectValue.longValue();
    }

    public void setLongPrimitiveValue(String objectValue) {
        this.longPrimitiveValue = Long.getLong(objectValue);
    }

    public void setLongPrimitiveValue(Number objectValue) {
        this.longPrimitiveValue = (long)objectValue;
    }

    public void setLongPrimitiveValue(Object objectValue) {
        this.longPrimitiveValue = (long)objectValue;
    }

}
