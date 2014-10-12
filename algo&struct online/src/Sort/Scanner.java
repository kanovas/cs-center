package Sort;

import java.util.*;

/**
 * Noli nocere!
 */
public class Scanner {

	static java.util.Scanner in;
	static Random rand;
	static int[] points;

	static class point {
		int type, key, id;
		point(int k, int t) {
			key = k;
			type = t;     //beginning - 1; final - -1
		}
		point(int k, int t, int i) {
			key = k;
			type = t;
			id = i;
		}
	}

	static class comporator implements Comparator<point> {
		@Override
		public int compare(point x, point y) {
			if(x.key == y.key) {
			    if(x.type > y.type) {
				   return -1;
			    }
				else if(x.type < y.type) {
				   return 1;
			    }
				else {
				   return 0;
			    }
			}
			if(x.key < y.key) {
				return -1;
			}
			else if(x.key > y.key) {
				return 1;
			}
			else {
				return 0;
			}
		 }
	}

/*	static void qsort(point[] a, int l, int r) {
		if (l >= r) {
			return;
		}
		int i = l;
		int j = r;
		point x = a[(l + r) / 2];
		while(i <= j) {
			while(a[i].key < x.key) {
				i++;
			}                                            //bgn < final; point > bgn; point < final
			while(a[i].key == x.key && (a[i].type == 0 && x.type == 1 || a[i].type == 0 && x.type == 2 || a[i].type == 2 && x.type == 1)) {
				i++;
			}
			while(a[j].key > x.key) {
				j--;
			}
			while(a[j].key == x.key && (a[j].type == 1 && x.type == 0 || a[j].type == 2 && x.type == 0 || a[j].type == 1 && x.type == 2)) {
				j--;
			}
			if(i <= j) {
				swap(a, i, j);
				i++;
				j--;
			}
		}
		qsort(a, l, j);
		qsort(a, i, r);
	}

	static void swap(point[] a, int i, int j) {
		point z = a[i];
		a[i] = a[j];
		a[j] = z;
	}
     */
	public static void main(String[] args) {
		rand = new Random();
		in = new java.util.Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] points = new int[m];
		ArrayList<point> a = new ArrayList<point>();
		for(int i = 0; i < n; i++) {
			a.add(new point(in.nextInt(), 1));
			a.add(new point(in.nextInt(), -1));
		}
		for(int i = 0; i < m; i++) {
			a.add(new point(in.nextInt(), 0, i));
		}
		Collections.sort(a, new comporator());
		int num = 0;
		for(int i = 0; i < 2 * n + m; i++) {
			num += a.get(i).type;
			if(a.get(i).type == 0) {
				points[a.get(i).id] = num;
			}
		}
		for(int i = 0; i < m; i++) {
			System.out.print(points[i] + " ");
		}
	}
}
