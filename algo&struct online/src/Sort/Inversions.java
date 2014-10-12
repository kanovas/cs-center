package Sort;

import java.util.Scanner;

/**
 * Noli nocere!
 */
public class Inversions {

	static long merge(int[] a, int l, int m, int r) {
		long curJumps = 0;
		int[] z = new int[r - l + 1];
		int pos1 = l;
		int pos2 = m + 1;
		int pos = 0;

		while (pos1 <= m && pos2 <= r) {
			if (a[pos1] <= a[pos2]) {
				z[pos++] = a[pos1++];
			}
			else {
				z[pos++] = a[pos2++];
				curJumps += m - pos1 + 1;
			}
		}
		while (pos1 <= m) {
			z[pos++] = a[pos1++];
		}
		while (pos2 <= r) {
			z[pos++] = a[pos2++];
		}

		System.arraycopy(z, 0, a, l, r - l + 1);
		return curJumps;
	}

	static long mergeSort(int a[], int l, int r) {
		long ans = 0;
		if (l >= r) { return ans; }

		int m = (l + r) / 2;
		ans += mergeSort(a, l, m);
		ans += mergeSort(a, m + 1, r);
		ans += merge(a, l, m, r);

		return ans;
	}

	static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++)  {
			a[i] = in.nextInt();
		}
		System.out.println(mergeSort(a, 0, n - 1));
		System.out.close();
	}
}