package Introduction;

import java.util.Scanner;

/**
 * Noli nocere!
 */
public class NumSort {

	static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		int[] b = new int[10];
		int n = in.nextInt();
		for(int i = 0; i < n; i++) {
			b[in.nextInt()]++;
		}
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < b[i]; j++) {
				System.out.print(i + " ");
			}
		}
		System.out.close();
	}
}
