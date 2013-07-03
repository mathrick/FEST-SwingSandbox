package org.mathrick.swingsandbox;

import org.junit.Test;
import org.mathrick.swingsandbox.MathOps;
import org.mathrick.swingsandbox.NegativeFactorialException;

public class MathOpsTest {

	@Test(expected=NegativeFactorialException.class)
    public void noNegativeFactorial()
    {
        MathOps.factorial(-1);
    }

}
