//package homework1;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Noli nocere!
 */
public class Collection {
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
			in = new FastScanner(new File("collection.in"));
			out = new PrintWriter("collection.out");
		} catch (IOException e) {
			e.printStackTrace();
		}

		int n = in.nextInt();
		boolean[] used = new boolean[15001];
		int ans = 0;
		int m;
		for(int i = 0; i < n; i++) {
			m = in.nextInt();
			if(!used[m]) {
				used[m] = true;
				ans++;
			}
		}
		out.print(15000 - ans);
		out.close();
	}
}
