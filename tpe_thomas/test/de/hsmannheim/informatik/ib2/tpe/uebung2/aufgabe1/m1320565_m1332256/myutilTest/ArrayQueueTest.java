package de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1320565_m1332256.myutilTest;

import static org.junit.Assert.*;

import org.junit.Test;

import de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1320565_m1332256.myutil.ArrayQueue;
import de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1320565_m1332256.util.IQueue;

public class ArrayQueueTest {

	@Test
	public void testCapacity() {
		IQueue queue = new ArrayQueue(99);

		assertEquals(99, queue.capacity());
	}

	@Test
	public void testClear() {
		IQueue queue = new ArrayQueue(2);

		//empty
		queue.clear();
		assertEquals(true, queue.isEmpty());
		
		// one element
		queue.enqueue(1);
		queue.clear();
		assertEquals(true, queue.isEmpty());

		// overflow
		queue.enqueue(1);
		queue.enqueue(1);
		queue.enqueue(1);
		queue.enqueue(1);
		queue.clear();
		assertEquals(true, queue.isEmpty());
	}

	@Test
	public void testDequeue() {
		IQueue queue = new ArrayQueue(5);

		// Standard case.
		queue.enqueue(1);
		assertNotNull(queue.dequeue());

		// Overflow case.
		queue.enqueue(1);
		queue.enqueue(1);
		queue.enqueue(1);
		queue.enqueue(13);
		queue.enqueue(15);
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		assertEquals(13, queue.dequeue());
	}

	@Test
	public void testEnqueue() {
		IQueue queue = new ArrayQueue();

		// Insert into empty.
		queue.enqueue(1);
		assertEquals(1 , queue.peek());
		
		// Insert into queue with elements.
		assertEquals(true, queue.enqueue(2));
	}

	@Test
	public void testIsEmpty() {
		IQueue queue = new ArrayQueue();

		// empty
		assertEquals(true, queue.isEmpty());

		// not empty
		queue.enqueue(1);
		assertEquals(false, queue.isEmpty());
	}

	@Test
	public void testPeek() {
		IQueue queue = new ArrayQueue(2);

		// empty queue
		assertNull(queue.peek());

		// queue with element
		queue.enqueue(1);
		assertEquals(1, queue.peek());

		// queue with more elements
		queue.enqueue(2);
		assertEquals(1, queue.peek());

		// in combination with dequeue
		queue.dequeue();
		assertEquals(2, queue.peek());
	}

	@Test
	public void testSize() {
		IQueue queue = new ArrayQueue(2);

		// empty queue
		assertEquals(0, queue.size());

		// queue with element
		queue.enqueue(1);
		assertEquals(1, queue.size());

		// case where array capacity will be doubled
		queue.enqueue(1);
		queue.enqueue(1);
		queue.enqueue(1);
		queue.enqueue(1);
		queue.enqueue(11);
		assertEquals(4, queue.size());
	}
}
