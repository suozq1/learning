package com.suo.javacode.nio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class SingleServerBIO {
	public static void main(String[] args) {
		Consumer c = new Consumer();
		System.out.println(c.name+c.age);
		c.getAge();
		c.getName();
		byte[] buffer = new byte[2048]; 
        try(ServerSocket serverSocket = new ServerSocket(8080)) { 
            System.out.println("服务器已启动并监听8080端口"); 
            System.out.println("--------------------------------------------");
            while (!serverSocket.isClosed()) {
                System.out.println("服务器正在等待请求..."+new Date().getTime()); 
                Socket socket = serverSocket.accept(); 
                System.out.println("服务器已接收到请求,等待数据..."+new Date().getTime()); 
                socket.getInputStream().read(buffer); 
                socket.getOutputStream().write("应答了".getBytes());
                System.out.println("服务器已经接收到数据并应答"+new Date().getTime()); 
                String content = new String(buffer); 
                System.out.println("接收到的数据:" + content+new Date().getTime()); 
                System.out.println("-------------------------------");
            } 
        } catch (IOException e) { 
            // TODO Auto-generated catch block 
            e.printStackTrace(); 
        }
	}
}
