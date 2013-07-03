package com.mycompany.app;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Hello fibonacci world!");
		for(int i = 0; i < 30; i++)
		{
			System.out.println(String.format("fib(%d) = %d", i, MathOps.fibonacci(i)));
		}
	}

}
