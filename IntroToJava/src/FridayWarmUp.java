
public class FridayWarmUp {

	public void digits(int x) {
		String num = Integer.toString(x);
		for (int i = 0; i < num.length(); i++) {
			System.out.println(num.substring(i,i+1));
		}
	}

	public void rect(int x, int y) {
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				System.out.print("X ");
			}
			System.out.println();
		}
	} 

	public void factors(int x) {
		for (int i = 1; i < x; i++) {
			for (int j = 1; j < i; j++) {
				if (i % j == 0)
					System.out.print(j + ", ");
			}
			System.out.print(i);
			System.out.println();
		}
	}
	
	public static void main(String args[]) {
		FridayWarmUp run = new FridayWarmUp();
		run.digits(32532);
		run.rect(5, 5);
		run.factors(8);
	}
}
