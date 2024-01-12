package Main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class GameAudio {
	// https://sfxr.me/ <---Used this
	//private static final String BUTTON_CLICK = "file:audio/button_click.wav";
	
	public static void playButtonSound() {
		try {
			final URL buttonSoundURL = new URL("file:audio/button_click.wav");
			final AudioInputStream buttonais = AudioSystem.getAudioInputStream(buttonSoundURL);
			final Clip buttonClip = AudioSystem.getClip();
			buttonClip.open(buttonais);
			buttonClip.setFramePosition(0);
			buttonClip.start();
		}
		catch(Exception e) {
			System.out.println("Button sound load error");
			e.printStackTrace();
		}
	}
}
