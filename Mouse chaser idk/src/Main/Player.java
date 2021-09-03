package Main;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Movable{
	
	
	
	public Player(int x, int y) {
		super(x,y);
	}
	
	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void draw(Graphics g) {
		
	}

	@Override
	public Rectangle getBounds() {
		return null;
	}

	@Override
	public void tick() {
		
	}
}
