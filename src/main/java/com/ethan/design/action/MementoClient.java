package com.ethan.design.action;

/**
 * 备忘录模式
 * 
 * 回复到之前的状态
 * 
 * 开发场景：悔棋，撤销操作
 *         数据库软件中，事务管理中的回滚操作
 *         历史记录
 */
public class MementoClient {
	
	private EmpMemento emo;//或者使用List,保存多个状态

	public EmpMemento getEmo() {
		return emo;
	}

	public MementoClient(EmpMemento emo) {
		super();
		this.emo = emo;
	}
	
	public static void main(String[] args) {
		Emp emp = new Emp(20,"马丽");
		
		Pr.pr(emp.toString());//Emp [age=20, name=马丽]
		EmpMemento emo = emp.bak();
		MementoClient c = new MementoClient(emo);
		
		emp.setAge(30);
		Pr.pr(emp.toString());//Emp [age=30, name=马丽]
		
		emp.recover(c.getEmo());
		Pr.pr(emp.toString());//Emp [age=20, name=马丽]
	}
}

class EmpMemento {
	private int age;
	private String name;
    public EmpMemento(Emp emp) {	
    	this.age = emp.getAge();
    	this.name = emp.getName();
    }
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

class Emp {
	private int age;
	private String name;
	public int getAge() {
		return age;
	}
	
	/** 恢复 */
	public void recover(EmpMemento empm) {
		this.age = empm.getAge();
		this.name = empm.getName();
	}
	
	/** 备忘 */
	public EmpMemento bak() {
		return new EmpMemento(this);
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Emp(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Emp [age=" + age + ", name=" + name + "]";
	}
	
}