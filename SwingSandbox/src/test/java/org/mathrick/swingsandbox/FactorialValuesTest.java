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
public class FactorialValuesTest 
{
	private int arg, result;
	
    @Parameters(name="{index}: {0}! = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { 
        		{ 0, 1 }, { 1, 1 }, 
        		{ 2, 2 }, { 3, 6 }, 
                { 5, 120 }, { 6, 720 }, 
                { 12, 479001600 } 
                });
    }

    public FactorialValuesTest(int n, int expected)
    {
    	arg = n;
    	result = expected;
    }
    
	@Test
	public void computeFactorials()
	{
		assertEquals(BigInteger.valueOf(result), MathOps.factorial(arg));
	}

}
