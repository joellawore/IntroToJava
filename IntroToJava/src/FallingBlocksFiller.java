import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FallingBlocksFiller extends JPanel {
	
	private int WIDTH = 800, HEIGHT = 600, NUMBLOCKS = 50;

	// instance variables (what kind of data structure should we use?)
	private int[] y = new int[NUMBLOCKS], x = new int[NUMBLOCKS], velo = new int[NUMBLOCKS];
	
	// your code here
	
	// fills in your arrays with random x and y values
	public void initializeArrays() {
		
		// your code here
		for (int i = 0; i < y.length; i++) {
			y[i] = 0;
			x[i] = (int)(Math.random()*WIDTH);
			velo[i] = (int)((Math.random()*5+7));
		}
		
	}
	
	// change your arrays here to make the blocks move
	public void moveblocks() {

		// your code here
		for (int i = 0; i < y.length; i++) {
			y[i] += velo[i];
		}
	}
	
	// change the last part of this method!
	public void paint(Graphics g) {
		// give a white background
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// color the rectangles blue - you can change this
		g.setColor(Color.blue);
		
		// draw your rectangles here! 
		for (int i = 0; i < NUMBLOCKS; i++) {
			g.fillRect(x[i], y[i], 15, 15);
		}
	}
	
	// ******** DON'T TOUCH BELOW CODE ***************
	
	// don't touch this method!
	public FallingBlocksFiller() {
		initializeArrays();
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setVisible(true);

		while (true) {
			moveblocks();
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			WIDTH = frame.getSize().width;
			HEIGHT = frame.getSize().height;
		}
	}

	// don't touch this method!
	public static void main(String[] args) {
		new FallingBlocksFiller();
	}

}