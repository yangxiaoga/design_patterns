package com.ethan.design.java.list;


/**
 * SelfImplArrayList
 * 自己实现的ArrayList
 */
public class SelfImplArrayList {
	
	/** 元素 */
	private Object[] elementData;
	
	/** 元素的数量 */
	private int size;
	
	/** 默认的长度 */
	private static final int DEFAULT_CAPACITY = 10;
	
	/**
	 * 默认构造函数
	 */
	public SelfImplArrayList() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * 可指定长度的构造函数
	 * @Param capacity 长度
	 */
	public SelfImplArrayList(int capacity) {
		if (capacity < 0 ) {
			throw new RuntimeException("不合法的数目");
		}
		elementData = new Object[capacity];
	}
	
	
	/**
	 * 添加元素
	 * @param object 被添加的元素
	 * @return void
	 */
	public void add(Object object ) {
		if (size == elementData.length) {//扩容
			Object[] newArray = new Object[size*2+2];
			System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			elementData = newArray;
		}
		elementData[size++] = object;
	}
	
	/**
	 * 获取元素
	 * @param index 要获取的元素的下标
	 * @return 指定下标的元素
	 * @throws Exception 
	 */
	public Object get(int index) throws Exception {
		if (index <0 || index >= size) {
			throw new Exception("下标不合法");
		}
		return elementData[index];
	}
	
	/**
	 * 删除指定的下标对象
	 * @param index 移除元素的下标
	 * @throws Exception 
	 */
	public void remove(int index) throws Exception {
		if (index <0 || index >= size) {
			throw new Exception("下标不合法");
		}	
		
		int length = size - index -1;
		System.arraycopy(elementData, index + 1, elementData, index, length);
		elementData[--size] = null;
		System.out.println("remove!");
		
	}
	
	/**删除指定元素的对象
	 * 只删除找到的第一个元素
	 * @param o 被移除的元素
	 * @throws Exception
     */
	public boolean remove(Object o) throws Exception {
		if (o == null) {
			for(int i = 0; i< elementData.length; i++) {
				if (elementData[i] == null) {
					remove(i);
					return true;
				}
			}
		}else {
			for(int i=0; i<elementData.length; i++) {
				if (o.equals(elementData[i])) {
					remove(i);
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 替换指定位置的元素 
	 * @param index 需要替换元素的下标
	 * @param o 需要被替换的元素的替换值
	 * @return 被替换的元素
	 * 
	 */
	public Object set(int index, Object o) {
		//checkIndexv
		elementData[index] = o;
		return elementData[index];
		
	}
	
	/**
	 * 返回长度
	 * @return 列表长度
	 */
	public int size() {
		return this.size;
	}
	
	/** 
	 * 判断是否为空
	 * 为空返回true
	 */
	public boolean isEmpty(){
		return size == 0;
	}
}
