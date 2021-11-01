package ru.task8.calculator;

import static java.lang.StrictMath.pow;

public class CalcMain {

    public static void main(String[] args) {

        Calculator calc = new Calculator();
        //  fill with funcs:
        calc.add("sum",  (a, b) -> a + b);
        calc.add("sub", (a, b) -> a - b);
        calc.add("mul", (a, b) -> a * b);
        calc.add("div", (a, b) -> a / b);
        calc.add("pow", Math::pow);
        calc.add("sqrt", (a, b) -> Math.pow(a, 1.0 / b));
        //  test unary ops:
        calc.add("pow2", a -> pow(2.0, a));
        calc.add("sqrt2", Math::sqrt);
        //  operate:
        calc.calculate("sum", 2.1, 3.5);
        calc.calculate("div", 2.1, 1.0);
        calc.calculate("sqrt", 4.0, 0.0);
        //  operate unary ops:
        calc.calculate("pow2", 3.51);
        calc.calculate("pow2", 4.0);
        calc.calculate("sqrt2", -4.0);
    }
}

