package org.mathrick.swingsandbox;

import org.fest.assertions.Assert;
import static org.fest.assertions.Assertions.*;
import org.fest.swing.core.EmergencyAbortListener;
import org.fest.swing.finder.WindowFinder;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.launcher.ApplicationLauncher;
import org.fest.swing.testing.FestSwingTestCaseTemplate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GUITest extends FestSwingTestCaseTemplate {
	private EmergencyAbortListener abortListener;
	private FrameFixture frame;
	
    @Before
    public void setUpAbort() throws Exception{
    	// Have to workaround @BeforeClass being static
    	if (abortListener == null)
    	{
			// EmergencyAbortListener - C-S-a to abort the tests
			abortListener = EmergencyAbortListener.registerInToolkit();
    	}
    }

    @After
    public void tearDownClass() throws Exception{
    	if (abortListener != null)
    	{
    		abortListener.unregister();
    		abortListener = null;
    	}
    }
    
    @Before
    public void setUp(){
        setUpRobot();
        ApplicationLauncher.application(GUIFrame.class).start();
        frame = WindowFinder.findFrame(GUIFrame.class).using(robot());
    }

    @After
    public void tearDown(){
        cleanUp();
    }

    private void setFromTo()
    {
    	frame.spinner("from").enterTextAndCommit("0");
    	frame.spinner("to").enterTextAndCommit("10");
    }
    
    @Test 
    public void generateFactorial()
    {
    	setFromTo();
    	frame.radioButton("factorial").check();
    	frame.button("generate").click();
    	assertThat(frame.textBox("result").text())
    	.isEqualTo("0! = 1\n" +
    				"1! = 1\n" +
    				"2! = 2\n" +
    				"3! = 6\n" +
    				"4! = 24\n" +
    				"5! = 120\n" +
    				"6! = 720\n" +
    				"7! = 5040\n" +
    				"8! = 40320\n" +
    				"9! = 362880\n" +
    				"10! = 3628800\n");
    }
    
    @Test
    public void generateFibonacci()
    {
    	setFromTo();
    	frame.radioButton("fibonacci").check();
    	frame.button("generate").click();
    	assertThat(frame.textBox("result").text())
    	.isEqualTo("fib(0) = 0\n" +
    				"fib(1) = 1\n" +
    				"fib(2) = 1\n" +
    				"fib(3) = 2\n" +
    				"fib(4) = 3\n" +
    			   	"fib(5) = 5\n" +
    			   	"fib(6) = 8\n" +
    			   	"fib(7) = 13\n" +
    			   	"fib(8) = 21\n" +
    			   	"fib(9) = 34\n" +
    			   	"fib(10) = 55\n");
    	
    	
    }
}
