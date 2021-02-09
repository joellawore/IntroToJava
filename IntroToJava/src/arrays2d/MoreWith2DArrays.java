package arrays2d;

public class MoreWith2DArrays {

	// display methods
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
	
	// methods
	public void toTheNthPower(int n) {
		int[][] arr = new int[n][n];
		int num = 1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = num;
				num ++;
			}
		}
		display(arr);
	}
	
	public void max(double[][] arr) {
		double max = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				max = Math.max(arr[i][j], max);
			}
		}
		System.out.println(max);
	}
	
	public void sum(int[][] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				sum += arr[i][j];
			}
		}
		System.out.println(sum);
	}
	
	public static void main(String[] args) {
		MoreWith2DArrays run = new MoreWith2DArrays();
		
		// run.display(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
		// run.toTheNthPower(3);
		//run.max(new double[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
		run.sum(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
	}
}
