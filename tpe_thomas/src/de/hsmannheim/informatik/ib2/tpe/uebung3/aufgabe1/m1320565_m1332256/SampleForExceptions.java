package de.hsmannheim.informatik.ib2.tpe.uebung3.aufgabe1.m1320565_m1332256;

public class SampleForExceptions {
	
	int base3 = 0;
	
	public SampleForExceptions()
	{
		
	}
	
	public void creatException () throws NumberFormatException {
		int c; 
		for (base3 = 12; base3 >= 2; base3--) {
			c = Integer.parseInt("60", base3);
			System.out.println("60 base " + base3 + " = " + c);
		}
		throw new NumberFormatException();
	}

}
