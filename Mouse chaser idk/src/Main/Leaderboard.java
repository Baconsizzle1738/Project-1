package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Leaderboard extends JPanel implements ActionListener{

	/**
	 * ???????????????????????????????????????
	 */
	private static final long serialVersionUID = 1L;

	ObjectHandler h;
	public Leaderboard(ObjectHandler h) {
		super();
		
		this.h = h;
		
		setLayout(null);
		setVisible(true);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(new Color(70, 70, 70));
		
		//sort the scores
		TreeSet<ScoreData> scores = new TreeSet<ScoreData>();
		try {
			Scanner read = new Scanner(new File("data/scores.dat"));
			while(read.hasNextLine()) {
				scores.add(new ScoreData(read.nextLine()));
			}
			read.close();
			System.out.println(scores);
		}
		catch(Exception e) {
			System.out.println("Error reading the scores file");
			e.printStackTrace();
		}
		
		
		
		//GUI stuff
		JLabel leaderboard = new JLabel("LEADERBOARD");
		leaderboard.setForeground(new Color(200, 200, 200));
		leaderboard.setBounds(Main.WIDTH/2-100, Main.HEIGHT/2-350, 220, 45);
		leaderboard.setFont(new Font(Font.MONOSPACED, Font.BOLD, 32));
		add(leaderboard);
		
		JButton menu = new JButton("MAIN MENU");
		menu.setBackground(new Color(100, 100, 0));
		menu.addActionListener(this);
		menu.setBounds(Main.WIDTH/2-100, Main.HEIGHT/2+120, 200, 45);
		add(menu);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (((JButton)e.getSource()).getText().equals("MAIN MENU")) {
			getParent().add(new StartScreen(h));
			getParent().validate();
			getParent().remove(this);
		}
		
	}
	
}
