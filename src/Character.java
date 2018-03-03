import java.awt.Graphics;

public abstract class Character extends GameObject {
	protected boolean movingRight = false;
	protected boolean movingLeft = false;
	protected boolean movingUp = false;
	protected boolean movingDown = false;

	protected double vx;
	protected double vy;

	protected final double DRAG = 0.95;
	protected double SPEED = 5;

	Character(double x, double y) {
		super(x, y);
	}

	public abstract void move();

	public abstract void render(Graphics g);

}
