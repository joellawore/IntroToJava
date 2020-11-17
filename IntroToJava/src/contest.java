
public class contest {

	public void loopingBox(int x) {
		for (int i = 1; i <= x; i++) {
			for (int j = i; j < i+5; j++) {
				System.out.print( (j <= 5) ? j + " ": (j - 5) + " ");

			}
			System.out.println();
		}
	}
	
	public void triangle(int x) {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("X");
			}
			System.out.println();
		}
	}
	
	public void what_power(int x, int y) {
		for (int i = 1; i >= 1; i++) {
			if(Math.pow(x, i) == y) {
				System.out.println(i);
				break;
			}
		}
	}
	
	public static void main(String args[]) {
		contest run = new contest(); {
			run.loopingBox(5);
			run.triangle(7);
			run.what_power(9,9);
		}
	}
}
