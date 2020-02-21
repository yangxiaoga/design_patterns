package com.ethan.design.structure;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/** 
 * 动态代理 
 * 实现方式：JDK自带的动态代理java.lang.reflect.Proxy
 * javassist字节码操作库实现
 * CGLIB
 * ASM(底层使用指令，可维护性较差)
 * 
 * java.lang.reflect.InvocationHandler处理器接口
 *   可以通过调用invoke方法实现对真实角色的代理访问;
 *   每次通过Proxy生成代理类对象时都要指定对应的处理器对象
 *   
 * AOP:Aspect Oriented Programming
 *     可以通过预编译方式和运行期动态代理实现在不修改源代码的情况下给程序动态统一添加
 *     功能的一种技术，它是一种新的方法论，是对传统的OOP编程的一种补充
 *     
 *     切点形成切面，加入统一逻辑处理
 */

public class DynamicProxyClient {

	public static void main(String[] args) {
		new DynamicProxyClient().client();
	}
	
	void client() {
	    Action singer = new Singer();
	    SingerHandler handler = new SingerHandler(singer);
	    
		/**ClassLoader;真实类实现的接口;Handler(原来静态代理类做的事情，他来做)*/
	    Action proxy = (Action)Proxy.newProxyInstance(
	    		ClassLoader.getSystemClassLoader(), 
	    		new Class[]{Action.class}, handler);
	    //相当于Proxy持有Handler,并通过invoke方法实现
	    proxy.contract();
	    proxy.sing();
	    proxy.getMoney();
	}
}

class SingerHandler implements InvocationHandler {
	
	Action object; //真实角色
	public SingerHandler(Action object) {
		super();
		this.object = object;
	}
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		/** com.ethan.design.structure.$Proxy0 */
		//Pr.pr(proxy.getClass().getName());
		
		if (method.getName().equals("sing")) {
			/** 这里需要注意，调用方法invoke,传递的对象【object】是真实的对象不是【proxy】 */
			method.invoke(object, args);
		} else {
			Pr.pr(method.getName()+" - 这是代理需要做的事情");
		}
		return null;
	}
}
