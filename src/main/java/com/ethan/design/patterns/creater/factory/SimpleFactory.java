package com.ethan.design.patterns.creater.factory;

import com.ethan.design.patterns.pojo.Audi;
import com.ethan.design.patterns.pojo.Bench;
import com.ethan.design.patterns.pojo.Car;

/**
 * 简单工厂模式
 * 工厂模式实现了创建者和调用者的分离
 * 简单工厂的问题:无法保证在添加新的内容时，不修改原来的代码
 * 如：要添加其他车时，需要修改getCar方法中的代码，违反了开闭原则
 */
public class SimpleFactory {
	
	public static Car getCar(String type) {
		if ("audi".equals(type)) {
			return new Audi();
		}else if ("bench".equals(type)) {
			return new Bench();
		}else {
			throw new RuntimeException("无相关车辆");
		}
	}

}
