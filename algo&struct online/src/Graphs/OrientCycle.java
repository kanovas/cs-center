package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Noli nocere!
 */
public class OrientCycle {

	static void dfs(ArrayList<Integer>[] a, int v) {
		c[v] = 1;
		for(int i = 0; i < a[v].size(); i++) {
			if(c[a[v].get(i)] == 1) {
				f = true;
			}
			else if (c[a[v].get(i)] == 0) {
				dfs(a, a[v].get(i));
			}
		}
		c[v] = 2;
	}

	static Scanner in;
	static int[] c;
	static boolean f;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		int n = in.nextInt() + 1;
		int m = in.nextInt();
		ArrayList<Integer>[] a = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			a[i] = new ArrayList<Integer>();
		}
		c = new int[n];
		int x, y;
		for(int i = 0; i < m; i++) {
			x = in.nextInt();
			y = in.nextInt();
			a[x].add(y);
		}
		f = false;
		Arrays.fill(c, 0);
		for(int i = 1; i < n; i++) {
			dfs(a, i);
		}

		System.out.print(f ? "True" : "False");
		System.out.close();
	}
}