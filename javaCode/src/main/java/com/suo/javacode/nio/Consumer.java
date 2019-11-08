package com.suo.javacode.nio;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Consumer implements Cloneable{
	
	String name = "";
	
	protected int age = 19;
	
	String getName() {
		return this.name;
	}
	
	protected int getAge() {
		return this.age;
	}
	
	public static void sendRequest(String ip,int port,String content) {
		try { 
            Socket socket = new Socket(ip,port);
            System.out.println("线程"+Thread.currentThread().getId()+"连接完成..."+new Date());
            TimeUnit.SECONDS.sleep(5);
            
            socket.getOutputStream().write(content.getBytes()); 
            System.out.println("线程"+Thread.currentThread().getId()+"写数据完成..."+new Date());
            TimeUnit.SECONDS.sleep(5);
            socket.close(); 
            System.out.println("线程"+Thread.currentThread().getId()+"连接关闭..."+new Date());
        } catch (IOException e) { 
            // TODO Auto-generated catch block 
            e.printStackTrace(); 
        } catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace(); 
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Consumer c = new Consumer();
		ExecutorService e = Executors.newFixedThreadPool(2);
		e.execute(()->sendRequest("127.0.0.1",8080,"测试了1"));
//		e.execute(()->sendRequest("127.0.0.1",8080,"测试了2"));
		/*
		 * e.execute(()->sendRequest("127.0.0.1",8080,"测试了3"));
		 * e.execute(()->sendRequest("127.0.0.1",8080,"测试了4"));
		 */
		e.shutdown();
	}
}
