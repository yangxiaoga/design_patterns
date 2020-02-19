package com.ethan.design.java.reflection;

import java.io.IOException;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMember;
import javassist.CtMethod;

/**
 * 字节码操作
 */
public class JavaSsist {
	
	public static void main(String[] args) throws CannotCompileException, IOException {
		javassist();
	}
	public static void javassist() throws CannotCompileException, IOException {
		//获得类池
		ClassPool pool = ClassPool.getDefault();
		//从类池中获得CtClass,CompileTimeClass
		CtClass cc = pool.makeClass("com.ethan.design.java.reflection.Student");
		CtField name = CtField.make("private String name;", cc);
		CtField age = CtField.make("private int age;", cc);
		cc.addField(name);
		cc.addField(age);
		CtMethod getName = CtMethod.make("public String getName(){return name;}", cc);
		CtMethod setName = CtMethod.make("public void setName(String name){this.name=name;}", cc);
		cc.addMethod(getName);
		cc.addMethod(setName);
		
		cc.writeFile("C:/Users/Administrator/Desktop");
	}

}
