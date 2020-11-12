// filler code for pong provided by Mr. David

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LoopGraphicsFiller extends JPanel {
	
	// constants that are predefined and won't change as the program runs
	private final int WIDTH = 1000, HEIGHT = 590;

	public void across(Graphics g, int n) {
		for (int i = 0; i < n; i++) {
			g.setColor(Color.blue);
			g.fillOval(i*30, 0, 30, 30);
		}
	}
	
	public void dynamicRow(Graphics g) {
		int width = 0;
		int d = 30;
		int x = 1;
		for (int i = 0; width < 1000; i++) {
			g.setColor(Color.blue);
			g.fillOval(i*d, 0, d, d);
			
			width += d;
			d += x;
			
			if (width >= WIDTH) {
				x = -1;
			}
		}
	}

	public void tenByTen(Graphics g) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				g.setColor(Color.blue);
				g.fillOval(i*40, j*40, 30, 30);
			}
		}
	}
	
	public void checkers(Graphics g) {
		for (int i = 0; i < 8 ; i++) {
			for (int j = 0; j < 8 ; j++) {
				
				if (j % 2 == (i % 2))
					g.setColor(Color.BLACK);
				else
					g.setColor(Color.WHITE);
				g.fillRect(j*30, i*30,30, 30);
			}
		}
	}

	public void cyclingRectangles(Graphics g) {
		int width = 0;
		int w = 30;
		int c = 0;
		for (int i = 0; width <= WIDTH; i++) {
			if (c == 0)
				g.setColor(Color.red);
			
			if (c == 1)
				g.setColor(Color.orange);
			
			if (c == 2)
				g.setColor(Color.yellow);
			
			if (c == 3)
				g.setColor(Color.green);
			
			if (c == 4)
				g.setColor(Color.blue);
			
			if (c == 5) {
				g.setColor(Color.MAGENTA);
				c = -1;
			}
			
			g.fillRect(i*w, HEIGHT/2-w, w, w);
			width += w;
			c++;
		
		}
	}
	
	// defines what we want to happen anytime we draw the graphics
	public void paint(Graphics g) {
		
		// background color is gray
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		// call your methods here
		//across(g, 10);
		//row(g);
		//checkers(g);	
		cyclingRectangles(g);
	}

	//////////////////////////////////////
	//////////////////////////////////////
	
	// DON'T TOUCH THE BELOW CODE
	
	
	// this method runs the actual program.
	public void run() {

		// while(true) should rarely be used to avoid infinite loops, but here it is ok because
		// closing the graphics window will end the program
		while (true) {
	
			// draws
			//repaint();
			
			//rests for a hundredth of a second
			try {
				Thread.sleep(10);
			} catch (Exception ex) {}
		}
	}
	
	// very simple main method to get the game going
	public static void main(String[] args) {
		new LoopGraphicsFiller();
	}
 
	// does complicated stuff to initialize the graphics and key listeners
	// DO NOT CHANGE THIS CODE UNLESS YOU ARE EXPERIENCED WITH JAVA
	// GRAPHICS!
	public LoopGraphicsFiller() {
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		this.setFocusable(true);
		
		run();
	}
}