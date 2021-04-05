package objects;

public class CreditCard extends InterestAccount{

	public CreditCard(String name, double balance, double interest) {
		super(name, balance, interest);
	}
	public CreditCard(String name, double interest) {
		super(name, interest);
	}

	public void addInterest() {
		super.deposit((super.getBalance()*(1+super.getInterest()))-10);
	}
	
	public void withdraw(double amount) {
		if (super.getBalance()-amount >= 100) {
			super.withdraw(amount);
		}
		else {
			System.out.println("Error: Account cannot go below $100.");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("What is your name?");
		String name = in.next();
		
		System.out.println("What is your interest rate?");
		double interest = in.nextDouble();
		
		CreditCard Account = new CreditCard(name, interest);
		
		boolean running = true;
		
		while (running) {
			System.out.println("What would you like to do?"
					  + "\n 1 - Deposit"
					  + "\n 2 - Withdraw"
					  + "\n 3 - View Account Info"
					  + "\n 4 - Add Interest"
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
				Account.addInterest();
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
