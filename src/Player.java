import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Player extends Character {
	public double SCALE_FACTOR = (double) 1 / 8;

	private BufferedImage imageRunning = Images.getImage("stick-man.png");
	private BufferedImage imageStanding = Images.getImage("stick-man-standing.jpg");

	Player(double x, double y) {
		super(x, y);
	}

	@Override
	public void render(Graphics g) {
		int width = (int) (imageRunning.getWidth() * SCALE_FACTOR);
		int height = (int) (imageRunning.getWidth() * SCALE_FACTOR);

		if (movingLeft && !(movingRight))
			g.drawImage(imageRunning, (int) x + width, (int) y, -width, height, null);
		else if (movingRight && !(movingLeft))
			g.drawImage(imageRunning, (int) x, (int) y, width, height, null);
		else
			g.drawImage(imageStanding, (int) x + width, (int) y, -width, height, null);
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
