package de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe2.m1320565_m1332256.util;

// Class MyInt implementing the interface IComparable.

public class MyInt implements IComparable {

	private int value;

	// Constructor.
	public MyInt(int value) {
		this.value = value;
	}

	public IComparable clone() {
		return new MyInt(this.value);
	}

	// this.value < value: returns -1
	// this.value > value: returns 1
	// this.value == value: returns 0
	@Override
	public int compareTo(Object o) throws ClassCastException {
		try {
			if (this.getValue() < ((MyInt) (o)).getValue()) {
				return -1;
			} else if (this.getValue() == ((MyInt) (o)).getValue()) {
				return 0;
			} else {
				return 1;
			}
		} catch (NullPointerException e) {
			return 1; // In case second object == null, for sort "null" should behave similar to less than.
		} catch (ClassCastException e) {
			Print.print("Not comparable.");
			throw e;
		}

	}

	public int getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		int hash = 1;
		hash = hash * 17 + getValue();
		return hash;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "" + getValue();
	}
}
