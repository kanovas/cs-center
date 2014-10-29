package ru.compscicenter.java2014.calculator;

/**
 * Noli nocere!
 */
public class Abs extends SingleOperation {
	public Abs(Expression a) {
		super(a);
	}

	public double oper(double a) {
		return Math.abs(a);
	}
}
