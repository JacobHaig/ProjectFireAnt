import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Game extends JFrame {
	private static int WINDOW_WIDTH = 1000;
	private static int WINDOW_HEIGHT = 800;

	public Screen screen;
	public static List<Meteor> meteors = new ArrayList<Meteor>();
	public static Player player = new Player(100, 600);

	public static int gameCounter = 0;
	private static int frameRate = 50;

	public Game() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
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

		for (int i = 0; i < 100; i++)
			meteors.add(new Meteor(Utilities.random(0, WINDOW_WIDTH), Utilities.random(-10 * WINDOW_HEIGHT, 0)));

		// Create the Screen!
		screen = new Screen();
		this.add(screen);
		this.setVisible(true);
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

			player.move();

			for (Meteor m : meteors)
				m.move();
			for (Meteor m : meteors)
				if (m.collision())
					player.playerDEAD = true;

			// Draw the screen!
			game.screen.repaint();
		}
	}

}