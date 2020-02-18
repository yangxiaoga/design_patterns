package com.ethan.design.java.thread;

import java.util.TimerTask;

public class Task extends TimerTask{

	private int count;
	@Override
	public void run() {
		System.out.println("task执行"+count++);
	}

}
