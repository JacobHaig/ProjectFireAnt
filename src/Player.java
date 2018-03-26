import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends Character {
	public boolean playerDEAD = false;
	public double angle = -Math.PI / 2;
	public float AIMSPEED = 0.05f;

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
			g.drawImage(imageRunning, (int) x + WIDTH / 2, (int) y - HEIGHT / 2, -WIDTH, HEIGHT, null);
		else if (movingRight && !(movingLeft))
			g.drawImage(imageRunning, (int) x - WIDTH / 2, (int) y - HEIGHT / 2, WIDTH, HEIGHT, null);
		else
			g.drawImage(imageStanding, (int) x - WIDTH / 2, (int) y - HEIGHT / 2, WIDTH, HEIGHT, null);
	}

	// Draw the circle hit box
	public void drawHitbox(Graphics g) {
		g.setColor(new Color(255, 0, 0));
		g.drawOval((int) x - WIDTH / 2, (int) y - HEIGHT / 2, WIDTH, HEIGHT);
	}

	// Draw the aiming angle
	public void drawAngle(Graphics g) {
		int coordX = (int) (100 * Math.cos(angle) + x);
		int coordY = (int) (100 * Math.sin(angle) + y);

		g.drawLine((int) x, (int) y, coordX, coordY);
	}

	// Move the player and set angle
	public void step() {
		// Move player
		vy = (((movingDown) ? 1 : 0) - ((movingUp) ? 1 : 0)) * SPEED * DRAG; // Up and Down
		vx = (((movingRight) ? 1 : 0) - ((movingLeft) ? 1 : 0)) * SPEED * DRAG; // Left and Right

		setY(getY() + vy);
		setX(getX() + vx);

		// Move aiming direction
		setAngle();
	}

	public void shoot() {
		bullets.add(new Bullet(x, y, angle));
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public void setAngle() {
		if (MouseInput.isMouseInputEnabled()) {
			double angle = Math.atan((MouseInput.getY() - this.y) / (MouseInput.getX() - this.x));
			this.angle = angle;
		}
	}

	public void addAngle(double angle) {
		this.angle = this.angle + angle;
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
