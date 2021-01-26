package arrays;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AngryBirdsFiller extends JPanel {
	
	// the width/height of the window - feel free to change these
	private final int W_WIDTH = 900, W_HEIGHT = 600;
	
	// the number of enemies in the game - feel free to change
	private final int NUM_ENEMIES = 6;
	
	// a constant for the gravitational pull on our 'bird' - again, feel free to change
	private final double G = .98;

	// hints...
	private int[] enemyX = {100};
	private int[] enemyY = {300};
	private boolean[] dead;
	
	private Image background;	// images

	// you'll need more instance variables - put them here.
	private int xI, yI;
	private int xVelo = 0, yVelo = 0;
	private int xBird = 100, yBird = 400;
	
	private boolean gSwitch = false;
	
	private final int DIAM_LAUNCHER = 25, DIAM_ENEMY = 40;
	
	// this method is for setting up any arrays that need filling in and loading images. 
	// This method will run once at the start of the game.
	public void setup() {

		// example of loading an image file - edit to suit your project
		try {
			background = ImageIO.read(new File("angrybirds.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// your code here
		
		
	}
	
	// move your 'bird' and apply any gravitational pull 
	public void moveBird() {
		// your code here
		xBird += xVelo;
		yBird += yVelo;
		
		if(gSwitch) {
			yVelo += G;
		}
		
		if (yI >= W_HEIGHT) {
			xI = 200; yI = 300;
			gSwitch = false;
			xVelo = 0; yVelo = 0;
			}
		}
	
	// check for any collisions between your 'bird' and the enemies.
	// if there is a collision, address it
	public void checkHits() {
		// your code here
		for (int i = 0; i < enemyX.length; i++)  {
			if (distance((int)xI, (int)yI, enemyX[i], enemyY[i]) <= DIAM_ENEMY/2 + DIAM_LAUNCHER/2) {
			}
		}
	}
	
	private int distance(int x1, int y1, int x2, int y2) {
		int dist = 0;
		
		return dist;
	}

	
	// what you want to happen at the moment when the 
	// mouse is first pressed down.
	public void mousePressed(int mouseX, int mouseY) {
		// your code here
		xI = mouseX;
		yI = mouseY;
	}
	
	// what you want to happen when the mouse button is released
	public void mouseReleased(int mouseX, int mouseY) {
		// your code here
		int xDelta = mouseX - xI;
		int yDelta = mouseY - yI;
		
		xVelo = -xDelta/10;
		yVelo = -yDelta/10;
		
		gSwitch = true;
	}
	
	// draws everything in our project - the enemies, your 'bird', 
	// and anything else that is present in the game
	public void paint(Graphics g) {
		// draws a white background
		g.setColor(Color.white);
		g.fillRect(0, 0, W_WIDTH, W_HEIGHT);
		
		// example of how to draw an image - draws at (100, 100) with width/height of 40/40
		g.drawImage(background, 0, 0, W_WIDTH, W_HEIGHT, null);
		
		// your code here
		g.setColor(Color.black);
		g.fillOval(xBird, yBird, 20, 20);
	}
	
	
	// ************** DON'T TOUCH THE BELOW CODE ********************** //
	
	public void run() {
		while (true) {
			moveBird();
			checkHits();
			repaint();
			
			try {Thread.sleep(20);} 
			catch (InterruptedException e) {}
		}
	}
	
	public AngryBirdsFiller() {
		setup();
		
		JFrame frame = new JFrame();
		frame.setSize(W_WIDTH, W_HEIGHT);
		this.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {
				AngryBirdsFiller.this.mousePressed(e.getX(),e.getY());	
			}
			public void mouseReleased(MouseEvent e) {
				AngryBirdsFiller.this.mouseReleased(e.getX(),e.getY());
			}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		});
		frame.add(this);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		run();
	}
	public static void main(String[] args) {
		new AngryBirdsFiller();
	}
}
