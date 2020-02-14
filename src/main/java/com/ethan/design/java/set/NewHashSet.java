package com.ethan.design.java.set;

import java.util.HashMap;

/**
 * 自定义实现Set 
 */
public class NewHashSet<E> {
	private HashMap<E, Object> map;
	private static final Object PRESENT = new Object();
	private int size;
	
	public NewHashSet() {
		map = new HashMap<E, Object>();
	}
	
	public int size () {
		return size;
	}
	public void add(E o) {//元素不可重复，就是利用了Map,key不可重复
		Object tmp = map.put(o, PRESENT);
		if ((tmp != null)&& !tmp.equals(o)) {
			size ++ ;
		}
	}
}
