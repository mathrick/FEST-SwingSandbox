package com.mycompany.app;

import java.math.BigInteger;

/**
 * Hello world!
 *
 */
public class Factorial 
{
    public static BigInteger factorial( int n ) throws IllegalArgumentException
    {
        if (n < 0)
        {
        	throw new IllegalArgumentException(String.format("Cannot compute factorial of negative number: %d", n));
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
