package Main;

import java.awt.Graphics;

public abstract class Enemy {
	
	protected float x, y;
	
	public Enemy(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract void Draw(Graphics g);
	
}
