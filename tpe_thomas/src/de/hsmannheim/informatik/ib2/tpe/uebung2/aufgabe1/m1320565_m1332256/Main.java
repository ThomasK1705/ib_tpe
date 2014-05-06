package de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1320565_m1332256;

import java.util.Scanner;

import de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1320565_m1332256.myutil.ArrayQueue;
import de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1320565_m1332256.myutil.ArrayStack;
import de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1320565_m1332256.myutil.ListQueue;
import de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1320565_m1332256.myutil.ListStack;
import de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1320565_m1332256.util.IQueue;
import de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1320565_m1332256.util.IStack;
import de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1320565_m1332256.util.StringNode;

public class Main {

	private static Scanner scanner = new Scanner(System.in);

	private static String input;
	private static String inputADT;
	private static String inputImpl;
	private static String inputQueue;
	private static String inputStack;

	private static IQueue arrayQueue = new ArrayQueue();
	private static IQueue listQueue = new ListQueue();

	private static IStack arrayStack = new ArrayStack();
	private static IStack listStack = new ListStack();

	public static void main(String[] args) {

		
		System.out.println("*** TPE Task 2.1 \n*** This is how it works: \n*** \t 1. Select abstract datatype \n*** \t 2. Select datatype implementation \n*** \t 3. Execute operations\n***\n***  Point of advice: 'Exit!' will bring you up to the menu level above the current one.");
		do {
			inputADT = adtSelection();

			if (inputADT.charAt(0) == 'q' ) {

				inputImpl = implementationSelection();

				do {
					if (inputImpl.charAt(0) == 'a') {
						queueOperation(arrayQueue);
					} else if (inputImpl.charAt(0) == 'l') {
						queueOperation(listQueue);
					}
				} while (!inputImpl.equals("Exit!"));

			} else if (inputADT.charAt(0) == 's') {

				inputImpl = implementationSelection();

				do {
					if (inputImpl.charAt(0) == 'a') {
						stackOperation(arrayStack);
					} else if (inputImpl.charAt(0) == 'l') {
						stackOperation(listStack);
					} 
				} while (!inputImpl.equals("Exit!"));
			} 
		} while (!inputADT.equals("Exit!"));
	}

	private static String adtSelection() {
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println("[q] for Queue / [s] for Stack");
		System.out.println("---------------------------------------------------------------------------------------");	
		
		return scanner.next();
	}

	private static String implementationSelection() {
		System.out.println("---------------------------------------------------------------------------------------");		
		System.out.println("[a] for Array / [l] for List");
		System.out.println("---------------------------------------------------------------------------------------");
		
		return scanner.next();
	}

	private static void queueOperation(IQueue queue){
		do{
			System.out.println("---------------------------------------------------------------------------------------");
			System.out.println("[1] capcity / [2] clear / [3] isEmpty / [4] peek / [5] size / [6] dequeue / [7] enqueue / [8] toString");
			System.out.println("---------------------------------------------------------------------------------------");

			inputQueue = scanner.next();

			switch (inputQueue.charAt(0)) {
			case '1':
				System.out.println("Capacity: " + queue.capacity());
				break;
			case '2':
				queue.clear();
				System.out.println("Cleared!");				
				break;
			case '3':
				System.out.println("Is empty: " + queue.isEmpty());				
				break;
			case '4':
				System.out.println("Peek: " + queue.peek());
				break;
			case '5':
				System.out.println("Size: " + queue.size());			
				break;
			case '6':
				System.out.println("Dequeued: " + queue.dequeue());
				break;
			case '7':
				System.out.println("Enter value: ");
				input = scanner.next();
				System.out.println("Enqueued: " + queue.enqueue(new StringNode(input)));					
				break;
			case '8':
				System.out.println(queue.toString());
				break;				
			}
		}while(!inputQueue.equals("Exit!"));
		inputImpl = "Exit!";
	}

	private static void stackOperation(IStack stack) {
		do {
			System.out.println("---------------------------------------------------------------------------------------");			
			System.out.println("[1] capcity / [2] clear / [3] isEmpty / [4] peek / [5] size / [6] pop / [7] push / [8] toString");
			System.out.println("---------------------------------------------------------------------------------------");
			
			inputStack = scanner.next();

			switch (inputStack.charAt(0)) {
			case '1':
				System.out.println("Capacity: " + stack.capacity());
				break;
			case '2':
				stack.clear();
				System.out.println("Cleared!");				
				break;
			case '3':
				System.out.println("Is empty: " + stack.isEmpty());				
				break;
			case '4':
				System.out.println("Peek: " + stack.peek());
				break;
			case '5':
				System.out.println("Size: " + stack.size());			
				break;
			case '6':
				System.out.println("Popped: " + stack.pop());
				break;
			case '7':
				System.out.println("Enter value: ");
				input = scanner.next();
				System.out.println("Enqueued: " + stack.push(new StringNode(input)));					
				break;
			case '8':
				System.out.println(stack.toString());
				break;				
			}
		} while (!inputStack.equals("Exit!"));
		inputImpl = "Exit!";
	}
	
}
