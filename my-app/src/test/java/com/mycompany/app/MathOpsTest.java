package com.mycompany.app;

import org.junit.Test;

public class MathOpsTest {

	@Test(expected=NegativeFactorialException.class)
    public void noNegativeFactorial()
    {
        MathOps.factorial(-1);
    }

}
