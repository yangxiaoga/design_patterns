package com.ethan.design.structure;
import com.ethan.design.structure.Adapter;

/**
 * 适配器模式
 * 实例：【国外的三孔插座】和【两孔转三孔的转换头】
 * 模式中的角色：
 * 	目标接口(Targer):客户所期待的接口，目标可以是具体的或抽象的类，也可以是接口
 *  需要适配的类(Adaptee):需要适配的类或适配者类,如：三孔插座
 *  适配器(Adapter):通过包装一个需要适配的对象，把原接口转换成目标接口
 *  
 *  常见的场景
 *  InputStreamReader(InputStream)
 *  OutputStreamWriter(OutputStream)
 * 
 */
public class AdapteeAnAdapterClient {
	
	public static void main(String[] args) {
		AdapteeAnAdapterClient client = new AdapteeAnAdapterClient();
		
		Adaptee adaptee = new Adaptee();//被适配的类
		Target target = new Adapter(adaptee);//目标接口
		client.adapt(target);
	}
	
	public void adapt(Target target) {
		target.twoHoles();	
	}

}

/**
 * 目标接口
 */
interface Target{
	void twoHoles();
}

/**
 * 需要被适配的对象
 */
class Adaptee{
	public void threeHoles() {
		System.out.println("三孔插座在工作");
	}
}

/**
 * 适配器
 */
class Adapter implements Target {
	private Adaptee adaptee;
	public Adapter(Adaptee adaptee) {
		super();
		this.adaptee = adaptee;
	}
	public void twoHoles() {
		System.out.println("两孔操作在工作");
		adaptee.threeHoles();
	}
}