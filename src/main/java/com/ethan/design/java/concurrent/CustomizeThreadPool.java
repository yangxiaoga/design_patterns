package com.ethan.design.java.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;

/**
 * 自定义线程池
 * 
 * 使用有界队列时，基于ThreadPoolExecutor，若有新的任务需要执行
 * 如果线程池实际线程数小于corePoolSize,则优先创建线程，若大于
 * corePoolSize,则会将任务加入队列，若队列已满，则在总线程数不大
 * 于maximumPoolSize的前提下，创建新的线程，若线程数大于maximumPoolSize,
 * 则执行拒绝策略，或其他自定义方式
 * 
 * 
 * 无界的任务队列时，
 * LinkedBlockingQueue,与有界队列相比，除非系统资源耗尽
 * 否则无界的任务队列，不存在入队失败的情况，当有新的任务
 * 到来，系统的线程数小于corePoolSize,则新建线程执行任务
 * 当达到corePoolSize后，就不会继续增加，若后续仍有新的
 * 任务加入，而没有空闲的线程资源，则任务直接进入队列等待
 * 若任务创建和处理的速度差异很大，无界队列会保持快速增长
 * 直到耗尽系统内存
 */
public class CustomizeThreadPool {
	
	
	public static ThreadPoolExecutor getThreadPoolExecutor() {
		return new ThreadPoolExecutor(
				1, 
				2, 
				60, 
				TimeUnit.SECONDS, 
				new ArrayBlockingQueue<Runnable>(3),//有界队列
	    		Executors.defaultThreadFactory(),new AbortPolicy());
	}
	public static void main(String[] args) {
		ThreadPoolExecutor tpe = getThreadPoolExecutor();
		for (int i=0; i < 5; i++) {
			tpe.execute(new Task(Integer.toString(i)));
		}
		tpe.shutdown();
	}
}




class CustomizedPolicy implements RejectedExecutionHandler{

	
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		//一般对于任务，不会拒绝，可以做成发http请求，把处理不了的
		//数据转给另一个服务器来处理
	}
	
}

class Task implements Runnable{
	private String id;
	public Task(String id) {
		this.id = id;
	}
	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("task: "+id+" finished");
	}
	
}