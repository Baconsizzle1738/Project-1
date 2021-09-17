package Main;

import java.awt.Color;
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
		
		//speed cap at 29
		if (this.speed>29) {
			this.speed = 29;
		}
		
		if (direction.equals("UP")) {
			this.y = Main.HEIGHT+30;
		}
		else if (direction.equals("DOWN")) {
			this.y = -30;
		}
		else if (direction.equals("RIGHT")) {
			this.x = -30;
		}
		else if (direction.equals("LEFT")) {
			this.x = Main.WIDTH+30;
		}
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(new Color(200, 0, 0));
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
		
		if (x>=Main.WIDTH+70 || x<-70) {
			h.remove(this);
		}
		else if(y>Main.HEIGHT+70 || y<-70) {
			h.remove(this);
		}
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 30, 30);
	}
	
	public String toString() {
		return "CONST " + x + " " + y;
	}

}
