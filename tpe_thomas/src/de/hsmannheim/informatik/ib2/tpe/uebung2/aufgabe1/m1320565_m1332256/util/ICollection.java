package de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1320565_m1332256.util;

public interface ICollection {
	
	/**
	 * Returns the number of elements the collection is able to store.
	 * 
	 * @return
	 */
	public int capacity();
	
	/**
	 * Removes all objects from the collection.
	 */
	public void clear();

	/**
	 * Returns information if collection stores elements or not.
	 * 
	 * @return true if empty, else false
	 */
	public boolean isEmpty();

	/**
	 * Returns first object of the collection without removing it.
	 * 
	 * @return
	 */
	public Object peek();

	/**
	 * Returns number of elements the collection contains.
	 * 
	 * @return
	 */
	public int size();

}
