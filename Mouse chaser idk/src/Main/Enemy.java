package Main;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Enemy extends Movable{

	protected ObjectHandler h;
	
	public Enemy(float x, float y, ObjectHandler h) {
		super(x, y);
		this.h = h;
	}
	
	
	
}
