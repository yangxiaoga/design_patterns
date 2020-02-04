package com.ethan.design.patterns.creater.prototype;

import java.util.Date;

/**
 * 如果要克隆的话，必须要实现Cloneable接口
 * clone()方法存在于Object类中
 */
public class Sheep implements Cloneable{//1997英国的克隆羊，多利 
	private String name;
	private Date birthday;
	
	public Sheep(String name, Date birthday){
		this.name = name;
		this.birthday = birthday;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Sheep sheep = (Sheep)super.clone();
		//实现深克隆
		sheep.setBirthday((Date)sheep.getBirthday().clone());
		return sheep;
	}

	@Override
	public String toString() {
		return "Sheep [name=" + name + ", birthday=" + birthday + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
}
