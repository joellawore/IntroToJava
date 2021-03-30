package objects;

public class Midfielder extends Footballer {
	private int passes;
	
	public Midfielder(String surname, String foot, double height, boolean playing, int passes) {
		super(surname, foot, height, playing);
		this.passes = passes;
	}
	
	public String toString() {
		return super.toString() +"\n"+ passes + " passes";
	}
	
	public int getPasses() {
		return passes;
	}
	
	public void completedPass() {
		passes++;
	}
}
