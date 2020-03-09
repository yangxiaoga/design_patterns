package com.ethan.design.java.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch
 * 
 * t2进入
 * 当前线程：t1添加了一个元素
 * 当前线程：t1添加了一个元素
 * 当前线程：t1添加了一个元素
 * 当前线程：t1添加了一个元素
 * 当前线程：t1添加了一个元素
 * 已经发出通知
 * Exception in thread "t2" 当前线程：t1添加了一个元素
 * 当前线程：t2收到通知线程停止
 * java.lang.RuntimeException
 *	at com.ethan.design.java.thread.CountDownLatchNotify$2.run(CountDownLatchNotify.java:58)
 *	at java.lang.Thread.run(Thread.java:748)
 * 当前线程：t1添加了一个元素
 * 当前线程：t1添加了一个元素
 * 当前线程：t1添加了一个元素
 * 当前线程：t1添加了一个元素
 * 
 * 【应用】
 * 	客户端连接，如Zookeeper
 */
public class CountDownLatchNotify {
	private volatile static List<String> list = new ArrayList<String>();
	
	public void addStr() {
		list.add("someStr");
	}
	public int size() {
		return list.size();
	}
	
	public static void main(String[] args) {
		
		final CountDownLatchNotify cdln = new CountDownLatchNotify();
		final CountDownLatch cdl = new CountDownLatch(1);//初始化为1
		
		Thread t1 =new Thread(new Runnable() {

			public void run() {
				try{
					for(int i = 0; i < 10; i++) {
						cdln.addStr();
						System.out.println("当前线程："+ Thread.currentThread().getName()+"添加了一个元素");
						Thread.sleep(500);
						if (cdln.size() == 5) {
							System.out.println("已经发出通知");
							cdl.countDown(); //size==5时，直接发出通知
						}
					}
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		},"t1");
		Thread t2 =new Thread(new Runnable() {

			public void run() {
			
					if (cdln.size() != 5) {
						try{
							System.out.println("t2进入");
							cdl.await();//size ！=5 阻塞;==5时，会接收到通知
						}catch(InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println("当前线程："+ Thread.currentThread().getName()+"收到通知线程停止");
					throw new RuntimeException();
				
			}
			
		},"t2");
		
		t2.start();
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.start();
	}
}
