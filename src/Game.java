
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JFrame;

public class Game extends JFrame {
	public static int WINDOW_WIDTH = 1000;
	public static int WINDOW_HEIGHT = 800;

	public static Game game;
	public static Screen screen;
	public static Point cursor;

	public Game() {
		// Setting up the window
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setResizable(false);
		this.setTitle("This is the game name");
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(1, 1, 0, 0));

		// Key Listeners for key Input
		addKeyListener(new KeyInput(this));
		addMouseListener(new MouseInput(this));
		//addMouseListener(new MouseInput(this));

		// Create the Screen!
		screen = new Screen();
		//screen.getMousePosition();
		this.add(screen);
		this.setVisible(true);
	}

	// Main
	public static void main(String[] args) {
		// Start the Game!
		game = new Game();
		Tick.Init(game);
		Game.cursor = Game.screen.getMousePosition();

		while (true)
			Tick.Step();
		// cursor = game.getCursor();
	}
}