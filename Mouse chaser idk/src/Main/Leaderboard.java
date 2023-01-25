package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class Leaderboard extends JPanel implements ActionListener{

	/**
	 * ???????????????????????????????????????
	 */
	private static final long serialVersionUID = 1L;
	
	private TreeSet<ScoreData> scores = new TreeSet<ScoreData>();

	ObjectHandler h;
	public Leaderboard(ObjectHandler h) {
		super();
		
		this.h = h;
		
		setLayout(null);
		setVisible(true);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(new Color(70, 70, 70));
		
		
		try {
			Scanner read = new Scanner(new File("data/scores.dat"));
			while(read.hasNextLine()) {
				scores.add(new ScoreData(read.nextLine()));
			}
			read.close();
			//System.out.println(scores);
		}
		catch(Exception e) {
			System.out.println("Error reading the scores file");
			e.printStackTrace();
		}
		
		//TODO: Iterate through the treeset and turn it into a matrix
		//Data in a matrix for a table
		String[][] data = new String[10][3];
		//names for table title
		String[] names = {"USERNAME", "SCORE", "TIME"};
		Iterator<ScoreData> iter = scores.iterator();
		
//		while (iter.hasNext()) {
//			ScoreData temp = iter.next();
//			data[i][0] = temp.getName();
//		}
		
		for (int i = 0; i<10; i++) {
			if (iter.hasNext()) {
				ScoreData temp = iter.next();
				data[i][0] = temp.getName();
				data[i][1] = temp.getScore() + "";
				data[i][2] = temp.getFormatTime();
			}
			
		}
		
		//System.out.println(data);
		for (int i = 0; i<data.length; i++) {
			for (int j = 0; j<data[i].length; j++) {
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
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
		
		JTable table = new JTable(data, names);
		table.setBounds(100, 100, 500, 300);
		table.setBackground(new Color(70, 70, 70));
		table.setForeground(new Color(200, 0, 0));
		table.setVisible(true);
		add(table);
		
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
