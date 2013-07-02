package com.mycompany.app;

import java.math.BigInteger;

/**
 * Hello world!
 *
 */
public class Factorial 
{
    public static BigInteger factorial( int n ) throws NegativeFactorialException
    {
        if (n < 0)
        {
        	throw new NegativeFactorialException(n);
        }
        
        if(n > 1)
        {
        	return factorial(n-1).multiply(BigInteger.valueOf(n));
        } else
        {
        	return BigInteger.ONE;
        }
    }
}
