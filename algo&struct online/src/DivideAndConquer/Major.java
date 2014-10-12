package DivideAndConquer;

import java.util.Scanner;

/**
 * Noli nocere!
 */
public class Major {
	static Scanner in;

	static String findMajor(int[] a) {
		int count = 0;
		int candidate = Integer.MAX_VALUE;
		for(int i = 0; i < a.length; i++) {
			if(count == 0) {
				candidate = a[i];
				count++;
			}
			else {
				if(a[i] == candidate) {
					count++;
				}
				else {
					count--;
				}
			}
		}
		count = 0;
		for(int i = 0; i < a.length; i++) {
			if(a[i] == candidate)  {
				count++;
			}
		}
		return count > a.length / 2 ? "True" : "False";
	}

	public static void main(String[] args) {
		in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		System.out.println(findMajor(a));
	}
}
