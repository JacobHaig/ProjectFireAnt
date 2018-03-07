import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends Character {
	public boolean playerDEAD = false;
	public double angle = -Math.PI / 2;

	public boolean aimingLeft = false;
	public boolean aimingRight = false;

	public ArrayList<Bullet> bullets = new ArrayList<Bullet>();

	private BufferedImage imageRunning = Images.getImage("stick-man.png");
	private BufferedImage imageStanding = Images.getImage("stick-man-standing.png");

	Player(double x, double y) {
		super(x, y);
	}

	@Override
	public void render(Graphics g) {
		drawImage(g);
		drawHitbox(g);
		drawAngle(g);
	}

	// Draw the set image
	public void drawImage(Graphics g) {
		if (movingLeft && !(movingRight))
			g.drawImage(imageRunning, (int) x + WIDTH, (int) y, -WIDTH, HEIGHT, null);
		else if (movingRight && !(movingLeft))
			g.drawImage(imageRunning, (int) x, (int) y, WIDTH, HEIGHT, null);
		else
			g.drawImage(imageStanding, (int) x + WIDTH, (int) y, -WIDTH, HEIGHT, null);
	}

	// Draw the circle hit boxcc
	public void drawHitbox(Graphics g) {
		g.setColor(new Color(255, 0, 0));
		g.drawOval((int) centerX - WIDTH / 2, (int) centerY - HEIGHT / 2, WIDTH, HEIGHT);
	}

	// Draw the aiming angle
	public void drawAngle(Graphics g) {
		// angle = Math.PI;
		int coordX = (int) (100 * Math.cos(angle) + this.centerX);
		int coordY = (int) (100 * Math.sin(angle) + this.centerY);

		g.drawLine((int) centerX, (int) centerY, coordX, coordY);
	}

	@Override
	// Move the player and set angle
	public void move() {
		double up = (movingUp) ? 1 : 0;
		double down = (movingDown) ? 1 : 0;
		vy = (down - up) * SPEED * DRAG;

		double left = (movingRight) ? 1 : 0;
		double right = (movingLeft) ? 1 : 0;
		vx = (left - right) * SPEED * DRAG;

		setY(getY() + vy);
		setX(getX() + vx);
		centerCoords();

		double aimleft = (aimingLeft) ? 1 : 0;
		double aimright = (aimingRight) ? 1 : 0;
		double changeAngle = (aimright - aimleft) * .05;
		setAngle(getAngle() + changeAngle);

	}

	public void shoot() {
		bullets.add(new Bullet(x, y, angle));
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public double getAngle() {
		return angle;
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

	public void setAimingLeft(boolean aimingLeft) {
		this.aimingLeft = aimingLeft;
	}

	public void setAimingRight(boolean aimingRight) {
		this.aimingRight = aimingRight;
	}

}
