package Main;

import java.util.LinkedList;

public class EnemyHandler {
	
	private LinkedList<Enemy> enemies;
	
	public EnemyHandler() {
		
	}
	
	public void add(Enemy e) {
		enemies.add(e);
	}
	
	public void remove(Enemy e) {
		enemies.remove(e);
	}
	
	
}
