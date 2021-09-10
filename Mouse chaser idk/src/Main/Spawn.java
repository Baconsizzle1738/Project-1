package Main;

public class Spawn {
	
	private ObjectHandler h;
	
	
	
	public Spawn (ObjectHandler h) {
		this.h = h;
	}
	
	public void newSpawn(float diff) {
		
		for (int i = 0; i<diff; i++) {
			int rand = (int)(3*Math.random());
			String dir = getDir();
			int xRand = (int)(Main.WIDTH*Math.random()*0.9)+(int)(Main.WIDTH*0.05);
			int yRand = (int)(Main.HEIGHT*Math.random()*0.9)+(int)(Main.HEIGHT*0.05);
			
			if (rand == 0) {
				h.add(new ConstEnemy(xRand, yRand, diff*1.3f, dir, h));
			}
			else if (rand == 1) {
				h.add(new FollowEnemy(xRand, yRand, diff*1.3f, h));
			}
			else {
				h.add(new LaserBeam(xRand, yRand, h, dir));
			}
			
		}
	}
	
	private String getDir() {
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
