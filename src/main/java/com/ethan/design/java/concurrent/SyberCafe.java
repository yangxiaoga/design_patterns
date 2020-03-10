package com.ethan.design.java.concurrent;

import java.util.concurrent.DelayQueue;

/**
 * 模拟网吧
 */
public class SyberCafe implements Runnable{
	
	private DelayQueue<Netizen> syberCafe = new DelayQueue<Netizen>();
	
	private boolean isRun = false;//营业状态

	public void run() {
		while(isRun) {
			try {
				//waiting if necessary until an element 
				//with an expired delay is available on this queue.
				Netizen n = syberCafe.take();
				leave(n);//下机
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	/** 上机 */
	public void use(Netizen n) {
		syberCafe.add(n); //put则需要等待空间可用
	}
	
	/**下机 */
	public void leave(Netizen n) {
		System.out.println("客户："+n.getName()+"下机，"+" 时间："+System.currentTimeMillis());
	}
	
	public static void main(String[] args) {
		SyberCafe sc = new SyberCafe();
		Thread t = new Thread(sc,"某网吧");
		sc.setRun(true);
		t.start();
		
		Netizen n1 = new Netizen("a1", "张三", 5*1000);//第三个参数只是剩余时间
		Netizen n2 = new Netizen("a2", "李四", 100000000*1000);
		Netizen n3 = new Netizen("a3", "王五", 15*1000);
		sc.use(n1);//上机
		sc.use(n2);
		sc.use(n3);
	}
	
	//是否营业
	public boolean isRun() {
		return isRun;
	}
	//设置营业状态
	public void setRun(boolean isRun) {
		this.isRun = isRun;
	}
}
