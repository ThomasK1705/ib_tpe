package de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1320565_m1332256.myutilTest;

import static org.junit.Assert.*;

import org.junit.Test;

import de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1320565_m1332256.myutil.ArrayStack;
import de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1320565_m1332256.util.IStack;

public class ArrayStackTest {

	@Test
	public void testCapacity() {
		IStack stack = new ArrayStack(99);

		assertEquals(99, stack.capacity());
	}

	@Test
	public void testClear() {
		IStack stack = new ArrayStack(2);

		// empty
		stack.clear();
		assertEquals(true, stack.isEmpty());

		// one element
		stack.push(1);
		stack.clear();
		assertEquals(true, stack.isEmpty());

		// overflow
		stack.push(1);
		stack.push(1);
		stack.push(1);
		stack.push(1);
		stack.clear();
		assertEquals(true, stack.isEmpty());
	}

	@Test
	public void testIsEmpty() {
		IStack stack = new ArrayStack();

		// empty
		assertEquals(true, stack.isEmpty());

		// not empty
		stack.push(1);
		assertEquals(false, stack.isEmpty());
	}

	@Test
	public void testPeek() {
		IStack stack = new ArrayStack(2);

		// empty queue
		assertNull(stack.peek());

		// with element
		stack.push(1);
		assertEquals(1, stack.peek());

		// with more elements
		stack.push(2);
		assertEquals(2, stack.peek());

		// in combination with pop
		stack.pop();
		assertEquals(1, stack.peek());
	}

	@Test
	public void testPop() {
		IStack stack = new ArrayStack(5);

		// standard case
		stack.push(1);
		assertNotNull(stack.pop());

		// overflow case
		stack.push(13);
		stack.push(1);
		stack.push(7);
		stack.push(13);
		stack.push(15);
		stack.pop();
		stack.pop();
		assertEquals(7, stack.pop());	}

	@Test
	public void testPush() {
		IStack stack = new ArrayStack();

		// insert into empty
		stack.push(1);
		assertEquals(stack.peek(), 1);
		
		// insert into stack with elements
		assertEquals(true, stack.push(2));	
	}

	@Test
	public void testSize() {
		IStack stack = new ArrayStack();

		// empty queue
		assertEquals(0, stack.size());

		// stack with element
		stack.push(1);
		assertEquals(1, stack.size());

		// case where array capacity will be doubled
		stack.push(1);
		stack.push(1);
		stack.push(1);
		stack.push(1);
		stack.push(11);
		assertEquals(6, stack.size());
	}
}
