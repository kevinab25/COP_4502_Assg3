import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class ServantThread implements Runnable {
	
	private LinkedList<Gift> unordered = new LinkedList<Gift>();
	private LinkedList<Gift> ordered = new LinkedList<Gift>();
	private Semaphore semaphore;
	private int part;

	public ServantThread(LinkedList<Gift> unordered , LinkedList<Gift> ordered , Semaphore sem , int part) {
		this.ordered = ordered;
		this.unordered = unordered;
		semaphore = sem;
		this.part = part;
	}

	@Override
	public void run() {
		try {
			semaphore.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for(int i = 0 ; i < part ; i++ ) {
			ordered.add(unordered.pop());
		}

		for(int i = 0 ; i < part ; i++) {
			System.out.println("ThankYou note for Gift " + ordered.pop().getTag() + " sent!");
		}

		semaphore.release();

	}

}
