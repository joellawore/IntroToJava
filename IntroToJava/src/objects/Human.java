package objects;

public class Human {
	private String name;
	private int age;
	private int height;
	
	// constructor class
	public Human (String n, int a, int h) {
		name = n;
		age = a;
		height = h;
	}
	
	// getMethods
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public int getHeight() {
		return height;
	}

	// methods
	public void getOlder() {
		this.age++;
	}
	public void changeName(String n) {
		name = n;
	}
	public boolean canVote(int y) {
		return (y % 4 == 0 && age >= 18);
	}
	
	public static void main(String[] args) {
		Human joel = new Human("Joel", 17, 68);
		System.out.println(joel.getAge());
		joel.getOlder();
		System.out.println(joel.getAge());
		
		System.out.println(joel.getName());
		joel.changeName("Ibukunoluwa");
		System.out.println(joel.getName());
		
		System.out.println(joel.canVote(2021));
	}
}
