package objects;

public class CenterDefensiveMidfielder extends Midfielder{
	private int interceptions;
	
	public CenterDefensiveMidfielder(String surname, String foot, double height, boolean playing, int passes, int interceptions) {
		super(surname, foot, height, playing, passes);
		this.interceptions = interceptions;
	}

	public String toString() {
		return super.toString() +"\n"+ interceptions + " interceptions\n";
	}
	
	public int getInterceptions() {
		return interceptions;
	}
	
	public void completedInterceptions() {
		interceptions++;
	}
	
	public static void main(String[] args) {
		CenterDefensiveMidfielder player = new CenterDefensiveMidfielder("Lawore", "Right", 5.8, true, 349, 63);
		System.out.println(player);
		
		int i = 0;
		while (i < 27) {
		player.completedPass();
		i++;
		}
		player.completedInterceptions();
		
		System.out.println(player);
	}
}
