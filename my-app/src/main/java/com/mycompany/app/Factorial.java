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
        
        BigInteger result = BigInteger.valueOf(1);
        
        while (n > 0)
        {
        	result = result.multiply(BigInteger.valueOf(n--));
        }
        
        return result;
    }
}
