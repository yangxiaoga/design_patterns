package com.ethan.design.patterns.creater.create;

/**
 * 逃逸塔
 */
public class EscapeTower {
	
	private String name;
	
	public EscapeTower(String name) {
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
		return "EscapeTower [name=" + name + "]";
	}
	
}
