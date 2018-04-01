import java.awt.Graphics;
import java.util.ArrayList;

public class Inventory {

	public static ArrayList<FallingItem> stack = new ArrayList<FallingItem>();

	/*
	 * ALL THE STACK INFORMATION SHOULD GO HERE When we collect cetain items they
	 * get added to the inventory The inventory needs a few things: Add(), Remove(),
	 * first, last, max, ect
	 */

	public static void push(FallingItem FI) {
		stack.add(FI);
	}

	public static void pop() {
		stack.remove(0);
	}

	public static FallingItem peek(int index) {
		return stack.get(index);
	}

	public static boolean isEmpty() {
		return size() > 0 ? true : false;
	}

	public static int size() {
		return stack.size();
	}

	public static void render(Graphics g) {
		// DONT WORRY ABOUT THIS
	}

}
