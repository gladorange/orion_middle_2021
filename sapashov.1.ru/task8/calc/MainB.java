package task8.calc;

import java.util.HashMap;

public class MainB {
    public static void main(String[] args) {
        Calculator calc = new Calculator(new HashMap<>());

        calc.addOperation("sum", (number1, number2) -> number1 + number2);
        System.out.println(calc.calculate("sum", 2., 3.));

        calc.addOperation("div", (number1, number2) -> number1 / number2);
        System.out.println(calc.calculate("div", 25., 5.));

        calc.addOperation("mult", (number1, number2) -> number1 * number2);
        System.out.println(calc.calculate("mult", 2.5, 2.));

        calc.addOperation("minus", ((number1, number2) -> number1 - number2));
        System.out.println(calc.calculate("minus",10., 5.));

        calc.addOperation("elevate", (number1, number2) -> Math.pow(number1, number2));
        System.out.println(calc.calculate("elevate", 5., 2.));

        calc.addOperation("log", (number1, base) -> Math.log(number1) / Math.log(base));
        System.out.println(calc.calculate("log", 25., 2.));


    }
}
