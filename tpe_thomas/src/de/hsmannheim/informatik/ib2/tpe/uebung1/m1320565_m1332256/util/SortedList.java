package de.hsmannheim.informatik.ib2.tpe.uebung1.m1320565_m1332256.util;

public class SortedList extends LinkedList {

	@Override
	public void add(ListNode node) {
		ListNode currentNode = root;
		int index = 0;

		if (isEmpty()) {
			super.addFirst(node);
		} else {
			//Get index of the node that has a value greater than the value of the former node.
			while (currentNode != null && currentNode.isLessThan(node)) {
				currentNode = currentNode.next;
				index++;
			}

			//Insert former node at current index and push the bigger node to the next index of the list.
			insert(node, index);
		}
	}

	private void insert(ListNode node, int index) {
		ListNode currentNode = root;
		ListNode formerNode = root;

		int currentIndex = 0;

		if (!isEmpty() && index >= 0 && index <= size()) {
			//Iterate to index.
			while (currentNode != null && currentIndex != index) {
				formerNode = currentNode;
				currentNode = currentNode.next;
				currentIndex++;
			}

			//Insertion.
			if (index == 0) {
				root = node;
				node.next = currentNode;
			} else {
				formerNode.next = node;
				node.next = currentNode;
			}
		}
	}
	
	public void concatList(LinkedList list) {
		ListNode currentNode = root;

		//Do only if both lists have elements.
		if (size() > 0 && list.size() > 0) {
			//Go to last element and append list to it.
			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
			currentNode.next = list.root;
		}
		sort();
	}
	
	public void sort(){
		SortedList sorted = new SortedList(); // Creates a new list to place the sorted listelements in.
		sorted.addFirst(getFirst()); // The first item of the unsorted list is sorted.
		removeFirst();
		int i = 0;
		while(!isEmpty()){
			i = sorted.size();
			while(i > 0 && getFirst().isLessThan(sorted.get(i-1)) == false){
				i--; // Compares the value of each list element to each value of the sorted list, placing it at the right position.
			}
			sorted.addIndex(getFirst(), i); // Adds the element to the right location.
			removeFirst(); // Removes the now sorted element from the unsorted list.
		}
		root = sorted.root; // Puts the sorted values back into the original list.
	}

}
