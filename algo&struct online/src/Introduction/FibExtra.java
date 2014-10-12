package Introduction;

import java.util.Scanner;

/**
 * Noli nocere!
 */
public class FibExtra {

	static long getFib(long n, int m) {
		long a11 = 1, a12 = 1, a21 = 1, a22 =  0;
		long r11 = 1, r12 =  0;
		long q11, q12, q21, q22;
		while (n > 0) {
			if ((n & 1) == 1) {
				q11 = (r11 * a11 + r12 * a21) % m;
				q12 = (r11 * a12 + r12 * a22) % m;
				r11 = q11;
				r12 = q12;
			}
			q11 = (a11 * a11 + a12 * a21) % m;
			q12 = (a11 * a12 + a12 * a22) % m;
			q21 = (a21 * a11 + a22 * a21) % m;
			q22 = (a21 * a12 + a22 * a22) % m;
			a11 = q11;
			a12 = q12;
			a21 = q21;
			a22 = q22;

			n >>= 1;
		}
		return r12;
	}

	static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		long n = in.nextLong();
		int m = in.nextInt();
		if(n < 2) {
			System.out.print(n % m);
			System.out.close();
			return;
		}
		System.out.print(getFib(n, m));
		System.out.close();
	}
}
