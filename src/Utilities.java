
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

}
