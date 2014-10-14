package ru.compscicenter.java2014.calculator.Operations.SingleOperations;

import ru.compscicenter.java2014.calculator.Expression;

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
