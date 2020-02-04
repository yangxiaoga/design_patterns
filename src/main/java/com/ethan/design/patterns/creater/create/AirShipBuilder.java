package com.ethan.design.patterns.creater.create;

public interface AirShipBuilder {
	Engine buildEngine();//构建发动机
	OrbitalModule buildOrbitalModule();//构建轨道舱
	EscapeTower buildEscapeTower();//构建逃逸塔
}
