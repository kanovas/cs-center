package Structures;

import java.util.Scanner;

/**
 * Noli nocere!
 */
public class Dsu {

	static int[] parent, rng;

	static int get(int x) {
		if(parent[x] != x) {
			parent[x] = get(parent[x]);
		}
		return parent[x];
	}

	static void union(int x, int y) {
		int px = get(x);
		int py = get(y);
		if(px == py) {
			return;
		}
		if(rng[px] > rng[py])  {
			parent[py] = px;

		}
		else if(rng[py] > rng[px]) {
			parent[px] = py;
		}
		else {
			parent[px] = py;
			rng[py]++;
		}
	}

	static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		int n = in.nextInt() + 1;
		int m = in.nextInt();

		parent = new int[n];                 //initialization
		rng = new int[n];
		for(int i = 0; i < n; i++) {
			parent[i] = i;
			rng[i] = 1;
		}

		String cmd;
		int x, y;

		for(int i = 0; i < m; i++) {
			cmd = in.next();
			x = in.nextInt();
			y = in.nextInt();
			if(cmd.equals("Check")) {
				System.out.println(get(x) == get(y) ? "True" : "False");
			}
			else if(cmd.equals("Union")){
				union(x, y);
			}
		}
		System.out.close();
	}
}
