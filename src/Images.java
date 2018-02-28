import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

//Import the Image from the res(RESOURCES) Folder
public class Images {
	static Images image;

	public static BufferedImage getImage(String arg) {
		image = new Images();
		return image.createImage(arg);
	}

	public BufferedImage createImage(String str) {

		try {
			return ImageIO.read(this.getClass().getResourceAsStream("/" + str));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}
