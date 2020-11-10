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

public class Pong extends JPanel implements KeyListener {
	
	// constants that are predefined and won't change as the program runs
	private final int WIDTH = 600, HEIGHT = 600, WINDOW_HEIGHT = 650;
	private final int PADDLE_WIDTH = 20, DIAM = 30, PADDLE_HEIGHT = 100;
	private final int XPADDLE1 = 0;
	private final int XPADDLE2 = WIDTH - PADDLE_WIDTH;

	
	// your instance variables here, I've given you a few 
	private boolean up1, down1, up2, down2; 		// booleans to keep track of paddle movement
	private boolean multiplayerCheck = true;
	private int xball = WIDTH/2, yball = HEIGHT/2;
	private int ypaddle1 = HEIGHT/2;
	private int ypaddle2 = HEIGHT/2;
	private int xvelo = 10;
	private int yvelo = 7;
	private int pspeed = 8;
	private int paddle_speed1 = 0;
	private int paddle_speed2 = 0;
	private int score1 = 0;
	private int score2 = 0;
	
	// this method moves the ball at each timestep
	public void move_ball() {

		// your code here //
		xball += xvelo;
		yball += yvelo;
	}
	
	// this method moves the paddles at each timestep
	public void move_paddles() {
		if (up1) {
			paddle_speed1 = 0 - pspeed;
		}
		if (up2) {
			paddle_speed2 = 0 - pspeed;
		}
		if (down1) {
			paddle_speed1 = pspeed;
		}
		if (down2) {
			paddle_speed2 = pspeed;
		}
		if (!up1 && !down1) {
			paddle_speed1 = 0;
		}
		if (!up2 && !down2) {
			paddle_speed2 = 0;
		}
		ypaddle1 += paddle_speed1;
		ypaddle2 += paddle_speed2;
		
		// your code here // 
	}
	
	// this method checks if there are any bounces to take care of,
	// and if the ball has reached a left/right wall it adds to 
	// the corresponding player's score
	public void check_collisions() {
		if (xball >= WIDTH-DIAM || xball <= 0) {
			xvelo = -xvelo;
		}
		if (yball >= HEIGHT-DIAM || yball <= 0) {
			yvelo = -yvelo;
		}
		if (xball <= 0) {
			score2 ++;
		}
		if (xball >= WIDTH-DIAM) {
			score1 ++;
		}
		
		// your code here
		if ((yball >= ypaddle1) && (yball + DIAM <= ypaddle1 + PADDLE_HEIGHT) && (xball <= XPADDLE1 + PADDLE_WIDTH)) {
			xvelo = 0 - xvelo;
		} 
		
		if ((yball >= ypaddle2) && (yball + DIAM <= ypaddle2 + PADDLE_HEIGHT) && (xball + DIAM >= XPADDLE2)) {
			xvelo = 0 - xvelo;
		} 
	}
	

	// defines what we want to happen any time we draw the game
	// you simply need to fill in a few parameters here
	public void paint(Graphics g) {
		
		// background color is gray
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// draw your rectangles and circles here
		g.setColor(new Color(50,100,200));
		g.fillOval(xball, yball, DIAM, DIAM);
		
		g.fillRect(XPADDLE1, ypaddle1, PADDLE_WIDTH, PADDLE_HEIGHT);
		g.fillRect(XPADDLE2, ypaddle2, PADDLE_WIDTH, PADDLE_HEIGHT);
		// .......
		
		// writes the score of the game - you just need to fill the scores in
		Font f = new Font("Arial", Font.BOLD, 14);
		g.setFont(f);
		g.setColor(Color.red);
		g.drawString("P1 Score: " + score1, WIDTH/5, 20);
		g.drawString("P2 Score: " + score2, WIDTH*3/5, 20);
	}

	// defines what we want to happen if a keyboard button has 
	// been pressed - you need to complete this
	public void keyPressed(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		
		// changes paddle direction based on what button is pressed
		if (keyCode == KeyEvent.VK_DOWN) 
			// fill this in
			if (multiplayerCheck) {
				down2 = true;
			}
		
		if (keyCode == KeyEvent.VK_UP) 
			// fill this in
			if (multiplayerCheck) {
				up2 = true;
			}

		if (e.getKeyChar() == 'w')
			// move paddle down
			up1 = true;
		
		if (e.getKeyChar() =='s')
			// fill this in
			down1 = true;
			
/*		// turn 1-player mode on
		if (e.getKeyChar() == '1')
			// fill this in
			multiplayerCheck = false;
			up2 = false;
			down2 = false;
			
		// turn 2-player mode on
		if (e.getKeyChar() == '2')
			// fill this in
			multiplayerCheck = true; */
	}

	// defines what we want to happen if a keyboard button
	// has been released - you need to complete this
	public void keyReleased(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		
		// stops paddle motion based on which button is released
		if (keyCode == KeyEvent.VK_UP) 
			// fill this in
			up2 = false;

		if (keyCode == KeyEvent.VK_DOWN) 
			// fill this in
			down2 = false;
  
		if(e.getKeyChar() == 'w')
			// fill this in
			up1 = false;
		
		if (e.getKeyChar() == 's')
			// fill this in
			down1 = false;
	}
	
	// restarts the game, including scores
	public void restart() {

		// your code here
	}

	//////////////////////////////////////
	//////////////////////////////////////
	
	// DON'T TOUCH THE BELOW CODE
	
	
	// this method runs the actual game.
	public void run() {

		// while(true) should rarely be used to avoid infinite loops, but here it is ok because
		// closing the graphics window will end the program
		while (true) {
	
			// draws the game
			repaint();
			
			// we move the ball, paddle, and check for collisions
			// every hundredth of a second
			move_ball();
			move_paddles();
			check_collisions();
			
			//rests for a hundredth of a second
			try {
				Thread.sleep(10);
			} catch (Exception ex) {}
		}
	}
	
	// very simple main method to get the game going
	public static void main(String[] args) {
		new Pong();
	}
 
	// does complicated stuff to initialize the graphics and key listeners
	// DO NOT CHANGE THIS CODE UNLESS YOU ARE EXPERIENCED WITH JAVA
	// GRAPHICS!
	public Pong() {
		JFrame frame = new JFrame();
		JButton button = new JButton("restart");
		frame.setSize(WIDTH+15, WINDOW_HEIGHT+15);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.add(button, BorderLayout.SOUTH);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restart();
				Pong.this.requestFocus();
			}
		});
		this.addKeyListener(this);
		this.setFocusable(true);
		
		run();
	}
	
	// method does nothing
	public void keyTyped(KeyEvent e) {}
}