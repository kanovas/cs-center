package ru.compscicenter.java2014.calculator;

/**
 * Noli nocere!
 */
public class Pow extends BinaryOperation {
	public Pow(Expression a, Expression b) {
		super(a, b);
	}

	public double oper(double a, double b) {
		return Math.pow(a, b);
	}
}

