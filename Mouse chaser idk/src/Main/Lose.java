package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Lose extends JPanel implements ActionListener{

	/**
	 * ????????????????
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField name;
	
	ObjectHandler h;
	
	LocalDateTime time;
	
	//private JLabel empty;
	private JLabel badName;
	//private JLabel tooLong;
	
	public Lose(ObjectHandler h) {
		super();
		
		time = LocalDateTime.now();
		
		setLayout(null);
		setVisible(true);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(new Color(20,20,20));
		
		
		this.h = h;
		this.h.clear();
		
		JLabel lose = new JLabel("YOU LOSE");
		lose.setForeground(new Color(200, 200, 200));
		lose.setBounds(Main.WIDTH/2-90, Main.HEIGHT/2-130, 200, 45);
		lose.setFont(new Font(Font.MONOSPACED, Font.BOLD, 35));
		add(lose);
		
		JButton menu = new JButton("MAIN MENU");
		menu.setBackground(new Color(80, 80, 80));
		menu.setForeground(new Color(40, 40, 200));
		menu.setBounds(Main.WIDTH/2-100, Main.HEIGHT/2+50, 200, 45);
		menu.addActionListener(this);
		add(menu);
		
		JButton again = new JButton("PLAY AGAIN");
		again.setBackground(new Color(80, 80, 80));
		again.setForeground(new Color(40, 40, 200));
		again.setBounds(Main.WIDTH/2-100, Main.HEIGHT/2+120, 200, 45);
		again.addActionListener(this);
		add(again);
		
		JLabel score = new JLabel("<html><div style ='text-align: center;'> SCORE: "+ Main.score + "</div></html>", SwingConstants.CENTER);
		score.setForeground(new Color(0, 255, 0));
		score.setBounds(Main.WIDTH/2-125, Main.HEIGHT/2-90, 250, 45);
		score.setFont(new Font(Font.MONOSPACED, Font.BOLD, 10));
		add(score);
		
		name = new JTextField();
		name.setBounds(Main.WIDTH/2-150, Main.HEIGHT/2-50, 300, 20);
		add(name);
		
		badName = new JLabel("<html><div style ='text-align: center;'> Name must be between 1 and 32 characters long <br></br> Inputting no name will not save the score <br></br> Name cannot contain []{}/\\+-=$%|&\"'?.,()<>:; or spaces </div></html>", SwingConstants.CENTER);
		badName.setForeground(new Color(200, 0, 0));
		badName.setBounds(Main.WIDTH/2-175, Main.HEIGHT/2-40, 350, 100);
		badName.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 10));
		add(badName);
	}

	
	/**
	 * Determines of the name in the text field is a legal one.
	 * Legal texts cannot contain spaces or any of the following: []{}/\+-=$%|&"'?.,()<>:;
	 * Legal texts also cannot be an empty string.
	 * Legal texts must be less than 32 characters long.
	 * @param s	Text to scrutinize
	 * @return	true if it is legal, false otherwise.
	 */
	private boolean isLegal(String s) {
		
		//if (s.equals("")) {
			//return false;
		//}
		
		if (s.length() > 32) {
			return false;
		}
		
		String[] illegal = {" ", "[", "]", "{", "}", "/", "\\", "+", "-", "=", "$", "%", "|", "&", "\"", "'", "?", ".", ",", "(", ")", "<", ">", ":", ";"};
		
		for (int i = 0; i<illegal.length; i++) {
			//System.out.println(illegal[i]);
			if (s.contains(illegal[i])) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		if (((JButton) (e.getSource())).getText().equals("MAIN MENU") || ((JButton) (e.getSource())).getText().equals("PLAY AGAIN")) {
//			if (isLegal(name.getText())) {
//				//SAVE THE DAMN SCORE if there is a name
//				if (!name.getText().equals("")) {
//					ScoreData finalScore = new ScoreData(Main.score, name.getText(), time);
//					finalScore.write();
//				}
//				//go to start screen
//				Main.score = 0;
//				getParent().add(new StartScreen(h));
//				getParent().validate();
//				getParent().remove(this);
//			}
//			else {
//				System.out.println("Ur name sucks try again.");
//			}
//		}
		
		if (name.getText().equals("") || isLegal(name.getText())) {
			//save score if name is good
			if (isLegal(name.getText())) {
				ScoreData finalScore = new ScoreData(Main.score, name.getText(), time);
				finalScore.write();
			}
			//reset score
			Main.score = 0;
			//leave screen when name is saved
			if (((JButton) (e.getSource())).getText().equals("MAIN MENU")) {
				getParent().add(new StartScreen(h));
				getParent().validate();
				getParent().remove(this);
			}
			if (((JButton) (e.getSource())).getText().equals("PLAY AGAIN")) {
				getParent().add(new Game(h));
				getParent().validate();
				getParent().remove(this);
			}
		}
		else {
			System.out.println("Ur name succ try again");
		}
	}
}
