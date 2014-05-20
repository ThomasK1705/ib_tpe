package de.hsmannheim.informatik.ib2.tpe.uebung3.aufgabe2.m1320565_m1332256.util;

@SuppressWarnings("serial")
public class PlaneToLowException extends GeneralFlightSimulatorException{
	
	public PlaneToLowException(String message) {
		super(message);
	}
	
	public void printinfo() {
		Print.print("Failure at" + this.getMessage());
	}
	
	public String toString() {
		return (this.getClass()).getSimpleName() + " " +  this.getMessage() + "\n";
	}

}
