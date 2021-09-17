package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FollowEnemy extends Enemy{
	
	private float speed, trueX, trueY;
	
	private int timer;
	
	private Player p;
	
	public FollowEnemy(float x, float y, float spd, ObjectHandler h, String dir) {
		super(x, y, h);
		
		speed = spd;
		
		//to prevent spawning in the middle of the screen.
		if (dir.equals("UP") || dir.equals("DOWN")) {
			this.y = -30;
		}
		else {
			this.x = -30;
		}
		
		trueX = this.x;
		trueY = this.y;
		
		//max speed is 19
		if (speed > 19) {
			speed = 19;
		}
		for (int i = 0; i<this.h.things.size(); i++) {
			if (this.h.things.get(i).getClass().equals(new Player(0, 0, null).getClass())) {
				p = (Player)this.h.things.get(i);
				break;
			}
		}
		
		
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(new Color(200, 0, 0));
		g.fillRect(x, y, 20, 20);
	}

	@Override
	public void tick() {
		//vector math yahooey
		//totally did not copy off my earlier project
		int distX = p.getX() - x;
		int distY = p.getY() - y;
		//this is scalar
		float trueDist = (float) Math.sqrt(Math.pow(distX, 2)+Math.pow(distY, 2));
		float scale = trueDist/speed;
		float trueVolX = distX/scale;
		float trueVolY = distY/scale;
		
		if (x != p.getX()) {
			trueX+= trueVolX;
			x = (int) trueX;
		}
		if (y != p.getY()) {
			trueY+= trueVolY;
			y = (int) trueY;
		}
		
		timer++;
		if (timer >= 300) {
			h.remove(this);
		}
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 20, 20);
	}
	
	public String toString() {
		return "FOLLOW " + x + " " + y;
	}

}
