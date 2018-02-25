
public class Utilities {
	// A way to cleaner version of Thread.sleep()
	public static void sleepThread(double wait) {
		try {
			Thread.sleep((int) wait);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
