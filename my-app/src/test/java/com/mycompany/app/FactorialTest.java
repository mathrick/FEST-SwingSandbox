package com.mycompany.app;

import org.junit.Test;

public class FactorialTest {

	@Test(expected=NegativeFactorialException.class)
    public void noNegativeFactorial()
    {
        Factorial.factorial(-1);
    }

}
