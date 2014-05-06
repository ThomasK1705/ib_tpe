package de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1320565_m1332256.myutil;

import de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1320565_m1332256.util.IStack;
import de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1320565_m1332256.util.LinkedList;
import de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1320565_m1332256.util.ListNode;

public class ListStack implements IStack {

	private LinkedList stack = new LinkedList();

	private int capacity = 5;
	private boolean overflown;
	
	public ListStack(){}
	
	public ListStack(int capacity){
		if(capacity>0){
			this.capacity = capacity;
		}
	}
	
	@Override
	public int capacity() {
		return capacity;
	}

	@Override
	public void clear() {
		stack.clear();
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public Object peek() {
		return stack.getLast();
	}

	/**
	 * Doubles the current capacity of Queue.
	 */
	private void doubleCapacity() {
		capacity *= 2;
	}
	
	@Override
	public Object pop() {
		Object obj = stack.getLast();
		stack.removeLast();
		return obj;	
	}

	@Override
	public boolean push(Object obj) {

		// Don't allow null to be enqueued.
		if (obj == null) {
			return false;
		}
		
		if (stack.size() < capacity) {
			stack.addLast((ListNode)obj); // Is allowed because of the restriction mentioned in the worksheet.
			return true;
		} else if (!overflown) { // Is the stack full and not overflown yet?
			overflown = true;
			doubleCapacity();
			push(obj); // Insert again.
			return true;			
		}
		
		return false;
	}

	@Override
	public int size() {
		return stack.size();
	}
	
	@Override
	public String toString(){
		ListNode stackElement = stack.getFirst();
		String result = "";
		int head = stack.size();
		int counter = 0;
		
		if(!stack.isEmpty()){
			while(stackElement != null){
				result+= counter + "[" + stackElement.toString() + "] ";
				
				if(counter == head){
					result+= "(head) ";
				}
				
				stackElement = stackElement.getNext();
				counter++;
			}	
		} else {
			result = "Stack is empty.";
		}
		
		return result;
	}
}
