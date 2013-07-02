package com.mycompany.app;

/**
 * Hello world!
 *
 */
public class Factorial 
{
    public static int factorial( int n ) throws IllegalArgumentException
    {
        if (n < 0)
        {
        	throw new IllegalArgumentException(String.format("Cannot compute factorial of negative number: %d", n));
        }
        
        if(n > 1)
        {
        	return n * factorial(n-1);
        } else
        {
        	return 1;
        }
    }
}
