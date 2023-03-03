package org.example;

public interface SetterUtil {

    boolean setValue(boolean value, Object targetObject, String propertyName);

    boolean setValue(byte value, Object targetObject, String propertyName);

    boolean setValue(short value, Object targetObject, String propertyName);

    boolean setValue(char value, Object targetObject, String propertyName);

    boolean setValue(int value, Object targetObject, String propertyName);

    boolean setValue(long value, Object targetObject, String propertyName);

    boolean setValue(float value, Object targetObject, String propertyName);

    boolean setValue(double value, Object targetObject, String propertyName);

    boolean setValue(Object value, Object targetObject, String propertyName);

    boolean setValue(Object value, Object targetObject, String propertyName, Class<?> valueType);

}
