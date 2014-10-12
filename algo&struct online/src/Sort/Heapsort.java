package Sort;

import java.util.Scanner;

/**
 * Noli nocere!
 */
public class Heapsort {

	static void buildHeap(int[] a) {
		for(int i = (a.length + 1) / 2; i > 0; i--) {
		   siftDown(a, i);
		}
	}

	static void siftDown(int[] a, int i) {
		int min = 0;
		int z;
		while (min != i) {
			min = i;
			if (i * 2 < size && a[i * 2] < a[min]) {
				min = i * 2;
			}
			if (i * 2 + 1 < size && a[i * 2 + 1] < a[min]) {
				min = i * 2 + 1;
			}
			swap(min, i);
			z = min;
			min = i;
			i = z;
		}
	}

	static void swap(int ind1, int ind2) {
		int z;
		z = a[ind1];
		a[ind1] = a[ind2];
		a[ind2] = z;
	}

	static Scanner in;
	static int[] a;
	static int size;

	public static void main(String[] args)  {
		in = new Scanner(System.in);
		int n = in.nextInt() + 1;
		a = new int[n];
		for(int i = 1; i < n; i++) {
			a[i] = in.nextInt();
		}
		size = n;
		buildHeap(a);
		for(int i = n - 1; i > 0; i--) {
			System.out.print(a[1] + " ");
			swap(i, 1);
			size--;
			siftDown(a, 1);
		}
		System.out.close();
	}

}
