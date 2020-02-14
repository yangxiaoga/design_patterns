package com.ethan.design.patterns.creater.singleton;

/**
 * 双重检测锁式 
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
