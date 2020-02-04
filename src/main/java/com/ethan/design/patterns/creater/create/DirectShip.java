package com.ethan.design.patterns.creater.create;

/** 飞行器组装 */
public interface DirectShip {
	/**
	 * 组装飞船对象
	 * @Param builder 构建类
	 */
    AirShip directShip();
}
