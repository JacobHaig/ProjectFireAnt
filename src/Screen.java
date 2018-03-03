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

		g.setColor(new Color(0, 0, 0));

		// Draw the Player
		Game.player.render(g);
		Game.player.drawHitbox(g);

		for (FallingItem m : Game.meteors)
			m.render(g);

		// Hit box
		for (FallingItem m : Game.meteors)
			m.drawHitbox(g);

		if (Game.player.playerDEAD) {
			Font font = new Font("SansSerif", Font.BOLD, 108);
			g.setFont(font);

			g.drawString("YOU FOOL", 230, 200);
			g.drawString("YOU DONE DIED", 80, 300);
		}

		if (Game.player.playerDEAD) {
			Font font = new Font("SansSerif", Font.BOLD, 108);
			g.setFont(font);

			g.drawString("YOU FOOL", 230, 200);
			g.drawString("YOU DONE DIED", 80, 300);
		}
	}
}
