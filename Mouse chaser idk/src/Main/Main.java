package Main;

import java.awt.Container;
import java.awt.Dimension;

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
	
	private EnemyHandler h;
	
	public Main(String title) {
		h = new EnemyHandler();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setPreferredSize(new Dimension(1300, 1300));
		this.setTitle(title);
		this.setVisible(true);
		
		
		
		
		Container c = this.getContentPane();
		c.add(new StartScreen());
		
		pack();
		
	}
	
	
	public static void main(String[] args) {
		new Main("Mouse fun");
	}
}
