package com.ethan.design.java.thread;

public class Player implements Runnable{
	
	private Movie movie;
	
	Player(Movie movie) {
		this.movie = movie;
	}

	public void run() {
		for(int i=0; i<20; i++) {
			if (i%2 == 0) {
				try {
					movie.play("左边青龙！");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}else{
				try {
					movie.play("右边白虎！");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
