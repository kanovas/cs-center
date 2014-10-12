package Structures;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Noli nocere!
 */
public class Rmq {

	static void treeBuild(int a[], int v, int tl, int tr) {
		if (tl == tr)
			tree[v] = a[tl];
		else {
			int tm = (tl + tr) / 2;
			treeBuild(a, v * 2, tl, tm);
			treeBuild(a, v * 2 + 1, tm + 1, tr);
			tree[v] = Math.min(tree[v * 2], tree[v * 2 + 1]);
		}
	}

	static int min(int v, int tl, int tr, int l, int r) {
		if (l > r)
			return Integer.MAX_VALUE;
		if (l == tl && r == tr)
			return tree[v];
		int tm = (tl + tr) / 2;
		return Math.min(min(v * 2, tl, tm, l, Math.min(r, tm)), min(v * 2 + 1, tm + 1, tr, Math.max(l, tm + 1), r));
	}

	static void update(int v, int tl, int tr, int pos, int new_val) {
		if (tl == tr)
			tree[v] = new_val;
		else {
			int tm = (tl + tr) / 2;
			if (pos <= tm)
				update(v * 2, tl, tm, pos, new_val);
			else
				update(v * 2 + 1, tm + 1, tr, pos, new_val);
			tree[v] = Math.min(tree[v * 2], tree[v * 2 + 1]);
		}
	}

	static Scanner in;
	static int[] tree;

	public static void main(String[] args) {
		in = new Scanner(System.in);

		int n = in.nextInt() + 1;
		int m = in.nextInt();

		int[] a = new int[n];

		for (int i = 1; i < n; i++) {
			a[i] = in.nextInt();
		}

		tree = new int[4 * n];
		Arrays.fill(tree, Integer.MAX_VALUE);
		treeBuild(a, 1, 0, n - 1);

		String cmd;
		int i, x;

		for(int j = 0; j < m; j++) {
			cmd = in.next();
			i = in.nextInt();
			x = in.nextInt();
			if (cmd.equals("Set")) {
				//out.println(cmd + " " + x);
				update(1, 0, n - 1, i, x);
			} else if (cmd.equals("Min")) {
				//out.println(cmd + " " + x);
				System.out.println(min(1, 0, n - 1, i, x));
			}
		}

		System.out.close();
	}
}
