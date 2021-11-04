package com.example8.calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class Calculator {
    private final Map<String, BinaryOperator<Double>> operations = new HashMap<>();

    public void add(String operationName, BinaryOperator<Double> operation) {
        operations.put(operationName, operation);
    }

    public Double calculate(String operationName, Double num1, Double num2) {
        BinaryOperator<Double> operation = operations.get(operationName);
        return operation.apply(num1, num2);
    }
}
