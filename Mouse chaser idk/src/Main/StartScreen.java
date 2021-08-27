package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class StartScreen extends JPanel implements ActionListener{

	/**
	 * ???????????????????
	 */
	private static final long serialVersionUID = 1L;
	
	public StartScreen() {
		
		setLayout(null);
		setVisible(true);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(new Color(70,70,70));
		
		
		JButton start = new JButton("START");
		start.setBackground(new Color(100, 100, 0));
		start.addActionListener(this);
		start.setBounds(100, 100, 500, 50);
		add(start);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
