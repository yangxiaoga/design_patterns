package com.ethan.design.java.list;

public class NewLinkedList {
	
	private Node first;//第一个元素
	
	private Node last; //最后一个元素
	
	private int size;//大小
	
	public NewLinkedList() {}
	
	/**
	 * 添加元素 
	 * @param o 需要被添加的元素
	 */
	public void add(Object o ) {//小心空指针
		
		Node node = new Node();
		if (first == null) {
			first = node;
			first.setElement(o);
			first.setNext(null);
			first.setPrevious(null);
			last = first;//既是第一个，也是最后一个
		}else {
			node.setElement(o);
			node.setPrevious(last);
			node.setNext(null);
			last.setNext(node);
	        last= node;
		}
		size++;
	}
	
	/**
	 * 获取元素
	 * @param index 下标
	 */
	public Object get(int index) {
		checkIndex(index);
		int temp = index;
		Node current = first;
/*		if (current == null) {
			throw new RuntimeException("列表为空，无元素");
		}*/
		while (temp != 0) {//这里应该判断下标，如果超过一半的size,可以从后往前找
			current = current.getNext();
			temp--;
		}
		return current.element;
	}
	
	/** 
	 * 检查下标是否越界
	 * @param index 要检查的下标
	 */
	private void checkIndex(int index) {
		if (index < 0|| index >= size) {//=size，将列表为空也排除了
			throw new RuntimeException("下标不合法");
		}
	}
	
	
	/**
	 * set 
	 * @param index 设置的下标
	 * @param object 设置的对象
	 */
	public void set(int index, Object object) {
		checkIndex(index);
		Node current = first;
		if (first == null) {
			throw new RuntimeException("无法设置，列表为空");
		}
		for(int j=0; j<index; j++) {
			current = current.getNext();
		}
		current.setElement(object);
	}
	
	/**
	 * 移除元素
	 * @param index 移除的下标
	 */
	public void remove(int index) {
		checkIndex(index);
		Node current = first;
		if (first == null) {
			throw new RuntimeException("无法移除，列表为空");
		}
		for(int j=0; j<index; j++) {
			current = current.getNext();
		}
		if (current == last) {
			current.setNext(null);
			current.getPrevious().setNext(null);
			current.setPrevious(null);
			
		}
		else {
			Node up = current.getPrevious();
			Node down = current.getNext();
			up.setNext(down);
			down.setPrevious(up);
		}
		size--;
	}
	
	
	/**返回长度*/
	public int size() {
		return size;
	}
	
	
    class Node {//表示一个节点
    	private Node previous; //前一个节点
    	private Object element;//节点内容
    	private Node next;//后一个节点
    	
    	public Node() {
    		
    	}
		public Node(Node previous, Object element, Node next) {
			super();
			this.previous = previous;
			this.element = element;
			this.next = next;
		}
		public Node getPrevious() {
			return previous;
		}
		public void setPrevious(Node previous) {
			this.previous = previous;
		}
		public Object getElement() {
			return element;
		}
		public void setElement(Object element) {
			this.element = element;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
    }
}
