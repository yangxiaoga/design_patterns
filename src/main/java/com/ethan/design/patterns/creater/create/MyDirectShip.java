package com.ethan.design.patterns.creater.create;

public class MyDirectShip implements DirectShip{

	private AirShipBuilder builder;
	
	public MyDirectShip(AirShipBuilder builder) {
		this.builder = builder;
	}
	
	
	public AirShip directShip() {
		Engine en = builder.buildEngine();
		OrbitalModule om = builder.buildOrbitalModule();
		EscapeTower et = builder.buildEscapeTower();
		
		AirShip ship = new AirShip();
		ship.setEngine(en);
		ship.setOrbitalModule(om);
		ship.setEscapeTower(et);
		return ship;
	}


	public AirShipBuilder getBuilder() {
		return builder;
	}


	public void setBuilder(AirShipBuilder builder) {
		this.builder = builder;
	}
	
}
