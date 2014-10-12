package ru.compscicenter.java2014.calculator;

import java.util.ArrayList;

/**
 * Noli nocere!
 */
public class Parser {

	Expression parseAddSub() throws ParserException {
		Expression left = parseMulDivPow();
		Expression right;
		while (l < r) {
			if (!expr[l].equals("+") && !expr[l].equals("-")) {
				break;
			}

			char sign = expr[l].charAt(0);
			switch (sign) {
				case '+':
					l++;
					right = parseMulDivPow();
					left = new Add(left, right);
					break;
				case '-':
					l++;
					right = parseMulDivPow();
					left = new Subtract(left, right);
					break;
			}
		}

		return left;
	}

	Expression parseMulDivPow() throws ParserException {
		Expression left = parseBrackets();
		Expression right;
		while (l < r) {
			if (!expr[l].equals("*") && !expr[l].equals("/") && !expr[l].equals("^")) {
				break;
			}

			char sign = expr[l].charAt(0);
			switch (sign) {
				case '*':
					l++;
					right = parseBrackets();
					left = new Multiply(left, right);
					break;
				case '/':
					l++;
					right = parseBrackets();
					left = new Divide(left, right);
					break;
				case '^':
					l++;
					right = parseBrackets();
					left = new Pow(left, right);
					break;
			}
		}

		return left;
	}

	Expression parseBrackets() throws ParserException {
		if (expr[l].equals("(")) {
			l++;
			Expression ret = parseAddSub();
			if (!expr[l].equals(")")) {
				throw new ParserException("expected ) at " + l);
			}
			l++;
			return ret;
		} else {
			return parseUnary();
		}
	}

	Expression parseUnary() throws ParserException {
		char tmp = expr[l].charAt(0);
		Expression inside;
		switch (tmp) {
			case '+':
				l++;
				break;
			case '-':
				if (isNumber(expr[l + 1])) return parseNum();
				l++;
				inside = parseBrackets();
				return new Neg(inside);
			case 's':
				l++;
				inside = parseBrackets();
				return new Sin(inside);
			case 'c':
				l++;
				inside = parseBrackets();
				return new Cos(inside);
			case 'a':
			    l++;
				inside = parseBrackets();
				return new Abs(inside);
		}
		return parseNum();
	}

	Expression parseNum() throws ParserException {
		if (l < r && expr[l].equals("(")) {
			return parseBrackets();
		}
		Expression ret;
		if(expr[l].equals("-")) {
			l++;
			sign = "-";
		}
		if(isNumber(expr[l])) {
			ret = new Const(Double.parseDouble(sign + expr[l]));
			l++;
		}
		else {
			throw new ParserException("wtf");
		}
		return ret;
	}

	boolean isDigit(char c) {
		return c >= '0' && c <= '9';
	}

	boolean isNumber(String s) {return isDigit(s.charAt(0));}

	String[] expr;
	String sign = "";
	int l, r;

	public Expression parse(String s) throws ParserException {

		StringBuilder str = new StringBuilder();
		char[] c = s.toLowerCase().toCharArray();
		ArrayList<String> expression = new ArrayList<String>();
		int i = 0;
		while(i < c.length) {
			if(c[i] == ' ') {
				i++;
			}
			else if(c[i] == 's' || c[i] == 'c' || c[i] == 'a') {
				expression.add(String.valueOf(c[i])); //s is for sin   c for cos    a for abs
				i += 3;
			}
			else if(Character.isDigit(c[i])) {
				boolean pOnce = false;  //marks if point was (once)
				boolean expecting = false;  //marks if we expect +/- after E
				boolean eOnce = false; //marks if E was (once)
				while((i < c.length) && (Character.isDigit(c[i]) || (!eOnce && c[i] == 'e') ||
						(expecting && ((c[i] == '+') || (c[i] == '-'))) || (!pOnce && (c[i] == '.')))) {
					if(c[i] == 'e') {
						str.append("E");
						eOnce = true;
						expecting = true;
					}
					else if(c[i] == '-' || c[i] == '+') {
						expecting = false;
					}
					else {
						str.append(c[i]);
					}
					if(c[i] == '.') pOnce = true;
					i++;
				}
				expression.add(str.toString());
				str.delete(0, str.length());
			}
			else {
				expression.add(String.valueOf(c[i]));
				i++;
			}
		}
		expr = new String[expression.size()];
		for(i = 0; i < expression.size(); i++) {
			expr[i] = expression.get(i);
		}
		l = 0;
		r = expr.length;
		return parseAddSub();
	}
}
