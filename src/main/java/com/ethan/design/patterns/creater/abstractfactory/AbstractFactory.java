package com.ethan.design.patterns.creater.abstractfactory;


/**
 * 抽象工厂模式
 * 对于单一产品增加的无能为力，可以由简单工厂和工厂方法解决
 * 抽象工厂模式可以看做是产品族的生产，如发动机，座椅，轮胎
 * 高端发动机，高端座椅，高端轮胎是一个产品族
 * 中端发动机，中端座椅，中端轮胎是一个产品族
 * 低端发动机，低端座椅，低端轮胎是一个产品族
 * 
 * 举例说明：其中抽象工厂AbstractFacroty有三个方法：
 * 1、createEngine()
 * 2、createTyre()
 * 3、createSeat()
 * HighFacroty 高端工厂
 * MediumFacroty 中端工厂
 * LowFactory低端工厂 
 * 均实现AbstractFacroty接口
 * 
 * Engine 又有不同的实现类: LowEngine、MidiumEngine、HighEngine
 * Tyre 又有不同的实现类: LowTyre、MidiumTyre、HighTyre
 * Seat 又有不同的实现类: LowSeat、MidiumSeat、HighSeat
 * 
 * 
 */
public interface AbstractFactory {
   Engine createEngine();
   Tyre createTyre();
   Seat createSeat();
}
