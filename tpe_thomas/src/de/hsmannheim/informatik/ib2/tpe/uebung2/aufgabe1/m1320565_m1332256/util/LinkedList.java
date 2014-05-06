package de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1320565_m1332256.util;

public class LinkedList {

	protected ListNode root = null;

	public void add(ListNode node) {
		ListNode temp = root;
		if (isEmpty()) {
			root = node;
		} else {
			// Iterate through list elements to the last element.
			while (temp.next != null) {
				temp = temp.next;
			}
			// Append element to the last element.
			temp.next = node;
		}
	}

	public void addIndex(ListNode node, int index) {
		ListNode temp = root;
		if (isEmpty()) {
			root = node;
		} else {
			// Iterate through list elements to the last element.
			while (temp.next != null) {
				temp = temp.next;
			}
			// Append element to the last element.
			temp.next = node;
		}
	}
	
	public void append(LinkedList list) {
		getLast().next = list.getFirst();
	}

	public void remove(ListNode node) {
		ListNode beforeNode = root;
		ListNode currentNode = root;

		if (!isEmpty()) {
			if (currentNode.isEqualTo(node)) {
				removeFirst();
			} else {
				while (currentNode != null) {
					if (currentNode.isEqualTo(node)) {
						// remove
						beforeNode.next = currentNode.next;
						return;
					}
					beforeNode = currentNode;
					currentNode = currentNode.next;
				}
			}
		}
	}

	public void removeLast() {
		ListNode temp = root;

		if (size() <= 1) {
			clear();
		} else {
			// Iterate through list till next element has no next element.
			while (temp.next != null && temp.next.next != null) {
				temp = temp.next;
			}
			// Delete next element that has no next element.
			temp.next = null;
		}
	}

	public void addFirst(ListNode node) {
		if (isEmpty()) {
			root = node;
		} else {
			node.next = root;
			root = node;
		}
	}

	public void addLast(ListNode node) {
		ListNode temp = root;
		if (isEmpty()) {
			root = node;
		} else {
			// Iterate through list elements to the last element.
			while (temp.next != null) {
				temp = temp.next;
			}
			// Append element to the last element.
			temp.next = node;
		}
	}

	public void removeFirst() {
		if (size() > 1) {
			root = root.next;
		} else {
			clear();
		}
	}

	public boolean delete(int index) {
		
		// Delete element at index.
		// Return true if index is ok, false otherwise.

		if (index >= 0 && index < size()) {
			ListNode currentNode = root;
			for (int i = 0; i < index; i++) {
				currentNode = currentNode.next;
			}

			if (index == 0) {
				root = currentNode.next;
			} else {
				currentNode.next = currentNode.next.next;
			}
			return true;
		} else {
			return false;
		}
	}

	public boolean isEmpty() {
		return root == null;
	}

	public int size() {
		ListNode currentNode = root;
		int counter = 0;

		while (currentNode != null) {
			counter++;
			currentNode = currentNode.next;
		}

		return counter;
	}

	public boolean contains(ListNode node) {
		ListNode currentNode = root;

		while (currentNode != null) {
			if (currentNode.isEqualTo(node)) {
				return true;
			}
			currentNode = currentNode.next;
		}
		return false;
	}

	public void clear() {
		root = null;
	}

	public boolean removeAll() {
		root = null;
		return true;
	}

	public void concatList(LinkedList list) {
		ListNode currentNode = root;

		// Do only if both lists have elements.
		if (size() > 0 && list.size() > 0) {
			// Go to last element and append list to it.
			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
			currentNode.next = list.root;
		}
	}

	public LinkedList cloneDeep() {
		LinkedList clone = new LinkedList();

		clone.add(root);
		return clone;
	}

	public ListNode get(int index) {
		if (index < size()) { // avoids null-pointer
			ListNode l = root;
			for (int i = 0; i < index; i++) {
				l = l.next;
			}
			return l.next;
		}
		return null;
	}

	public ListNode getFirst() {
		return root;
	}

	public ListNode getLast() {
		if (size() < 1) { // avoids null-pointer
			ListNode l = root;
			for (int i = 0; i < size(); i++) {
				l = l.next;
			}
			return l.next;
		}
		return null;
	}

	public ListNode[] toArray() {
		ListNode[] array = new ListNode[size()];
		ListNode temp = root;
		int index = 0;
		if (isEmpty()) {
			return array;
		} else {
			// Iterate through list elements to the last element.
			while (index < size()) {
				array[index] = temp;
			}
			return array;
		}
	}

	@Override
	public String toString() {
		ListNode currentNode = root;
		String result = "";

		while (currentNode != null) {
			result += "[" + currentNode.toString() + "]  ";
			currentNode = currentNode.next;
		}

		return result;
	}
}
