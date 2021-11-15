package com.mera.lesson12;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Test
    public void testArithmetic()
    {
        assertEquals("Арифметика не работает", 4, App.sum(2, 2));
    }



    @Test
    @Ignore
    public void testArithmeticOverflow()
    {
        assertTrue("Арифметика не работает",App.sum(2_147_483_646,42) > 0);
    }
}
