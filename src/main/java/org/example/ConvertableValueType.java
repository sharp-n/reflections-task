package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Method;

@Data
@AllArgsConstructor
public class ConvertableValueType {

    Class<?> valueType;

    int distance;

    Method method; // optional

}
