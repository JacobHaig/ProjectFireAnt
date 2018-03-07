import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Bullet extends Character {
	private double angle;
	private double SPEED = 10;

	private BufferedImage imageRunning = Images.getImage("stick-man.png");

	Bullet(double x, double y, double angle) {
		super(x, y);
		this.angle = angle;
	}

	@Override
	public void move() {
		centerCoords();
		double vx = (double) (SPEED * (Math.cos(angle)));
		double vy = (double) (SPEED * (Math.sin(angle)));

		setY(getY() + vy);
		setX(getX() + vx);
	}

	@Override
	public void render(Graphics g) {
		drawImage(g);
	}

	public void drawImage(Graphics g) {
		g.drawImage(imageRunning, (int) x, (int) y, WIDTH, HEIGHT, null);
	}
}
