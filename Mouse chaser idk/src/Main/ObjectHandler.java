package Main;

import java.util.LinkedList;

public class ObjectHandler {
	
	private LinkedList<Enemy> enemies;
	
	public ObjectHandler() {
		
	}
	
	public void add(Enemy e) {
		enemies.add(e);
	}
	
	public void remove(Enemy e) {
		enemies.remove(e);
	}
	
	
}
