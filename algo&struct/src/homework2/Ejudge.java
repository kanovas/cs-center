//package homework2;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.Comparator;

/**
 * Noli nocere!
 */
public class Ejudge {
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
	static Random rand;

	static void QuickSort(Node[] a, int l, int r) {
		if (l >= r) {
			return;
		}
		int i = l;
		int j = r;
		Node x = a[l + rand.nextInt(r - l + 1)];
		while(i <= j) {
			while(a[i].solved > x.solved) {
				i++;
			}
			if(a[i].solved == x.solved) {
				while(a[i].fine < x.fine) {
					i++;
				}
			}
			if(a[i].solved == x.solved && a[i].fine == x.fine) {
				while(a[i].number < x.number) {
					i++;
				}
			}

			while(a[j].solved < x.solved) {
				j--;
			}
			if(a[j].solved == x.solved) {
				while(a[i].fine > x.fine) {
					j--;
				}
			}
			if(a[j].solved == x.solved && a[j].fine == x.fine) {
				while(a[j].number > x.number) {
					j--;
				}
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
		int solved;
		int fine;
		Node(int number, int solved, int fine){
			this.number = number;
			this.solved = solved;
			this.fine = fine;
		}
	}

	static class Comp implements Comparator<Node> {
		 public int compare(Node a, Node b) {
			 if(a.solved == b.solved && a.fine == b.fine) {
				 return a.number - b.number;
			 }
			 else if(a.solved == b.solved) {
				 return a.fine - b.fine;
			 }
			 return b.solved - a.solved;
		 }
	}

	public static void main(String[] args) {
		try {
			in = new FastScanner(new File("ejudge.in"));
			out = new PrintWriter("ejudge.out");
		} catch (IOException e) {
			e.printStackTrace();
		}

		int n = in.nextInt();
		Node[] a = new Node[n];
		for(int i = 0; i < n; i++) {
			a[i] = new Node(i, in.nextInt(), in.nextInt());
		}
		//rand = new Random();
		//QuickSort(a, 0, n - 1);
		Arrays.sort(a, new Comp());
		for(int i = 0; i < n; i++) {
			out.print(a[i].number + 1 + " ");
		}
		out.close();
	}
}
