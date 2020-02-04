package com.ethan.design.patterns.creater.singleton;

/**
 * 双重检测锁式 
 * 由于虚拟机内部优化的问题，可能会出问题
 * 但在J2SE5.0中已经被修复，可以用volatile关键字保证多线程下的单例
 * 
 */
public class DoubleCheckLockStyle {
	private volatile static DoubleCheckLockStyle instance = new DoubleCheckLockStyle();
	private DoubleCheckLockStyle() {}
	public static DoubleCheckLockStyle getInstance() {
		if (instance == null) {
			synchronized(DoubleCheckLockStyle.class) {
				if (instance == null) {
						instance = new DoubleCheckLockStyle();
				}
			}
		}
		return instance;
	}
}
