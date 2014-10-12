package Introduction;

import java.util.Scanner;

/**
 * Noli nocere!
 */
public class Fib2 {

	static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		int n = in.nextInt();
		if(n < 2) {
			System.out.print(n);
			System.out.close();
			return;
		}
		int f0 = 0;
		int f1 = 1;
		int ans = 0;
		for(int i = 2; i < n + 1; i++) {
			ans = f0 + f1;
			f0 = f1;
			f1 = ans;
		}
		System.out.print(ans);
		System.out.close();
	}
}
