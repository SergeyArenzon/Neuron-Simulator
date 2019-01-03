import java.util.Random;

public class Rand {

	public static int randInt(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}
	public static double randDouble(int min, int max) {
		Random rand = new Random();
		double randomNum = min + (max - min) * rand.nextDouble();;
		return randomNum;
	}

	public static boolean getRandomBoolean() {
		return Math.random() < 0.5;
	}

}
