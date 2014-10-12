package homework1;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Noli nocere!
 */
public class Refrator {
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

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
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
		long nextLong() {
			return Long.parseLong(next());
		}
	}

	static FastScanner in;
	static PrintWriter out;

	public static void main(String[] args) {
		try {
			in = new FastScanner(new File("refrator.in"));
			out = new PrintWriter("refrator.out");
		} catch (IOException e) {
			e.printStackTrace();
		}
		long n = in.nextLong();
		long res = Long.MAX_VALUE;
		long resA = 0;
		long resB = 0;
		long resC = 0;
		long c;
		long s;
		//double t = System.currentTimeMillis();
		int rtN = (int) Math.sqrt(n);
		int rt3N = (int) Math.pow(n, 1/3) + 1;
		for(int a = 1; a < rtN; a++) {
			//int rtA = (int) Math.sqrt(n / a) + 1;
			for(int b = 1; b < rt3N; b++) {
				if (n % (a * b) != 0) continue;
				else {
					c = n / (a * b);
					s = 2 * (a * b + b * c + a * c);
					if(s < res) {
						resA = a;
						resB = b;
						resC = c;
						res = s;
					}
				}
			}
		}
		out.println(res + " " + resA + " " + resB + " " + resC);
		//out.print(System.currentTimeMillis() - t);
		out.close();
	}
}
