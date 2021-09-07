package Main;

import java.awt.Graphics;
import java.awt.Rectangle;

public class ConstEnemy extends Enemy{
	
	private String direction;
	
	private float speed;
	/**
	 * Direction is direction of travel.
	 * @param x
	 * @param y
	 * @param speed
	 * @param dir
	 */
	public ConstEnemy(float x, float y, float speed, String dir, ObjectHandler h) {
		super(x, y, h);
		
		direction = dir;
		this.speed = speed;
		
	}
	
	@Override
	public void draw(Graphics g) {
		g.fillRect(x, y, 30, 30);
	}

	@Override
	public void tick() {
		if (direction.equals("UP")) {
			y-=speed;
		}
		else if (direction.equals("DOWN")) {
			y+=speed;
		}
		else if (direction.equals("LEFT")) {
			x-=speed;
		}
		else if (direction.equals("RIGHT")) {
			x+=speed;
		}
		
		if (x>=Game.WIDTH+70 || x<-60) {
			h.remove(this);
		}
		else if(y>Game.HEIGHT+70 || y<-60) {
			h.remove(this);
		}
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 30, 30);
	}

}
