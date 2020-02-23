package com.ethan.design.action;

/**
 * 模板方法模式
 * 
 * 场景：客户到银行办理业务-取号排队-办业务-给银行工作人员评分
 *      请客-点单-吃东西-买单
 *      
 *  作用：定义一个操作中的算法挂架，将某些步骤延迟到子类中实现
 *       新的子类可以再不改变一个算法结构的前提下重新定义该算法的某些
 *       特定步骤
 *  使用场景：实现一个算法时，整体步骤很固定，但是在某些部分易变
 *          易变部分可以抽象出来，供子类实现
 *  开发场景：数据库访问的封装，Junit单元测试
 *         Servlet中关于doGet/doPost方法调用
 *         Spring中JDBCTemplate，HibernateTemplate
 */
public class TemplateMethodClient {
	
	public static void main(String[] args) {
		new TemplateMethodClient().test();
	}
	void test(){
		BankService service = new SomeBank();
		service.process();
	}
}

/** 银行服务，定义模板方法的抽象类 */
abstract class BankService {
	
	void getNum(){//模板方法简单实现
		Pr.pr("得到号码");
	}
	abstract void transact();//办业务，钩子方法，待子类实现
	
	void evaluate() {
		Pr.pr("客户打分");
	}
	
	//定义成final，确保调用的顺序
	public final void process() {
		getNum();
		transact();
		evaluate();
	}
}

/** 具体要办理的银行业务，继承BankService，并实现抽象方法transact **/
class SomeBank extends  BankService {
	@Override
	void transact() {
		Pr.pr("=============================");
		Pr.pr("出示证件");
		Pr.pr("我要取款");
		Pr.pr("=============================");
	}
}
