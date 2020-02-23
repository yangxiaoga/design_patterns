package com.ethan.design.action;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * 观察者模式
 * 广播-群发消息
 * 
 * java.util.Observable和java.util.Observer实现了该模式
 * 两者分别为类和接口
 * 
 * 场景：监听器的实现
 *     Android中，广播机制
 *     AWT:事件源--目标对象；时间监听器--观察者
 */
public class ObserverClient {
	
	public static void main(String[] args) {
		new ObserverClient().test();
	}
	void test(){
		Observer o1 = new SomeObserver("观察者1");
		Observer o2 = new SomeObserver("观察者2");
		Observer o3 = new SomeObserver("观察者3");
		
		Observable sender = new SomeSender();
		sender.add(o1);
		sender.add(o2);
		sender.add(o3);
		sender.send("我发了一个消息给你们hah!");
		Pr.pr("=========================================");
		
		sender.remove(o3);
		sender.send("我们团队成员少了一个！");
	}
}

/** 消息发送者 */
interface Observable {
	void send(String msg);
	void add(Observer ob);
	void remove(Observer ob);
}

/** 消息发送者的实现类 */
class SomeSender implements Observable {
	
	private List<Observer> obs = new ArrayList<Observer>();

	/** 注册 */
	public void add(Observer ob){
		obs.add(ob);
	}
	
	/**移除*/
	public void remove(Observer ob) {
		obs.remove(ob);
	}
	
	/** 发送消息 */
	public void send(String msg) {//遍历，向注册的观察者发消息
		ListIterator<Observer> i = obs.listIterator();
		while(i.hasNext()) {
			i.next().read(msg);
		}
	}
}

/** 观察者 */
interface Observer{
	void read(String msg);//读取消息
}

/** 观察者实现类 */
class SomeObserver implements Observer{
	
	private String name;
	
	public SomeObserver(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void read(String msg) {
		Pr.pr("我是："+name+",我接受到的消息是："+msg);
	}
}
