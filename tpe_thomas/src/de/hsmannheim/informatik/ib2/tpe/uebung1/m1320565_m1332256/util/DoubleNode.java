package de.hsmannheim.informatik.ib2.tpe.uebung1.m1320565_m1332256.util;

public class DoubleNode extends ListNode{
	
	private double value;
	
	public DoubleNode(double value) {
		this.value = value;
	}
	
	@Override
	boolean isLessThan(ListNode n) {
		if (n instanceof DoubleNode) {
			return this.value < ((DoubleNode) n).getValue();
		}
		return false;
	}

	@Override
	boolean isEqualTo(ListNode n) {
		if (n instanceof DoubleNode) {
			return ((DoubleNode) n).getValue() == this.value;
		}
		return false;
	}

	@Override
	public String toString() {
		return "" + value;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

}
