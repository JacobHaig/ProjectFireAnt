import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {
	// Import the Image from the res(RESOURCES) Folder

	public BufferedImage getImage(String str) {

		try {
			return ImageIO.read(this.getClass().getResourceAsStream("/" + str));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}
