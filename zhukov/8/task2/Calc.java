package task2;

import task2.classes.Calculator;

public class Calc {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.add("addition",(a,b)-> a+b);
        calculator.add("subtraction",(a,b)-> a-b );
        calculator.add("increase",(a,b)-> a*b );
        calculator.add("division",(a,b)-> a/b );
        calculator.add("degree",(a,b)-> Math.pow (a,b) );
        calculator.add("logOnBase",(a,b)-> Math.log (b) / Math.log(a) );

        System.out.print(calculator.calculate("addition",10.0,20.0)+"\n" );
        System.out.print(calculator.calculate("subtraction",10.0,20.0)+"\n" );
        System.out.print(calculator.calculate("increase",10.0,20.0)+"\n" );
        System.out.print(calculator.calculate("division",10.0,20.0)+"\n" );
        System.out.print(calculator.calculate("degree",10.0,2.0)+"\n" );
        System.out.print(calculator.calculate("logOnBase",10.0,20.0)+"\n" );
    }
}
