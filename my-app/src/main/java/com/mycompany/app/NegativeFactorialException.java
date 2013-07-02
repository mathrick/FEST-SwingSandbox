package com.mycompany.app;

public class NegativeFactorialException extends IllegalArgumentException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String msg = "Cannot compute factorial of negative argument";
	private static final String fmt = "Cannot compute factorial of negative argument: %d";
	

	public NegativeFactorialException() {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	public NegativeFactorialException(int n) {
		super(String.format(fmt, n));
		// TODO Auto-generated constructor stub
	}

	public NegativeFactorialException(int n, Throwable cause) {
		super(String.format(fmt, n), cause);
		// TODO Auto-generated constructor stub
	}

	public NegativeFactorialException(Throwable cause) {
		super(msg, cause);
		// TODO Auto-generated constructor stub
	}
	
}
