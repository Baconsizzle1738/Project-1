package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.sound.sampled.*;

import java.net.URL;

public class StartScreen extends JPanel implements ActionListener{

	/**
	 * ???????????????????
	 */
	private static final long serialVersionUID = 1L;
	
	private ObjectHandler h;
	
	//sound stuff
	private URL buttonSoundURL;
	private AudioInputStream buttonais;
	private Clip clip;
	
	public StartScreen(ObjectHandler h) {
		super();
		
		try {
			buttonSoundURL = new URL(Main.BUTTON_CLICK);
			buttonais = AudioSystem.getAudioInputStream(buttonSoundURL);
			clip = AudioSystem.getClip();
			clip.open(buttonais);
		}
		catch(Exception e) {
			System.out.println("Error loading sound in start");
			e.printStackTrace();
		}
		
		
		setLayout(null);
		setVisible(true);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(new Color(70,70,70));
		
		this.h = h;
		
		//start button
		JButton start = new JButton("START");
		start.setBackground(new Color(100, 100, 0));
		start.addActionListener(this);
		start.setBounds(Main.WIDTH/2-100, Main.HEIGHT/2+50, 200, 45);
		add(start);
		
		//leaderboard button
		JButton leaderboard = new JButton("LEADERBOARD");
		leaderboard.setBackground(new Color(100, 100, 0));
		leaderboard.addActionListener(this);
		leaderboard.setBounds(Main.WIDTH/2-100, Main.HEIGHT/2+120, 200, 45);
		add(leaderboard);
		
		//exit button
		JButton quit = new JButton("QUIT");
		quit.setBackground(new Color(100, 100, 0));
		quit.addActionListener(this);
		quit.setBounds(Main.WIDTH/2-100, Main.HEIGHT/2+190, 200, 45);
		add(quit);
		
		
		//title text
		JLabel title = new JLabel("LE MOUSE GAME");
		title.setFont(new Font(Font.MONOSPACED, Font.BOLD, 60));
		title.setBounds(Main.WIDTH/2-250, Main.HEIGHT/2-70, 700, 45);
		title.setBackground(new Color(0, 125, 200));
		add(title);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (((JButton) (e.getSource())).getText().equals("START")) {
			//sound
			clip.setFramePosition(0);
			clip.start();
			
			getParent().add(new Game(h));
			getParent().validate();
			getParent().remove(this);
		}
		if (((JButton)(e.getSource())).getText().equals("LEADERBOARD")) {
			getParent().add(new Leaderboard(h));
			getParent().validate();
			getParent().remove(this);
		}
		if (((JButton)(e.getSource())).getText().equals("QUIT")) {
			System.exit(0);
		}
	}

}
