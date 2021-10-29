package com.orion.lesson8;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class UnboundedMethodReference {


    public static void main(String[] args) {
        String someString = "abcabcbabcbacbcb cbsabcabcb abcacba";

        Map<Character, BigInteger> count = new HashMap<>();
        for (char c : someString.toCharArray()) {
            // count.merge(c, BigInteger.ONE, (bigInteger, val) -> bigInteger.add(val));
            count.merge(c, BigInteger.ONE, BigInteger::add);
        }

        System.out.println(count);

    }
}
