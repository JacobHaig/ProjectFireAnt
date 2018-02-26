import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Player {
	private double x;
	private double y;
	private double vx;
	private double vy;

	private boolean movingRight = false;
	private boolean movingLeft = false;
	private boolean movingUp = false;
	private boolean movingDown = false;

	final double DRAG = 0.95;
	private double SPEED = 5;
	private String imagefile = "stick-man.png";

	public double SCALE_FACTOR = (double) 1 / 8;

	Images images = new Images();
	private BufferedImage image = images.getImage(imagefile);
	// private Graphics2D fliped = image.createGraphics().;

	Player(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void render(Graphics g) {
		int width = (int) (image.getWidth() * SCALE_FACTOR);
		int height = (int) (image.getWidth() * SCALE_FACTOR);
		int width2 = (int) (image.getWidth() * SCALE_FACTOR);
		int height2 = (int) (image.getWidth() * SCALE_FACTOR);

		g.drawImage(image, (int) x, (int) y, width, height, null);
		g.drawImage(image, (int) x, (int) y, width, height, (int) x, (int) y, (int) x + width, (int) y + height , null);
		//g.drawImage(image, (int) x, (int) y, width, height, 0, 0, 100, 100 , null);

	}

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

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
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
