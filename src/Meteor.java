import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Meteor extends Character {

	public double SCALE_FACTOR = (double) 1 / 2;

	final double GRAVITY = 5.0;
	final double DRAG = 1;

	private BufferedImage imageMeteor = Images.getImage("Meteor.png");

	Meteor(double x, double y) {
		super(x, y);
	}

	@Override
	public void render(Graphics g) {
		int width = (int) (imageMeteor.getWidth() * SCALE_FACTOR);
		int height = (int) (imageMeteor.getWidth() * SCALE_FACTOR);

		g.drawImage(imageMeteor, (int) x, (int) y, width, height, null);

	}

	@Override
	public void move() {

		setY(getY() + GRAVITY);
		setX(getX() + vx);

		vy = (vy) * DRAG;
		vx = (vx) * DRAG;
	}

}
