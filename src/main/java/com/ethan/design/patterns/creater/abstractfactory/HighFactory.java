package com.ethan.design.patterns.creater.abstractfactory;

public class HighFactory implements AbstractFactory{

	public Engine createEngine() {
		return new HighEngine();
	}

	public Tyre createTyre() {
		return new HighTyre();
	}

	public Seat createSeat() {
		return new HighSeat();
	}

}
