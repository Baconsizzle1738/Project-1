package Main;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Movable {
	protected int x;
	protected int y;
	
	public Movable (int x, int y) {
		this.x = x;
		this.y = y;
		
	}
	
	public Movable (float x, float y) {
		this.x = (int)x;
		this.y = (int)y;
		
	}
	
	public abstract void draw(Graphics g);
	
	public abstract void tick();
	
	public abstract Rectangle getBounds();
	
}
