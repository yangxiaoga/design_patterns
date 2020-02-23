package com.ethan.design.structure;

/**
 * 外观模式
 * 迪米特法则：一个软件实体应当尽可能少的与其他实体发生相互作用
 * 
 * 为子系统提供统一的入口，封装子系统的复杂性，便于客户端操作
 * 注册公司：工商局 - 质检局 - 税务局 - 银行账户
 * 相当于找了一个代理
 */
public class FacadeClient {
	
	public static void main(String[] args) {
		String material  = "开公司需要的材料";
		new FacadeClient().client(material);
	}
	
	void client(String material) {//客户只需要准备材料，知道找谁办理即可
		
		new Registry(material).register();
	}
}

class Registry {
	
	private String material;
	
	public Registry(String material) {
		super();
		this.material = material;
	}

	/**
	 * 统一的入口
	 */
	void register(){
		Pr.pr("办理公司需要：" + material);
		Pr.pr("Do A lot of things to found  a company!");
	}
}
