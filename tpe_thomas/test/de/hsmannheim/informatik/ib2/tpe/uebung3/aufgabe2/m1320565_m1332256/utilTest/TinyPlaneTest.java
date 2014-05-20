package de.hsmannheim.informatik.ib2.tpe.uebung3.aufgabe2.m1320565_m1332256.utilTest;

import static org.junit.Assert.*;
import org.junit.Test;
import de.hsmannheim.informatik.ib2.tpe.uebung3.aufgabe2.m1320565_m1332256.util.*;

public class TinyPlaneTest {

	public static TinyPlane TestPlane;
	public static Exception ex;

	/**
	 * Initialize a plane for tests.
	 * LengthOfTheRoute = 6 km
	 * minDistACL = 50 m
	 * maxDistACL = 200 m
	 * close the doors
	 * set Exception "ex" to null
	 * @throws GeneralFlightSimulatorException
	 */
	public void initializePlaneForTest() throws GeneralFlightSimulatorException {
		TestPlane = new TinyPlane(6,50,200);
		TestPlane.closeDoors(); 
		ex = null;
	}
	
	/**
	 * @Test
	 * Test the rules of flyNextKilometer
	 * 
	 * The general rules are:
	 * Don't fly with open doors.
	 * -100 < additionalHeight < 100
	 * actualHeight > 0
	 * distanceTraveled <= lengthOfTheRoute
	 * 
	 * Additional rules flying above the city:
	 * (distanceTraveled > 2km and lengthOfTheRoute-distanceTraveld > 2 km)
	 * minDistACL < actualHeight < maxDistACL
	 * 
	 */
	
