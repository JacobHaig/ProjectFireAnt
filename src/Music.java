import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class Music extends Thread {

	Music() {
		String str = "RPG-Battle-Climax";
		String str2 = "allen_arrogh";

		AudioPlayer MGP = AudioPlayer.player;
		// ContinuousAudioDataStream loop = null;

		try {
			InputStream audio = new FileInputStream("res/" + str + ".wav");
			AudioStream BGM = new AudioStream(audio);
			AudioPlayer.player.start(BGM);

		} catch (FileNotFoundException e) {
			System.out.print(e.toString());
		} catch (IOException error) {
			System.out.print(error.toString());
		}
	}
}
