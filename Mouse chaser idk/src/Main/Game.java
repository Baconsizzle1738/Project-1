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
	
	public Game() {
		super();
		
		diff = 0;
		
		setCursor(getToolkit().createCustomCursor(getToolkit().getImage(""), new Point(), "REE"));
		setLayout(null);
		setVisible(true);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(new Color(70,70,70));
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(new Color(200, 200, 200));
		g.drawRect((int)(MouseInfo.getPointerInfo().getLocation().getX()-getLocationOnScreen().getX()), (int)(MouseInfo.getPointerInfo().getLocation().getY()-getLocationOnScreen().getY()), 30, 30);
		
		
		repaint();
	}
}
