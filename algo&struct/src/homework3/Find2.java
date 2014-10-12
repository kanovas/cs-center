package homework3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Noli nocere!
 */
public class Find2 {
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
			in = new FastScanner(new File("find2.in"));
			out = new PrintWriter("find2.out");
		} catch (IOException e) {
			e.printStackTrace();
		}
		int n = in.nextInt();
		int k = in.nextInt();
		int[]a = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		for(int i = 0; i < k; i++) {
			out.println(Arrays.binarySearch(a, in.nextInt()) >= 0 ? "YES" : "NO");
		}

		out.close();
	}
}
