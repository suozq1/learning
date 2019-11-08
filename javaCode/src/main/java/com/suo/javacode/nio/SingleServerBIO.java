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
            System.out.println("������������������8080�˿�"); 
            System.out.println("--------------------------------------------");
            while (!serverSocket.isClosed()) {
                System.out.println("���������ڵȴ�����..."+new Date().getTime()); 
                Socket socket = serverSocket.accept(); 
                System.out.println("�������ѽ��յ�����,�ȴ�����..."+new Date().getTime()); 
                socket.getInputStream().read(buffer); 
                socket.getOutputStream().write("Ӧ����".getBytes());
                System.out.println("�������Ѿ����յ����ݲ�Ӧ��"+new Date().getTime()); 
                String content = new String(buffer); 
                System.out.println("���յ�������:" + content+new Date().getTime()); 
                System.out.println("-------------------------------");
            } 
        } catch (IOException e) { 
            // TODO Auto-generated catch block 
            e.printStackTrace(); 
        }
	}
}
