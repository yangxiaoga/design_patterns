package com.ethan.design.action;

/**
 * 责任链模式
 * 
 * 定义：能够处理同一类请求的对象连城一条链，所提交的请求
 *      沿着链传递，链上的对象逐个判断是否有能力处理该请求
 *      如果能则处理，如果不能则传递给链上的下一个对象
 *      
 * 场景：打牌时，轮流出牌
 *      接力赛跑
 *      奖学金审批
 *      公文审批
 *      
 * 典型：Java的try,catch
 * 
 */
public class ChainOfResponsibility {

	public static void main(String[] args) {
		new ChainOfResponsibility().test();
	}
	void test() {
		LeaveRequest request1 = new LeaveRequest("a45689", 5, "事假1");
		LeaveRequest request2 = new LeaveRequest("a45689", 15, "事假2");
		
		Leader manager = new Manager("总经理");
		Leader vice = new ViceManager("副总");
		vice.setNextLeader(manager);
		
		vice.handleRequest(request1);//我是副总经理，天数小于10，我可以处理
		vice.handleRequest(request2);//我是总经理，天数大于10，我来处理
	}
}

/** 抽象类，领导*/
abstract class Leader {
	
	private String name;
	
	/**下一位处理者*/
	private Leader nextLeader;

	public Leader(String name) {
		super();
		this.name = name;
		this.nextLeader = null;
	}
	
	public Leader(String name, Leader nextLeader) {
		super();
		this.name = name;
		this.nextLeader = nextLeader;
	}
	
	/** 核心处理方法  - 抽象，由具体的领导如：主任，经理，副总经理来实现 */
	abstract void handleRequest(LeaveRequest request);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Leader getNextLeader() {
		return nextLeader;
	}

	public void setNextLeader(Leader nextLeader) {
		this.nextLeader = nextLeader;
	}
}

/**副总经理*/
class ViceManager extends Leader{
	
	public ViceManager(String name) {
		super(name, null);
	}
	
	public ViceManager(String name, Leader nextLeader) {
		super(name, nextLeader);
	}

	@Override
	void handleRequest(LeaveRequest request) {
		if (request.getDays() < 10) {
			Pr.pr("我是副总经理，天数小于10，我可以处理");
		} else {
			getNextLeader().handleRequest(request);
		}
	}
}

/** 总经理 */
class Manager extends Leader{

	public Manager(String name) {
		super(name, null);
	}
	
	public Manager(String name, Leader nextLeader) {
		super(name, nextLeader);
	}

	@Override
	void handleRequest(LeaveRequest request) {
		if (request.getDays() >10) {
			Pr.pr("我是总经理，天数大于10，我来处理");
		}
	}
}


/** 模拟请假的审批 */
class LeaveRequest {
	
	/** 雇员名称或者编号 */
	private String employee;
	
	/** 请假天数 */
	private int days;
	
	/** 请假理由 */
	private String desc;

	public LeaveRequest(String employee, int days, String desc) {
		super();
		this.employee = employee;
		this.days = days;
		this.desc = desc;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "LeaveRequest [employee=" + employee + ", days=" + days + ", desc=" + desc + "]";
	}
	
}
