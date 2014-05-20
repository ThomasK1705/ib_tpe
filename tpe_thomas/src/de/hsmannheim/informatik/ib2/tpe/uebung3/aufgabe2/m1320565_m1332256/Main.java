package de.hsmannheim.informatik.ib2.tpe.uebung3.aufgabe2.m1320565_m1332256;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import de.hsmannheim.informatik.ib2.tpe.uebung3.aufgabe2.m1320565_m1332256.util.*;

public class Main {

	public static TinyPlane tinyTpePlane;
	public static String tpeLog = "FlightLog " + new Date() + "\n\n";
	public static int numberOfFlights = 2;

	public static void main(String[] args) {
		//staticTest();
		playMenu();
	}

	public static void playMenu() {
		boolean loop = true;
		while (loop == true) {
			Print.print("Welcome to Java-Flight-Simulator 1.1 Home Premium! \n"
					+ "--------------------------------- \n"
					+ "Please make a choice: \n"
					+ "1) To start your next testflight. \n"
					+ "2) To End the Programm. \n");
			int selection = readInt();
			switch (selection) {

			case 1:
				enterFlightRoute();
				loop = false;
				break;
			case 2:
				Print.print("Thank you for using Java-Flight-Simulator 1.1 Home Premium!");
				loop = false;
				break;

			default:
				Print.print("You did nocht have the choice to do this! This was bad and you should feel bad! (V)_(;,,;)_(V) \n");
				break;

			}
		}
	}

	public static void enterFlightRoute() {
		Print.print("Java-Flight-Simulator 1.1 Home Premium \n"
				+ "--------------------------------- \n"
				+ "Please enter your Flightroute: \n"
				+ "1) How far do you want to fly? \n"
				+ "Please note that this tiny plane can go as far as 100 kilometers. (Yeah, here at JFS 1.1. we use the metric system, even when we are airborne!)\n"
				+ "And to make it worth taking of you have to fly at lease 2 kilometers. And if you violate these terms you will burn in hell... or a simple exception will be thrown.\n"
				+ "Length of your flight: \n");
		int lengthOfTheRoute = readInt();

		Print.print("Java-Flight-Simulator 1.1 Home Premium \n"
				+ "--------------------------------- \n"
				+ "Please enter your Flightroute: \n"
				+ "2) Please tell me how low you want to get: \n"
				+ "You probably dont want to touch the ground, so you should fly at least 20 meters above the ground.\n"
				+ "And since this is no freakin' space ship you can only go as high as 9999 meters.\n"
				+ "Minimal altitude: \n");

		int minDistACL = readInt();

		Print.print("Java-Flight-Simulator 1.1 Home Premium \n"
				+ "--------------------------------- \n"
				+ "Please enter your Flightroute: \n"
				+ "3) Please tell me how high you want to get: \n"
				+ "You can't go higher than 9999 meters and obviously you have to go at least as high as you minimaly want to go. \n"
				+ "Maximal altitude: \n");

		int maxDistACL = readInt();

		for (int i = 1; i <= numberOfFlights; i++) {
			tpeLog += "Java-Flight-Simulator flight #: " + i + "\n";

			Print.print("Flight # " + i + "\n");
			try {
				tinyTpePlane = new TinyPlane(lengthOfTheRoute, minDistACL,maxDistACL);
				flightSimulator(lengthOfTheRoute);
			} catch (PlaneToLowException e) {
				tpeLog += e.toString();
			} catch (PlaneToHighException e) {
				tpeLog += e.toString();
			} catch (GeneralFlightSimulatorException e) {
				tpeLog += e.toString();
			} catch (NullPointerException e) {
				tpeLog += e.getMessage();
			}
			try{
			Print.print(tinyTpePlane.getTinyPlaneLog());
			}
				catch (NullPointerException e) {
					e.getMessage();
			}
			
		Print.print("Flight # " + i + " is finished." + "\n"); }
		
		Print.print("------------------------\n"+ "And this is the result of the flight. See how bad you messed up \n");
		Print.print(tpeLog);
	}

	public static void flightSimulator(int lengthOfTheFlight) throws NullPointerException, GeneralFlightSimulatorException{
		boolean loop = true;
		int distanceTravelled = 0;

		while (loop == true) {
			Print.print("Java-Flight-Simulator 1.1 Home Premium \n"
					+ tinyTpePlane.toString()
					+ "--------------------------------- \n"
					+ "Choose your next step: \n" + "1) Open the Doors. \n"
					+ "2) Close the doors. \n" + "3) Stop the plane! \n"
					+ "4) Fly the next km. \n" + "0) Stop the test!! \n");

			int selection = readInt();

			switch (selection) {
			case 1:
				try {
				tinyTpePlane.openDoors();
				if (distanceTravelled == lengthOfTheFlight) {
					loop = false;
				}
				break; }
				catch (GeneralFlightSimulatorException e) {
					tpeLog += e.toString(); }
				
			case 2:
				tinyTpePlane.closeDoors();
				break;

			case 3:
				try {
				tinyTpePlane.stop();
				}
				catch (GeneralFlightSimulatorException e) {
				tpeLog += e.toString(); }
				break; 

			case 4:
				try {
				Print.print("In case you want to fligh higher or lower, now is your choice: \n");
				String temp = readString();
				int value = Integer.parseInt(temp);
				tinyTpePlane.flyNextKilometer(value);
				distanceTravelled++;
				break; }
				catch (GeneralFlightSimulatorException e) {
					tpeLog += e.toString(); }
				
			case 0:
				Print.print("Flight aborted!");
				loop = false;
				tpeLog += "Flight aborted! \n";
				break;

			default:
				Print.print("Wrong input. Get it together man! \n");
				break;
			}
		}
	}

	public static void staticTest() {
		try {
			tinyTpePlane = new TinyPlane(10, 50, 500);

			tinyTpePlane.closeDoors();
			tinyTpePlane.flyNextKilometer(50);
			tinyTpePlane.flyNextKilometer(50);
			tinyTpePlane.flyNextKilometer(-50);
			tinyTpePlane.flyNextKilometer(80);
			tinyTpePlane.flyNextKilometer(50);
			tinyTpePlane.flyNextKilometer(100);
			tinyTpePlane.flyNextKilometer(0);
			tinyTpePlane.flyNextKilometer(0);
			tinyTpePlane.flyNextKilometer(50);
			tinyTpePlane.flyNextKilometer(50);
			// tinyTpePlane.flyNextKilometer(50);
			tinyTpePlane.stop();
			tinyTpePlane.openDoors();

		} catch (GeneralFlightSimulatorException e) {
			tinyTpePlane.pushToTinyPlaneLog(e.toString());
		}
		tinyTpePlane.printTinyPlaneLog();
	}

	
	
	// Helper function to read an integer input from keyboard.
	public static int readInt() {
		byte[] charArray = new byte[1000];
		int num = 0;
		try {
			System.in.read(charArray);
		} catch (IOException ioe) {
			System.out.println("Error on input!");
		} for (int t = 0; charArray[t] >= '0' && charArray[t] <= '9'; t++) {
			num = (num * 10) + charArray[t] - '0';
		} return (num);
	}

	// Helper function to read a string input from keyboard.
	public static String readString(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String inStr = "";
		try {
			inStr = reader.readLine();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return inStr;
	}

}
