import java.util.Collections;
import java.util.LinkedList;

import javax.print.DocFlavor.INPUT_STREAM;

public class Main {
	
	public static void printList(LazyList<Integer> list) {	
		Node temp;
		
		if(list.isEmpty()) {
			System.out.println("List Empty");
			return;
		}
		
		temp = list.getHead();
		temp = temp.next;
		System.out.println("Recorded Data for One hour :");
		while(temp.key < Integer.MAX_VALUE){
			System.out.println(temp.key);
			temp = temp.next;
		}
	}

	public static void addToHighest(LazyList<Integer> list) {
		Node temp = list.getHead();
		int max = temp.key;

		while(temp.key < Integer.MAX_VALUE) {
			if(max < temp.key) {
				max = temp.key;
				// highest.add(max);
			}
			temp = temp.next;
		}
	}

	public static void addToSmallest(LazyList<Integer> list) {
		Node temp = list.getHead();
		int min = Integer.MAX_VALUE;

		while(temp.key > Integer.MAX_VALUE) {
			if(min > temp.key) {
				min = temp.key;
				// smallest.add(min);
			}
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		int numThreads = 8;
		LazyList<Integer> sharedData = new LazyList<Integer>();

		
		Thread sensorThreads[] = new Thread[numThreads];
		SensorThread sensors[] = new SensorThread[numThreads];
		LinkedList<Integer> highest = new LinkedList<Integer>();
		LinkedList<Integer> lowest = new LinkedList<Integer>();

		for(int i = 0 ; i < numThreads  ; i++ ) {
			sensors[i] = new SensorThread(sharedData);
			sensorThreads[i] = new Thread(sensors[i]);
			sensorThreads[i].setName("Sensor " + (i+1));
			sensorThreads[i].start();
		}
		
		for(int i = 0 ; i < numThreads  ; i++ ) {
			try {
				sensorThreads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		printList(sharedData);
		// Collections.sort(sharedData);
		
		System.out.print("Five Lowest Tempratures : ");
		for(int i = 0 ; i < 5 ; i++) {
			// System.out.print(sharedData.get(i)+ " , ");
		}
		
		System.out.print("\nFive Highest Tempratures : ");
		for(int i = 0 ; i < 5 ; i++) {
			// System.out.print(sharedData.pollLast() + " , ");
		}

	}

}
