package lection8.task2;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    Map<String,Operation> operations = new HashMap<>();

    public void calculate(String operationName, Double number1, Double number2){
        if(operations.containsKey(operationName)) {
            try {
                System.out.println(operations.get(operationName).doOperation(number1, number2));
            } catch (ArithmeticException e) {
                System.err.println("Дружище! Что то пошло не так, возможно недопустимые числа!");
            }
        } else {
            System.out.println("Дружище! Ты пытаешься выполнить несуществующую операцию операцию!");
        }
    }

    public void addOperation(String operationName, Operation implementation) {
        if(operations.containsKey(operationName)) {
            System.out.println("Дружище! Ты пытаешься добавить уже добавленную операцию!");
        } else {
            operations.put(operationName, implementation);
        }
    }
}
