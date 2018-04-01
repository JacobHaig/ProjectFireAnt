import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class Bullet extends Character {
	private double angle;

	private double SPEED = 15;
	private int WIDTH = 50;
	private int HEIGHT = 50;
	private boolean isFI = false;

	private static BufferedImage imageCurrent = Images.getImage("Bullet.png");
	private BufferedImage imageFI;

	private FallingItem FI;

	Bullet(double x, double y, double angle) {
		super(x, y);
		this.angle = angle;
	}

	Bullet(double x, double y, double angle, FallingItem FI) {
		super(x, y);
		this.angle = angle;
		this.FI = FI;
		this.imageFI = FI.getImage();
		this.isFI = true;
	}

	public void step() {
		double vx = (double) (SPEED * (Math.cos(angle)));
		double vy = (double) (SPEED * (Math.sin(angle)));

		setY(getY() + vy);
		setX(getX() + vx);
	}

	@Override
	public void render(Graphics g) {

		AffineTransformOp op = new AffineTransformOp(AffineTransform.getRotateInstance(angle, WIDTH, HEIGHT),
				AffineTransformOp.TYPE_BILINEAR);

		g.drawImage(op.filter(isFI ? imageFI : imageCurrent, null), (int) x - WIDTH / 2, (int) y - HEIGHT / 2, null);
	}

	// Checks if bullet is Out of Bounds
	public boolean checkPos() {
		if (x < -this.WIDTH || x > Game.WINDOW_WIDTH + this.WIDTH)
			return true;
		if (y < -this.HEIGHT || y > Game.WINDOW_HEIGHT + this.HEIGHT)
			return true;
		return false;
	}
}