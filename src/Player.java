import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player {
	private double x;
	private double y;
	private double vx;
	private double vy;
	private double momentumX = 0;
	private double momentumY = 0;

	private double SPEED = 5;
	private String imagefile = "stick-man.png";

	public double SCALE_FACTOR = (double) 1 / 8;

	Images images = new Images();
	private BufferedImage image = images.getImage(imagefile);

	Player(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void render(Graphics g) {
		int width = (int) (image.getWidth() * SCALE_FACTOR);
		int height = (int) (image.getWidth() * SCALE_FACTOR);

		g.drawImage(image, (int) x, (int) y, width, height, null);
	}

	public void move() {
		double DRAG = 0.95;

		setY(getY() + vy);
		setX(getX() + vx);

		vy = (vy) * DRAG;
		vx = (vx) * DRAG;

	}

	public void setVx(double vx) {
		this.vx = vx * SPEED;
	}

	public void setVy(double vy) {
		this.vy = vy * SPEED;
	}

	public double getVy() {
		return vy;
	}

	public double getVx() {
		return vx;
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

}
