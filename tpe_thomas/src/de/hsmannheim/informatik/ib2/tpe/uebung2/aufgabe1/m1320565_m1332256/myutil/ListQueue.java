package de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1320565_m1332256.myutil;

import de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1320565_m1332256.util.IQueue;
import de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1320565_m1332256.util.LinkedList;
import de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1320565_m1332256.util.ListNode;

public class ListQueue implements IQueue {

	private LinkedList queue = new LinkedList();

	private int capacity = 5;
	private boolean overflown;
	
	public ListQueue() {
	}

	public ListQueue(int capacity) {
		if (capacity > 0) {
			this.capacity = capacity;
		}
	}

	@Override
	public int capacity() {
		return capacity;
	}

	@Override
	public void clear() {
		queue.clear();
	}

	@Override
	public Object dequeue() {
		Object obj = queue.getFirst();
		queue.removeFirst();

		return obj;
	}

	@Override
	public boolean enqueue(Object obj) {
		
		// Don't allow null to be enqueued.
		if (obj == null) {
			return false;
		}
		
		if (queue.size() < capacity) {
			queue.addLast((ListNode)obj); // Is allowed because of the restriction mentioned in the worksheet.
			return true;
		} else if (!overflown) { // Is queue full and not overflown yet?
			overflown = true;
			doubleCapacity();
			enqueue(obj); // Insert again.
			return true;			
		}

		return false;
	}
	
	/**
	 * Doubles the current capacity of Queue.
	 */
	private void doubleCapacity() {
		capacity *= 2;
	}

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	@Override
	public Object peek() {
		return queue.getFirst();
	}

	@Override
	public int size() {
		return queue.size();
	}

	@Override
	public String toString(){
		ListNode queueElement = queue.getFirst();
		String result = "";
		int tail = queue.size();
		int head = 0;
		
		int counter = 0;
		
		if(!queue.isEmpty()){
			while(queueElement != null){
				result+= counter + "[" + queueElement + "] ";
				
				if(counter == head){
					result+= "(head) ";
				}
				
				if(counter == tail){
					result+= "(tail) ";
				}
				
				queueElement = queueElement.getNext();
				counter++;
			}	
		} else {
			result = "Queue is empty.";
		}
		
		return result;
	}		
}
