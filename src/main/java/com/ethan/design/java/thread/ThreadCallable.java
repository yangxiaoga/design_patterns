package com.ethan.design.java.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * 解决Thread无返回值，无发抛出异常
 */
public class ThreadCallable {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
    	ExecutorService service = Executors.newFixedThreadPool(2);//二个线程
		
		Race rabbit = new Race("乌龟", 3000);
		Race tortoise = new Race("兔子", 1000);
		
		Future<Integer> rabbitResult =  service.submit(rabbit);
		Future<Integer> tortoiseResult = service.submit(tortoise);
        
		Thread.sleep(10000);
		rabbit.setFlag(false);
		tortoise.setFlag(false);
		
		int num1 = rabbitResult.get();
        int num2 = tortoiseResult.get();
        System.out.println(rabbit.getName()+"跑了："+ num1 +"步");
        System.out.println(tortoise.getName()+"跑了："+ num2 +"步");
        service.shutdown();//停止
    }
}

/**
 * 实现Callable接口
 */
class Race implements Callable<Integer> {
	private String name;
	private int time;
	private boolean flag = true;
	private int steps = 0; //步数
	public Race(){}
	public Race(String name, int time){
		this.name = name;
		this.time = time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public Integer call() throws Exception {
		while(flag) {
			Thread.sleep(time);
			steps++;
		}
		return steps;
	}
}
