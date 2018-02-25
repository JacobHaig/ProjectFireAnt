import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player {
	private double x;
	private double y;
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

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

}
