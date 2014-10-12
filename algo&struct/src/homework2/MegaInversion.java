package homework2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Noli nocere!
 */
public class MegaInversion {
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
	static int[] a, b;

	static int countInversions(int[] arr, int l, int r) {
		if (l >= r) return 0;
		int m = (l + r) / 2;
		int res = countInversions(arr, l, m);
		res += countInversions(arr, m + 1, r);
		res += mergeCount(arr, l, m, r);
		return res;
	}

	static int mergeCount(int[] arr, int l, int m, int r) {
		int i = l;
		int j = m + 1;
		int k = 1;
		int res = 0;
		while(i < m || j < r) {
			if(j == r || (i < m && arr[i] < arr[j])) {
				b[k++] = arr[i++];
			}
			else {
				res += m - i;
				b[k++] = arr[j++];
			}
		}
		for(int c = l; c < r; c++) {
			arr[c] = b[c];
		}
		return res;

	}

	static void reverse() {
		for(int i = 0; i < a.length / 2; i++) {
			int z = a[i];
			a[i] = a[a.length - i - 1];
			a[a.length - i - 1] = z;
		}
	}

	public static void main(String[] args) {
		try {
			in = new FastScanner(new File("mega.in"));
			out = new PrintWriter("mega.out");
		} catch (IOException e) {
			e.printStackTrace();
		}
		int n = in.nextInt();

		a = new int[n];
		b = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		int ans = countInversions(a, 0, a.length);
		reverse();
		ans += countInversions(a, 0, a.length);
		out.print(ans);
		out.close();
	}
}
