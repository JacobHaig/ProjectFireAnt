import java.awt.Color;
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
		Game.m.render(g);

	}
}
