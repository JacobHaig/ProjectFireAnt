import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Screen extends JPanel {
	private static BufferedImage backgroundImage = Images.getImage("Game-Background.png");
	private static BufferedImage menuImage = Images.getImage("Game-Menu.png");
	private static BufferedImage pauseImage = Images.getImage("Game-Pause.png");

	Screen() { // Calling repaint() calls everything need to paint() aswell as paint() itself
		repaint();
	}

	// Clear the screen
	private void clearScreen(Graphics g) {
		g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), null);
		g.setColor(new Color(0, 0, 0));
	}

	public void drawMenu(Graphics g) { // Draw the main menu
		g.drawImage(menuImage, 0, 0, this.getWidth(), this.getHeight(), null);
	}

	public void drawPause(Graphics g) { // Draw the pause menu
		g.drawImage(pauseImage, 0, 0, this.getWidth(), this.getHeight(), null);
	}

	@Override
	public void paint(Graphics g) {

		if (Game.gameStart) // Draw the main menu
			drawMenu(g); 
		
		else if (Game.gamePaused) // Draw the pause menu
			drawPause(g);
		
		else {
			clearScreen(g);
			Tick.player.render(g); // Draw the Player

			for (Bullet b : Tick.player.getBullets()) // Draw the Bullets
				b.render(g);
			for (FallingItem o : Tick.getFallingObjects()) // Draw the FallingObjects
				o.render(g);

			Stats.render(g); // Draw any Statistics
			Inventory.render(g); // Draw the STACK <<<--------------------

			if (Player.playerDead) {
				Font font = new Font("SansSerif", Font.BOLD, 108);
				g.setFont(font);
				
				g.setColor(new Color(255, 0, 0));
				g.drawString("YOU FOOL", 290, 200);
				g.drawString("YOU DONE DIED", 150, 300);
			}
			Game.screen.repaint();
		}

	}
}
