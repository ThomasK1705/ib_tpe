package de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1320565_m1332256.myutilTest;

import static org.junit.Assert.*;

import org.junit.Test;

import de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1320565_m1332256.myutil.*;
import de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1320565_m1332256.util.IStack;
import de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1320565_m1332256.util.IntNode;

public class ListStackTest {

	@Test
	public void testCapacity() {
		IStack stack = new ListStack(99);

		assertEquals(99, stack.capacity());
	}

	@Test
	public void testClear() {
		IStack stack = new ListStack(2);

		// empty
		stack.clear();
		assertEquals(true, stack.isEmpty());

		// one element
		stack.push(new IntNode(1));
		stack.clear();
		assertEquals(true, stack.isEmpty());

		// overflow
		stack.push(new IntNode(1));
		stack.push(new IntNode(1));
		stack.push(new IntNode(1));
		stack.push(new IntNode(1));
		stack.clear();
		assertEquals(true, stack.isEmpty());
	}

	@Test
	public void testIsEmpty() {
		IStack stack = new ListStack();

		// empty
		assertEquals(true, stack.isEmpty());

		// not empty
		stack.push(new IntNode(1));
		assertEquals(false, stack.isEmpty());
	}

	@Test
	public void testPeek() {
		IStack stack = new ListStack(2);

		// empty queue
		assertNull(stack.peek());

		// with element
		stack.push(new IntNode(1));
		assertEquals(1, ((IntNode)stack.peek()).getValue());

		// with more elements
		stack.push(new IntNode(2));
		assertEquals(2, ((IntNode)stack.peek()).getValue());

		// in combination with pop
		stack.pop();
		assertEquals(1, ((IntNode)stack.peek()).getValue());
	}

	@Test
	public void testPop() {
		IStack stack = new ArrayStack(5);

		// standard case
		stack.push(new IntNode(1));
		assertNotNull(stack.pop());

		// overflow case
		stack.push(new IntNode(13));
		stack.push(new IntNode(1));
		stack.push(new IntNode(7));
		stack.push(new IntNode(13));
		stack.push(new IntNode(15));
		stack.pop();
		stack.pop();
		assertEquals(7, ((IntNode)stack.pop()).getValue());	}

	@Test
	public void testPush() {
		IStack stack = new ArrayStack();

		// insert into empty
		stack.push(new IntNode(1));
		assertEquals(1, ((IntNode)stack.peek()).getValue());
		
		// insert into stack with elements
		assertEquals(true, stack.push(new IntNode(2)));	
	}

	@Test
	public void testSize() {
		IStack stack = new ListStack();

		// empty queue
		assertEquals(0, stack.size());

		// stack with element
		stack.push(new IntNode(1));
		assertEquals(1, stack.size());

		// case where array capacity will be doubled
		stack.push(new IntNode(1));
		stack.push(new IntNode(1));
		stack.push(new IntNode(1));
		stack.push(new IntNode(1));
		stack.push(new IntNode(11));
		assertEquals(6, stack.size());
	}
}
