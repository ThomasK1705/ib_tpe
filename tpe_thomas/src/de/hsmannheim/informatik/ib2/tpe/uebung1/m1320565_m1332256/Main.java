/*
 * How did we choose the package name?
 * 
 * First of all, we followed the reverse domain name convention.
 * From an architecture standpoint it makes sense to structure the package like we did, because it belongs
 * to:
 *  -> HS-Mannheim 
 *  -> computer science
 *  -> second semester of the Bachelor-course
 *  -> TPE lecture
 *  -> Task 1
 *  -> avoided collisions with others, by appending Sebastian and my student id which are unique anyway.
 */

package de.hsmannheim.informatik.ib2.tpe.uebung1.m1320565_m1332256;

import de.hsmannheim.informatik.ib2.tpe.uebung1.m1320565_m1332256.util.IntNode;
import de.hsmannheim.informatik.ib2.tpe.uebung1.m1320565_m1332256.util.SortedList;
import de.hsmannheim.informatik.ib2.tpe.uebung1.m1320565_m1332256.util.StringNode;

public class Main {

	public static void main(String[] args) {
		// Creating a new sorted list containing integer values.
		SortedList sortedIntegers = new SortedList();
		//SortedList sortedIntegers2 = new SortedList();
		// Creating a new sorted list containing string values.
		SortedList sortedStrings = new SortedList();

		sortedIntegers.add(new IntNode(1));
		sortedIntegers.add(new IntNode(3));
		sortedIntegers.add(new IntNode(19));
		sortedIntegers.add(new IntNode(15));
		sortedIntegers.add(new IntNode(17));
		sortedIntegers.add(new IntNode(-8));
		sortedIntegers.add(new IntNode(3));
		sortedIntegers.add(new IntNode(7));
		System.out.println(sortedIntegers.toString());
		sortedIntegers.add(new IntNode(14));
		System.out.println(sortedIntegers.toString());
		//sortedIntegers2.add(new IntNode(2));
		//sortedIntegers2.add(new IntNode(6));
		// sortedIntegers2.add(new IntNode(5));
		//System.out.println(sortedIntegers2.toString());
		//sortedIntegers.concatList(sortedIntegers2);
		System.out.println(sortedIntegers.toString());
		
		sortedStrings.add(new StringNode("Alle"));
		sortedStrings.add(new StringNode("meine"));
		sortedStrings.add(new StringNode("Entchen"));
		sortedStrings.add(new StringNode("schwimmen"));
		sortedStrings.add(new StringNode("auf"));
		sortedStrings.add(new StringNode("dem"));
		sortedStrings.add(new StringNode("See"));
		System.out.println(sortedStrings.toString());
		
	}
}