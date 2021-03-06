import java.util.LinkedList;
import java.util.Random;

public class SensorThread implements Runnable {

	private LazyList<Integer> sharedData = new LazyList<Integer>();
	private int timeInterval = 60;

	public SensorThread(LazyList<Integer> sharedData) {
		this.sharedData = sharedData;
	}

	public int getRandomTemperature(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min) + min;
	}

	@Override
	public void run() {
		
		for(int minute = 0 ; minute < timeInterval ; minute++) {
			synchronized(sharedData) {
				sharedData.add(getRandomTemperature(-100, 70));
			}
		}
	}

}
