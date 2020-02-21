package com.ethan.design.patterns.creater.prototype;

import java.util.Date;

/**
 * 如果需要短时间创建大量对象
 * 并且new的过程比较耗时，则可以
 * 考虑原型模式
 */
public class CloneTest {
	public static void main(String[] args) throws CloneNotSupportedException {
		Sheep sheep = new Sheep("Duoli", new Date());
		Sheep clone = (Sheep) sheep.clone();
		System.out.println("original: " + sheep.toString()+ " clone: "+ clone.toString());
		System.out.println("origin==new?: "+(sheep==clone));//FALSE
		
		/** 如果为浅复制则为TRUE，如果为深复制，则为FALSE */
		System.out.println("originDATE==newDATE?: "+(sheep.getBirthday()==clone.getBirthday()));
		
	}
}
