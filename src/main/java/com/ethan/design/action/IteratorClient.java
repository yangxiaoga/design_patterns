package com.ethan.design.action;

import java.util.ArrayList;
import java.util.List;

/**
 * 迭代器模式
 *
 */
public class IteratorClient {

	public static void main(String[] args) {
		new IteratorClient().test();
	}
	void test(){
		
		List<Object> eles = new ArrayList<Object>();
		eles.add("121");eles.add("yifus");eles.add("b23d");
		
		Container c = new Container(eles);
		Iterat i = c.getIterator();
		while(i.hasNext()) {
			Object o = i.getCurrentObj();
			i.next();
			Pr.pr(o.toString());
			
		}
	}
}

/** 迭代器接口 */
interface Iterat {
	void first(); //将游标指向第一个元素
	void next();  //将游标指向下一个元素
	Object getCurrentObj();//获取当前游标指向的对象
	boolean hasNext();
	boolean isFirst();
	boolean isLast();
}


/** 聚合类，也可以称之为容器类 */
class Container {
	private List<Object> list = new ArrayList<Object>();//简单实现
	public Container() {
		super();
	}
	public Container(List<Object> list) {
		super();
		this.list = list;
	}
	/**获取迭代器*/
	public InnerItera getIterator() {
		return new InnerItera();
	}
	public void addObject(Object obj) {
		list.add(obj);
	}
	public void removeObject(Object obj) {
		list.remove(obj);
	}
	/**
	 * 用内部类实现迭代器
	 */
	private class InnerItera implements Iterat{
		private int cursor;
		public void first() {
			cursor = 0;
		}
		public void next() {
			if (cursor < list.size()) {
				cursor++;
			}
		}
		public boolean hasNext() {
			if (cursor < list.size()) {
				return true;
			}
			return false;
		}
		public boolean isFirst() {
			return cursor == 0;
		}
		public boolean isLast() {
			return cursor==(list.size()-1);
		}
		public Object getCurrentObj() {
			return list.get(cursor);
		}
	}
}

