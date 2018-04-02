import java.awt.Font;
import java.awt.Graphics;

public class Stats {
	private static int health = 100;
	private static int damage = 10;

	// Damage the player
	public static void takeDamage() {
		health -= damage;
	}

	public static int getHealth() {
		return health;
	}

	// Render Health
	public static void render(Graphics g) {
		g.setFont(new Font("SansSerif", Font.BOLD, 24));
		g.drawString("Health: " + health, 130, 20);
		//g.drawString("Bullets: " + Tick.player.getBullets().size(), 100, 40);
	}

	public static void addHealth() {
		health += 10;
	}
}