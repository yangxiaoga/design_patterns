package com.ethan.design.patterns.creater.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;

/**
 * 通过序列化和反序列化实现深克隆
 */
public class DeepCloneBySerializable {
	
	public static void main(String[] args) {
		new DeepCloneBySerializable().deep();
	}
	
	/**
	 * 通过序列化和反序列化实现深克隆
	 */
	public void deep() {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ByteArrayInputStream bai = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		SimpleClonePojo pojo = new SimpleClonePojo("反序列化对象克隆",new Date(232332L), 20);
		try {
			oos = new ObjectOutputStream(bos);
			
			/**序列化,将对象写入到字节数组流中*/
			oos.writeObject(pojo); 
			
			byte[] arr = bos.toByteArray();
			bai = new ByteArrayInputStream(arr, 0, arr.length);
			ois = new ObjectInputStream(bai);
			
			/** 反序列化读取对象 */
			SimpleClonePojo cp = (SimpleClonePojo) ois.readObject();
			System.out.println("pojo==cp:? "+ (pojo == cp)); //FALSE
			System.out.println("pojo.birth==cp.birth:? "+ 
			(pojo.getBirth() == cp.getBirth())); //FALSE
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
