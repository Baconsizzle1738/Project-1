package Main;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * IUT is in Google doc
 * @author Baconsizzle1738
 *
 */

public class Main extends JFrame{

	/**
	 * ????????????????????????????
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static final int HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()-30;
	
	private ObjectHandler h;
	
	public Main(String title) {
		h = new ObjectHandler();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setTitle(title);
		this.setVisible(true);
		
		
		
		
		Container c = this.getContentPane();
		c.add(new StartScreen(h));
		
		pack();
		
	}
	
	
	public static void main(String[] args) {
		new Main("Mouse fun");
	}
}
