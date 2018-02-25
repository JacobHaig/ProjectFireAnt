import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Screen extends JPanel {
	Screen() {
		// Calling repaint() calls everything need to paint() aswell as paint() itself
		repaint();
	}

	// Clear the screen
	private void clearScreen(Graphics g) {
		g.setColor(new Color(255, 255, 255));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}

	@Override
	public void paint(Graphics g) {
		// Clear the screen
		clearScreen(g);

		// Draw the Player
		Game.player.render(g);

		// Rectangles
		g.setColor(new Color(0, 0, 255));
		g.fillRect(120, 10, 200 + Game.gameCounter, 100);
		g.drawRect(10, 10, 100, 100);

		// Text and Strings
		g.setColor(new Color((int) Game.gameCounter % 255, 200, 0));
		g.setFont(new Font("Comic Sans", Font.BOLD, 18));
		g.drawString("HELLO ME! The current time is: " + Game.gameCounter / 30, 10, 130);

		// Circles and Ovals
		g.setColor(new Color(255, 100, 0));
		g.drawOval(10, 150, 100, 100);
		g.fillOval(120, 150, 200 + Game.gameCounter, 100);

	}
}
