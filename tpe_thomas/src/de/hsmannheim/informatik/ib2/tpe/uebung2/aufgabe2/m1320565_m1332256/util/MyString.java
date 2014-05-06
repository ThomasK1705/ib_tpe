package de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe2.m1320565_m1332256.util;

//Class MyString implementing the interface IComparable.
public class MyString implements IComparable {

	private String value;

	// Constructor.
	public MyString(String value) {
		setValue(value);
	}

	public IComparable clone() {
		return new MyString(this.value);
	}

	// this.value < value: returns -1
	// this.value > value: returns 1
	// this.value == value: returns 0
	// Not case sensetive.
	@Override
	public int compareTo(Object obj) throws ClassCastException {

		try {
			if (this.getValue()
					.compareToIgnoreCase(((MyString) obj).getValue()) < 0) {
				return -1;
			} else if (this.getValue().compareToIgnoreCase(
					((MyString) obj).getValue()) == 0) {
				return 0;
			} else {
				return 1;
			}
		} catch (NullPointerException e) {
			return 1; // In case second object == null, for sort "null" should behave similar to less than.
		} catch (ClassCastException e) {
			Print.print("not comparable");
			throw e;
		}

	}

	public String getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		int hash = 1;
		hash = hash * 17 + getValue().hashCode();
		return hash;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "" + getValue();
	}
}
