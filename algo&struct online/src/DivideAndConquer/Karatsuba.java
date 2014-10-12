package DivideAndConquer;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * Noli nocere!
 */
public class Karatsuba {

	static Scanner in;

	public static BigInteger karatsuba(BigInteger x, BigInteger y) {

		int N = Math.max(x.bitLength(), y.bitLength());
		if (N <= 2000) return x.multiply(y);

		N = (N / 2) + (N % 2);

		BigInteger b = x.shiftRight(N);
		BigInteger a = x.subtract(b.shiftLeft(N));
		BigInteger d = y.shiftRight(N);
		BigInteger c = y.subtract(d.shiftLeft(N));

		BigInteger ac    = karatsuba(a, c);
		BigInteger bd    = karatsuba(b, d);
		BigInteger abcd  = karatsuba(a.add(b), c.add(d));

		return ac.add(abcd.subtract(ac).subtract(bd).shiftLeft(N)).add(bd.shiftLeft(2*N));
	}

	public static String toString(BigInteger bi) {
		StringBuilder sb = new StringBuilder();
		int i = 16;
		while (bi.compareTo(powerOfTen(i)) > 0)
			i *= 2;
		toString(bi, sb, i);
		int start = 0;
		while (sb.charAt(start) == '0')
			start++;
		return sb.substring(start);
	}

	private static void toString(BigInteger bi, StringBuilder sb, int digits) {
		if (digits < 18) {
			int start = sb.length();
			for (int i = 0; i < digits; i++)
				sb.append('0');
			long l = bi.longValue();
			for (int i = digits - 1; i >= 0; i--, l /= 10)
				sb.setCharAt(start + i, (char) ('0' + l % 10));
		} else {
			int digits2 = digits / 2;
			BigInteger[] parts = bi.divideAndRemainder(powerOfTen(digits2));
			toString(parts[0], sb, digits - digits2);
			toString(parts[1], sb, digits2);
		}
	}

	private static final Map<Integer, BigInteger> powersOfTen = new HashMap<Integer, BigInteger>();

	private static BigInteger powerOfTen(int digits2) {
		BigInteger tens = powersOfTen.get(digits2);
		if (tens == null)
			powersOfTen.put(digits2, tens = BigInteger.TEN.pow(digits2));
		return tens;
	}

//	static char[] multiply(char[] a, char[] b) {
//		int n = Math.max(a.length, b.length);
//		if(n == 1) {
//			return (a[0] == '1' && b[0] == '1')?  : "0";
//		}
//	}

	public static void main(String[] args) {
		long start, stop;
		in = new Scanner(System.in);
		BigInteger a = in.nextBigInteger();
		BigInteger b = in.nextBigInteger();
		start = System.currentTimeMillis();
		System.out.println(toString(karatsuba(a, b)));
		stop = System.currentTimeMillis();
		System.out.print(stop - start);
	}
}
