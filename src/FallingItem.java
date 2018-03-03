import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class FallingItem extends Character {

	final double GRAVITY = 5.0;
	final double DRAG = 1;
	public ItemType item;

	public enum ItemType {
		Meteor, Health, Nuke, Rocket;
	};

	private static BufferedImage imageMeteor = Images.getImage("Meteor.png");
	private static BufferedImage imageBandage = Images.getImage("Bandage.png");
	private static BufferedImage imageNuke = Images.getImage("Nuke.png");
	private static BufferedImage imageRocket = Images.getImage("Rocket.png");

	private BufferedImage imageCurrent;

	FallingItem(double x, double y) {
		super(x, y);
		switch (Utilities.random(4)) {
		case 1:
			item = ItemType.Meteor;
			imageCurrent = imageMeteor;
			break;
		case 2:
			item = ItemType.Health;
			imageCurrent = imageBandage;
			break;
		case 3:
			item = ItemType.Nuke;
			imageCurrent = imageNuke;
			break;
		case 4:
			item = ItemType.Rocket;
			imageCurrent = imageRocket;
			break;

		}

		WIDTH = imageCurrent.getWidth();
		HEIGHT = imageCurrent.getHeight();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(imageCurrent, (int) x, (int) y, WIDTH, HEIGHT, null);
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

		// if(item.Health)

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
