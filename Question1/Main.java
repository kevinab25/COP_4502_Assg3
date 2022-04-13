import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class Main {
	
	public static void printList(LinkedList<Gift> list) {		
		if(list.isEmpty()) {
			System.out.println("List Empty");
			return;
		}
		
		for(Gift i : list )
			System.out.println("Gift :" +  i.getTag());
	}

	public static void main(String[] args) {
		int numGifts = 500000;
		int numThreads = 4;
		int part = numGifts/numThreads;
		
		LinkedList<Gift> unordered = new LinkedList<Gift>();
		LinkedList<Gift> ordered = new LinkedList<Gift>();
		
		// Adding gifts in unOrdered list
		for(int i = 0 ; i < numGifts ; i++) {
			Gift gift = new Gift();
			unordered.add(gift);
		}
		
		Semaphore sem = new Semaphore(1);
		Thread servantThreads[] = new Thread[numThreads];
		ServantThread servants[] = new ServantThread[numThreads];
		for(int i = 0 ; i < numThreads  ; i++ ) {
			servants[i] = new ServantThread(unordered , ordered , sem , part);
			servantThreads[i] = new Thread(servants[i]);
			servantThreads[i].start();
		}
		
		for(int i = 0 ; i < numThreads  ; i++ ) {
			try {
				servantThreads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		System.out.println("Ordered List : ");
		printList(ordered);
		System.out.println("unOrdered List : ");
		printList(unordered);
		
	}

}
