package com.ethan.design.patterns.creater.factory;

import com.ethan.design.patterns.pojo.Car;

/**
 * 工厂方法模式
 * 创建接口，由具体的工厂实现该接口
 * 工厂方法模式，从复杂度上来说比简单工厂模式要复杂
 * 但是其满足开闭原则，对扩展开放
 */
public interface FactoryMethod {
	Car createCar();
}
