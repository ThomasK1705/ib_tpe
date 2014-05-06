package de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1320565_m1332256.myutilTest;

import static org.junit.Assert.*;

import org.junit.Test;

import de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1320565_m1332256.myutil.*;
import de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1320565_m1332256.util.*;

public class ListQueueTest {


	@Test
	public void testCapacity() {
		IQueue queue = new ListQueue(99);

		assertEquals(99, queue.capacity());
	}

	@Test
	public void testClear() {
		IQueue queue = new ListQueue(99);

		//empty
		queue.clear();
		assertEquals(true, queue.isEmpty());
		
		// one element
		queue.enqueue(new IntNode(1));
		queue.clear();
		assertEquals(true, queue.isEmpty());

		// overflow
		queue.enqueue(new IntNode(1));
		queue.enqueue(new IntNode(1));
		queue.enqueue(new IntNode(1));
		queue.enqueue(new IntNode(13));
		queue.clear();
		assertEquals(true, queue.isEmpty());
	}

	@Test
	public void testDequeue() {
		IQueue queue = new ListQueue(99);

		// standard case
		queue.enqueue(new IntNode(1));
		assertNotNull(queue.dequeue());

		// overflow case
		queue.enqueue(new IntNode(1));
		queue.enqueue(new IntNode(1));
		queue.enqueue(new IntNode(1));
		queue.enqueue(new IntNode(13));
		queue.enqueue(new IntNode(15));
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		assertEquals(13, ((IntNode)queue.dequeue()).getValue());
	}

	@Test
	public void testEnqueue() {
		IQueue queue = new ListQueue();

		// insert into empty
		queue.enqueue(new IntNode(1));
		assertEquals(1, ((IntNode)queue.peek()).getValue());
		
		// insert into queue with elements
		assertEquals(true, queue.enqueue(new IntNode(2)));
	}

	@Test
	public void testIsEmpty() {
		IQueue queue = new ListQueue();

		// empty
		assertEquals(true, queue.isEmpty());

		// not empty
		queue.enqueue(new IntNode(1));
		assertEquals(false, queue.isEmpty());
	}

	@Test
	public void testPeek() {
		IQueue queue = new ListQueue(2);

		// empty queue
		assertNull(queue.peek());

		// queue with element
		queue.enqueue(new IntNode(1));
		assertEquals(1, ((IntNode)queue.peek()).getValue());

		// queue with more elements
		queue.enqueue(new IntNode(2));
		assertEquals(1, ((IntNode)queue.peek()).getValue());

		// in combination with dequeue
		queue.dequeue();
		assertEquals(2, ((IntNode)queue.peek()).getValue());
	}

	@Test
	public void testSize() {
		IQueue queue = new ListQueue(2);

		// empty queue
		assertEquals(0, queue.size());

		// queue with element
		queue.enqueue(new IntNode(1));
		assertEquals(1, queue.size());

		// case where array capacity will be doubled
		queue.enqueue(new IntNode(1));
		queue.enqueue(new IntNode(1));
		queue.enqueue(new IntNode(1));
		queue.enqueue(new IntNode(1));
		queue.enqueue(new IntNode(11));
		assertEquals(4, queue.size());
	}
	
}