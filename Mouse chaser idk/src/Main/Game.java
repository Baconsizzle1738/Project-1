package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import javax.swing.JPanel;

public class Game extends JPanel{
	
	/**
	 * ??????????????????????
	 */
	private static final long serialVersionUID = 1L;
	
	private float diff;
	
	private long now = System.currentTimeMillis();
	private long now2 = now;
	
	private ObjectHandler h;
	
	private Player p;
	
	private Spawn spawn;
	
	public Game(ObjectHandler h) {
		super();
		
		diff = 1;
		this.h = h;
		spawn = new Spawn(this.h);
		p = new Player(100, 100, this.h);
		this.h.add(p);
		//this.h.add(new ConstEnemy(300, -40, 12, "DOWN", this.h));
		//this.h.add(new FollowEnemy(0, 0, 15, h));
		
		setCursor(getToolkit().createCustomCursor(getToolkit().getImage(""), new Point(), "REE"));
		setLayout(null);
		setVisible(true);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(new Color(70,70,70));
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//spawning mechanism, spawns new enemies every second, time between spawns decreases as diff gets higher
		if (System.currentTimeMillis()-now2 >= 1000/(diff*1.3)) {
			
			spawn.newSpawn(diff);
			//System.out.println(1000/(diff*3));
			
			now2 = System.currentTimeMillis();
		}
		
		//tick timer to remain consistent across different computeres at 60 fps.
		if (System.currentTimeMillis()-now >= 1000/60) {
			
			int mx = (int)(MouseInfo.getPointerInfo().getLocation().getX()-getLocationOnScreen().getX()); 
			int my = (int)(MouseInfo.getPointerInfo().getLocation().getY()-getLocationOnScreen().getY());
			
			//diff increases linearly for now
			diff = diff + 0.00026f;
			p.setPos(mx, my);
			p.tick();
			
			//DRAWSTUFF
			
			//DRAWSTUFF
			
			h.update();
			
			//if you hit one enemy you lose
			for (int i = 0; i<h.things.size(); i++) {
				if (!h.things.get(i).getClass().equals(p.getClass())) {
					if (p.getBounds().intersects(h.things.get(i).getBounds())) {
						getParent().add(new Lose(h));
						getParent().validate();
						getParent().remove(this);
					}
				}
			}
			
			//System.out.println(diff);
			now = System.currentTimeMillis();
		}
		
		//DRAW STUFF
		g.setColor(new Color(200, 200, 200));
		//g.drawRect((int)(, 30, 30);
		
		p.draw(g);
		h.draw(g);
		g.setColor(new Color(0, 200, 0));
		Main.score = (int)(diff*100)-100;
		g.drawString("SCORE: " + Main.score, 10, 10);
		
		//System.out.println(diff);
		//DRAWSTUFF
		
		repaint();
	}
	
	
}
