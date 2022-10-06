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
	
	public ScoreData(int score, String name, LocalDateTime time) {
		this.score = score;
		this.name = name;
		this.time = time;
	}
	
	public ScoreData(String data) {
		//TODO: if taken in as String then parse string.
		String[] dat = data.split(" ");
		
		this.score = Integer.parseInt(dat[0]);
		this.name = dat[1];
		this.time = LocalDateTime.parse(dat[2]);
	}
	
	public void write() {
		
		try {
			FileWriter save = new FileWriter("data/scores.dat");
			save.write(this.toString() + "\n");
			save.close();
		}
		catch(Exception e) {
			System.out.println("An error occured while writing the score");
			e.printStackTrace();
		}
	}
	
	public int getScore() {
		return score;
	}
	
	public String getName() {
		return name;
	}
	
	public LocalDateTime getRawTime() {
		return time;
	}
	
	public String getFormatTime() {
		return time.format(format);
	}
	
	public String toString() {
		return score + " " + name + " " + this.getFormatTime();
	}

	@Override
	public int compareTo(ScoreData o) {
		if (this.getScore() >= o.getScore()) {
			return -1;
		}
		return 1;
	}
}
