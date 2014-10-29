package ru.compscicenter.java2014.calculator;

/**
 * Noli nocere!
 */
public abstract class Operation implements BinaryExpression {
	protected Expression expr1;
	protected Expression expr2;

	Operation(Expression x, Expression y) {
		expr1 = x;
		expr2 = y;
	}

	@Override
	public double evaluate() throws ParserException {
		return oper(expr1.evaluate(), expr2.evaluate());
	}
}
