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

public class Lose extends JPanel implements ActionListener{

	/**
	 * ????????????????
	 */
	JTextField name;
	
	private static final long serialVersionUID = 1L;
	
	ObjectHandler h;
	
	LocalDateTime time;
	
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
		lose.setBackground(new Color(200, 200, 200));
		lose.setBounds(Main.WIDTH/2-90, Main.HEIGHT/2-30, 200, 45);
		lose.setFont(new Font(Font.MONOSPACED, Font.BOLD, 35));
		add(lose);
		
		JButton again = new JButton("TRY AGAIN");
		again.setBackground(new Color(80, 80, 80));
		again.setBounds(Main.WIDTH/2-100, Main.HEIGHT/2+50, 200, 45);
		again.addActionListener(this);
		add(again);
		
		JLabel score = new JLabel("SCORE: "+ Main.score);
		score.setBackground(new Color(0, 255, 0));
		score.setBounds(Main.WIDTH/2-90, Main.HEIGHT/2-90, 300, 45);
		score.setFont(new Font(Font.MONOSPACED, Font.BOLD, 10));
		add(score);
		
		name = new JTextField();
		name.setBounds(Main.WIDTH/2, Main.HEIGHT/2-200, 300, 45);
		add(name);
		
	}

	
	/**
	 * Determines of the name in the text field is a legal one.
	 * Legal texts cannot contain spaces or any of the following: []{}/\+-=$%|&"'?.,()<>:;
	 * Legal texts also cannot be an empty string.
	 * @param s	Text to scrutinize
	 * @return	true if it is legal, false otherwise.
	 */
	private boolean isLegal(String s) {
		
		if (s.equals("")) {
			return false;
		}
		
		String[] illegal = {" ", "[", "]", "{", "}", "/", "\\", "+", "-", "=", "$", "%", "|", "&", "\"", "'", "?", ".", ",", "(", ")", "<", ">", ":", ";"};
		
		for (int i = 0; i<illegal.length; i++) {
			System.out.println(illegal[i]);
			if (s.contains(illegal[i])) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (((JButton) (e.getSource())).getText().equals("TRY AGAIN")) {
			if (isLegal(name.getText())) {
				//SAVE THE DAMN SCORE
				ScoreData finalScore = new ScoreData(Main.score, name.getText(), time);
				finalScore.write();
				
				Main.score = 0;
				getParent().add(new StartScreen(h));
				getParent().validate();
				getParent().remove(this);
			}
			
			
			
		}
	}
}
