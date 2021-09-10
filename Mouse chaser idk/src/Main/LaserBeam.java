package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class LaserBeam extends Enemy{
	
	private String direction;
	
	private boolean canDamage;
	
	private int wid, hei, time;
	
	public LaserBeam(float x, float y, ObjectHandler h, String dir) {
		super(x, y, h);
		
		direction = dir;
		canDamage = false;
		time = 0;
		
		if (direction.equals("UP") || direction.equals("DOWN")) {
			this.y = -3;
			wid = 40;
			hei = Main.HEIGHT;
		}
		
		else if (direction.equals("LEFT") || direction.equals("RIGHT")) {
			this.x = -3;
			wid = Main.WIDTH;
			hei = 40;
		}
	}

	@Override
	public void draw(Graphics g) {
		if (!canDamage) {
			g.setColor(new Color(0.8f, 0, 0, 0.5f));
		}
		else {
			g.setColor(new Color(200, 0, 0));
		}
		g.fillRect(x, y, wid, hei);
	}

	@Override
	public void tick() {
		time++;
		if (time == 60) {
			canDamage = true;
		}
		
		if (time >= 120) {
			h.remove(this);
		}
	}

	@Override
	public Rectangle getBounds() {
		if (!canDamage) {
			return new Rectangle(9000, 9000, 0, 0);
		}
		return new Rectangle(x, y, wid, hei);
	}

}
