import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Screen extends JPanel {
	private static BufferedImage background = Images.getImage("Game-Background.png");

	Screen() {
		// Calling repaint() calls everything need to paint() aswell as paint() itself

		repaint();
	}

	// Clear the screen
	private void clearScreen(Graphics g) {
		g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), null);
	}

	@Override
	public void paint(Graphics g) {
		// Clear the screen
		clearScreen(g);

		g.setColor(new Color(0, 0, 0));

		// Draw the Player
		Tick.player.render(g);

		for (Bullet b : Tick.player.bullets)
			b.render(g);

		for (FallingItem o : Tick.fallingObjects)
			o.render(g);

		Stats.render(g);

		if (Tick.player.playerDEAD) {
			Font font = new Font("SansSerif", Font.BOLD, 108);
			g.setFont(font);

			g.drawString("YOU FOOL", 230, 200);
			g.drawString("YOU DONE DIED", 80, 300);
		}

	}
}
