package Main;

import java.awt.Graphics;
import java.awt.Rectangle;

public class LaserBeam extends Enemy{
	
	private String direction;
	
	private boolean canDamage;
	
	private int wid,hei;
	
	public LaserBeam(float x, float y, ObjectHandler h, String dir) {
		super(x, y, h);
		
		direction = dir;
		canDamage = false;
		
		if (direction.equals("UP") || direction.equals("DOWN")) {
			wid = 40;
			hei = Main.HEIGHT;
		}
	}

	@Override
	public void draw(Graphics g) {
		
	}

	@Override
	public void tick() {
		
	}

	@Override
	public Rectangle getBounds() {
		if (!canDamage) {
			return new Rectangle(9000, 9000, 0, 0);
		}
		return new Rectangle(x, y, wid, hei);
	}

}
