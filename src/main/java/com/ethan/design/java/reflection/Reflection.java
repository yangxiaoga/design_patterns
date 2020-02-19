package com.ethan.design.java.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.ethan.design.java.annotation.Student;

public class Reflection {
	
	public static void main(String[] args) {
		String path = "com.ethan.design.java.annotation.Student";
		reflect(path);
	}
	
	/**
	 * @param path
	 */
	@SuppressWarnings("all")
	public static void reflect(String path) {
		Class<Student> clazz;
		try {
			clazz = (Class<Student>) Class.forName(path);
			
			/** 返回声明为public的属性 */
			Field[] fileds = clazz.getFields();
			
			/** 返回所有属性 */
			clazz.getDeclaredFields();
		    Field field = clazz.getDeclaredField("name");
		
			/** 获取方法 */
			clazz.getMethods();//public
			clazz.getDeclaredMethods();//all
			Method m = clazz.getDeclaredMethod("setName", String.class); //方法名，参数类型
			
			
			/** 获得构造方法的信息 */
			clazz.getDeclaredConstructors();//all constructors
			
			/** 通过Class构造实例对象 */
		    Student student = clazz.newInstance();//调用午餐构造方法，若没有午餐构造函数，则出现初始化错误异常
		    Constructor<Student> constructor = clazz.getDeclaredConstructor(String.class, int.class);
		    Student stu =constructor.newInstance("我是通过构造方法构造的", 20);
		    System.out.println(stu.getName());
		    
		    /** 通过反射调用方法 ,m为setName*/
            m.invoke(stu, "改变之后的姓名")	;
            System.out.println(stu.getName());
            
			/** 设置属性 */
            field.setAccessible(true);
            field.set(stu, "直接操作属性修改后的结果");
            System.out.println(stu.getName());
            
            
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}
}
