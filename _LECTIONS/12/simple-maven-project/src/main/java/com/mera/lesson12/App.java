package com.mera.lesson12;

import java.math.BigInteger;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println(sum(42,2));
    }

    public static int sum(int one, int another) {
        return one + another;
    }

    public static int testSum(int one, int another) {
        return one + another;
    }
}
