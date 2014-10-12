package ru.compscicenter.java2014.calculator;

/**
 * Noli nocere!
 */
public class Multiply extends Operation{
	public Multiply(Expression a, Expression b) {
		super(a, b);
	}

	public double oper(double a, double b) {
		return a * b;
	}
}
