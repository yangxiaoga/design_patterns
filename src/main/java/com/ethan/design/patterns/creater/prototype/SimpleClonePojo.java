package com.ethan.design.patterns.creater.prototype;

import java.io.Serializable;
import java.sql.Date;

public class SimpleClonePojo implements Cloneable,Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private Date birth;
	private int age;
	
@Override
protected Object clone() throws CloneNotSupportedException {
	return super.clone();
}	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public SimpleClonePojo(String name, Date birth, int age) {
		super();
		this.name = name;
		this.birth = birth;
		this.age = age;
	}
	@Override
	public String toString() {
		return "SimpleClonePojo [name=" + name + ", birth=" + birth + ", age=" + age + "]";
	}
	public SimpleClonePojo() {
		super();
	}
	
	
}
