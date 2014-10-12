package ru.compscicenter.java2014.calculator;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Noli nocere!
 */
public class Calculator {
	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner(File f) {
			try {
				br = new BufferedReader(new FileReader(f));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		FastScanner(InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine(), "\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		boolean hasNext() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					if(br.ready()) {
						st = new StringTokenizer(br.readLine());
					}
					else {
						return false;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.hasMoreTokens();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}



	static FastScanner in;
	static PrintWriter out;
	static ArrayList<String> expr;

	public static void main(String[] args) {
		in = new FastScanner(System.in);
		out = new PrintWriter(System.out);

		Parser parser = new Parser();
		try {
			out.println(parser.parse(in.next()).evaluate());
		} catch (ParserException e) {
			e.printStackTrace();
		}
		out.close();
	}
}
