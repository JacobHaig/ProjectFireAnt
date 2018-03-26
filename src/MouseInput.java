import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {
	private static Game game;
	private static Player player;

	private static boolean isMouseInputEnabled = false;
	private static int x = Game.WIDTH / 2;
	private static int y = Game.HEIGHT / 2;

	public MouseInput(Game game) {
		this.game = game;
		this.player = Tick.player;
	}

	public static void updateMousePos() {
		try {
			Point c = Game.screen.getMousePosition();

			x = (int) c.getX();
			y = (int) c.getY();

		} catch (Exception e) {
		}
	}

	public static int getX() {
		return x;
	}

	public static int getY() {
		return y;
	}

	public static boolean isMouseInputEnabled() {
		return isMouseInputEnabled;
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		isMouseInputEnabled = true;
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		isMouseInputEnabled = false;

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		player.shoot();

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// Doesn't work with "click and drag's"
	}

}
