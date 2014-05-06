package de.hsmannheim.informatik.ib2.tpe.uebung1.m1320565_m1332256.util;

//Class IntNode extends the abstract class ListNode so it can handle integer values.
public class IntNode extends ListNode {

	private int value;

	public IntNode(int value) {
		this.value = value;
	}

	@Override
	boolean isLessThan(ListNode n) {
		if (n instanceof IntNode) {
			return this.value < ((IntNode) n).getValue();
		}
		return false;
	}

	@Override
	boolean isEqualTo(ListNode n) {
		if (n instanceof IntNode) {
			return ((IntNode) n).getValue() == this.value;
		}
		return false;
	}

	@Override
	public String toString() {
		return "" + value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
