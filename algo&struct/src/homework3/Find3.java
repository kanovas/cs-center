package homework3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.max;

/**
 * Noli nocere!
 */
public class Find3 {
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

	static int leftBinarySearch(int[] a, int x) {
		int l = 0;
		int r = a.length - 1;
		int m;
		while(l < r - 1) {
			m = (l + r) / 2;
			if (a[m] < x) {
				l = m;
			}
			else {
				r = m;
			}
		}
		if(a[l] == x) {
			return l;
		}
//		else if(a[r] == x) {
//			return r;
//		}
		else {
			return r;
		}
	}

	static int rightBinarySearch(int[] a, int x) {
		int l = 0;
		int r = a.length - 1;
		int m;
		while(l < r - 1) {
			m = (l + r) / 2;
			if (a[m] <= x) {
				l = m;
			}
			else {
				r = m;
			}
		}
		if(a[r] == x) {
			return r;
		}
//		else if(a[l] == x) {
//			return l;
//		}
		else {
			return l;
		}
	}

	public static void main(String[] args) {
		try {
			in = new FastScanner(new File("find3.in"));
			out = new PrintWriter("find3.out");
		} catch (IOException e) {
			e.printStackTrace();
		}

		int n = in.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		Arrays.sort(a);
		int k = in.nextInt();
		int l;
		int r;
		int posL;
		int posR;
		for(int i = 0; i < k; i++) {
			l = in.nextInt();
			r = in.nextInt();
			posL = max(0, leftBinarySearch(a, l));
			posR = rightBinarySearch(a, r);
			if(r > a[a.length - 1]) posR = a.length - 1;
			out.print(posR - posL + 1 + " ");
		}
		out.close();
	}
}
