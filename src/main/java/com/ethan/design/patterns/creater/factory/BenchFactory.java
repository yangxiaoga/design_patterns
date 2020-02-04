package com.ethan.design.patterns.creater.factory;

import com.ethan.design.patterns.pojo.Bench;
import com.ethan.design.patterns.pojo.Car;

public class BenchFactory implements FactoryMethod{

	public Car createCar() {
		return new Bench();
	}

}
