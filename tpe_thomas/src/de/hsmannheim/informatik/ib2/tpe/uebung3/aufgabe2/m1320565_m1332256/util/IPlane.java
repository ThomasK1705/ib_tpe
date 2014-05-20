package de.hsmannheim.informatik.ib2.tpe.uebung3.aufgabe2.m1320565_m1332256.util;

public interface IPlane {

	/**
	 * �ffnet die T�ren des Flugzeugs. Damit die T�ren ge�ffnet werden k�nnen,
	 * muss sich das Flugzeug auf dem Boden befinden und darf sich nicht mehr
	 * bewegen.
	 * @throws GeneralFlightSimulatorException
	 * Wenn das Flugzeug noch in der Luft ist oder noch nicht still steht.
	 */
	public void openDoors() throws GeneralFlightSimulatorException;

	/**
	 * Schlie�t die T�ren des Flugzeugs.
	 */
	public void closeDoors();

	/**
	 * H�lt das Flugzeug an, wenn es gerade auf dem Boden f�hrt. 
	 * @throws GeneralFlightSimulatorException 
	 * Wenn das Flugzeug in der Luft ist
	 */
	public void stop() throws GeneralFlightSimulatorException;

	/**
	 * L�sst das Flugzeug einen weiteren Kilometer fliegen, der H�henunterschied
	 * wird als Parameter angegeben.
	 * @param additionalHeight 
	 * Der H�henunterschied, den das Flugzeug in diesem Kilometer h�her / niedriger
	 * fliegt als zuvor. Kann positiv oder negativ sein. 
	 * @throws GeneralFlightSimulatorException
	 * Falls beim Fliegen Probleme auftauchen.
	 */
	public void flyNextKilometer(int additionalHeight) throws GeneralFlightSimulatorException;
}
