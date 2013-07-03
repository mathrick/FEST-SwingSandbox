package com.mycompany.app;

import java.math.BigInteger;

/**
 * Hello world!
 *
 */
public class MathOps 
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
    
    public static BigInteger fibonacci( int n )
    {
    	BigInteger a = BigInteger.ZERO;
    	BigInteger b = BigInteger.valueOf((int)Math.signum(n));
    	BigInteger fib = BigInteger.ZERO;
    	
        for (n = Math.abs(n); n > 0; n--)
        {
        	a = b;
        	b = fib;
        	fib = a.add(b);
        }
        
        return fib;
    }
}
