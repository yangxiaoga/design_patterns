package com.ethan.design.java.thread;

public class Watcher implements Runnable{
	
	private Movie movie;
	
	public Watcher(Movie movie){
		this.movie = movie;
	}

	public void run() {
		for(int i=0;i <20;i++) {
			try {
				movie.watch();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
