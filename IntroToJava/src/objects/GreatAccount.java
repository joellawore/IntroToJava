package objects;
//
public class GreatAccount extends BankAccount{
	private int monthsWithdrawals;
	private int month = 1;
	
	public GreatAccount(String name, double balance) {
		super(name, balance);
	}
	public GreatAccount(String name) {
		super(name);
	}

	public void withdraw(double amount) {
		if (monthsWithdrawals < 3) {
		super.withdraw(amount);
		monthsWithdrawals++;
		System.out.println("Months Withdrawals: " + monthsWithdrawals);
		}
		else {
			System.out.println("ERROR: Maximum monthly withdrawals reached.");
		}
	}
	
	public void nextMonth() {
		month++;
		if (month % 12 == 0 && monthsWithdrawals == 0) {
			super.deposit(super.getBalance());
			System.out.println("12th month reached, balance doubled.");
		}
		monthsWithdrawals = 0;	
	}
	
	public static void main(String[] args) {
		System.out.println("What is your name?");
		String name = in.next();
		
		GreatAccount Account = new GreatAccount(name);
		
		boolean running = true;
		
		while (running) {
			System.out.println("What would you like to do?"
					  + "\n 1 - Deposit"
					  + "\n 2 - Withdraw"
					  + "\n 3 - View Account Info"
					  + "\n 4 - Clock New Month"
					  + "\n x - Quit");
			String pressed = in.next();
			if (pressed.equals("1")) {
				System.out.println("Enter deposit amount:");
				double amount = in.nextDouble();
				Account.deposit(amount);
				System.out.println("Done.");
			}
			else if (pressed.equals("2")) {
				System.out.println("Enter withdrawal amount:");
				double amount = in.nextDouble();
				Account.withdraw(amount);
				System.out.println("Done.");
			}
			else if (pressed.equals("3")) {
				System.out.println(Account);
			}
			else if (pressed.equals("4")) {
				Account.nextMonth();
			}
			else if (pressed.equals("x")) {
				running = false;
			}
			else {
				System.out.println("Invalid Response.");
			}
		}
	}
}
