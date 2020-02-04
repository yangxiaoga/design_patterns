package com.ethan.design.patterns.creater.factory;

import com.ethan.design.patterns.pojo.Car;

public class FactoryTest {
	
	public static void main(String[] args) {
		//getProductSimpleFactory();
		getProductFactoryMethod();
	}
	
	public static void getProductSimpleFactory() {
		Car bench = SimpleFactory.getCar("bench");
		Car audi = SimpleFactory.getCar("audi");
		bench.run();
		audi.run();
	}
	
	public static void getProductFactoryMethod(){
		FactoryMethod benchFactory = new BenchFactory();
		Car benchCar = benchFactory.createCar();
		benchCar.run();
		
		FactoryMethod audiFactory = new AudiFactory();
		Car audiCar = audiFactory.createCar();
		audiCar.run();
		
	}
}
