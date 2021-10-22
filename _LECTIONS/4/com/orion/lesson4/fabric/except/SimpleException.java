package com.orion.lesson4.fabric.except;

public class SimpleException {


    public static void main(String[] args) {

        try {
            tryException();
        }
        catch (ArithmeticException e) {
            System.out.println("Случилось деление на ноль");
        }
        catch (NullPointerException e) {
            System.out.println("Случилось NPE");
        }
        catch (Exception e) {
            System.out.println("Случилось что-то непонятое " + e.getMessage() + " " + e.getStackTrace());
        }

        System.out.println("Конец программы");
    }

    private static int tryException() {
        throw new IllegalArgumentException();

        //return 42 / 0;
    }
}
