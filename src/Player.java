import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player extends Character {
	public boolean playerDEAD = false;

	private BufferedImage imageRunning = Images.getImage("stick-man.png");
	private BufferedImage imageStanding = Images.getImage("stick-man-standing.png");

	Player(double x, double y) {
		super(x, y);
	}

	@Override
	public void render(Graphics g) {
		if (movingLeft && !(movingRight))
			g.drawImage(imageRunning, (int) x + WIDTH, (int) y, -WIDTH, HEIGHT, null);
		else if (movingRight && !(movingLeft))
			g.drawImage(imageRunning, (int) x, (int) y, WIDTH, HEIGHT, null);
		else
			g.drawImage(imageStanding, (int) x + WIDTH, (int) y, -WIDTH, HEIGHT, null);
	}

	public void drawHitbox(Graphics g) {
		g.setColor(new Color(255, 0, 0));
		g.drawOval((int) centerX - WIDTH / 2, (int) centerY - HEIGHT / 2, WIDTH, HEIGHT);
	}

	@Override
	public void move() {
		double up = (movingUp) ? 1 : 0;
		double down = (movingDown) ? 1 : 0;
		vy = (down - up) * SPEED;

		double left = (movingRight) ? 1 : 0;
		double right = (movingLeft) ? 1 : 0;
		vx = (left - right) * SPEED;

		setY(getY() + vy);
		setX(getX() + vx);

		vy = (vy) * DRAG;
		vx = (vx) * DRAG;

		centerCoords();
	}

	public void setMovingRight(boolean movingRight) {
		this.movingRight = movingRight;
	}

	public void setMovingLeft(boolean movingLeft) {
		this.movingLeft = movingLeft;
	}

	public void setMovingUp(boolean movingUp) {
		this.movingUp = movingUp;
	}

	public void setMovingDown(boolean movingDown) {
		this.movingDown = movingDown;
	}

}
