package de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1320565_m1332256.util;

public abstract class ListNode {
	
	ListNode next;

	abstract public ListNode clone();

	abstract public ListNode getNext();

	abstract boolean isEqualTo(ListNode n);
	
	abstract boolean isLessThan(ListNode n);
}
