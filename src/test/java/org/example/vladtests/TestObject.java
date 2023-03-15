package org.example.vladtests;

//import lombok.AllArgsConstructor;
//import lombok.Data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestObject {

    private final List<InfoContainer> infoContainerList = new ArrayList<>();

    public void registerValue(Object value) {
        Class<?> valueType;
        if (value != null) {
            valueType = value.getClass();
        } else {
            valueType = Object.class;
        }
        infoContainerList.add(new InfoContainer(this, value, valueType));
    }

    public void registerValue(boolean value) {
        infoContainerList.add(new InfoContainer(this, value, boolean.class));
    }

    public void registerValue(byte value) {
        infoContainerList.add(new InfoContainer(this, value, byte.class));
    }

    public void registerValue(short value) {
        infoContainerList.add(new InfoContainer(this, value, short.class));
    }

    public void registerValue(int value) {
        infoContainerList.add(new InfoContainer(this, value, int.class));
    }

    public void registerValue(long value) {
        infoContainerList.add(new InfoContainer(this, value, long.class));
    }

    public void registerValue(float value) {
        infoContainerList.add(new InfoContainer(this, value, float.class));
    }

    public void registerValue(double value) {
        infoContainerList.add(new InfoContainer(this, value, double.class));
    }

    public void registerValue(char value) {
        infoContainerList.add(new InfoContainer(this, value, char.class));
    }

    public List<InfoContainer> getInfoContainerList() {
        return infoContainerList;
    }

    public List<Class<?>> getInfoClassTypeList() {
        return getInfoContainerList().stream()
                .map(InfoContainer::getValueType)
                .collect(Collectors.toList());
    }

    @Data
    @AllArgsConstructor
    public static class InfoContainer {

        //    private Method method; -???
        private Object object;
        private Object value;
        private Class<?> valueType;

    }

}
