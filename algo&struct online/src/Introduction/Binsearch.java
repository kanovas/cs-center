package Introduction;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Noli nocere!
 */
public class Binsearch {
	static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		int k = in.nextInt();
		int b;
		int ans;
		for(int i = 0; i < k; i++) {
			b = in.nextInt();
			ans = Arrays.binarySearch(a, b);
			System.out.print((ans < 0 ? -1: ans + 1) + " ");
		}
		System.out.close();
	}
}
