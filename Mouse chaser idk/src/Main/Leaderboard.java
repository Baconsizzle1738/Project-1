package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Leaderboard extends JPanel implements ActionListener{

	/**
	 * ???????????????????????????????????????
	 */
	private static final long serialVersionUID = 1L;


	public Leaderboard() {
		super();
		
		
		setLayout(null);
		setVisible(true);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(new Color(70, 70, 70));
		
		
		JLabel leaderboard = new JLabel("LEADERBOARD");
		leaderboard.setForeground(new Color(200, 200, 200));
		leaderboard.setBounds(Main.WIDTH/2-100, Main.HEIGHT/2-30, 220, 45);
		leaderboard.setFont(new Font(Font.MONOSPACED, Font.BOLD, 32));
		add(leaderboard);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
