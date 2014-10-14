package ru.compscicenter.java2014.calculator.Operations.SingleOperations;

import ru.compscicenter.java2014.calculator.Expression;
import ru.compscicenter.java2014.calculator.ParserException;

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
