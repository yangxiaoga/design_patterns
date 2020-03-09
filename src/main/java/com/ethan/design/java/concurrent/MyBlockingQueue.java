package com.ethan.design.java.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Administrator
 *
 */
public class MyBlockingQueue {
	private List<Object> list = new ArrayList<Object>();
	private AtomicInteger count = new AtomicInteger(0);
	
	private static final int QUEUE_MIN_SIZE = 0;
	
	private final int maxSize;
	
	/* 用于加锁 */
	private final Object lock = new Object();
	
	public MyBlockingQueue(int size) {
		this.maxSize = size;
	}
	
	public void put(Object o) {
		synchronized(lock) {
			while (count.get() == this.maxSize) {//队列已满，等待
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			list.add(o);
			count.incrementAndGet();
			lock.notify(); //唤醒另外一个线程
		}
	}
	
	public Object get() {
		Object o = null;
		synchronized(lock) {
			while(count.get() == QUEUE_MIN_SIZE) {//队列为空，等待
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			o = list.remove(0);
			count.decrementAndGet();
			
			lock.notify();
			return o;
		}
	}
	
	public static void main(String[] args) {
		
		final MyBlockingQueue queue = new MyBlockingQueue(5);
		queue.put("1a");
		queue.put("2b");
		queue.put("3c");
		queue.put("4d");
		queue.put("5e");
		
		Thread provider = new Thread(new Runnable(){
			public void run() {
				System.out.println("线程"+Thread.currentThread().getName()+"添加元素：");
				queue.put("provider 1");
				System.out.println("线程"+Thread.currentThread().getName()+"添加元素provider 1");
				queue.put("provider 2");
				System.out.println("线程"+Thread.currentThread().getName()+"添加元素provider 2");
			}
			
		},"provider");
		
		provider.start();
		
		Thread consumer = new Thread(new Runnable(){
			public void run() {
				Object ele1 = queue.get();
				System.out.println("线程"+Thread.currentThread().getName()+"移除元素"+ele1);
				Object ele2 = queue.get();
				System.out.println("线程"+Thread.currentThread().getName()+"移除元素"+ele2);
			}
			
		},"consumer");
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		consumer.start();
	}
}
