package Main;

import java.util.LinkedList;

public class ObjectHandler {
	
	private LinkedList<Movable> enemies;
	
	public ObjectHandler() {
		
	}
	
	public void add(Movable e) {
		enemies.add(e);
	}
	
	public void remove(Movable e) {
		enemies.remove(e);
	}
	
	
}
