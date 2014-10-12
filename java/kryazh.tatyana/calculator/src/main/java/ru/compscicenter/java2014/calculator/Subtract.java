package ru.compscicenter.java2014.calculator;

/**
 * Noli nocere!
 */
public class Subtract extends Operation {

	public Subtract(Expression a, Expression b) {
		super(a, b);
	}

	public double oper(double a, double b) {
		//	long res = a - b;
		//	if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
		//		throw new OverflowException("overflow: " + res + " got while calculating");
		//	}
		return a - b;
	}
}