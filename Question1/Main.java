
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Main {
	
	public static void printList(LazyList<Integer> list) {	
		if(list.getHead().key == Integer.MIN_VALUE && list.getTail().key == Integer.MAX_VALUE) {
			System.out.println("List is empty");
		} else{
			System.out.println("Oh noooooo");
		}
	}

	public static void main(String[] args) {
		int numGifts = 50000;
		int numThreads = 4;
		int part = numGifts/numThreads;
		
		LazyList<Integer> unordered = new LazyList<Integer>();
		LazyList<Integer> ordered = new LazyList<Integer>();
		LinkedList<Integer> list = new LinkedList<>();
		
		// Adding gifts in unOrdered list
		for(int i = 0 ; i < numGifts ; i++) {
			list.add(i);
		}
		Collections.shuffle(list);
		for(Integer num: list)
			unordered.add(num);
		
		Semaphore sem = new Semaphore(1);
		Thread servantThreads[] = new Thread[numThreads];
		ServantThread servants[] = new ServantThread[numThreads];
		for(int i = 0 ; i < numThreads  ; i++ ) {
			servants[i] = new ServantThread(unordered, ordered, sem, numGifts);
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
		
		System.out.print("Ordered List : ");
		printList(ordered);
		System.out.print("unOrdered List : ");
		printList(unordered);
		
	}

}
