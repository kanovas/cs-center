//package homework1;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Noli nocere!
 */
public class Partition {
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
	static int[] a;
	static StringBuilder str;
	static Stack ans;

	static void dec(int n, int k, int i) {
		if (n < 0) return;
		else if (n == 0) {
			for (int j = 0; j < i; j++) {
				str.append(a[j]);
				str.append(" ");
			}
			ans.push(str.toString());
			str.delete(0, str.length());

		}
		else {
			if (n - k >= 0) {
				a[i] = k;
				dec(n - k, k, i + 1);
			}

			if (k - 1 > 0) {
				dec(n, k - 1, i);
			}
		}
	}

	public static void main(String[] args) {
		try {
			in = new FastScanner(new File("partition.in"));
			out = new PrintWriter("partition.out");
		} catch (IOException e) {
			e.printStackTrace();
		}

		int n = in.nextInt();
		a = new int[n + 1];
		str = new StringBuilder();
		ans = new Stack();
		dec(n, n, 0);
		while(!ans.empty()) {
			out.println(ans.pop());
		}
		out.close();
	}
}
