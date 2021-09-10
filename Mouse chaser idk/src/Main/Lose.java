package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Lose extends JFrame implements ActionListener{

	/**
	 * ????????????????
	 */
	private static final long serialVersionUID = 1L;
	
	ObjectHandler h;
	
	public Lose(ObjectHandler h) {
		super();
		
		setLayout(null);
		setVisible(true);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(new Color(20,20,20));
		
		this.h = h;
		this.h.clear();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	

}
