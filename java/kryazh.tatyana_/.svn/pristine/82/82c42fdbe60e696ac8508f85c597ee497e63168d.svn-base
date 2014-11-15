package ru.compscicenter.java2014.calculator;

/**
 * Noli nocere!
 */
public class Divide extends BinaryOperation {

	public Divide(Expression a, Expression b) {
		super(a, b);
	}

	final double eps = 1E-20;
	public double oper(double a, double b) throws ParserException {
		if (b < eps) {
			throw new ParserException("It seems you are trying to divide by zero");
		}
		return a / b;
	}
}
