package lection8.task2;
//Домашнее задание к лекции 8
//Лямбда-выражения и потоки
//Расширяемый калькулятор
//Салмов Евгений

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2 {

    enum OpType{
        MUL("mul"), DIV("div"), SUM("sum"),
        SUB("sub"), POW("pow"), ROOT("root");
        private final String name;
        OpType(String name){
            this.name = name;
        }
        public String getName(){ return name;}
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.addOperation(OpType.MUL.getName(), (a,b) -> a*b);
        calc.addOperation(OpType.DIV.getName(), (a,b) -> a/b);
        calc.addOperation(OpType.SUM.getName(), (a,b) -> a+b);
        calc.addOperation(OpType.SUB.getName(), (a,b) -> a-b);
        calc.addOperation(OpType.POW.getName(), (a,b) -> Math.pow(a,b));
        calc.addOperation(OpType.ROOT.getName(), (a,b) -> Math.pow(a,1/b));

        calc.calculate(OpType.MUL.getName(),2.0,3.0);
        calc.calculate(OpType.DIV.getName(),12.0,3.0);
        calc.calculate(OpType.SUM.getName(),2.0,3.0);
        calc.calculate(OpType.SUB.getName(),12.0,3.0);
        calc.calculate(OpType.POW.getName(),2.0,3.0);
        calc.calculate(OpType.ROOT.getName(),8.0,3.0);

        Double number1;
        Double number2;

        while(true) {
            try {
                System.out.println("Введите номер типа операции.");
                for (int i = 0; i < OpType.values().length; i++) {
                    System.out.print(i + "-" + OpType.values()[i] + ", ");
                }
                System.out.println();
                System.out.print("любое другое число - завершение работы: ");
                Scanner myScan = new Scanner(System.in);
                int opType = myScan.nextInt();
                if(opType<0 || opType>= OpType.values().length)
                    return;
                System.out.print("Введите первое число: ");
                number1 = myScan.nextDouble();
                System.out.print("Введите второе число: ");
                number2 = myScan.nextDouble();
                calc.calculate(OpType.values()[opType].getName(), number1, number2);
            } catch (InputMismatchException e) {
                System.err.println("Неправильный формат ввода!");
                return;
            }
        }
    }
}
