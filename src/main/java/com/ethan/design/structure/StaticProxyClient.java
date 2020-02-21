package com.ethan.design.structure;

/**
 * 代理模式
 * 通过代理，控制对象的访问
 * 可以详细控制访问某个类，对象的方法，在调用这个方法前做前置处理
 * 从而实现将统一流程代码放到代理类中处理
 * 
 * 核心角色
 *   抽象角色：定义代理角色和真是角色的公共对外方法
 *   真实角色：实现抽象角色，定义真实角色所在实现的业务逻辑供代理角色调用，关注真正的业务逻辑
 *   代理角色：实现抽象角色，是真实角色的代理，通过真实角色的业务逻辑方法来实现抽象方法，并可以附加自己的操作
 *   
 *   将统一的流程控制放到代理角色中处理
 *   
 * 调用这个方法后做后置处理(即AOP的微观实现)
 */
public class StaticProxyClient {
	
	public static void main(String[] args) {
		Singer singer = new Singer();
		Action proxy = 	new SingerProxy(singer);
		
		StaticProxyClient client = new StaticProxyClient();
		client.organize(proxy);
	}

	/** 组织演唱会 */
	void organize(Action action) {
		action.contract();
		action.sing();
		action.getMoney();
	}
}

/** 打印输出 */
class Pr {
	public static void pr(String content) {
		System.out.println(content);
	}
}

/** 定义抽象类，即接口 */
interface Action{
	 void contract();//签合同
	 void sing(); //唱歌
	 void getMoney();//收款
}

/** 定义真实角色 - 歌手 */
class Singer implements Action{
	
	public void sing() {
		Pr.pr("歌手唱歌");
	}

	public void contract() {
		Pr.pr("歌手签合同"); 
	}

	public void getMoney() {
		Pr.pr("歌手获得尾款");
	}

}

/** 定义代理类 */
class SingerProxy implements Action{

	private Singer singer;
    	
	public SingerProxy( Singer singer) {
		this.singer = singer;
	}
	public void contract() {
		Pr.pr("我是代理，我来签合同");
	}

	public void sing() {
		Pr.pr("代理完成任务，接下来：");
		singer.sing();
	}
	public void getMoney() {
		Pr.pr("我是代理，我来收尾款");
		singer.getMoney();
	}
	
}
