package com.ethan.design.structure;

/**
 * 装饰模式
 * 动态的为对象添加新的功能 
 * 
 * 是一种用于代替继承的技术，无须通过继承增加子类就能扩展对象的
 * 新功能，使用对象的关联关系代替继承关系，更加灵活。
 * 同时避免类型体系的快速膨胀
 *  
 * 如：汽车，水上汽车，飞行汽车，人工智能汽车
 * 
 * 实现细节：
 *   Component:抽象构件角色
 *             真是对象和装饰对象有相同的接口，这样，客户端对象就能够以与真实对象相同的方式
 *             同装饰对象交互
 *   ConcreteComponent 具体构件角色(真是对象)：
 *     io流中的FileInputStream,FileOutputStream
 *   Decorator 装饰角色：
 *     持有一个抽象构件的引用，装饰对象接口所有客户端的请求，并把这些请求转发给真实 的对象
 *     这样就能在真实对象调用前后增加新的功能
 *     
 *   ConcreteDecorator具体装饰角色：
 *     负责给构件对象增加新的责任
 *     
 *   因为从上到下都是ICar接口进行处理，所以构造方法都是ICar,name可以不断增加新的功能
 *   
 *   Reader reader = 
 *   new BufferedReader(InputStreamReader(new FileInputStream(new File())));
 *   
 *   Component:InputStream,OutputStream,Reader,Writer
 *   ConcreteComponent: FileInputStream,FileOutputStream
 *   Decorator: FilterInputStream,FilterOutputStream
 *   ConcreteDecorator:BufferedInputStream,BufferedOutputStream
 */
public class DecoratorClient {
	
	public static void main(String[] args) {
		new DecoratorClient().test();
	}
	void test(){
		Car car = new Car();
		ICar flyCar = new FlyCar(car);
		flyCar.move();
		
	}
}

/** 抽象组件 */
interface ICar{
	void move();
}

class Car implements ICar{
	public void move() {
		Pr.pr("陆地上行驶");
	}
}

/** 装饰器 */
class SuperCar implements ICar{

	//持有真实对象的引用
	protected ICar car;
	
	public SuperCar(ICar car) {
		super();
		this.car = car;
	}

	public void move() {
		car.move();
	}
}

interface Flyable {
	void fly();
}

/** 真实装饰器 */
class FlyCar extends SuperCar implements Flyable{

	public FlyCar(ICar car) {
		super(car);
	}
	
	public void fly() {
		Pr.pr("天上飞");;
	}
	
	@Override
	public void move() {
		super.move();
		fly();
	}
}
