package ru.compscicenter.java2014.calculator.Operations.SingleOperations;

import ru.compscicenter.java2014.calculator.Expression;

/**
 * Noli nocere!
 */
public class Neg extends SingleOperation {
	public Neg(Expression a) {
		super(a);
	}

	public double oper(double a) {
		return -a;
	}
}