package de.hsmannheim.informatik.ib2.tpe.uebung3.aufgabe2.m1320565_m1332256.util;

public class TinyPlane implements IPlane {

	private int currentAltitudeAboveGround;
	private int distanceTraveled;
	private boolean doorsClosed;
	private boolean finished;
	private boolean grounded;
	private boolean stopped;
	private FlightRoute tinyPlaneRoute;
	private SimulationLog tinyPlaneLog;

	/*
	 *  minAltACL = minimal altitude above city level
	 *  maxAltACL = maximal altitude above city level
	 */
	
	
	/**
	 * Constructor setting lengthOfTheRoute, minAltACL, maxAltACL to standard values if no parameters want to be chosen.
	 * lengthOfTheRoute = 10, minAltACL = 50, maxAltACL = 1000
	 * Every plane has its own log.
	 */
	public TinyPlane() throws GeneralFlightSimulatorException {
		
		this.tinyPlaneLog = new SimulationLog();
		currentAltitudeAboveGround = 0;
		doorsClosed = false;
		finished = false;
		grounded = true;
		stopped = true;
		distanceTraveled = 0;
		this.tinyPlaneRoute = new FlightRoute(10,50,1000);
		checkStatus();
	}

	/**
	 * Construcotr able to handle parameters.
	 * @param 2 < lengthOfTheRoute < 100
	 * @param 19 < minAltACL < 999
	 * @param 20 < maxDisACL < 10000
	 * minAltACL < maxAltACL
	 * @throws GeneralFlightSimulatorException
	 */
	
	public TinyPlane(int lengthOfTheRoute, int minAltACL, int maxDisACL) throws GeneralFlightSimulatorException {
		
		this.tinyPlaneLog = new SimulationLog();
		currentAltitudeAboveGround = 0;
		doorsClosed = false;
		finished = false;
		grounded = true;
		stopped = true;
		distanceTraveled = 0;
		this.tinyPlaneRoute = new FlightRoute(lengthOfTheRoute, minAltACL,maxDisACL);
		checkStatus();
	}

	/**
	 * Opens the door of the plane it the plane is stopped an grounded.
	 * @throws GeneralFlightSimulatorException
	 */
	 @Override
	public void openDoors() throws GeneralFlightSimulatorException {

		if (stopped && grounded) {
			doorsClosed = false;
		} else {
			tinyPlaneLog.pushToLog("openDoorFailure at km: " + distanceTraveled);
			throw new GeneralFlightSimulatorException("openDoorFailure at km: " + distanceTraveled);
		}
		checkStatus();
	}

	@Override
	/**
	 * Closes the doors of the plane.
	 */
	public void closeDoors() {
		doorsClosed = true;
		checkStatus();

	}

	/**
	 * Checks if the plane is grounded and if the route is finished.
	 */
	private void checkStatus() {
		if (currentAltitudeAboveGround == 0) {
			grounded = true;
		}
		if (distanceTraveled == tinyPlaneRoute.getLengthOfTheRoute()) {
			finished = true;
		}
	}

	/**
	 * Stops the plane if the route is finished and the plane is grounden.
	 * @throws GeneralFlightSimulatorException
	 */
	@Override
	public void stop() throws GeneralFlightSimulatorException {

		if (finished && grounded) {
			stopped = true;
		} else {
			tinyPlaneLog.pushToLog("stopFailure at km: " + distanceTraveled);
			throw new GeneralFlightSimulatorException("stopFailure at km: " + distanceTraveled);
		}
		checkStatus();
	}

	/**
	 * Lets the plane fly the next kilometer of its route.
	 * Does not let it do so if:
	 * - The route is finished
	 * - The doors are open
	 * - The rules for flying over the airport or the city are violated
	 * @throws GeneralFlightSimulatorException
	 */
	@Override
	public void flyNextKilometer(int additionalHeight) throws GeneralFlightSimulatorException {
		// if traveledDistance == lengthOfTheRoute
		if (finished) {
			tinyPlaneLog.pushToLog("flyNextKilometer failure - already finished");
			throw new GeneralFlightSimulatorException("flyNextKilometer failure - already finished");
		}
		// Don't fly with open doors!
		if (!doorsClosed) {
			tinyPlaneLog.pushToLog("flyNextKilometer failure - Doors are opened");
			throw new GeneralFlightSimulatorException("flyNextKilometer failure - Doors are opened");
		}

		// Plane is above the airport
		if (distanceTraveled < 2 || tinyPlaneRoute.getLengthOfTheRoute() - distanceTraveled <= 2) {
			// Checks the rules above the airport and fly one km.
			if (checkAboveAirport(additionalHeight)) {
				distanceTraveled++;
				currentAltitudeAboveGround += additionalHeight;
				stopped = false;
			} else {
				tinyPlaneLog.pushToLog("flyNextKilometer above the airport failure at km: " + distanceTraveled);
				throw new GeneralFlightSimulatorException("flyNextKilometer above the airport failure at km: " + distanceTraveled);
			}
			// Plane is above the City
			// Checks the rules above the city and fly one km
		} else if (checkAboveCity(additionalHeight)) {
			distanceTraveled++;
			currentAltitudeAboveGround += additionalHeight;
			stopped = false;
		} else {
			tinyPlaneLog.pushToLog("flyNextKilometer above the city failure at km : " + distanceTraveled);
			throw new GeneralFlightSimulatorException("flyNextKilometer above the city failure at km : " + distanceTraveled);
		}
		// check the actual status of the plane after flying the next steps.
		checkStatus();

	}

