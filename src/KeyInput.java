import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

	// Global Key pressed
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_Y)
			Game.gameStart = false;

		// Arrow Keys
		if (key == KeyEvent.VK_RIGHT)
			Tick.player.setMovingRight(true);
		else if (key == KeyEvent.VK_LEFT)
			Tick.player.setMovingLeft(true);
		else if (key == KeyEvent.VK_UP)
			Tick.player.setMovingUp(true);
		else if (key == KeyEvent.VK_DOWN)
			Tick.player.setMovingDown(true);

		// WASD Keys
		if (key == KeyEvent.VK_D)
			Tick.player.setMovingRight(true);
		else if (key == KeyEvent.VK_A)
			Tick.player.setMovingLeft(true);
		else if (key == KeyEvent.VK_W)
			Tick.player.setMovingUp(true);
		else if (key == KeyEvent.VK_S)
			Tick.player.setMovingDown(true);

		if (key == KeyEvent.VK_ESCAPE)
			Game.gamePaused = !Game.gamePaused;
	}

	// Global Key released
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		// Arrow Keys
		if (key == KeyEvent.VK_RIGHT)
			Tick.player.setMovingRight(false);
		else if (key == KeyEvent.VK_LEFT)
			Tick.player.setMovingLeft(false);
		else if (key == KeyEvent.VK_UP)
			Tick.player.setMovingUp(false);
		else if (key == KeyEvent.VK_DOWN)
			Tick.player.setMovingDown(false);

		// WASD Keys
		if (key == KeyEvent.VK_D)
			Tick.player.setMovingRight(false);
		else if (key == KeyEvent.VK_A)
			Tick.player.setMovingLeft(false);
		else if (key == KeyEvent.VK_W)
			Tick.player.setMovingUp(false);
		else if (key == KeyEvent.VK_S)
			Tick.player.setMovingDown(false);
	}
}
