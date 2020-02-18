package com.ethan.design.java.thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 任务调度 
 */
public class TimerAndTask {
	public static void main(String[] args) {
		task();
	}

	public static void task() {
		Timer timer = new Timer();
		TimerTask task = new Task();
		//任务，第一次执行，间隔
		timer.schedule(task, 1000, 1000);
		
	}
}
