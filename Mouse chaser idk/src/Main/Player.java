package Main;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Movable{
	
	
	
	public Player(int x, int y, ObjectHandler h) {
		super(x,y);
	}
	
	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void draw(Graphics g) {
		g.fillRect(x, y, 40, 40);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 40, 40);
	}

	@Override
	public void tick() {
		
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
