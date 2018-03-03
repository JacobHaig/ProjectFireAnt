import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Meteor extends Character {

	final double GRAVITY = 5.0;
	final double DRAG = 1;

	private BufferedImage imageMeteor = Images.getImage("Meteor.png");

	Meteor(double x, double y) {
		super(x, y);
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(imageMeteor, (int) x, (int) y, WIDTH, HEIGHT, null);

	}

	public void drawHitbox(Graphics g) {

		g.drawOval((int) centerX - WIDTH / 2, (int) centerY - HEIGHT / 2, WIDTH, HEIGHT);
		g.drawLine((int) getX(), (int) getY(), (int) (getX() + WIDTH), (int) getY());
	}

	// Check for collision of the meteor
	public boolean collision() {
		int distance = 50;
		int realDistance = (int) Math.pow(distance, 2);// This is faster then having to Math.hypot()

		int a = (int) Math.pow(x - Game.player.x, 2);
		int b = (int) Math.pow(y - Game.player.y, 2);

		return (a + b < realDistance) ? true : false;
	}

	// MOVE THE STUFF
	@Override
	public void move() {
		setY(getY() + GRAVITY);
		setX(getX() + vx);

		vy = (vy) * DRAG;
		vx = (vx) * DRAG;
		this.centerCoords();
	}

}
