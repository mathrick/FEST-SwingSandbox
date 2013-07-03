package org.mathrick.swingsandbox;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mathrick.swingsandbox.MathOps;

@RunWith(Parameterized.class)
public class FibonacciValuesTest
{
	private int arg, result;
	
    @Parameters(name="{index}: fib[{0}]! = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { 
        		{ 0, 0 }, { 1, 1 }, 
        		{ 2, 1 }, { 3, 2 }, 
                { 4, 3 }, { 12, 144 }, 
                {46, 1836311903} 
                });
    }

    public FibonacciValuesTest(int n, int expected)
    {
    	arg = n;
    	result = expected;
    }
    
	@Test
	public void computeFibonacci()
	{
		assertEquals(BigInteger.valueOf(result), MathOps.fibonacci(arg));
	}

}
