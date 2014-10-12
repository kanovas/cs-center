package homework2;

import java.io.*;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * Noli nocere!
 */
public class InversionCount {
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

	static int nextRand24() {
		cur = cur * a + b;
		return cur >> 8;
	}

	static FastScanner in;
	static PrintWriter out;
	static Random rand;
	static int a, b;
	static int cur = 0;

	public static void main(String[] args) {
		try {
			in = new FastScanner(new File("invcnt.in"));
			out = new PrintWriter("invcnt.out");
		} catch (IOException e) {
			e.printStackTrace();
		}
		int n = in.nextInt();
		int m = in.nextInt();
		a = in.nextInt();
		b = in.nextInt();
		int[] arr = new int[m];
		for(int i = 0; i < m; i++) {
			arr[i] =  nextRand24() % m;
			out.print(arr[i] + " ");
		}

		out.close();
	}
}
