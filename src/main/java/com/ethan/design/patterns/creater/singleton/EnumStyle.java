package com.ethan.design.patterns.creater.singleton;

/**
 * 枚举实现单例模式
 * 枚举本身就是单例模式，由JVM从根本上提供保障
 * 避免通过反射和反序列化的漏洞
 * 缺点：无延迟加载
 */
public enum EnumStyle {
	
	//这个枚举元素，本身就是单例对象
	INSTANCE;
	public void operator() {
		//功能处理
	}

/** 测试代码 */
	public static void main(String[] args){
		EnumStyle ins = EnumStyle.INSTANCE;
		EnumStyle ins1 = EnumStyle.INSTANCE;
		System.out.println(ins == ins1);
	}

}
