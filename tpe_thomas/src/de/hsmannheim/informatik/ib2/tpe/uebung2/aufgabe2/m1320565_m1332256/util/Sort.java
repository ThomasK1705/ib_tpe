package de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe2.m1320565_m1332256.util;

public class Sort {

	// Sorts in descending order.
	// "<" --> sorts descending; ">" --> sorts ascending.
	private static void insertionSort(IComparable[] ArrayToSort) {
		for (int i = 1; i < ArrayToSort.length; i++) {
			int j = i;
			IComparable tempBucket = ArrayToSort[i]; // Filling bucket with the original values.

			while (j > 0 && ArrayToSort[j - 1].compareTo(tempBucket) < 0) {
				// Move all bigger elements to the back of the array
				ArrayToSort[j] = ArrayToSort[j - 1];
				j--;
			}
			ArrayToSort[j] = tempBucket; // Empty the tempBucket into the array.
		}
	}

	// Sorts descending.
	// leftToRight "<" and rightToLeft ">" -- > sorts descending.
	// leftToRight ">" and rightToLeft "<" --> sorts ascending.
	private static void shakerSort(IComparable[] ArrayToSort) {

		boolean swapped = true;
		boolean leftToRight = true; //
		int left = 0;
		int right = ArrayToSort.length - 1;
		while (swapped) {
			swapped = false;
			// If there is nothing to do set swapped == false and end procedure

			if (leftToRight) {
				// Bubble through array from left to right.
				for (int i = left; i < right; i++) {
					if (ArrayToSort[i].compareTo(ArrayToSort[i + 1]) < 0) {
						swap(ArrayToSort, i, i + 1);
						swapped = true;
					}
				}
				right--; // Decrement the area to be sorted from the right.
				leftToRight = false; // Switch the sorting-direction for the next step.

			} else {
				// Bubble through array from right to left.
				for (int j = right; j > left; j--) {
					if (ArrayToSort[j].compareTo(ArrayToSort[j - 1]) > 0) {
						swap(ArrayToSort, j, j - 1);
						swapped = true;
					}
				}
				left++; // Decrement the area to be sorted from the left.
				leftToRight = true; // Switch the sorting-direction for the next step.
			}
		}
	}

	// kindOfSort = true --> ShakerSort; kindOfSort = false --> InsertionSort
	public static void sortArray(boolean kindOfSort, IComparable[] ArrayToSort) {
		if (kindOfSort) {
			Print.print("Before shakerSort: ");
			Print.printArray(ArrayToSort);
			shakerSort(ArrayToSort);
			Print.print("After shakerSort: ");
			Print.printArray(ArrayToSort);
		} else {
			Print.print("Before insertionSort: ");
			Print.printArray(ArrayToSort);
			insertionSort(ArrayToSort);
			Print.print("After insertionSort: ");
			Print.printArray(ArrayToSort);
		}
	}

	// Swaps two elements with the help of swapHelper.
	public static void swap(IComparable ArrayToSwap[], int bucket1, int bucket2) {
		IComparable swapHelper;
		swapHelper = ArrayToSwap[bucket1];
		ArrayToSwap[bucket1] = ArrayToSwap[bucket2];
		ArrayToSwap[bucket2] = swapHelper;
	}

}