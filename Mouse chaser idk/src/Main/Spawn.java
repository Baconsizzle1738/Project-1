package Main;

public class Spawn {
	
	private ObjectHandler h;
	
	
	
	public Spawn (ObjectHandler h) {
		this.h = h;
	}
	
	public void newSpawn(float diff) {
		
		for (int i = 0; i<diff; i++) {
			int rand = (int)(3*Math.random());
			
		}
	}
	
	private String getOrigin() {
		int rand = (int)(4*Math.random());
		if (rand == 0) {
			return "UP";
		}
		else if (rand == 1) {
			return "DOWN";
		}
		else if (rand == 2) {
			return "LEFT";
		}
		else {
			return "RIGHT";
		}
	}
	
	
}
