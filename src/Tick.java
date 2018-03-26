import java.util.ArrayList;
import java.util.List;

public class Tick extends Game {
	private static int frameRate = 60;

	public static Game game;
	public static List<FallingItem> fallingObjects = new ArrayList<FallingItem>();
	public static Player player = new Player(100, 600);

	// Constructor
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
	public static void Step() {
		Utilities.sleepThread(1000 / frameRate);

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
					Stats.takeDamage();
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

		} catch (Exception e) {
			System.out.println(e);
		}

		// Draw the screen!
		Game.screen.repaint();
	}
}