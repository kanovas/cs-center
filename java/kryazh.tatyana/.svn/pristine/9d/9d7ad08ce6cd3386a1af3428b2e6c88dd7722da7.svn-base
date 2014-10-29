package ru.compscicenter.java2014.calculator;

/**
 * Noli nocere!
 */
public abstract class SingleOperation implements SingleExpression {
	protected Expression expr;

	SingleOperation(Expression x) {
		expr = x;
	}

	@Override
	public double evaluate() throws ParserException {
		return oper(expr.evaluate());
	}

}
