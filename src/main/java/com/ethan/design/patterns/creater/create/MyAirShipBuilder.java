package com.ethan.design.patterns.creater.create;
/**
 * 以后学习XML解析中，JDOM库中的类，DomBuilder,SaxBuilder
 */
public class MyAirShipBuilder implements AirShipBuilder{

	public Engine buildEngine() {
		//也可以使用工厂模式来创建，如发动机的工厂，通过工厂获取
		return new Engine("我的发动机");
	}

	public OrbitalModule buildOrbitalModule() {
		return new OrbitalModule("我的轨道舱");
	}

	public EscapeTower buildEscapeTower() {
		return new EscapeTower("我的逃逸塔");
	}
}
