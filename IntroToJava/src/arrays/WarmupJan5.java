package arrays;

import java.util.Arrays;

public class WarmupJan5 {
	// easy
	public void arrayToString(String[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
	}

	public void numberLength(int b) {
		int[] n = new int[b];
		for (int i = 0; i < b; i++) {
			n[i] = i+1;
		}
		System.out.println(Arrays.toString(n));
	}
	
	public void average(int[] c) {
		int sum = 0;
		double avg = 0;
		
		for (int i = 0; i < c.length; i++) {
			sum += c[i];
		}
		avg = sum/c.length;
		
		System.out.print(avg);
	}

	
	public void doub(int[] d) {
		for (int i = 0; i < d.length; i++) {
			d[i] = d[i]*2;
		}
		System.out.println(Arrays.toString(d));
	}
	
	// medium
	public void trim(int[] e) {
		int max = 0, min = 0;
		
		for (int i = 1; i < e.length; i++) {
			max = Math.max(e[i-1], e[i]);
			min = Math.min(e[i-1], e[i]);
		}
		int[] trimmed = new int[e.length-2];
		
		int j = 0;
		for (int i = 0; i < e.length; i++) {
			if (e[j] == max || e[j] == min)
				continue;
			
			trimmed[j] = e[j];
			j++;
		}
		System.out.println(Arrays.toString(trimmed));
	}
	
	public void fibonacci(int f) {
		int[] sequence = new int[f];
		sequence[0] = 1;
		sequence[1] = 1;
		
		for (int i = 2; i < sequence.length; i++) {
			sequence[i] = sequence[0] + sequence[1];
		}
		
		System.out.println(Arrays.toString(sequence));
	}
	
	public void divisible(int[] g) {
		for (int i = 1; i < g.length; i++) {
			System.out.println((g[i] % g[i-1] == 0) ? "yes" : "no");
		}
	}
	
	
	// hard
	public void risingAverage(int[] h) {
		int sum = 0;
		int[] avg = new int[h.length];
		for (int i = 0; i < h.length; i++) {
			sum += h[i];
			avg[i] = sum/(i+1);
		}
		System.out.println(Arrays.toString(avg));
	}
	
	public void duplicates(int[] i, int[] j) {
		int k = 0;
		int c = 0;
		for (int a = 0; a < j.length; a++) {
			for (int b = 0; b < i.length; b++) {
				if (j[a] == i[b]) {
					k++;
					break;
				}
			}
		}
		
		int[] dup = new int[k];
		for (int a = 0; a < j.length; a++) {
			for (int b = 0; b < i.length; b++) {
				if (j[a] == i[b]) {
					dup[c] = j[a];
					c++;
					break;
				}
			}
		}
		
		System.out.println(Arrays.toString(dup));
	}
	
	public void dotProduct(int[] k, int[] l) {
		int dotSum = 0;
		for (int i = 0; i < k.length; i++) {
			dotSum += k[i]*l[i];
		}
		
		System.out.println(dotSum);
	}
	
	
	public static void main(String []args) {
		WarmupJan5 run = new WarmupJan5();
		
		/* easy values */
		String[] a = {"Ants", "Bees", "Cats", "Dogs", "Elephants", "Frogs"};
		int b = 57;
		int[] c = {1, 2, 3, 4, 5};
		int[] d = {7, 4, 1, 9, 2, 8};
			/* easy */
			run.arrayToString(a);
			run.numberLength(b);
			run.average(c);
			run.doub(d);
		
			
		/* medium values*/
		int[] e = {6, 3, 8, 7, 2};
		int f = 5;
		int[] g = {8, 3, 12, 5, 15, 45};
			/* medium */
			run.trim(e);
			run.fibonacci(f);
			run.divisible(g);
		
			
		/* hard values*/
		int[] h = {4, 6, 2, 12};
		int[] i = {8, 4, 9, 0, 2}, j = {7, 2, 3, 9, 6};
		int[] k = {5, 3, 1}, l = {8, 4, 7};
			/* hard */
			run.risingAverage(h);
			run.duplicates(i, j);
			run.dotProduct(k, l);
	}
}


