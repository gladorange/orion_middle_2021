package com.example8.calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Calculator {
    private final Map<String, BiFunction<Double, Double, Double>> operations = new HashMap<>();

    public void add(String operationName, BiFunction<Double, Double, Double> operation) {
        operations.put(operationName, operation);
    }

    public Double calculate(String operationName, Double num1, Double num2) {
        BiFunction<Double, Double, Double> operation = operations.get(operationName);
        return operation.apply(num1, num2);
    }
}
