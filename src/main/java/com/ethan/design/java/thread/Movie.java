package com.ethan.design.java.thread;

public class Movie {
	
	private String pic;
	
	/**
	 * flag为true时，生产者生产，消费者等待，生产完成后，通知消费
	 * 否则，消费者消费，生产者等待，消费完后，通知生产
	 */
	private boolean flag = true;
	
	public Movie(String pic) {
		this.pic = pic;
	}
	
	public synchronized void  play(String s) throws InterruptedException {
		if (!flag) {//生产者等待
			this.wait();
		}
		Thread.sleep(500);
		//生产完毕
		this.pic = s;
		System.out.println("生产了："+pic);
		//通知消费
		this.notify();
		//生产者停下
		this.flag = false;
		
	}
	public synchronized void watch() throws InterruptedException {
		if(flag) {
			this.wait();
		}
		//开始消费
		Thread.sleep(500);
		System.out.println("消费了："+pic);
		//观看完,通知生产
		this.notifyAll();
		//消费停止
		this.flag = true;
	}

}
