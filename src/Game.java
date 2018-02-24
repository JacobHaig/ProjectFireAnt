import java.awt.GridLayout;

import javax.swing.JFrame;

public class Game extends JFrame {
	Screen screen;

	public Game() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 800);
		this.setResizable(false);
		this.setTitle("This is the game name");

		init();
	}
	
	// Setting up garbage
	public void init() {
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(1, 1, 0, 0));

		screen = new Screen();
		this.add(screen);

		this.setVisible(true);
	}

	// Main
	public static void main(String[] args) {
		new Game();
	}
}
