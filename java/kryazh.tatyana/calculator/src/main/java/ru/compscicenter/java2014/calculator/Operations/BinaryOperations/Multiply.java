package ru.compscicenter.java2014.calculator.Operations.BinaryOperations;

import ru.compscicenter.java2014.calculator.Expression;

/**
 * Noli nocere!
 */
public class Multiply extends BinaryOperation {
	public Multiply(Expression a, Expression b) {
		super(a, b);
	}

	public double oper(double a, double b) {
		return a * b;
	}
}
