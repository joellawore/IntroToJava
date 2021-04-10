package inheritance;

import java.awt.Color;

public class ColorBall extends Ball {
	private int time;
	
	public ColorBall(int startx, int starty, int startrad, int startxspeed, int startyspeed) {
		super(startx, starty, startrad, startxspeed, startyspeed, null);
	}
	
	public static Color randomColor() {
		int r = (int)((Math.random() * 254 ) + 1);
		int g = (int)((Math.random() * 254 ) + 1);
		int b = (int)((Math.random() * 254 ) + 1);
		return new Color(r, g, b);
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
			setColor(randomColor());
	}
}