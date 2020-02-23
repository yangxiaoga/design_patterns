package com.ethan.design.action;

import java.util.HashMap;
import java.util.Map;

/**
 * 中介者模式
 * 
 * 财务部，市场部，研发部分别跟总经理打交道，而不是各自为政
 * 
 * 核心：把网状结构重新解耦，变成一对多
 * 同事对象 - 中介者对象
 * 
 * 核心： Mediator中介者，Department部门抽象，各个部分实现Market，Development，Financial
 * 需要在各自持有的Mediator中注册，由具体实现的Mediator统一发布指令或者任务
 * 
 * 场景：MVC模式中的C
 * 控制器就是一个中介者对象，M和V都和它打交道
 * 
 */
public class MediatorClient {
	
	public static void main(String[] args) {
		new MediatorClient().client();
	}
	
	@SuppressWarnings("unused")
	void client(){
		Mediator m = new ReputationManager();
		Department market = new Market(m);
		Department develope = new Development(m);
		Department financial = new Financial(m);
		m.command("market", "找客户推荐新产品");
		m.command("financial", "给研发部一笔新的启动金");
		m.command("development", "研发新产品");
	}
}

/** 中介者  - 其他部分有事需要向其反馈，再由它分发任务 */
interface Mediator {
	void register(String dname, Department department);
	void command(String dname, String command);
}

/** 部门  */
interface Department {
	void selfAction();//部门内的事情
	void selfAction(String command);//部门内的事情
	void outAction();//向总经理发出申请
}
//研发部
class Development implements Department {
	
	private Mediator m;
	
	public Development(Mediator m) {
		super();
		this.m = m;
		m.register("development", this);
	}
	
	public void setM(Mediator m) {
		this.m = m;
		m.register("development", this);
	}

	public Mediator getM() {
		return m;
	}

	public void selfAction() {
		Pr.pr("开发项目");
	}
	public void outAction() {
		Pr.pr("没钱了，需要资金支持");
	}

	public void selfAction(String command) {
		Pr.pr("研发部接到指令："+command);
		selfAction();
		Pr.pr("==============分隔线======================");
		
	}
}
//财务部
class Financial implements Department{

    private Mediator m;
    public Financial(Mediator m) {
    	super();
    	this.m = m;
    	m.register("financial", this);
    }
    
	public Mediator getM() {
		return m;
	}

	public void setM(Mediator m) {
		this.m = m;
		m.register("financial", this);
	}

	public void selfAction() {
		Pr.pr("财务管理");
	}
	public void outAction() {
		Pr.pr("汇报工作，钱怎么花");
	}

	public void selfAction(String command) {
		Pr.pr("财务部接到指令");
		selfAction();
		Pr.pr("==============分隔线======================");		
	}
}
//市场部
class Market implements Department {
	private Mediator m;
	public Market(Mediator m) {
		this.m = m;
		m.register("market", this);
	}
	
	public Mediator getM() {
		return m;
	}

	public void setM(Mediator m) {
		this.m = m;
		m.register("market", this);
	}

	public void selfAction() {
		Pr.pr("市场拓展");
	}
	public void outAction() {
		Pr.pr("汇报市场工作");
	}
	
	public void selfAction(String command) {
		Pr.pr("市场部接到指令:"+command);
		selfAction();
		Pr.pr("==============分隔线======================");		
	}
}

/** 总经理 */
class ReputationManager implements Mediator{

	private Map<String,Department> dept = new HashMap<String,Department>();
	
	public void register(String dname, Department department) {
		dept.put(dname,department);
	}

	public void command(String dname, String command) {
		Department d = dept.get(dname);
		if (d!=null) {
			d.selfAction(command);
		}
	}
	
}