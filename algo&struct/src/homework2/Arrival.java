package homework2;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * Noli nocere!
 */
public class Arrival {
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

	static void QuickSort(Node[] a, int l, int r) {
		if (l >= r) {
			return;
		}
		int i = l;
		int j = r;
		int x = a[l + rand.nextInt(r - l + 1)].in;
		while(i <= j) {
			while(a[i].in > x) {
				i++;
			}
			while(a[j].in < x) {
				j--;
			}
			if(i <= j) {
				Node z = a[i];
				a[i] = a[j];
				a[j] = z;
				i++;
				j--;
			}
		}
		QuickSort(a, l, j);
		QuickSort(a, i, r);
	}

	static class Node {
		int number;
		int in;
		Node(int in, int number) {
			this.in = in;
			this.number = number;
		}
	}

	static FastScanner in;
	static PrintWriter out;
	static Random rand;

	public static void main(String[] args) {
		try {
			in = new FastScanner(new File("arrival.in"));
			out = new PrintWriter("arrival.out");
		} catch (IOException e) {
			e.printStackTrace();
		}
		int n = in.nextInt();
		int m = in.nextInt();
		Node[] a = new Node[m];
		for(int i = 0; i < m; i++) {
			a[i] = new Node(in.nextInt(), i + 1);
		}
		rand = new Random();
		QuickSort(a, 0, m - 1);
		int i = 0;
		ArrayList<Integer> ans = new ArrayList<Integer>();
		while(n > 0 && i < m) {
			n -=  a[i].in;
			ans.add(a[i].number);
			i++;
		}
		if (n > 0) {
			out.print("-1");
		}
		else {
			out.println(ans.size());
			for(int j = 0; j < ans.size(); j++) {
				out.print(ans.get(j) + " ");
			}
		}
		out.println();
		out.close();
	}
}
