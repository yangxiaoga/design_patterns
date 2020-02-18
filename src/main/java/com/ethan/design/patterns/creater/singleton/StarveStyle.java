package com.ethan.design.patterns.creater.singleton;
/**
 * 饿汉式单例模式
 * 饿汉模式中，static变量会在类装载时初始化，此时不会涉及多个线程对象
 * 访问该对象的问题。虚拟机保证只会装载一次该类，肯定不会发生并发访问的
 * 问题。因此可以省略synchronized关键字
 * 问题：如果只是加载本类，而不是调用getInstance,甚至永远没有调用，则
 * 会造成资源浪费。
 * 
 * 饿汉模式的典型实例：Java中的Runtime类
 */
public class StarveStyle {
	
	/** 类初始化时，立即加载 */
	private static StarveStyle instance = new StarveStyle();
	
	/* 私有构造器 */
	private StarveStyle(){}
	public static StarveStyle getInstance(){
		return instance;
	}
}
