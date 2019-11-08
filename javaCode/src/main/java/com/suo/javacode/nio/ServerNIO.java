package com.suo.javacode.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class ServerNIO {
	 public static void main(String[] args) throws InterruptedException { 
	        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
	        try { 
	            //JavaΪ���������õ��� 
	            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open(); 
	            serverSocketChannel.bind(new InetSocketAddress(8080)); 
	            //����Ϊ������ 
	            serverSocketChannel.configureBlocking(false); 
	            while(true) { 
	                SocketChannel socketChannel = serverSocketChannel.accept(); 
	                if(socketChannel==null) { 
	                    //��ʾû������ 
	                    System.out.println("���ڵȴ��ͻ�����������..."); 
	                    Thread.sleep(5000); 
	                }else { 
	                    System.out.println("��ǰ���յ��ͻ�����������..."); 
	                } 
	                if(socketChannel!=null) { 
	 //����Ϊ������     
	                    socketChannel.configureBlocking(false); 
	                    byteBuffer.flip();//�л�ģʽ д-->�� 
	                    int effective = socketChannel.read(byteBuffer); 
	                    if(effective!=0) { 
	                        String content = Charset.forName("utf-8").decode(byteBuffer).toString(); 
	                        System.out.println(content); 
	                    }else { 
	                        System.out.println("��ǰδ�յ��ͻ�����Ϣ"); 
	                    } 
	                } 
	            } 
	        } catch (IOException e) { 
	            // TODO Auto-generated catch block 
	            e.printStackTrace(); 
	        } 
	  } 
}
