package com.ethan.design.patterns.creater.create;

/**
 * 飞船发动机
 */
public class Engine {
	
	private String name;
	
	public Engine(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Engine [name=" + name + "]";
	}
}
