package com.mycompany.app;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class FactorialTest 
{
	@Test(expected=IllegalArgumentException.class)
    public void noNegativeFactorial()
    {
        Factorial.factorial(-1);
    }
	
	@Test
	public void computeFactorials()
	{
		assertEquals(BigInteger.ONE, Factorial.factorial(0));
		assertEquals(BigInteger.ONE, Factorial.factorial(1));
		assertEquals(BigInteger.valueOf(2), Factorial.factorial(2));
		assertEquals(BigInteger.valueOf(6), Factorial.factorial(3));
		assertEquals(BigInteger.valueOf(120), Factorial.factorial(5));
		assertEquals(BigInteger.valueOf(720), Factorial.factorial(6));
	}
}
