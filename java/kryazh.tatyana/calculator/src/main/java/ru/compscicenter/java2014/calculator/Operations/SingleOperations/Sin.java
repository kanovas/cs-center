package ru.compscicenter.java2014.calculator.Operations.SingleOperations;

import ru.compscicenter.java2014.calculator.Expression;

/**
 * Noli nocere!
 */
public class Sin extends SingleOperation {
	public Sin(Expression a) {
		super(a);
	}

	public double oper(double a) {
		return Math.sin(a);
	}
}