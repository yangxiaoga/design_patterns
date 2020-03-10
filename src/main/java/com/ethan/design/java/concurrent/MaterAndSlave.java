package com.ethan.design.java.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 模拟master分发 - slave处理，最终master汇总结果
 *
 */
public class MaterAndSlave {
	public static void main(String[] args) {
		Slave slave = new Slave();
		Master master = new Master(slave, 20);
		
		Random random = new Random();
		for (int i=0; i<100; i++) {
			master.commit(new Job(random.nextInt(),random.nextInt()));
		}
		master.execute();
		
		while(true) {
			if (master.done()) {
				System.out.println(master.getResult());
				break;
			}
		}
	}
}

class Master {
	
	/**任务队列，不需要阻塞，因为不是生产者消费者模式，有任务就分发，被取完则结束 */
	private ConcurrentLinkedQueue<Job> jobs = new ConcurrentLinkedQueue<Job>();
	
	/** Slave，取得job，并处理*/
	private Map<String, Thread> slaves = new HashMap<String,Thread>();
	
	/** result，结果，涉及到并发*/
	private ConcurrentHashMap<String,Integer> results = new ConcurrentHashMap<String,Integer>();
	
	public Master(Slave slave, int slaveNumber) {
		
		Slave s = slave;
		s.setJobs(jobs);
		s.setResults(results);
		
		String key;
		for (int i = 0; i < slaveNumber; i++) {
			key = "slave"+i;
			slaves.put(key, new Thread(s));//初始化slaveNumber个Slave线程，并存储
		}
	}
	
	public void commit(Job job) {//添加任务到任务队列
		jobs.add(job);
	}
	
	public void execute() {//执行Slave线程，处理任务
		for (Entry<String, Thread> entry: slaves.entrySet()) {
			entry.getValue().start();
		}
	}
	
	public boolean done() {//是否执行完毕
		for (Entry<String, Thread> entry: slaves.entrySet()) {
			if(entry.getValue().getState()!= Thread.State.TERMINATED){//判断处理job的线程是否全部结束，这里枚举单例可以用!=
				return false;
			}
		}
		return true;
	}
	
	//获取结果
	public int getResult() {
		Integer total = 0;
		for (Map.Entry<String, Integer> entry: results.entrySet()) {
			//将结果简单相加
			total += entry.getValue();
		}
		return total;
	}
}

/** 从 */
class Slave implements Runnable{
	private ConcurrentLinkedQueue<Job> jobs;//任务队列，最终赋值为master的任务队列
	private ConcurrentHashMap<String,Integer> results;//存储Job的执行结果
	
	public void run() {
		while(!jobs.isEmpty()) {//任务队列为空，则结束
			Job j = jobs.poll();
			System.out.println(j.toString());
			try {
				Thread.sleep(5*100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			results.put(Integer.toString(j.getId()), j.getPrice()); //j.getPrice()简化，这里可能会是一些处理操作
		}
	}
	
	public void setJobs(ConcurrentLinkedQueue<Job> jobs) {
		this.jobs = jobs;
	}
	public void setResults(ConcurrentHashMap<String, Integer> results) {
		this.results = results;
	}
}

/** 任务 */
class Job {
	private int id;
	private int price;
	public Job(int id, int price) {
		super();
		this.id = id;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Job [id=" + id + ", price=" + price + "]";
	}
}
