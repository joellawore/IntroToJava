package inheritance;

import java.awt.Color;

public class ShrinkingBall extends Ball {
	private int time;
	public ShrinkingBall(int startx, int starty, int startrad, int startxspeed, int startyspeed, Color startcolor) {
		super(startx, starty, startrad, startxspeed, startyspeed, startcolor);
	}
	
	public void move() {
		setX(getX()+getXSpeed());
		setY(getY()+getYSpeed());
		if (getX() <= 0 || getX() >= super.WIDTH-getRad())
			setXSpeed(getXSpeed() * -1);
		if (getY() <= 0 || getY() >= super.HEIGHT-getRad())
			setYSpeed(getYSpeed() * -1);
		time++;
		if (time % 25 == 0)
			setRad(getRad()-1);
	}
}

