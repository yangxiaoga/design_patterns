package com.ethan.design.action;

/**
 * 命令模式
 * 
 * 调用者     ->    命令【命令实现类】                           -> 接收者
 * Invoke ->   Command[ConcreteCommand]  ->  Receiver
 * 
 * 设计模式的初中就是适应变化，便于扩展
 * 
 * 场景：数据库底层的事务机制
 *
 */
public class CommandClient {
	
	public static void main(String[] args) {
		new CommandClient().client();
	}
	void client(){
		Receiver r = new Receiver();
		Command command = new ConcreteCommand(r);
		command.execute();
	}
}

class Invoke {
	
	//可以定义成List<Command>供批处理
	
	private Command command;

	public Invoke(Command command) {
		super();
		this.command = command;
	}

	public void invoke() {
		command.execute();
	}
	
}
class ConcreteCommand implements Command{

	private Receiver receiver;
	
	public ConcreteCommand(Receiver receiver) {
		super();
		this.receiver = receiver;
	}

	public void execute() {
		receiver.action();
	}
	
}

interface Command{
	void execute();
}

class Receiver {
	public void action() {
		Pr.pr("执行前");
		Pr.pr("action");
		Pr.pr("执行后");
	}
}