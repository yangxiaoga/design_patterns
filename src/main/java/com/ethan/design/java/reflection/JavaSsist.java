package com.ethan.design.java.reflection;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;
import javassist.Modifier;
import javassist.NotFoundException;

/**
 * 字节码操作
 */
public class JavaSsist {
	
	public static void main(String[] args) throws IOException, NoSuchFieldException {
		//javassist();
		getSomeClass();
	}
	public static void javassist() throws CannotCompileException, IOException {
		/**获得类池*/
		ClassPool pool = ClassPool.getDefault();
		/**从类池中获得CtClass,CompileTimeClass*/
		//Student类并不存在
		CtClass cc = pool.makeClass("com.ethan.design.java.reflection.Student");
		CtField name = CtField.make("private String name;", cc);
		CtField age = CtField.make("private int age;", cc);
		cc.addField(name);
		cc.addField(age);
		CtMethod getName = CtMethod.make("public String getName(){return name;}", cc);
		CtMethod setName = CtMethod.make("public void setName(String name){this.name=name;}", cc);
		cc.addMethod(getName);
		cc.addMethod(setName);
		cc.writeFile("C:/Users/Administrator/Desktop");//写出类文件到工作空间
	}

	
	@SuppressWarnings("all")
	public static void getSomeClass() throws NoSuchFieldException {
		try {
			ClassPool pool = ClassPool.getDefault();
			CtClass ctClass = pool.get("com.ethan.design.java.reflection.Pojo");
			
			/** 
			 *  如果一个CtClass对象通过writeFile(),toClass(),或者toByteCode()转换成class文件，
			 *  那么javassist会冻结这个CtClass对象。后面就不能修改这个CtClass对象了
			 */
/*			byte[] bytes = ctClass.toBytecode(); //获取类的字节数组
			print(Arrays.toString(bytes));*/
			
			print(ctClass.getName()) ;//类名，包含包
			print(ctClass.getSimpleName());//只有类名
			print(ctClass.getSuperclass()); //获得父类
			
			/**属性的操作*/
			CtField field  = new CtField(CtClass.intType, "age", ctClass);
			field.setModifiers(Modifier.PRIVATE);
			ctClass.addField(field);	
			
			/** 产生新的方法 */
			/**返回值类型;方法名;参数类型;对应的类*/
			CtMethod method = new CtMethod(CtClass.intType,"add",new CtClass[]{CtClass.intType,CtClass.intType},ctClass);
			method.setModifiers(Modifier.PUBLIC); 
			
			/**$1为第一个参数，$2为第二个参数，$0为this*/
			method.setBody("{return $1+$2;}"); 
			
			//在方法前添加内容
			method.insertBefore("System.out.println($1+\"+\"+$2);");
			ctClass.addMethod(method);
			
			/** 转换为Class，供反射使用 */
			Class clazz = ctClass.toClass();
			
			if(ctClass.isFrozen()){//如果类被冻结了，解冻
                ctClass.defrost();
            }
			Pojo object = (Pojo) clazz.newInstance();
			java.lang.reflect.Method me = 
					clazz.getDeclaredMethod("add", int.class, int.class);
			Object result = me.invoke(object, 23,2);
			print(result);
			
			/** 获取属性 */
			print(clazz.getDeclaredField("age"));
			
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}catch (NotFoundException e) {
				e.printStackTrace();
			}catch (CannotCompileException e) {
				e.printStackTrace();
			}
	}
	
	/** 打印输出 */
	public static void print(Object content) {
		System.out.println(content);
	}
}
