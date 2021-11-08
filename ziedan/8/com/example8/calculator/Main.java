package com.example8.calculator;

public class Main {

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.add("add", Double::sum);
        calc.add("subtract", (a, b) -> a - b);
        calc.add("multiply", (a, b) -> a * b);
        calc.add("divide", (a, b) -> a / b);
        calc.add("exponent", Math::pow);
        calc.add("root", (a, b) -> Math.pow(a, 1/b));

        System.out.println(calc.calculate("multiply", 1.0, 2.0));

    }
}