	/**
	 * Checks if the plane is allowed in the given altitude above the airport. 
	 * It has to be at least 0 meters high and it cannot rise or fall more than 100 meters.
	 * @param additionalHeight
	 * @return
	 * @throws GeneralFlightSimulatorException
	 * @throws PlaneToLowException
	 */
	// Checks the additional height difference
	private boolean checkAboveAirport(int additionalHeight) throws GeneralFlightSimulatorException, PlaneToLowException {
		if (currentAltitudeAboveGround + additionalHeight < 0) {
			tinyPlaneLog.pushToLog("Plane grounded at km: " + distanceTraveled  + " additional Height: " + additionalHeight);
			throw new PlaneToLowException("Plane grounded at km: " + distanceTraveled  + " additional Height: " + additionalHeight);
		}
		if (additionalHeight > 100 || additionalHeight < -100) {
			tinyPlaneLog.pushToLog(" additionalHeightAboveCityFailure at km: " + distanceTraveled + " additional Height: " + additionalHeight);
			throw new GeneralFlightSimulatorException(" additionalHeightAboveCityFailure at km: " + distanceTraveled + " additional Height: " + additionalHeight);
		}
		return true;
	}

	/**
	 * Checks if the plane is allowed in the given altitude above the city. 
	 * It has to be at least 0 meters high and it cannot rise or fall more than 100 meters.
	 * Also cannot be to low or to high above the city. This will be given by the route.
	 * @param additionalHeight
	 * @return
	 * @throws GeneralFlightSimulatorException
	 * @throws PlaneToLowException
	 * @throws PlaneToHighException
	 */
	// Checks the additional height difference
	// and the minAltACL / maxAltACL
	private boolean checkAboveCity(int additionalHeight) throws GeneralFlightSimulatorException, PlaneToLowException, PlaneToHighException {
		if (currentAltitudeAboveGround + additionalHeight < 0) {
			tinyPlaneLog.pushToLog("Plane grounded at km: " +distanceTraveled  + " additional Height: " + additionalHeight);
			throw new PlaneToLowException("Plane grounded at km: " +distanceTraveled  + " additional Height: " + additionalHeight);
		}
		if (additionalHeight > 100 || additionalHeight < -100) {
			tinyPlaneLog.pushToLog("additionalHeighAboveCityFailure at km: " + distanceTraveled + " additional Height: " + additionalHeight);
			throw new GeneralFlightSimulatorException("additionalHeighAboveCityFailure at km: " + distanceTraveled + " additional Height: " + additionalHeight);
		}
		if ((currentAltitudeAboveGround + additionalHeight) < tinyPlaneRoute.getMinAltitudeAboveTheCity()) {
			tinyPlaneLog.pushToLog(" additionalHeightAboveCityFailure at km: " + distanceTraveled + "additionalHeigh: " + additionalHeight);
			throw new PlaneToLowException(" additionalHeightAboveCityFailure at km: " + distanceTraveled + "additionalHeigh: " + additionalHeight);
		}
		if ((currentAltitudeAboveGround + additionalHeight) > tinyPlaneRoute.getMaxAltitudeAboveTheCity()) {
			tinyPlaneLog.pushToLog(" additionalHeightAboveCityFailure at km: " + distanceTraveled + "additionalHeigh: " + additionalHeight);
			throw new PlaneToHighException(" additionalHeightAboveCityFailure at km: " + distanceTraveled + "additionalHeigh: " + additionalHeight);
		}
		return true;
	}
	
	
	@Override
	public String toString() {
		String returnString = "";
		returnString += "------- Flight status: -----------\n"
				+ "------------------------------------ \n"
				+ "lengthOfTheRoute: " + this.tinyPlaneRoute.getLengthOfTheRoute() + "\n"
				+ "minimal distance above the city: " + this.tinyPlaneRoute.getMinAltitudeAboveTheCity() + "\n"
				+ "maximal distance above the city: " + this.tinyPlaneRoute.getMaxAltitudeAboveTheCity() + "\n"
				+ "currentAltitudeAboveGround: " + currentAltitudeAboveGround + "\n"
				+ "doorsClosed: " + doorsClosed + "\n"
				+ "Plane is stopped: " + stopped + "\n"
				+ "distance traveled: " + distanceTraveled + "\n";
		return returnString;
	}
	
	
	public int getDistanceTraveled() {
		return distanceTraveled;
	}
	
	public int getcurrentAltitudeAboveGround() {
		return this.currentAltitudeAboveGround;
	}
	
	public void pushToTinyPlaneLog(String log) {
		this.tinyPlaneLog.pushToLog(log);
	}
	
	public String getTinyPlaneLog() {
		return this.tinyPlaneLog.toString();
	}
	
	public void printTinyPlaneLog() {
		Print.print(tinyPlaneLog.toString());
	}

}
