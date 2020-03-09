package com.ethan.design.java.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程间通信
 * 
 *t2进入
 *当前线程：t1添加了一个元素
 *当前线程：t1添加了一个元素
 *当前线程：t1添加了一个元素
 *当前线程：t1添加了一个元素
 *当前线程：t1添加了一个元素
 *已经发出通知
 *当前线程：t1添加了一个元素
 *当前线程：t1添加了一个元素
 *当前线程：t1添加了一个元素
 *当前线程：t1添加了一个元素
 *当前线程：t1添加了一个元素
 *当前线程：t2收到通知线程停止
 *Exception in thread "t2" java.lang.RuntimeException
 *	at com.ethan.design.java.thread.WaitAndNotify$2.run(WaitAndNotify.java:61)
 *	at java.lang.Thread.run(Thread.java:748)
 *
 * 存在的问题：notify并不释放锁，所以即使发出通知，t2获取不到锁，同样无法继续执行，直到t1释放锁
 */
public class WaitAndNotify {
	
	private volatile static List<String> list = new ArrayList<String>();
	
	public void addStr() {
		list.add("someStr");
	}
	public int size() {
		return list.size();
	}
	
	public static void main(String[] args) {
		
		final WaitAndNotify wan = new WaitAndNotify();
		final Object lock = new Object();
		
		Thread t1 =new Thread(new Runnable() {

			public void run() {
				try{
					synchronized(lock) {
						for(int i = 0; i < 10; i++) {
							wan.addStr();
							System.out.println("当前线程："+ Thread.currentThread().getName()+"添加了一个元素");
							Thread.sleep(500);
							if (wan.size() == 5) {
								lock.notify();//不释放锁
								System.out.println("已经发出通知");
							}
						}
					}
					
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		},"t1");
		Thread t2 =new Thread(new Runnable() {

			public void run() {
				synchronized(lock) {
					if (wan.size() != 5) {
						try{
							System.out.println("t2进入");
							lock.wait();//释放锁
						}catch(InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println("当前线程："+ Thread.currentThread().getName()+"收到通知线程停止");
					throw new RuntimeException();
				}
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
