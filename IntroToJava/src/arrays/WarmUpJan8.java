package arrays;

import java.util.Arrays;

public class WarmUpJan8 {
	public void indexSum(double[] n) {
		double sum = 0;
		for (int i = 0; i < n.length; i++) {
			sum += n[i] * i;
		}
		System.out.println(sum);
	}
	
	public void singleString(char[] a) {
		String single = ""; 
		for (int i = 0; i < a.length; i++) {
			if (a[i] >= 'a' && a[i] <= 'z')
				single += a[i];
		}
		System.out.println(single);
	}
	
	public void mode(char[] b) {
		int maxMode = 0;
		int maxChar = 0;
		for (int i = 0; i < b.length; i++) {
			int tempMode = 0;
			for (int j = 0; j < b.length; j++) {
				if (b[i] == b[j])
					tempMode++;
			}
			if (tempMode > maxMode) {
				maxChar = b[i];
			}
			maxMode = Math.max(tempMode, maxMode);
			
		}
		System.out.println((char)maxChar);
	}
	
	public static void main(String []args) {
		WarmUpJan8 run = new WarmUpJan8();
		
		double[] n = {5.8, 3.1, 2.5};
		char[] a = {'h', 'i', '!', 'H', 'e', 'l', 'L', 'o', '?'};
		char[] b = {'h', 'k', 'h', 'u', 'b', 'e', 'k', 'u', 'u'};
		
		run.indexSum(n);
		run.singleString(a);
		run.mode(b);
	}
}
