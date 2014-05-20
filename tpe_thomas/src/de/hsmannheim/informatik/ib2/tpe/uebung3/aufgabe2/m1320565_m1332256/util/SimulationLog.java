package de.hsmannheim.informatik.ib2.tpe.uebung3.aufgabe2.m1320565_m1332256.util;

public class SimulationLog {
	
	private String simLog;
	private int failureCounter;
	
	public SimulationLog() {
		simLog = "Simulationlog: \n";
		failureCounter = 0;
	}

	public String getSimulationLog() {
		return simLog;
	}

	public void pushToLog(String simLog) {
		failureCounter++;
		this.simLog += failureCounter + ": " + simLog + "\n";
		
	}
	
	@Override
	public String toString() {
		if(failureCounter == 0){
		return "Failures: " + failureCounter + "\n" + this.simLog + "Well done, you didn't mess up.";
		}
		else{
		return "Failures: " + failureCounter + "\n" + this.simLog + "You messed up. You're probably dead...";
		}
	}
}
