package com.ethan.design.action;

/**
 * 状态模式
 * 
 * 常见使用场景：红绿灯：红灯、路灯、黄灯
 *           订单状态：下单、已付款、已发货、送货中、已收货
 *           电梯的运行：向上、向下、开门、关门、维修
 *
 */
public class StateClient {
	public static void main(String[] args) {
		new StateClient().test();
	}
	void test(){
		State state = new OrderedState();
		RoomContext c = new RoomContext(state);
		c.show();//酒店房间处于预订状态
		
		//切换状态
		state = new FreeState();
		c.setState(state);
		c.show();//酒店房间处于空闲状态
	}
}


/** 状态的抽象类 */
interface State {
	void handle();
}

/** 不同的子类状态来实现State*/
class OrderedState implements State{
	public void handle() {
		Pr.pr("酒店房间处于预订状态");
	}
}
class FreeState implements State{
	public void handle() {
		Pr.pr("酒店房间处于空闲状态");
	}
}
class ReturnState implements State{
	public void handle() {
		Pr.pr("酒店房间处于退订状态");
	}
}

class RoomContext  {
	private State state;
	public RoomContext(State state) {
		super();
		this.state = state;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	
	public void show() {
		state.handle();
	}
}

