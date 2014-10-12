package Structures;

import java.util.Scanner;

/**
 * Noli nocere!
 */
class Heap {

	public static class myPriorityQueue {           // [1..tail)
		//a[1] - root
		private int tail;
		private int[] a;

		myPriorityQueue() {
			tail = 1;
			a = new int[64];
		}

		private void checkSize() {
			if (a.length > 4 * tail && a.length > 64) {
				int[] b = new int[a.length / 2];
				for (int i = 0; i < tail; i++) {
					b[i] = a[i];
				}
				a = b.clone();
			}
		}

		private int pop() {
			tail--;
			int res = a[tail];
			checkSize();
			return res;
		}

		public void push(int x) {
			tail++;
			if (tail < a.length) {
				a[tail - 1] = x;
			} else {
				int[] b = new int[a.length * 2];
				for (int i = 0; i < a.length; i++) {
					b[i] = a[i];
				}
				a = b.clone();
				a[tail - 1] = x;
			}
			siftUp(tail - 1);
		}

		public void extractMax() {
			if (!isEmpty()) {
				swap(tail - 1, 1);
				System.out.println(pop());
				siftDown(1);
			} else {
				System.out.println("*");
			}
		}

		private int siftUp(int i) {
			while (i > 1 && a[i] > a[i / 2]) {
				swap(i, i / 2);
				i /= 2;
			}
			return i;
		}

		private int siftDown(int i) {
			int max = 0;
			int z;
			while (max != i) {
				max = i;
				if (i * 2 < tail && a[i * 2] > a[max]) {
					max = i * 2;
				}
				if (i * 2 + 1 < tail && a[i * 2 + 1] > a[max]) {
					max = i * 2 + 1;
				}
				swap(max, i);
				z = max;
				max = i;
				i = z;
			}
			return i;
		}

		private void swap(int ind1, int ind2) {
			int z;
			z = a[ind1];
			a[ind1] = a[ind2];
			a[ind2] = z;
		}

		private boolean isEmpty() {
			return tail == 1;
		}
	}

	static Scanner in;
	static myPriorityQueue queue;

	public static void main(String[] args) {
		try {
			in = new Scanner(System.in);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String cmd;
		int x;
		queue = new myPriorityQueue();
		int n = in.nextInt();

		for(int i = 0; i < n; i++) {
			cmd = in.next();
			if (cmd.equals("Insert")) {
				x = in.nextInt();
				queue.push(x);
			}
			else if (cmd.equals("Extract")) {
				queue.extractMax();
			}
		}

		System.out.close();
	}
}