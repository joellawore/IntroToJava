package arrays2d;

public class EvenMoreWith2DArrays {
	
	// helper methods
	public void display(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	public void display(double[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	public void display(char[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	public void display(String[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void arrayToString(char[][] arr) {
		String str = "";
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				str += arr[i][j];
			}
		}
		System.out.println(str);
	}	
	public void diagonals(int n) {
		String[][] arr = new String[n][n];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (i == j || (i+j+1) == arr.length)
					arr[i][j] = "n";
			}
		}
		display(arr);
	}
	public void triangle(int n) {
		int[][] arr = new int[n][];
		arr[0] = new int[1];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = new int[arr[i-1].length+1];
		}
		int x = 1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = x;
				x++;
			}
		}
		display(arr);
	}
	public void doubleArray(int[][] arr) {
		int[][] doub = new int[arr.length][];
		for (int i = 0; i < arr.length; i++) {
			doub[i] = new int[arr[i].length*2];
		}
		for (int i = 0; i < doub.length; i++) {
			int j = 0;
			for (int x = 0; x < arr[i].length; x++) {
				doub[i][j] = arr[i][x];
				j+=2;
			}
		}
		display(doub);
	}
	public void reverse2D(double[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for(int n = 0, j = arr[i].length-1; n < arr[i].length/2; n++, j--) {
				double temp = arr[i][n];
				arr[i][n] = arr[i][j];
				arr[i][j] = temp;
			}
		}
		display(arr);
	}
	
	public static void main(String args[]) {
		EvenMoreWith2DArrays run = new EvenMoreWith2DArrays();
		// run.arrayToString(new char[][] {{'h', 'e', 'l'}, {'l', 'o'}});
		// run.diagonals(5);
		// run.triangle(4);
		// run.doubleArray(new int[][] {{1, 2, 3}, {4, 5, 6}});
		// run.reverse2D(new double[][] {{1}, {2, 3}, {4, 5, 6}, {7, 8, 9, 10}, {11, 12, 13, 14, 15}});
	}
}
