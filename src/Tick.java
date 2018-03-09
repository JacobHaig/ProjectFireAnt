import java.util.ArrayList;
import java.util.List;

public class Tick extends Game {
	private static int frameRate = 60;

	public static Game game;
	public static List<FallingItem> fallingObjects = new ArrayList<FallingItem>();
	public static Player player = new Player(100, 600);

	// Constuctor
	public static void Init(Game g) {
		game = g;

		for (int i = 0; i < 100; i++)
			fallingObjects
					.add(new FallingItem(Utilities.random(0, WINDOW_WIDTH), Utilities.random(-15 * WINDOW_HEIGHT, 0)));
	}

	// Just wait
	public static void None() {
		Utilities.sleepThread(1000 / frameRate);
	}

	// Pause Screen
	public static void Pause() {
		Utilities.sleepThread(1000 / frameRate);

	}

	// Play game like normal
	public static void Tick() {
		Utilities.sleepThread(1000 / frameRate);

		// MOVEMENT
		player.move();

		for (Bullet b : player.bullets)
			b.move();

		for (FallingItem m : fallingObjects)
			m.move();

		try {

			// Destroy falling objects and remove health if collision
			for (int m = 0; m < fallingObjects.size(); m++) {
				if (fallingObjects.get(m).collision(player.x, player.y)) {
					Stats.takeDamage();
					fallingObjects.remove(m);
				}
				if (Stats.getHealth() <= 0)
					player.playerDEAD = true;
			}

			// Destroy bullets and falling objects if collision
			for (int m = 0; m < fallingObjects.size(); m++)
				for (int o = 0; o < player.bullets.size(); o++)
					if (fallingObjects.get(m).collision(player.bullets.get(o).x, player.bullets.get(o).y)) {
						fallingObjects.remove(m);
						player.bullets.remove(o);
					}

		} catch (Exception e) {
			System.out.println(e);
		}

		// Draw the screen!
		game.screen.repaint();
	}
}
