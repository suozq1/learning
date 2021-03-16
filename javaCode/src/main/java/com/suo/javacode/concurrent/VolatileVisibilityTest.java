package com.suo.javacode.concurrent;

public class VolatileVisibilityTest {
	private static volatile  boolean flag = true;
	private boolean test = false;
	
	public void changeTest() {
		this.test = true;
		System.out.println("hehe"+test);
	}
	
	
	
	public static void startWhile() {
		 int i =0;
		while(flag) {
				System.out.println("寰幆浜嗭細"+(++i));
//			try {
////				Thread.sleep(200);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
		System.out.println("鎴戜滑寰楀埌浜嗘渶鏂扮殑flag");
	}
	public static void changeFlag(boolean flag) {
		VolatileVisibilityTest.flag = flag;
		System.out.println("宸茬粡鏀瑰彉flag鐨勫�硷細"+flag);
	}
	public static void main(String[] args) throws InterruptedException {
//		VolatileVisibilityTest vvt = new VolatileVisibilityTest();
//		Runnable run = vvt::changeTest;
//		run.run();
//		System.out.println(vvt.test);
		Thread t1 = new Thread(VolatileVisibilityTest::startWhile);
		t1.start();
//		Thread.sleep(2000);
		Thread t2 = new Thread(()->{
			VolatileVisibilityTest.changeFlag(false);
		});
		t2.start();
		System.out.println("涓荤嚎绋嬬粨鏉�");
		
	}
}
