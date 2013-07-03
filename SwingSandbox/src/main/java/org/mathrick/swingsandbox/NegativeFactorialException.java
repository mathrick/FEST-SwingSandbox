package org.mathrick.swingsandbox;

public class NegativeFactorialException extends IllegalArgumentException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String msg = "Cannot compute factorial of negative argument";
	private static final String fmt = "Cannot compute factorial of negative argument: %d";
	

	public NegativeFactorialException() {
		super(msg);
	}

	public NegativeFactorialException(int n) {
		super(String.format(fmt, n));
	}

	public NegativeFactorialException(int n, Throwable cause) {
		super(String.format(fmt, n), cause);
	}

	public NegativeFactorialException(Throwable cause) {
		super(msg, cause);
	}
	
}
