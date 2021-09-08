package Main;

import java.awt.Graphics;
import java.awt.Rectangle;

public class FollowEnemy extends Enemy{
	
	private float speed;
	
	private Player p;
	
	public FollowEnemy(float x, float y, float spd, ObjectHandler h) {
		super(x, y, h);
		
		speed = spd;
		for (int i = 0; i<this.h.things.size(); i++) {
			if (this.h.things.get(i).getClass().equals(new Player(0, 0, null).getClass())) {
				p = (Player)this.h.things.get(i);
				break;
			}
		}
		
		
	}

	@Override
	public void draw(Graphics g) {
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
		int trueVolX = (int) (distX/scale);
		int trueVolY = (int) (distY/scale);
		
		if (x != p.getX()) {
			x+= trueVolX;
			//x = (int) trueX;
		}
		if (y != p.getY()) {
			y+= trueVolY;
			//y = (int) trueY;
		}
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 20, 20);
	}

}
