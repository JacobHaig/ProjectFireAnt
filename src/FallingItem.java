import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class FallingItem extends Character {

	final double GRAVITY = 5.0;
	final double DRAG = 1;
	public ItemType item;

	public static enum ItemType {
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
	
	public boolean isBandage() {
		return item.equals(ItemType.Health);
	}

	@Override
	public void render(Graphics g) {
		drawImage(g);
		drawHitbox(g);
	}

	public void drawImage(Graphics g) {
		g.drawImage(imageCurrent, (int) x - WIDTH / 2, (int) y - HEIGHT / 2, WIDTH, HEIGHT, null);
	}

	public void drawHitbox(Graphics g) {
		g.drawOval((int) x - WIDTH / 2, (int) y - HEIGHT / 2, WIDTH, HEIGHT);
		g.drawOval((int) x - 25, (int) y - 25, 50, 50);
		g.drawLine((int) getX(), (int) getY(), (int) (getX() + WIDTH), (int) getY());
	}

	public BufferedImage getImage() {
		return imageCurrent;
	}
	
	// MOVE THE STUFF
	public void step() {
		setY(getY() + GRAVITY);
		setX(getX() + vx);

		vy = (vy) * DRAG;
		vx = (vx) * DRAG;
	}
}