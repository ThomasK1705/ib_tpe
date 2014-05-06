package de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1320565_m1332256.myutil;

import de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1320565_m1332256.util.IQueue;

public class ArrayQueue implements IQueue {

	private Object[] queue;

	/*
	 * The correct position of the head-/tail pointer will be determined 
	 * with the help of the modulo operation and the size of the queue. 
	 * This works because the head-/tail pointer only needs 
	 * to be increased after each successful enqueue/dequeue. 
	 * Here is an example on how to get the correct position of the head pointer:
	 * 
	 * 	int position = head % queue.length;
	 */
	private int head;
	private int tail;

	private boolean overflown;

	public ArrayQueue() {
		this(0);
	}

	public ArrayQueue(int capacity) {
		if (capacity > 0) {
			queue = new Object[capacity];
		} else {
			queue = new Object[5];
		}

		head = queue.length;
		tail = queue.length;
	}

	@Override
	public int capacity() {
		return queue.length;
	}

	@Override
	public void clear() {
		queue = new Object[queue.length];
	}

	@Override
	public Object dequeue() {
		Object obj = null;

		if (!isEmpty()) {
			obj = queue[(head) % queue.length]; // Save object for return.
			queue[(head) % queue.length] = null; // Delete object in queue.

			if (queue[(head + 1) % queue.length] != null) { // Increase headpointer only if next element exist.
				head++;
			}
		}

		return obj;
	}

	/**
	 * Copies existing queue into a new queue with a doubled capacity of current Queue.
	 */
	
	private void doubleCapacity() {
		ArrayQueue doubledQueue = new ArrayQueue(queue.length * 2);

		// Copy current queue into new queue.
		while (!isEmpty()) {
			doubledQueue.enqueue(dequeue());
		}

		// 'Assign' new queue to current queue.
		// This is possible because we are in the same class. Make it easier to handle the names.
		queue = doubledQueue.queue;
		head = doubledQueue.head;
		tail = doubledQueue.tail;
	}

	@Override
	public boolean enqueue(Object obj) {

		// Don't allow null to be enqueued.
		if (obj == null) {
			return false;
		}

		if (isEmpty()) {
			queue[tail % queue.length] = obj;
			return true;
		} else if (queue[(tail + 1) % queue.length] == null) { // Is next cell empty?
			queue[(tail + 1) % queue.length] = obj; // Insert in next cell.
			tail++; // Increase tailpointer.
			return true;
		} else if (!overflown) { // Is Queue full and not overflown yet?
			overflown = true;
			doubleCapacity();
			enqueue(obj); // Insert again
			return true;
		}

		return false;
	}

	@Override
	public boolean isEmpty() {
		return peek() == null;
	}

	@Override
	public Object peek() {
		return queue[head % queue.length];
	}

	@Override
	public int size() {
		int counter = 0;

		for (Object obj : queue) {
			if (obj != null) {
				counter++;
			}
		}

		return counter;
	}

	@Override
	public String toString() {
		String result = "";
		int counter = 0;

		if (!isEmpty()) {
			for (Object obj : queue) {
				if (obj != null) {
					result += counter + "[" + obj + "] ";
					if (counter == (head) % queue.length) {
						result += "(head) ";
					}
					if (counter == (tail) % queue.length) {
						result += "(tail) ";
					}
				}
				counter++;
			}
		} else {
			result = "Queue is empty.";
		}
		return result;
	}
}