	@Test
	public void testFlyNextKilometer() throws GeneralFlightSimulatorException{


		/*
		 *  test flyNextKilometer with open doors
		 */
		TestPlane = new TinyPlane(6,50,200);
		try {
			TestPlane.flyNextKilometer(50);
		} catch (Exception e) {
			ex = e;
		}
		assertTrue(ex instanceof GeneralFlightSimulatorException);
		assertEquals(0, TestPlane.getDistanceTraveled());
		assertEquals(0, TestPlane.getcurrentAltitudeAboveGround());


		// Tests the initializePlaneForTest-method.
		try {
			initializePlaneForTest();
		} catch (Exception e) {
			ex = e;
		}
		assertTrue(ex == null);
		assertEquals(0, TestPlane.getDistanceTraveled());
		assertEquals(0, TestPlane.getcurrentAltitudeAboveGround());


		/*
		 * Above the Airport.
		 * Fly with positive additionalHeight = 40
		 * actual distance above the ground < minDistACL
		 */
		initializePlaneForTest();
		try {
			TestPlane.flyNextKilometer(40);
		} catch (Exception e) {
			ex = e;
		}
		assertTrue(ex == null);
		assertEquals(1, TestPlane.getDistanceTraveled());
		assertEquals(40, TestPlane.getcurrentAltitudeAboveGround());


		/*
		 * Above the Airport.
		 * Fly with negative additionalHeight = -10
		 * actual distance above the ground < minDistACL
		 */
		initializePlaneForTest();
		try {
			TestPlane.flyNextKilometer(50);
			TestPlane.flyNextKilometer(-10);
		} catch (Exception e) {
			ex = e;
		}
		assertTrue(ex == null);
		assertEquals(2, TestPlane.getDistanceTraveled());
		assertEquals(40, TestPlane.getcurrentAltitudeAboveGround());


		/* 
		 * Above the Airport.
		 * Plane grounded = PlaneToLowException
		 */
		initializePlaneForTest();
		try {
			TestPlane.flyNextKilometer(-50);
		} catch (Exception e) {
			ex = e;
		}
		assertTrue(ex instanceof PlaneToLowException);
		assertEquals(0,TestPlane.getDistanceTraveled());
		assertEquals(0, TestPlane.getcurrentAltitudeAboveGround());

		/*
		 * Above the airport.
		 * additionalHeight > 100 = GeneralFlightException
		 */
		initializePlaneForTest();
		try {
			TestPlane.flyNextKilometer(110);
		} catch (Exception e) {
			ex = e;
		}
		assertTrue(ex instanceof GeneralFlightSimulatorException);
		assertEquals(0,TestPlane.getDistanceTraveled());
		assertEquals(0, TestPlane.getcurrentAltitudeAboveGround());


		/*
		 * Above the airport.
		 * additional Height < -100 = GeneralFlightException		 
		 */
		initializePlaneForTest();
		try {
			TestPlane.flyNextKilometer(-110);
		} catch (Exception e) {
			ex = e;
		}
		assertTrue(ex instanceof GeneralFlightSimulatorException);
		assertEquals(0,TestPlane.getDistanceTraveled());
		assertEquals(0, TestPlane.getcurrentAltitudeAboveGround());


		/*
		 * Above the city.
		 * actual distance above ground < minDistACL
		 * PlaneToLowException
		 */
		initializePlaneForTest();
		try {
			TestPlane.flyNextKilometer(50);
			TestPlane.flyNextKilometer(10);
			TestPlane.flyNextKilometer(-30);
		} catch (Exception e) {
			ex = e;
		}
		assertTrue(ex instanceof PlaneToLowException);
		assertEquals(2,TestPlane.getDistanceTraveled());
		assertEquals(60, TestPlane.getcurrentAltitudeAboveGround());


		/* 
		 * Above the city
		 * actual distance above ground > maxDistACL
		 * PlaneToHighException
		 */
		initializePlaneForTest();
		try {
			TestPlane.flyNextKilometer(100);
			TestPlane.flyNextKilometer(100);
			TestPlane.flyNextKilometer(10);
		} catch (Exception e) {
			ex = e;
		}
		assertTrue(ex instanceof PlaneToHighException);
		assertEquals(2,TestPlane.getDistanceTraveled());
		assertEquals(200, TestPlane.getcurrentAltitudeAboveGround());

		/*
		 * Above the city
		 * Plane grounded
		 * PlaneToLowException
		 */
		initializePlaneForTest();
		try {
			TestPlane.flyNextKilometer(50);
			TestPlane.flyNextKilometer(50);
			TestPlane.flyNextKilometer(-100);
		} catch (Exception e) {
			ex = e;
		}
		assertTrue(ex instanceof PlaneToLowException);
		assertEquals(2,TestPlane.getDistanceTraveled());
		assertEquals(100, TestPlane.getcurrentAltitudeAboveGround());


		/*
		 * Above the Airport - again
		 * actual distance above the ground < minDistACL
		 */
		initializePlaneForTest();
		try {
			TestPlane.flyNextKilometer(50);
			TestPlane.flyNextKilometer(0);
			TestPlane.flyNextKilometer(0);
			TestPlane.flyNextKilometer(0);
			TestPlane.flyNextKilometer(-10);
		} catch (Exception e) {
			ex = e;
		}
		assertTrue(ex == null);
		assertEquals(5, TestPlane.getDistanceTraveled());
		assertEquals(40, TestPlane.getcurrentAltitudeAboveGround());



		/* 
		 * Above the Airport - again
		 * actual distance above the ground > maxDistACL
		 */
		initializePlaneForTest();
		try {
			TestPlane.flyNextKilometer(100);
			TestPlane.flyNextKilometer(100);
			TestPlane.flyNextKilometer(0);
			TestPlane.flyNextKilometer(0);
			TestPlane.flyNextKilometer(10);
		} catch (Exception e) {
			ex = e;
		}
		assertTrue(ex == null);
		assertEquals(5, TestPlane.getDistanceTraveled());
		assertEquals(210, TestPlane.getcurrentAltitudeAboveGround());


		/*
		 * Above the Airport - again
		 * LengthOfTheRoute < distanceTraveled
		 * GeneralFlightException
		 */
		initializePlaneForTest();
		try {
			TestPlane.flyNextKilometer(50);
			TestPlane.flyNextKilometer(50);
			TestPlane.flyNextKilometer(0);
			TestPlane.flyNextKilometer(0);
			TestPlane.flyNextKilometer(0);
			TestPlane.flyNextKilometer(0);
			TestPlane.flyNextKilometer(50);
		} catch (Exception e) {
			ex = e;
		}
		assertTrue(ex instanceof GeneralFlightSimulatorException);
		assertEquals(6, TestPlane.getDistanceTraveled());
		assertEquals(100, TestPlane.getcurrentAltitudeAboveGround());

	}
}
