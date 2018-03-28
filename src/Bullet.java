import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class Bullet extends Character {
	private double angle;
	
	private double SPEED = 10;
	private int WIDTH = 50;
	private int HEIGHT = 50;

	private static BufferedImage imageCurrent = Images.getImage("Bullet.png");

	Bullet(double x, double y, double angle) {
		super(x, y);
		this.angle = angle;
	}

	public void step() {
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
		AffineTransformOp op = new AffineTransformOp(AffineTransform.getRotateInstance(angle, WIDTH, HEIGHT),
				AffineTransformOp.TYPE_BILINEAR);

		g.drawImage(op.filter(imageCurrent, null), (int) x - WIDTH / 2, (int) y - HEIGHT / 2, null);
	}
}