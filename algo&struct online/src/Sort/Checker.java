package Sort;

import java.util.Random;

/**
 * Noli nocere!
 */
public class Checker {

	static void generateTest(int n) {
		for(int i = 0; i < n; i++) {
			a[i] = r.nextInt(1000000000);
		}
	}

	static int answer(int[] a, int n) {
		int ans = 0;
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				if(a[i] > a[j]) {
					ans++;
				}
			}
		}
		return ans;
	}

	static int[] a;
	static Random r;

	public static void main(String[] args) {
		int testNum = 1000;
		int n;
		int ans;
		long myAns;
		r = new Random();
		for(int i = 0; i < testNum; i++) {
			n = r.nextInt(10000);
			a = new int[n];
			generateTest(n);
			ans = answer(a, n);
			myAns = Inversions.mergeSort(a, 0, n - 1);
			if(ans != myAns) {
				System.out.println(n);
				for (int j = 0; j < n; j++) {
					System.out.print(a[j] + " ");
				}
				System.out.println(ans);
			}
		}
	}
}
