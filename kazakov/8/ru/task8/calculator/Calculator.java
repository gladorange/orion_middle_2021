package ru.task8.calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/*
Задание 2.Расширяемый калькулятор
        Создать класс Calculator, который может выполнять операции на двумя числами.
        определить метод calculate(String operationName, Double number1, Double number2);

        Операции могут быть разными и хранятся внутри калькулятора.

        Добавьте в калькулятор операции:
        Умножение
        Деление
        Сложение
        Вычитание
        Возведение в степень
        Извлечение корня степени n

        Для опредления тела операции используйте лямбда выражения
        Например:
        Calculator calc = new Calculator();
        calc.add("sum", (a,b) -> a+b);
        calc.calculate("sum",2,3);// выводит 5
 */

//  Определите интерфейс (или используйте подходящий интерфейс из java.util.function)
/*
interface Operation {
    Double doOperation(Double number1, Double number2) throws ArithmeticException;
}
 */

//  использовал ресурсы (удалось прикрутить определение интерфейса к нашему калькулятору):
//  https://stackoverflow.com/questions/34669586/how-can-i-implement-function-and-bifunction-at-the-same-time
//  https://coderoad.ru/32057262/Java-8-применить-BiFunction-к-двум-спискам-различных-объектов
interface GenericFunction<T, U, R> extends Function<T, R>, BiFunction<T, U, R> {
    @Override
    default <V> GenericFunction<T, U, V> andThen(Function<? super R, ? extends V> after) {
        return new GenericFunction<>() {
            @Override
            public V apply(final T t, final U u) {
                return after.apply(GenericFunction.this.apply(t, u));
            }

            @Override
            public V apply(final T t) {
                return after.apply(GenericFunction.this.apply(t));
            }
        };
    }
}

public class Calculator {
    final private Map<String, GenericFunction<Double, Double, Double>> opsFuncs = new HashMap<>();

    /*
    в классе калькудятор создайте метод, который добавляет новыую операцию в калькулятор:
    void addOperation(String operationName, Operation implementation);
     */
    void add(String operationName, Function<Double, Double> func) {
        GenericFunction<Double, Double, Double> mySum = new GenericFunction<>() {
            @Override
            public Double apply(Double a) {
                return func.apply(a);
            }

            @Override
            public Double apply(Double a, Double b) {
                return null;
            }
        };
        opsFuncs.put(operationName, mySum);
    }

    void add(String operationName, BiFunction<Double, Double, Double> biFunc) {
        GenericFunction<Double, Double, Double> mySum = new GenericFunction<>() {
            @Override
            public Double apply(Double a) {
                return null;
            }

            @Override
            public Double apply(Double a, Double b) {
                return biFunc.apply(a, b);
            }
        };
        opsFuncs.put(operationName, mySum);
    }

    //  определить метод calculate(String operationName, Double number1, Double number2);
    void calculate(String operationName, Double a, Double b) {

        BiFunction<Double, Double, Double> biFunc = opsFuncs.get(operationName);
        if (biFunc == null) {
            System.out.println("Бинарная операция: '%s' в калькуляторе не найдена.");
            return;
        }
        System.out.printf("Операция: %s; операнд1 = %.2f,  операнд2 = %.2f, результат = %.2f\n",
                operationName, a, b, biFunc.apply(a, b));
    }

    //  определить метод calculate(String operationName, Double number1);
    void calculate(String operationName, Double a) {

        Function<Double, Double> func = opsFuncs.get(operationName);
        if (func == null) {
            System.out.println("Унарная операция: '%s' в калькуляторе не найдена.");
            return;
        }
        System.out.printf("Операция: %s; операнд: %.2f, результат: %.2f\n", operationName, a, func.apply(a));
    }
}

