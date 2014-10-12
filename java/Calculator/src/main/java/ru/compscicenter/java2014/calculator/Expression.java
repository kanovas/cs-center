package ru.compscicenter.java2014.calculator;

/**
 * Noli nocere!
 */
public interface Expression {
	abstract double evaluate() throws ParserException;
}
