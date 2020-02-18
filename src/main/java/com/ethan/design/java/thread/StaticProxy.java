package com.ethan.design.java.thread;

/**
 * 在Thread类中，有 实现Runnable接口，Thread类则类似以下Proxy的角色
 * 
 */
public class StaticProxy {
	public static void main(String[] args) {
		Marry you = new You();
		Marry weddingCompany = new Proxy(you);
		weddingCompany.marry();
	}

}

interface Marry {//结婚
	void marry();
}

//真实角色
class You implements Marry {

	public void marry() {
		System.out.println("你和嫦娥结婚啦！");
	}
}

/**代理角色,持有真实角色的引用*/
class Proxy implements Marry {
	private Marry obj; //真实的角色
	public Proxy() {
		
	}
	public Proxy(Marry obj) {
		super();
		this.obj = obj;
	}
	
	public void busyBeforeAndAfter() {
		System.out.println("忙前忙后！");
	}
	public void marry() {
		busyBeforeAndAfter();
		obj.marry();
	}
}