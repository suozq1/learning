package com.suo.javacode.concurrent;

public class VolatileAtom {
	private static volatile int num=0;
	
	public static void run() {
		for(int i = 0;i<1000;i++) {
			num++;
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread[] threads = new Thread[10];
		for(int i =0;i<10;i++) {
			threads[i] = new Thread(VolatileAtom::run);
			threads[i].start();
		}
		for(Thread t: threads) {
			t.join();
		}
		System.out.println(num);
	}
}
