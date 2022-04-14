import java.util.LinkedList;
import java.util.concurrent.Semaphore;

import javax.print.attribute.standard.NumberOfInterveningJobs;

public class ServantThread implements Runnable {
	
	private LazyList<Integer> unordered = new LazyList<>();
	private LazyList<Integer> ordered = new LazyList<>();
	private Semaphore semaphore;
	private int numGifts;

	public ServantThread(LazyList<Integer> unordered , LazyList<Integer> ordered ,Semaphore sem, int numGifts) {
		this.ordered = ordered;
		this.unordered = unordered;
		semaphore = sem;
		this.numGifts = numGifts;
	}

	@Override
	public void run() {
		// try {
		// 	// semaphore.acquire();
		// } catch (InterruptedException e) {
		// 	e.printStackTrace();
		// }
		
		for(int i = 0 ; i < numGifts ; i++ ) {
			ordered.add(i);
			unordered.remove(i);
		}

		for(int i = 0 ; i < numGifts ; i++) {
			ordered.remove(i);
			System.out.println("ThankYou note for Gift " + i + " sent!");
		}

		// semaphore.release();

	}

}
