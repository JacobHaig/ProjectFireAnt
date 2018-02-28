import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	Game game;
	Player player;

	public KeyInput(Game game) {
		this.game = game;
		this.player = Game.player;
	}

	// Global Key pressed
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_RIGHT)
			player.setMovingRight(true);
		else if (key == KeyEvent.VK_LEFT)
			player.setMovingLeft(true);
		else if (key == KeyEvent.VK_UP)
			player.setMovingUp(true);
		else if (key == KeyEvent.VK_DOWN)
			player.setMovingDown(true);
	}

	// Global Key released
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_RIGHT)
			player.setMovingRight(false);
		else if (key == KeyEvent.VK_LEFT)
			player.setMovingLeft(false);
		else if (key == KeyEvent.VK_UP)
			player.setMovingUp(false);
		else if (key == KeyEvent.VK_DOWN)
			player.setMovingDown(false);
		else if (key == KeyEvent.VK_ESCAPE)
			System.out.print("ENDING THE PROGRAM");
	}
}
