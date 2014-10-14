package ru.compscicenter.java2014.calculator.Operations.BinaryOperations;

import ru.compscicenter.java2014.calculator.Expression;
import ru.compscicenter.java2014.calculator.ParserException;

/**
 * Noli nocere!
 */
public abstract class BinaryOperation implements BinaryExpression {
	protected Expression expr1;
	protected Expression expr2;

	public BinaryOperation(Expression x, Expression y) {
		expr1 = x;
		expr2 = y;
	}

	@Override
	public double evaluate() throws ParserException {
		return oper(expr1.evaluate(), expr2.evaluate());
	}
}
