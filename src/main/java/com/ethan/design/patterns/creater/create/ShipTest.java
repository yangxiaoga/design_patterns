package com.ethan.design.patterns.creater.create;

public class ShipTest {
	public static void main(String[] args) {
		
		AirShipBuilder mfb = new MyAirShipBuilder();
		DirectShip ds = new MyDirectShip(mfb);
		AirShip ship = ds.directShip();
		System.out.println(ship);
	}

}
