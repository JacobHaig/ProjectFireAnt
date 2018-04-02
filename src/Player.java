import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Player extends Character {
	public static boolean playerDead = false;
	private double angle = -Math.PI / 2;

	private ArrayList<Bullet> bullets = new ArrayList<>();

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

	public List<Bullet> getBullets(){
		return bullets;
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
		vy = ((movingDown ? 1 : 0) - (movingUp ? 1 : 0)) * SPEED * DRAG; // Up and Down
		vx = ((movingRight ? 1 : 0) - (movingLeft ? 1 : 0)) * SPEED * DRAG; // Left and Right

		setY(getY() + vy);
		setX(getX() + vx);

		// Set angle at which you are pointing aiming direction
		setAngle();
	}

	// Shoot 
	public void shoot(MouseEvent e) {
		if (e.getButton() == 1)
			bullets.add(new Bullet(x, y, angle));
		else {
			bullets.add(new Bullet(x, y, angle, Inventory.peek(0)));
			Inventory.pop();
		}
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public void setAngle() {
		if (MouseInput.isMouseInputEnabled()) {
			double a = MouseInput.getX() - this.x;
			double o = MouseInput.getY() - this.y;
			this.angle = Math.atan2(o, a);
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
}
