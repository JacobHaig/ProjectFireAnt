import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Game extends JFrame {
	public Screen screen;
	public static Player player = new Player(100, 600);;

	public static int gameCounter = 0;
	private static int frameRate = 30;

	public Game() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 800);
		this.setResizable(false);
		this.setTitle("This is the game name");
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(1, 1, 0, 0));

		init();
	}

	// Setting up importain
	public void init() {
		// Key Listeners
		addKeyListener(new KeyInput(this));
		
		
		
		// Create the Screen!
		screen = new Screen();
		this.add(screen);
		this.setVisible(true);
	}

	// Global Key pressed
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		final int SPEED = 10;

		if (key == KeyEvent.VK_RIGHT)
			player.setX(player.getX() + SPEED);
		else if (key == KeyEvent.VK_LEFT)
			player.setX(player.getX() - SPEED);
		else if (key == KeyEvent.VK_UP)
			player.setY(player.getY() - SPEED);
		else if (key == KeyEvent.VK_DOWN)
			player.setY(player.getY() + SPEED);

	}

	public void keyReleased(KeyEvent e) {
	}

	// Main
	public static void main(String[] args) {
		// Start the Game!
		Game game = new Game();

		// Main loop
		while (true) {
			// Sleep thread 30 fps = 1000 / 30
			Utilities.sleepThread(1000 / frameRate);

			// Increment the game counter
			gameCounter++;

			// Draw the screen!
			game.screen.repaint();
		}
	}

}