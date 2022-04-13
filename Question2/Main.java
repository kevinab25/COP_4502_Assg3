package q2;

import java.util.Collections;
import java.util.LinkedList;

public class Main {
	
	public static void printList(LinkedList<Integer> list) {		
		if(list.isEmpty()) {
			System.out.println("List Empty");
			return;
		}
		
		System.out.println("Recorded Data for One hour :");
		for(int i : list )
			System.out.println(i);
	}

	public static void main(String[] args) {
		int numThreads = 8;
		LinkedList<Integer> sharedData = new LinkedList<Integer>();

		
		Thread sensorThreads[] = new Thread[numThreads];
		SensorThread sensors[] = new SensorThread[numThreads];
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
		Collections.sort(sharedData);
		
		System.out.print("Five Lowest Tempratures : ");
		for(int i = 0 ; i < 5 ; i++) {
			System.out.print(sharedData.get(i)+ " , ");
		}
		
		System.out.print("\nFive Highest Tempratures : ");
		for(int i = 0 ; i < 5 ; i++) {
			System.out.print(sharedData.pollLast() + " , ");
		}

	}

}
