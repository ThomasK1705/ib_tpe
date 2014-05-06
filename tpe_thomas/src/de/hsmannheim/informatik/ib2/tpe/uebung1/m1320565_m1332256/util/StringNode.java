package de.hsmannheim.informatik.ib2.tpe.uebung1.m1320565_m1332256.util;

public class StringNode extends ListNode {

	private String value;

	public StringNode(String value) {
		this.value = value;
	}

	@Override
	boolean isLessThan(ListNode n) {
		if (n instanceof StringNode) {
			return value.compareToIgnoreCase(((StringNode) n).getValue()) < 0;
		}
		return false;
	}

	@Override
	boolean isEqualTo(ListNode n) {
		if (n instanceof StringNode) {
			return value.compareToIgnoreCase(((StringNode) n).getValue()) == 0;
		}
		return false;
	}

	@Override
	public String toString() {
		return value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
