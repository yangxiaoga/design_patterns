package com.ethan.design.patterns;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import com.ethan.design.patterns.creater.singleton.LazyStyle;

/**
 * 如何防止反射和反序列化漏洞[基于懒汉单例模式] 
 * 怎样解决该问题：在私有构造方法中，通过构造行数的调用次数来判断，大于0则抛出异常
 * 反序列化漏洞可以通过定义readResolve方法解决
 * 
 */
public class ReflectionAndSerializableShortage {
	
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		//reflect();
		serializable();
	}
	
	@SuppressWarnings({ "unchecked" })
	public static void reflect() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
	
		//通过反射的方式破坏单例
		Class<LazyStyle> clazz = (Class<LazyStyle>)Class.forName("com.ethan.design.patterns.creater.singleton.LazyStyle");
		Constructor<LazyStyle> constructor = clazz.getDeclaredConstructor();
		constructor.setAccessible(true);
		LazyStyle obj = constructor.newInstance();
		LazyStyle obj1 = constructor.newInstance();
		System.out.println("obj:" + obj);
		System.out.println("obj1:" + obj1);
		System.out.println("obj==obj1:"+(obj==obj1));
	}
	
	public static void serializable() throws IOException, ClassNotFoundException {
		//通过反序列化构造多个对象
		//可以通过readResolve方法解决
		LazyStyle obj = LazyStyle.getInstance();
		FileOutputStream fos = new FileOutputStream("f:/a.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(oos);
		oos.close();
		fos.close();
		
		FileInputStream fis = new FileInputStream("f:/a.txt");
		@SuppressWarnings("resource")
		ObjectInputStream ois = new ObjectInputStream(fis);
		LazyStyle obj1 = (LazyStyle) ois.readObject();
		System.out.println("obj==obj1:"+ (obj==obj1));
		
	}

}














