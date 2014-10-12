package ru.compscicenter.java2014.calculator;

/**
 * Noli nocere!
 */
public class Test {
	public static void main(String[] args) {
		Parser parser = new Parser();
		System.out.println(parser.calculate("3 ^ -2 ^ -2"));
		System.out.println(parser.calculate("-0^5"));
		System.out.println(parser.calculate("-0^-0"));
		System.out.println(parser.calculate("5+5*5^-5*5*5"));
		System.out.println(parser.calculate("5 + 5 * 5 * 5 * 5 ^ -5"));
		System.out.println(parser.calculate("---5*5---5^-(5*5-5^-5+5*5-5^(-5+5*-5^-5))*-5^-5*-5"));
	}
}
