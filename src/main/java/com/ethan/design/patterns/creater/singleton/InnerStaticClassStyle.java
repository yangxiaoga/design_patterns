package com.ethan.design.patterns.creater.singleton;

/**
 * 静态内部类的实现 
 * 外部类没有static属性，不会像饿汉式那样立即加载对象
 * 只有真正调用getInstance，才会加载静态内部类，加载类时是线程安全的
 * instance是static final 类型，保证内存中只有一个这样的实例存在，
 * 而且只能被赋值一次，从而保证线程的安全性
 * 兼备了高并发调用和延迟加载的优势
 */
public class InnerStaticClassStyle {
	
	
	private static class InnerClass{
		private static final InnerStaticClassStyle instance = new InnerStaticClassStyle();
	}
	
	private InnerStaticClassStyle(){}
	
	public static InnerStaticClassStyle getInstance() {
		return InnerClass.instance;
	}
}
