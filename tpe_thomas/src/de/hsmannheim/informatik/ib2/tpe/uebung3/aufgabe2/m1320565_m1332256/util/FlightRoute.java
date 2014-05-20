package de.hsmannheim.informatik.ib2.tpe.uebung3.aufgabe2.m1320565_m1332256.util;

public class FlightRoute {

	/**
	 * lengthOfTheRoute in kilometer.
	 *  min = 2 km; max = 100 km.
	 */
	private int lengthOfTheRoute;

	/**
	 * minAltitudeAboveTheCity in meter.
	 * min = 20 m; max = 9999 m.
	 */
	private int minAltitudeAboveTheCity;

	/**
	 *  maxAltitudeAboveTheCity in meter.
	 *  min = 21 m; max = 10000 m; bigger than minAltitudeAboveTheCity.
	 */
	private int maxAltitudeAboveTheCity;

	/**
	 * Creates a flight route. Parameters can be given.
	 * @param lengthOfTheRoute
	 * @param minAltitudeAboveTheCity
	 * @param maxAltitudeAboveTheCity
	 * @throws GeneralFlightSimulatorException
	 */
	public FlightRoute(int lengthOfTheRoute, int minAltitudeAboveTheCity, int maxAltitudeAboveTheCity) throws GeneralFlightSimulatorException {
			setLengthOfTheRoute(lengthOfTheRoute);
			setMinAltitudeAboveTheCity(minAltitudeAboveTheCity);
			setMaxAltitudeAboveTheCity(maxAltitudeAboveTheCity);

	}

	/**
	 * Gets length of the route.
	 * @return int
	 */
	public int getLengthOfTheRoute() {
		return lengthOfTheRoute;
	}

	/**
	 * Sets the length of the route within the rules.
	 * @param lengthOfTheRoute
	 * @throws GeneralFlightSimulatorException
	 */
	public void setLengthOfTheRoute(int lengthOfTheRoute) throws GeneralFlightSimulatorException {
		if (lengthOfTheRoute <= 1) {
			throw new GeneralFlightSimulatorException("lengthOfTheRouteFailure lengthOfTheRoute <= 1 km");
		} else if (lengthOfTheRoute > 100) {
			throw new GeneralFlightSimulatorException("lengthOfTheRouteFailure lengthOfTheRouteFailure > 100 km");
		} else {
			this.lengthOfTheRoute = lengthOfTheRoute;
		}
	}

	/**
	 * Gets the maximum altitude.
	 * @return int
	 */
	public int getMaxAltitudeAboveTheCity() {
		return maxAltitudeAboveTheCity;
	}

	/**
	 * Sets the maximum altitude above the city within the rules.
	 * @param maxAltitudeAboveTheCity
	 * @throws GeneralFlightSimulatorException
	 */
	public void setMaxAltitudeAboveTheCity(int maxAltitudeAboveTheCity) throws GeneralFlightSimulatorException {
		if (maxAltitudeAboveTheCity < 21) {
			throw new GeneralFlightSimulatorException("maxAltitudeAboveTheCityFailure maxAltitudeAboveTheCity < 21 m");
		} else if (maxAltitudeAboveTheCity > 10000) {
			throw new GeneralFlightSimulatorException("maxAltitudeAboveTheCityFailure maxAltitudeAboveTheCity > 10000 m");
		} else if (maxAltitudeAboveTheCity < this.getMinAltitudeAboveTheCity()) {
			throw new GeneralFlightSimulatorException("maxAltitudeAboveTheCityFailure maxAltitudeAboveTheCity < minAltitudeAboveTheCity");

		}
		this.maxAltitudeAboveTheCity = maxAltitudeAboveTheCity;
	}

	/**
	 * Gets the minimal altitude.
	 * @return int
	 */
	public int getMinAltitudeAboveTheCity() {
		return minAltitudeAboveTheCity;
	}

	/**
	 * Sets the minimal altitude above the city within the rules.
	 * @param minAltitudeAboveTheCity
	 * @throws GeneralFlightSimulatorException
	 */
	public void setMinAltitudeAboveTheCity(int minAltitudeAboveTheCity) throws GeneralFlightSimulatorException {
		if (minAltitudeAboveTheCity < 20) {
			throw new GeneralFlightSimulatorException("minAltitudeAboveTheCityFailure minAltitudeAboveTheCity < 20 m");
		} else if (minAltitudeAboveTheCity > 9999) {
			throw new GeneralFlightSimulatorException("minAltitudeAboveTheCityFailure minAltitudeAboveTheCity > 9999 m");
		} else {
			this.minAltitudeAboveTheCity = minAltitudeAboveTheCity;
		}
	}

}
