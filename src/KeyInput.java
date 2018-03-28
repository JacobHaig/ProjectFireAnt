import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	Game game;
	Player player = Tick.player;

	// Global Key pressed
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		// Arrow Keys
		if (key == KeyEvent.VK_RIGHT)
			player.setMovingRight(true);
		else if (key == KeyEvent.VK_LEFT)
			player.setMovingLeft(true);
		else if (key == KeyEvent.VK_UP)
			player.setMovingUp(true);
		else if (key == KeyEvent.VK_DOWN)
			player.setMovingDown(true);

		// WASD Keys
		if (key == KeyEvent.VK_D)
			player.setMovingRight(true);
		else if (key == KeyEvent.VK_A)
			player.setMovingLeft(true);
		else if (key == KeyEvent.VK_W)
			player.setMovingUp(true);
		else if (key == KeyEvent.VK_S)
			player.setMovingDown(true);
	}

	// Global Key released
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		// Arrow Keys
		if (key == KeyEvent.VK_RIGHT)
			player.setMovingRight(false);
		else if (key == KeyEvent.VK_LEFT)
			player.setMovingLeft(false);
		else if (key == KeyEvent.VK_UP)
			player.setMovingUp(false);
		else if (key == KeyEvent.VK_DOWN)
			player.setMovingDown(false);

		// WASD Keys
		if (key == KeyEvent.VK_D)
			player.setMovingRight(false);
		else if (key == KeyEvent.VK_A)
			player.setMovingLeft(false);
		else if (key == KeyEvent.VK_W)
			player.setMovingUp(false);
		else if (key == KeyEvent.VK_S)
			player.setMovingDown(false);

		if (key == KeyEvent.VK_ESCAPE)
			Game.gameOver = true;

	}

}
