import java.util.ArrayList;
import java.util.List;

public class Tick extends Game {
	private static double frameRate = 1000 / 60;
	private static int chance = 6000;

	public static Game game;
	private static List<FallingItem> fallingObjects = new ArrayList<>();
	public static Player player;

	// Constructor
	public static void init(Game g) {
		game = g;
		player = new Player(100, 600);
	}

	public static List<FallingItem> getFallingObjects() {
		return fallingObjects;
	}

	public static void play() {
		if (Game.gameStart || Game.gamePaused) {
			Utilities.sleepThread(frameRate);
			Game.screen.repaint();
		} else if (!Game.gameOver)
			step();
	}

	// Pause Screen
	public static void pause() {
		Utilities.sleepThread(frameRate);
		Game.screen.repaint();
	}

	// Play game like normal
	public static void step() {
		Utilities.sleepThread(frameRate);

		// Randomness of the FallingItem
		chance -= (chance > 1000 ? 1 : 0);
		if (Utilities.random(0, (int) (chance / 100)) == 0)
			fallingObjects.add(new FallingItem(Utilities.random(0, WINDOW_WIDTH), -100)); // The Falling Item

		// If mouse is in the window
		if (MouseInput.isMouseInputEnabled())
			MouseInput.updateMousePos();

		// MOVEMENT
		player.step();
		for (Bullet b : player.getBullets())
			b.step();
		for (FallingItem m : fallingObjects)
			m.step();

		try {
			// Destroy falling objects and remove health if collision
			for (int m = 0; m < fallingObjects.size(); m++) {
				if (Utilities.collision(fallingObjects.get(m), player)) {
					if (!fallingObjects.get(m).isBandage()) // If the item is not a Bandage damage
						Stats.takeDamage();
					Inventory.push(fallingObjects.get(m)); // Push FallingItem to the stack
					fallingObjects.remove(m);
				}
				if (Stats.getHealth() <= 0)
					Player.playerDead = true;
			}

			// Destroy bullets and falling objects if collision
			for (int m = 0; m < fallingObjects.size(); m++)
				for (int o = 0; o < player.getBullets().size(); o++)
					if (Utilities.collision(fallingObjects.get(m), player.getBullets().get(o))) {
						fallingObjects.remove(m);
						player.getBullets().remove(o);
					}

			// Destroy Bullets if out of bounds
			for (int b = 0; b < player.getBullets().size(); b++)
				if (player.getBullets().get(b).checkPos())
					player.getBullets().remove(b);

			// Destroy fallingObjects if out of bounds
			for (int o = 0; o < fallingObjects.size(); o++)
				if (fallingObjects.get(o).getY() > Game.WINDOW_HEIGHT - 100)
					fallingObjects.remove(o);

		} catch (Exception e) {
		}

		Game.screen.repaint(); // Draw the screen!
	}
}