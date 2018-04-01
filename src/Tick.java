import java.util.ArrayList;
import java.util.List;

public class Tick extends Game {
	private static int frameRate = 60;
	private static int chance = 6000;

	public static Game game;
	public static List<FallingItem> fallingObjects = new ArrayList<FallingItem>();
	public static Player player = new Player(100, 600);

	// Constructor
	public static void Init(Game g) {
		game = g;
	}

	public static void Play() {
		if (Game.gameStart || Game.gamePaused) {
			Utilities.sleepThread(1000 / frameRate);
			Game.screen.repaint();
		} else if (!Game.gameOver)
			Step();
	}

	// Pause Screen
	public static void Pause() {
		Utilities.sleepThread(1000 / frameRate);
		Game.screen.repaint();
	}

	// Play game like normal
	public static void Step() {
		Utilities.sleepThread(1000 / frameRate);

		// Randomness of the FallingItem
		chance -= (chance > 1000 ? 1 : 0);
		if (Utilities.random(0, (int) (chance / 100)) == 0)
			fallingObjects.add(new FallingItem(Utilities.random(0, WINDOW_WIDTH), -100)); // The Falling Item

		// If Mouse is in the window
		if (MouseInput.isMouseInputEnabled())
			MouseInput.updateMousePos();

		// MOVEMENT
		player.step();
		for (Bullet b : player.bullets)
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
					player.playerDEAD = true;
			}

			// Destroy bullets and falling objects if collision
			for (int m = 0; m < fallingObjects.size(); m++)
				for (int o = 0; o < player.bullets.size(); o++)
					if (Utilities.collision(fallingObjects.get(m), player.bullets.get(o))) {
						fallingObjects.remove(m);
						player.bullets.remove(o);
					}

			// Destroy Bullets if out of bounds
			for (int b = 0; b < player.bullets.size(); b++)
				if (player.bullets.get(b).checkPos())
					player.bullets.remove(b);

			// Destroy fallingObjects if out of bounds
			for (int o = 0; o < fallingObjects.size(); o++)
				if (fallingObjects.get(o).getY() > Game.WINDOW_HEIGHT - 100)
					fallingObjects.remove(o);

		} catch (Exception e) {
			System.out.println(e + "STOP IT");
		}

		// Draw the screen!
		Game.screen.repaint();
	}
}