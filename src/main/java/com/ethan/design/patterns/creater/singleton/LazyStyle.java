package com.ethan.design.patterns.creater.singleton;

import java.io.Serializable;

/**
 * 懒汉式的单例模式 
 * 真正使用的时候才会加载
 * 资源的利用率变高，但是每次调用getInstance方法都需要同步
 * 并发效率较低
 * 
 */
public class LazyStyle implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private static int count = 0;
	private static LazyStyle instance;
	
	private LazyStyle(){
		synchronized(LazyStyle.class) {
			if (count >0) {
				throw new RuntimeException("多实例异常");
			}
			count ++;
		}
		
	}
	
	public static synchronized LazyStyle getInstance(){
		if (instance ==null) {
			instance = new LazyStyle();
		}
		return instance;
		
	}
	/** 防止反序列化漏洞 ，反序列化时直接调用该方法，而不需要生成新的对象*/
	private Object readResolve() {
		return instance;
	}
}
