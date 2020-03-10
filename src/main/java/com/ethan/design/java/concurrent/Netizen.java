package com.ethan.design.java.concurrent;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 模拟网民
 * 实现Delayed的目的是用于DelayQueue,模拟下机的剩余时间
 *
 */
public class Netizen implements Delayed{
	
	private String id;  //身份证号
	private String name;//姓名
	private long remainTime;//剩余时间

	 /**  
	 * 比较与旧的时间的大小，
	 * @param d 旧的对象
	 * @return 比较结果，如果大于则返回1，否则返回0
	 */
	public int compareTo(Delayed d) {
		Netizen n = (Netizen)d;
		long result = this.getDelay(TimeUnit.SECONDS)- n.getDelay(TimeUnit.SECONDS);
		return result > 0 ? 1: 0;
	}
	
	/** 剩余时间 */
	public long getDelay(TimeUnit unit) {
		return remainTime - System.currentTimeMillis();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getRemainTime() {
		return remainTime;
	}

	public void setRemainTime(long remainTime) {
		this.remainTime = remainTime;
	}

	public Netizen(String id, String name, long remainTime) {
		super();
		this.id = id;
		this.name = name;
		this.remainTime = remainTime+System.currentTimeMillis();//加系统时间的目的是便于后续方法的比较
	}
}
