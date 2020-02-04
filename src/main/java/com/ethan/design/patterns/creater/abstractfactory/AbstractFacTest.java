package com.ethan.design.patterns.creater.abstractfactory;

public class AbstractFacTest {
	public static void main(String[] args) {
		AbstractFactory factory = new HighFactory();
		Engine engine = factory.createEngine();
		Tyre tyre = factory.createTyre();
		Seat seat = factory.createSeat();
		engine.start();
		tyre.rotate();
		seat.support();
		
	}

}
