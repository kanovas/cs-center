package ru.compscicenter.java2014.calculator.Operations.BinaryOperations;

import ru.compscicenter.java2014.calculator.Expression;

/**
 * Noli nocere!
 */
public class Add extends BinaryOperation {
	public Add(Expression a, Expression b) {
		super(a, b);
	}

	public double oper(double a, double b) {
		return a + b;
	}
}

