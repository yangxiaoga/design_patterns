package com.ethan.design.java.annotation;

@Table(value = "t_student")
public class Student {

	@StudentField(column="c_name", length=30, type="VARCHAR")
	private String name;
	
	@StudentField(column="n_age", length=10, type="INT")
	private int age;

	public Student() {
		
	}
	
	public Student(String name,  int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	

}
