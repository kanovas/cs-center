package ru.compscicenter.java2014.calculator;

import java.util.ArrayList;

/**
 * Noli nocere!
 */
public class Parser implements Calculator{

    private enum singleOperator {
        singleMinus('-') {
            @Override
            public Expression apply() throws ParserException {
                l++;
                return new Neg(parsePow());
            }
        },
        sin('s') {
            @Override
            public Expression apply() throws ParserException {
                l++;
                return new Sin(parseBrackets());
            }
        },
        cos('c') {
            @Override
            public Expression apply() throws ParserException {
                l++;
                return new Cos(parseBrackets());
            }
        },
        abs('a') {
            @Override
            public Expression apply() throws ParserException {
                l++;
                return new Abs(parseBrackets());
            }
        },
        ;
        private final char code;

        private singleOperator(char code) {
            this.code = code;
        }

        public static singleOperator buildSingleOperator(char code) {
            for (singleOperator operator : singleOperator.values()) {
                if (code == operator.code) {
                    return operator;
                }
            }
            return null;
        }

        public abstract Expression apply() throws ParserException;
    }

	static Expression parseAddSub() throws ParserException {
		Expression left = parseMulDiv();
		Expression right;
		while (l < r) {
			if (!expr[l].equals("+") && !expr[l].equals("-")) {
				break;
			}

			char sign = expr[l].charAt(0);
			switch (sign) {
				case '+':
					l++;
					right = parseMulDiv();
					left = new Add(left, right);
					break;
				case '-':
					l++;
					right = parseMulDiv();
					left = new Subtract(left, right);
					break;
			}
		}

		return left;
	}

	static Expression parseMulDiv() throws ParserException {
		Expression left = parsePow();
		Expression right;
		while (l < r) {
			if (!expr[l].equals("*") && !expr[l].equals("/")) {
				break;
			}

			char sign = expr[l].charAt(0);
			switch (sign) {
				case '*':
					l++;
					right = parsePow();
					left = new Multiply(left, right);
					break;
				case '/':
					l++;
					right = parsePow();
					left = new Divide(left, right);
					break;
			}
		}

		return left;
	}

	static Expression parsePow() throws ParserException {
		Expression left = parseUnary();
		Expression right;
		if(l < expr.length && expr[l].equals("^")) {
			l++;
			right = parsePow();
			return new Pow(left, right);
		}
		else {
			return left;
		}
	}

	static Expression parseBrackets() throws ParserException {
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

	static Expression parseUnary() throws ParserException {
        singleOperator tmp = singleOperator.buildSingleOperator(expr[l].charAt(0));
        return tmp != null ? tmp.apply() : parseNum();
	}

	static Expression parseNum() throws ParserException {
		if (l < r && expr[l].equals("(")) {
			return parseBrackets();
		}
		Expression ret;

		if(isNumber(expr[l])) {
			ret = new Const(Double.parseDouble(expr[l]));
			l++;
		}
		else {
			throw new ParserException("wtf");
		}
		return ret;
	}

	static private boolean isNumber(String s) {return Character.isDigit(s.charAt(0));}

    private void parseNumber(char[] c, ArrayList<String> expression) {
        StringBuilder str = new StringBuilder();
        boolean pointOnce = false;  //marks if point was (once)
        boolean expecting = false;  //marks if we expect +/- after E
        boolean eOnce = false; //marks if E was (once)
        while((i < c.length) && (Character.isDigit(c[i]) || (!eOnce && c[i] == 'e') ||
                (expecting && ((c[i] == '+') || (c[i] == '-'))) || (!pointOnce && (c[i] == '.')))) {
            if(c[i] == 'e') {
                str.append("E");
                eOnce = true;
                expecting = true;
            }
            else if(c[i] == '-' || c[i] == '+') {
                expecting = false;
                str.append(c[i]);
            }
            else {
                str.append(c[i]);
            }
            if(c[i] == '.') pointOnce = true;
            i++;
        }
        expression.add(str.toString());
        str.delete(0, str.length());
    }


	static String[] expr;
	static int l, r, i;

	public double calculate(String s) {
		double ans = 0;
		char[] c = s.toLowerCase().toCharArray();
		ArrayList<String> expression = new ArrayList<String>();
        i = 0;
		while(i < c.length) {
			if(c[i] == ' ') {
				i++;
			}
			else if(c[i] == 's' || c[i] == 'c' || c[i] == 'a') {
				expression.add(String.valueOf(c[i])); //s is for sin   c for cos    a for abs
				i += 3;
			}
			else if(Character.isDigit(c[i])) {
                parseNumber(c, expression);
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
		try {
			ans = parseAddSub().evaluate();
		} catch (ParserException e) {
			e.printStackTrace();
		}
		return ans;
	}
}
