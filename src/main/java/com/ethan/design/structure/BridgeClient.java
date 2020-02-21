package com.ethan.design.structure;

/** 
 *桥接模式 
 *  处理问题：
 *    
 *                        联想台式机
 *              台式机              戴尔台式机
 *                        神舟台式机
 *                        
 *                        联想笔记本
 *    电脑      ---  笔记本             戴尔笔记本
 *                        神舟笔记本
 *                            
 *                        联想平板电脑
 *              平板电脑          戴尔平板电脑
 *                        神舟平板电脑
 *                    
 * 如果实现上述的继承体系，不仅复杂，面临类的个数的巨大膨胀，而且冗余繁琐
 * 
 * 解决方式：将品牌和类型分开如：【联想】【平板】分开形成两个维度
 *     类型
 *       | 
 * 台式机    |
 * 笔记本    |        (桥接)
 * 平板电脑 |
 *        — - - - - - - -  - - - 品牌
 *           联想     戴尔    神舟
 *           
 *  电脑类中持有Brand，新添加品牌或者类型都会更容易，取代多重继承结构
 */
public class BridgeClient {
	public static void main(String[] args) {
		Brand brand = new Lenovo() ;
		Computer computer = new DeskTop(brand);
		computer.sale();//联想品牌，销售台式机
		
	}
	void bridge(){
		
	}
}

/** 电脑类 **/

class Computer{
	
	private Brand brand;
	
	public Computer(Brand brand){
		this.brand = brand;
	}
	
	public void sale() {
		this.brand.sale();
	}
}

/** 台式机 */
class DeskTop extends Computer{

	public DeskTop(Brand brand) {
		super(brand);
	} 
	
	@Override
	public void sale() {
		super.sale();
		Pr.pr("销售台式机");
	}
	
}

/** 笔记本 */
class LapTop extends Computer{

	public LapTop(Brand brand) {
		super(brand);
	}
	
	@Override
	public void sale() {
		super.sale();
		Pr.pr("销售笔记本");
	}
}

/** 品牌 */
interface Brand {
	void sale();
}

class Lenovo implements Brand{

	public void sale(){
		Pr.pr("联想品牌");
		
	}
	
}

class Dell implements Brand {

	public void sale() {
        Pr.pr("戴尔品牌");		
	}
	
}
