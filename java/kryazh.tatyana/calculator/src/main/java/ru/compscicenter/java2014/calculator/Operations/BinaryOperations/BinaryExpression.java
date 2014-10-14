package ru.compscicenter.java2014.calculator.Operations.BinaryOperations;

import ru.compscicenter.java2014.calculator.Expression;
import ru.compscicenter.java2014.calculator.ParserException;

/**
 * Noli nocere!
 */
public interface BinaryExpression extends Expression {
	abstract double oper(double a, double b) throws ParserException;
}
