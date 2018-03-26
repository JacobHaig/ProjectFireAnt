
public class Utilities {
	// Random int from lower to higher
	public static int random(int lower, int higher) {
		return ((int) (Math.random() * (higher - lower + 1)) + lower);
	}

	// Random int from 1 to higher
	public static int random(int higher) {
		return ((int) (Math.random() * (higher) + 1));
	}

	// A cleaner version of Thread.sleep()
	public static void sleepThread(double wait) {
		try {
			Thread.sleep((int) wait);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Works by using any derivative of a GameObject.
	// GameObjects have protected methods
	public static boolean collision(GameObject Obj1, GameObject Obj2) {
		int distance = 50;
		int realDistance = (int) distance * distance; // This is faster then having to Math.hypot()

		int a = (int) Math.pow(Obj1.getX() - Obj2.getX(), 2);
		int b = (int) Math.pow(Obj1.getY() - Obj2.getY(), 2);

		return (a + b < realDistance) ? true : false;
	}
}