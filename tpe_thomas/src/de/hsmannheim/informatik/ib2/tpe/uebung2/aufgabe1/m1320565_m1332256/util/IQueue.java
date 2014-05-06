package de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1320565_m1332256.util;

public interface IQueue extends ICollection {

	/**
	 * Removes and returns the object at the beginning of the Queue.
	 * 
	 * @return
	 */
	public Object dequeue();

	/**
	 * Adds object at the end of the Queue.
	 * 
	 * @param obj
	 * @return true if Queue was added to the Stack, else false
	 */
	public boolean enqueue(Object obj);
}
