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
		g.setFont(new Font("SansSerif", Font.BOLD, 18));
		g.drawString("Health: " + health, 10, 20);
		g.drawString("Bullets: " + Tick.player.bullets.size(), 10, 40);
		g.drawString("ppos: x" + (int) Tick.player.getX() + " y" + (int) Tick.player.getY(), 10, 60);
		g.drawString("mpos: x" + MouseInput.getX() + " y" + MouseInput.getY(), 10, 80);
	}
}