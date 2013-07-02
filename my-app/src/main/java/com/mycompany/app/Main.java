package com.mycompany.app;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Hello factorial world!");
		System.out.println(String.format("1! = %d", Factorial.factorial(1)));
		System.out.println(String.format("6! = %d", Factorial.factorial(6)));
		System.out.println(String.format("12! = %d", Factorial.factorial(12)));
		System.out.println(String.format("60! = %d", Factorial.factorial(60)));
	}

}
