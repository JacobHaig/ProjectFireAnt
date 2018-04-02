import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Inventory {

	public static ArrayList<FallingItem> stack = new ArrayList<FallingItem>();

	/*
	 * ALL THE STACK INFORMATION SHOULD GO HERE When we collect certain items they
	 * get added to the inventory The inventory needs a few things: Add(), Remove(),
	 * first, last, max, ect
	 */

	// Add it to the back of the list
	public static void push(FallingItem FI) {
		stack.add(FI);
	}

	// Remove it from the front of the list
	public static void pop() {
		if (stack.remove(0).isBandage())
			Stats.addHealth();
	}

	// get the object without removing it
	public static FallingItem peek(int index) {
		return stack.get(index);
	}

	// IS IT EMPTY?!?!?
	public static boolean isEmpty() {
		return size() > 0 ? true : false;
	}

	// Return the size of the LIST
	public static int size() {
		return stack.size();
	}

	// DISPLAY THE LIST
	public static void render(Graphics g) {
		for (int i = 0; i < Math.min(5, size()); i++) {
			FallingItem FI = stack.get(i);

			g.setColor(new Color(150, 20, 25, 100));
			g.fillOval(10, i * 100, 100, 90 + 10);
			g.drawImage(FI.getImage(), 60 - FI.WIDTH / 2, i * 100, FI.WIDTH, 90, null);
		}
	}
}