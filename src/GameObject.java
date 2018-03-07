public class GameObject {
	protected int WIDTH = 100;
	protected int HEIGHT = 100;

	protected double x;
	protected double y;

	protected double centerX;
	protected double centerY;

	GameObject(double x, double y) {
		this.x = x;
		this.y = y;
	}

	protected void centerCoords() {
		centerX = x + WIDTH / 2;
		centerY = y + HEIGHT / 2;
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
