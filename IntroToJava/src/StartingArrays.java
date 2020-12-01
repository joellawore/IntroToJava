import java.util.Scanner;

public class StartingArrays {

	static int arr[] = {4, 5, 2, 8, 11};
			
	public void display(int[] n) {
		for (int i = 0; i < n.length; i++) {
			System.out.print(n[i] + " ");
		}
	}
	
	public void oneToN(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
		}
		display(arr);
	}

	public void swap(int[] n) {
		int f = n[0];
		n[0] = n[n.length-1];
		n[n.length-1] = f;
		display(n);
	}

	public void userArray() {
		Scanner in = new Scanner(System.in);
		int n[] = new int[7];
		System.out.println("Enter 7 numbers:");
		for (int i = 0; i < n.length; i++) {
			n[i] = in.nextInt();
		}
		display(n);
	}
	
	public void reverses(int[] n) {
		for(int i = 0, j = n.length-1; i < n.length/2; i++, j--) {
			int temp = n[i];
			
			n[i] = n[j];
			
			n[j] = temp;
		}
		
		display(n);
	}

	public static void main(String args[]) {
		StartingArrays run = new StartingArrays();
		
		// run.display(arr);
		// run.oneToN(9);
		 run.swap(arr);
		// run.userArray();
		// run.reverses(arr);
	}
}
