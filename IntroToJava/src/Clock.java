public class Clock {
	private int time;
	
	public void setTime(int t) {
		time = t;
			
	} 
	
	public void tick() {
		time++;
		while (time == 60) {
			time = 0;
		}
	}
	
	public void displayTime() {
		System.out.println(time);
	}
	
	// create your methods here
	
	public static void main(String[] args) {
		Clock tester = new Clock();
		
		// should display the time to be 56, 57, 58, 59, 0, 1, etc.
		tester.setTime(56);
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
	}
}