package com.suo.javacode.concurrent;
/**
 * 连接池测试类
 * @author 锁战强
 *
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ExecutorServiceTest {
	static ExecutorService cached = Executors.newCachedThreadPool();
	static ExecutorService fixed = Executors.newFixedThreadPool(10);
	static ScheduledExecutorService schedul = Executors.newScheduledThreadPool(10);
	static ExecutorService single = Executors.newSingleThreadExecutor();
	
	static ExecutorService s =Executors.newWorkStealingPool();
	
	public static void main(String[] args) {
	}
	
}
