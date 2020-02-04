package com.ethan.design.patterns.creater.factory;

import com.ethan.design.patterns.pojo.Audi;
import com.ethan.design.patterns.pojo.Car;

public class AudiFactory implements FactoryMethod{

	public Car createCar() {
		return new Audi();
	}

}
