package com.ethan.design.patterns.creater.create;

/**
 * 轨道舱 
 */
public class OrbitalModule {
	
	private String name;
	
	public OrbitalModule(String name) {
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
		return "OrbitalModule [name=" + name + "]";
	}
	
}
