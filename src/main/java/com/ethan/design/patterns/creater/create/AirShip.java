package com.ethan.design.patterns.creater.create;

/**
 * 宇宙飞船
 */
public class AirShip {
	
	private OrbitalModule orbitalModule;//轨道舱模块
	
	private Engine engine; //发动机模块
	
	private EscapeTower escapeTower; //逃逸仓

	public OrbitalModule getOrbitalModule() {
		return orbitalModule;
	}

	public void setOrbitalModule(OrbitalModule orbitalModule) {
		this.orbitalModule = orbitalModule;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public EscapeTower getEscapeTower() {
		return escapeTower;
	}

	public void setEscapeTower(EscapeTower escapeTower) {
		this.escapeTower = escapeTower;
	}

	@Override
	public String toString() {
		return "AirShip [orbitalModule=" + orbitalModule + ", engine=" + engine + ", escapeTower=" + escapeTower + "]";
	}
	
}
