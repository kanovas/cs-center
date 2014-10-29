package ru.compscicenter.java2014.calculator;

/**
 * Noli nocere!
 */
public class Cos extends SingleOperation {
	public Cos(Expression a) {
		super(a);
	}

	public double oper(double a) {
		return Math.cos(a);
	}
}