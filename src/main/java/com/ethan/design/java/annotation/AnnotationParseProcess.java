package com.ethan.design.java.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Annotation解析
 * 使用反射读取自定义注解@Table,@StudentField信息
 */
public class AnnotationParseProcess {
	
	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException {
		String path = "com.ethan.design.java.annotation.Student";
		process(path);
	}
	@SuppressWarnings({ "all"})
	public static void process(String classPath) throws ClassNotFoundException, NoSuchFieldException, SecurityException {
		Class clazz = Class.forName(classPath);
		
		//获得类的所有注解
		Annotation[] annotations = clazz.getAnnotations();
		Table table = (Table) clazz.getAnnotation(Table.class);
		System.out.println(table.value()); //t_student
		
		//获得类属性的注解
		Field name = clazz.getDeclaredField("name");
		StudentField nameField = name.getAnnotation(StudentField.class);
		
		//获取属性的注解信息
		String column = nameField.column();
		String type = nameField.type();
		int len = nameField.length();
		System.out.println("field:"+name.getName()+" column:"+column+" type:"+type+" length:"+len);
		
		
	}

}
