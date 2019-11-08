package com.suo.javacode.nio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadServerBIO {
	private static ExecutorService cacheThreadPool = Executors.newCachedThreadPool();
	
	public static void handleRequest(Socket socket) {
		byte[] bytes = new byte[1024];
		try {
			socket.getInputStream().read(bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		String s = new String(bytes);
		System.out.println(socket.hashCode()+"�������ݶ�ȡ���:"+new Date()+s);
	}
	
	public static void main(String[] args) {
		 try(ServerSocket serverSocket = new ServerSocket(8080)) { 
	            System.out.println("������������������8080�˿�"); 
	            System.out.println("--------------------------------------------");
	            while (!serverSocket.isClosed()) {
	            	Socket socket = serverSocket.accept();
	            	System.out.println(socket.hashCode()+"���յ�����"+new Date());
	            	cacheThreadPool.execute(() -> handleRequest(socket));
	            } 
	        } catch (IOException e) { 
	            // TODO Auto-generated catch block 
	            e.printStackTrace(); 
	        }
	}
}
