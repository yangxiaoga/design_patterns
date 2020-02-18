package com.ethan.design.java.thread;

/**
 * 生产者，消费者 
 * 先生产，再消费
 */
public class ProviderConsumer {
	public static void main(String[] args) {
		Movie movie = new Movie("Smooth");
		Thread t1 = new Thread(new Player(movie));
		Thread t2 = new Thread(new Watcher(movie));
		t1.start();
		t2.start();
	}

}
