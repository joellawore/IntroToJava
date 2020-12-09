
public class Arrays {
	
	public void displayString(String[] n) {
		for (int i = 0; i < n.length; i++) {
			System.out.print(n[i] + " ");
		}
	}
	
	public void displayInt(int[] n) {
		for (int i = 0; i < n.length; i++) {
			System.out.print(n[i] + " ");
		}
	}
	
	public void average(double[] n) {
		double sum = 0;
		for (int i = 0; i < n.length; i++) {
			sum += n[i];
		}
		System.out.println(sum/n.length);
	}

	public void intToString(int[] n) {
		String[] arr = new String[n.length];
		for (int i = 0; i < arr.length; i++) {
			if (n[i] >= 0) {
				arr[i] = "pos";
			}
			else {
				arr[i] = "neg";
			}
		}
		displayString(arr);
	}

	public void merge(int[] a, int[] b) {
		int[] ab = new int[a.length + b.length];
		for (int i = 0; i < a.length; i++) {
			ab[i] = a[i];
		}
		for (int i = a.length; i < ab.length; i++) {
			ab[i] = b[i];
		}
		displayInt(ab);
	}

	public void charCheck(char a, char[] arr) {
		boolean check = false;
		for (int i = 0; i < arr.length; i++) {
			if (a == arr[i])
				check = true;
		}
		if (check) {
			System.out.println("Array contains " + a + ".");
		}
		else {
			System.out.println("Array does not contain " + a + ".");
		}
		
	}

	public void stringCheck(String a, String[] arr) {
		int index = -1;
		for (int i = 0; i < arr.length; i++) {
			if(a.equals(arr[i]))
				index = i;
		}
		System.out.println(index);
	}

	public void commonNumbers(int[] a, int[] b) {
		boolean common = false;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (a[i] == b[j])
					common = true;
			}
			if (common)
				System.out.println(a[i]);
		}
		
	}

	public static void main(String[] args) {
		
	}
}
