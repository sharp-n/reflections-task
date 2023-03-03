package org.example;

public class RegisterType {

    private Class<?> registeredType;

    public void registerSetter(Class<?> classType){
        this.registeredType = classType;
    }

    public Class<?> getRegisteredType() {
        return registeredType;
    }

}
