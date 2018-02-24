import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Screen extends JPanel {
	private BufferedImage image;

	Screen() {

		// Import the Image from the res(RESOURCES) Folder
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/MadMax.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		repaint();
	}

	@Override
	public void paint(Graphics g) {
		// Rectangles
		g.setColor(new Color(0, 0, 255));
		g.fillRect(120, 10, 200, 100);
		g.drawRect(10, 10, 100, 100);

		// Text and Strings
		g.setColor(new Color(0, 200, 0));
		g.setFont(new Font("Comic Sans", Font.BOLD, 18));
		g.drawString("HELLO ME", 10, 130);

		// Circles and Ovals
		g.setColor(new Color(255, 100, 0));
		g.drawOval(10, 150, 100, 100);
		g.fillOval(120, 150, 200, 100);

		// Images!
		g.drawImage(image, 10, 260, image.getWidth() / 4, image.getHeight() / 4, null);

	}
}
