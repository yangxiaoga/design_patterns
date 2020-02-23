package com.ethan.design.structure;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元模式
 * 
 * 核心：享元模式以共享的方式高效地支持大量细粒度的对象重用
 * 享元对象能做到共享的关键是区分了内部状态和外部状态
 * 内部状态：可以共享，不会随环境变化而改变
 * 外部状态：不可以共享，会随环境变化而改变
 * 
 * 围棋的软件设计：
 *   内部状态：颜色，形状，大小；可以共享
 *   外部状态：位置；不可以共享
 * 
 * 享元模式的实现：
 *   FlyWeightFactory 享元工厂类
 *     创建并管理享元对象，享元池一般设计成键值对
 *   FlyWeight抽象享元类
 *     通常是一个接口或者抽象类，声明公共方法，这些方法可以向外界提供对象
 *     的内部状态，设置外部状态
 *   ConcreteFlyWeight具体享元类
 *     为内部状态提供成员变量进行存储
 *    UnshardConcreteFlyWeight非共享享元类
 *      不能被共享的子类可以设计成非共享享元类
 *      
 *  场景：线程池，数据库连接池
 *       String类的设计也是享元模式
 *       
 *  节约内存空间，外部状态相对独立，不影响内部状态
 *  模式较为复杂，读取外部状态额外增加运行的时间，时间换空间
 */
public class FlyWeightClient {//轻量级
    public static void main(String[] args) {
		new FlyWeightClient().play();
	}
	void play (){
		String black = "black";
		String white = "white";
		
		ChessFlyWeight blackChess = ChessFlyWeightFactory.getChess(black);
		blackChess.display(new Position(2,3));//外部状态，由外部传来
		
		ChessFlyWeight whiteChess = ChessFlyWeightFactory.getChess(white);
		whiteChess.display(new Position(2,3));
	}
}

/**
 * 享元类
 */
interface ChessFlyWeight {
	void setColor(String color);
	String getColor();
	void display(Position p);
}

/**享元工厂*/
class ChessFlyWeightFactory {
	//享元池
	private static Map<String, ChessFlyWeight> map = 
		   new HashMap<String, ChessFlyWeight>();
	
	public static ChessFlyWeight getChess (String color) {
		if (map.get(color)!= null) {
			return map.get(color);
		}
		ChessFlyWeight c = new ConcreteChess(color);
		map.put(color, c);
		return c;
		
	}
	
}

/** 具体的享元类 */
class ConcreteChess implements ChessFlyWeight{

	
	private String color;
	
	public ConcreteChess(String color) {
		super();
		this.color = color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getColor() {
		return color;
	}
	public void display(Position p) {
		Pr.pr("棋子的颜色{ "+getColor()+" }");
		Pr.pr("显示在指定的地方：{x:"+p.getX()+", "+"y:"+p.getY()+"}");
	}
	
}


/**
 * 坐标类 UnsharedConcreteFlyWeight
 * 表示外部状态
 */
class Position{
	private int x,y;

	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}





