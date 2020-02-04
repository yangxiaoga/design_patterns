package com.ethan.design.patterns;

import java.util.concurrent.CountDownLatch;
import com.ethan.design.patterns.creater.singleton.EnumStyle;

public class App {
    public static void main( String[] args ) throws InterruptedException{
    	testSingletonSpeed();
    }
    
    /** 
     * 测试单例模式的优劣 
     * 多线程环境下的
     * @throws InterruptedException 
     * LazyStyle:2683
     * StarveStyle 46
     * DoubleCheckLockStyle:78
     * InnerStaticClassStyle:109
     * EnumStyle:47
     * 效率：StarveStyle>EnumStyle>DoubleCheckLockStyle>InnerStaticClassStyle>LazyStyle
     */    
    public static void testSingletonSpeed() throws InterruptedException {
    	
    	long time = System.currentTimeMillis();
    	int threadNumber = 10;
    	final CountDownLatch count = new CountDownLatch(threadNumber);
    	for(int i = 0; i<threadNumber; i++) {
	    	new Thread(new Runnable(){
	           
				public void run() {
					for (int i = 0; i<10000000; i++) {
						//Object o = LazyStyle.getInstance();
						//Object o1 = StarveStyle.getInstance();
						//Object o2 = DoubleCheckLockStyle.getInstance();
						//Object o3 = InnerStaticClassStyle.getInstance();
						@SuppressWarnings("unused")
						Object o4 = EnumStyle.INSTANCE;
					}
					//线程执行完，则计数器减一
					count.countDown();
				}
	    		
	    	}).start();
    	}
    	
    	//await使得主线程等待，直到计数器变为0
	    count.await();
		
    	time = System.currentTimeMillis() - time;
    	System.out.println("使用时间："+ time);
    }
}
