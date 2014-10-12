//package homework1;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Noli nocere!
 */
public class Catalan {
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
	}

	static FastScanner in;
	static PrintWriter out;

	public static void main(String[] args) {
		try {
			in = new FastScanner(new File("catalan.in"));
			out = new PrintWriter("catalan.out");
		} catch (IOException e) {
			e.printStackTrace();
		}
		int n = in.nextInt();
		int m = in.nextInt();
		long c[] = new long[n + 1];
		c[0] = 1 % m;
		for(int j = 1; j < n + 1; j++) {
			for(int i = 0; i < j; i++) {
				c[j] = (c[j] + c[i] * c[j - i - 1]) % m;      //O(n^2)
			}
		}
		out.print(c[n]);
		out.close();
	}
}
