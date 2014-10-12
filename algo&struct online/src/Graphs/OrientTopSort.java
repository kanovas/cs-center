package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Noli nocere!
 */
public class OrientTopSort {

	static void dfs(ArrayList<Integer>[] a, int v) {
		c[v] = 1;
		for(int i = 0; i < a[v].size(); i++) {
			if (c[a[v].get(i)] == 0) {
				dfs(a, a[v].get(i));
			}
		}
		c[v] = 2;
		ans.add(v);
	}

	static Scanner in;
	static int[] c;
	static ArrayList<Integer> ans;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		int n = in.nextInt() + 1;
		int m = in.nextInt();
		ArrayList<Integer>[] a = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			a[i] = new ArrayList<Integer>();
		}
		c = new int[n];
		Arrays.fill(c, 0);
		int x, y;
		for(int i = 0; i < m; i++) {
			x = in.nextInt();
			y = in.nextInt();
			a[x].add(y);
		}
		ans = new ArrayList<Integer>();

		for(int i = 1; i < n; i++) {
			if(c[i] == 0) {
				dfs(a, i);
			}
		}
		for(int i = 1; i < n; i++) {
			if(c[i] == 0) {
				ans.add(i);
			}
		}
		for(int i = n - 2; i > -1; i--) {
			System.out.print(ans.get(i) + " ");
		}
	}
}
