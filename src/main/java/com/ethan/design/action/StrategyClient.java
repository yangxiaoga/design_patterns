package com.ethan.design.action;

/**
 * 策略模式
 * 
 * 策略模式对应于解决某一个问题的算法族，允许用户从该算法族
 * 中任选一个算法解决某一问题，同时可以方便的更换算法或者增加
 * 新的算法，并且由客户端决定调用哪个算法
 * 
 * 场景 Spring框架中，Resource接口，资源访问策略
 * HttpServlet.service()子Service
 */
public class StrategyClient {
	
	public static void main(String[] args) {
		new StrategyClient().test();
	}
	void test(){
		Strategy s = new One();
		Strategy s1 = new Two();
		Context c = new Context(s);
		Pr.pr("策略1价格："+c.invoke(10023.5));
		c.setStra(s1);
		Pr.pr("策略2价格："+c.invoke(10023.5));
		//策略1价格：10023.5
		//策略2价格：9021.15
	}
}

class Context{
	
	//注入具体的策略
	private Strategy stra;

	public Context(Strategy stra) {
		super();
		this.stra = stra;
	}
	
	public void setStra(Strategy stra) {
		this.stra = stra;
	}

	public double invoke(double price) {
		return stra.getPrice(price);
	}
	
}

interface Strategy{
	double getPrice(double originPrice);
}

/**普通客户小批量购买*/
class One implements Strategy{

	public double getPrice(double originPrice) {
		return originPrice;
	}
}

/**普通客户大批量 */
class Two implements  Strategy{
	public double getPrice(double originPrice) {
		return originPrice*0.9;
	}
}

/** 老客户小批量 */
class Three implements  Strategy{
	public double getPrice(double originPrice) {
		return originPrice*0.85;
	}
}

/** 老客户大批量 */
class Four implements  Strategy{
	public double getPrice(double originPrice) {
		return originPrice*0.8;
	}
}