package Main;

import java.awt.Graphics;
import java.util.LinkedList;

public class ObjectHandler {
	
	public LinkedList<Movable> things;
	
	public ObjectHandler() {
		things = new LinkedList<Movable>();
	}
	
	public void add(Movable e) {
		things.add(e);
	}
	
	public void remove(Movable e) {
		things.remove(e);
	}
	
	public void update() {
		for (int i = 0; i<things.size(); i++) {
			things.get(i).tick();
		}
	}
	
	public void draw(Graphics g) {
		for (int i = 0; i<things.size(); i++) {
			things.get(i).draw(g);
		}
	}
}
