package de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe2.m1320565_m1332256.util;

public class Print {

	public static void print(String s) {
		System.out.println(s);
	}

	public static void printArray(IComparable[] ArrayToPrint) {
		String output = "";

		for (int i = 0; i < ArrayToPrint.length; i++) {
			output += "  [" + i + "] " + ArrayToPrint[i].toString();
		}
		print("___________________________________________________________ \n");
		print(output);
		print("___________________________________________________________ \n");
	}

}