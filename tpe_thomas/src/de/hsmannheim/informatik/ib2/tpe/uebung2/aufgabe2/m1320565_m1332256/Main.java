/* 		
 *		HS Mannheim - 2IB - TPE - Task 2.2
 *		Members:	Sebastian Schuler 1332256 and Thomas Kämmerling 1320565	
 *		Lecturer: Prof Dr. Schramm
 *		Submission Deadline: 07th of May 2014
 */

package de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe2.m1320565_m1332256;

import de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe2.m1320565_m1332256.util.IComparable;
import de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe2.m1320565_m1332256.util.MyInt;
import de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe2.m1320565_m1332256.util.MyString;
import de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe2.m1320565_m1332256.util.Print;
import de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe2.m1320565_m1332256.util.Sort;

public class Main {
	// Static testArrays to make testing simple.
	public static int lengthOfTheIntArray = 5;
	public static int lengthOfTheStringArray = 5;
	public static IComparable myIntArray[];
	public static IComparable myStringArray[];

	// Helper to create random words with capital letters.
	// Is given the length of the word as an integer value.
	public static String createRandomWord(int lengthOfTheWord) {
		String randomWord = "";
		char randomLetter;
		for (int i = 0; i < lengthOfTheWord; i++) {
			// Creates random letters ranging 'A' - 'Z'
			// Unicode-Letter-range between 65 - 90.
			randomLetter = (char) ((((int) (Math.random() * 100)) % 26) + 65);
			randomWord += randomLetter;
		}
		return randomWord;
	}

	static void initialize() {
		// Initializing myIntArray with random MyInt-Objects.
		myIntArray = new IComparable[lengthOfTheIntArray];
		for (int i = 0; i < lengthOfTheIntArray; i++) {
			myIntArray[i] = new MyInt((int) (Math.random() * 100));
		}

		// Initializing myStringArray with random MyString-Objects
		myStringArray = new IComparable[lengthOfTheStringArray];
		for (int i = 0; i < lengthOfTheStringArray; i++) {
			String value = createRandomWord(5);
			myStringArray[i] = new MyString(value);
		}
	}

	public static void main(String[] args) {

		// Initializing random array and sort with shakerSort (true).
		Print.print("Initialize random array and test with shakerSort: \n 1) myIntArray \n 2) myStringArray \n");
		initialize();
		Sort.sortArray(true, myIntArray);
		Sort.sortArray(true, myStringArray);

		// Initialize random array and sort with insertionSort (false)
		Print.print("Initialize random array and test with insertionSort: \n 1) myIntArray \n 2) myStringArray \n");
		initialize();
		Sort.sortArray(false, myIntArray);
		Sort.sortArray(false, myStringArray);

	}

}
