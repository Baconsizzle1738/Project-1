package Main;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Enemy extends Movable{

	protected int dmg;
	
	
	public Enemy(float x, float y, int dmg) {
		super(x, y);
		
		this.dmg = dmg;
	}
	
	
	
}
