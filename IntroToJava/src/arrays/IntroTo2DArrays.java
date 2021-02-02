package arrays;
/*
	A - 6
	B - 1
	C - OutOfBoundsException
	D - 3
	E - k
	F - OutOfBoundsException
	G - 105
	H - k
	I - [I@....
*/
public class IntroTo2DArrays {
	
	public void display(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int  j= 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void matrix(int n) {
		int[][] arr = new int[n][n];
		display(arr);
	}

	public void columnCount(String[][] arr) {
		System.out.println("Columns: " + arr.length);
		System.out.println("Rows: " + arr.length);
	}

	public void intToArray(int a, int b, int c, int d, int e, int f) {
		int[][] arr = { {a},
						{b, c},
						{d, e, f}
		};
		display(arr);
	}
	
	public static void main(String[] args) {
		IntroTo2DArrays run = new IntroTo2DArrays();
	}
}
