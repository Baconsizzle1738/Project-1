package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class Game extends JPanel{
	
	/**
	 * ??????????????????????
	 */
	private static final long serialVersionUID = 1L;
	
	private float diff;
	
	private long now = System.currentTimeMillis();
	
	private ObjectHandler h;
	
	private Player p;
	
	public Game(ObjectHandler h) {
		super();
		
		diff = 1;
		
		this.h = h;
		p = new Player(100, 100, this.h);
		this.h.add(p);
		this.h.add(new ConstEnemy(300, -40, 12, "DOWN", this.h));
		this.h.add(new FollowEnemy(0, 0, 15, h));
		
		setCursor(getToolkit().createCustomCursor(getToolkit().getImage(""), new Point(), "REE"));
		setLayout(null);
		setVisible(true);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(new Color(70,70,70));
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//spawning mechanism, spawns new enemies every second.
		if (System.currentTimeMillis()-now >= 1000) {
			
			
			
		}
		
		//tick timer to remain consistent across different computeres at 90 fps.
		if (System.currentTimeMillis()-now >= 1000/90) {
			
			int mx = (int)(MouseInfo.getPointerInfo().getLocation().getX()-getLocationOnScreen().getX()); 
			int my = (int)(MouseInfo.getPointerInfo().getLocation().getY()-getLocationOnScreen().getY());
			
			diff = diff + 0.0013f;
			p.setPos(mx, my);
			p.tick();
			h.update();
			System.out.println("tick");
			now = System.currentTimeMillis();
		}
		
		long nowa = System.currentTimeMillis();
		
		g.setColor(new Color(200, 200, 200));
		//g.drawRect((int)(, 30, 30);
		
		p.draw(g);
		h.draw(g);
		
		System.out.println(diff);
		
		
		
		repaint();
	}
	
	
}
