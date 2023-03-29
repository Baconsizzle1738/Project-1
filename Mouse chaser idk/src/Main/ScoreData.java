package Main;

//import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.FileWriter;

public class ScoreData implements Comparable<ScoreData>{
	
	private int score;
	
	private String name;
	
	private LocalDateTime time;
	private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
	
	/**
	 * This object contains all of the data for each run of the game.
	 * @param score	Score of the run
	 * @param name	Name of the player
	 * @param time	Time when the score was made
	 */
	public ScoreData(int score, String name, LocalDateTime time) {
		this.score = score;
		this.name = name;
		this.time = time;
	}
	
	public ScoreData(String data) {
		
		String[] dat = data.split(" ");
		
		this.score = Integer.parseInt(dat[0]);
		this.name = dat[1];
		this.time = LocalDateTime.parse(dat[2]);
	}
	
	/**
	 * Writes the score to the scores.dat file
	 */
	public void write() {
		
		try {
			FileWriter save = new FileWriter("data/scores.dat", true);
			save.append(this.toString() + "\n");
			save.close();
		}
		catch(Exception e) {
			System.out.println("An error occured while writing the score");
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @return	The score of the player
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * 
	 * @return	The name of the player
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @return	Time when the score was made
	 */
	public LocalDateTime getRawTime() {
		return time;
	}
	
	public String getFormatTime() {
		return time.format(format);
	}
	
	public String toString() {
		return score + " " + name + " " + time;
	}

	@Override
	public int compareTo(ScoreData o) {
		//Data is sorted by score
		if (this.getScore() > o.getScore()) {
			return -1;
		}
		return 1;
	}
}
