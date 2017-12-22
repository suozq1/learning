package com.suo.thrift.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import com.suo.thrift.HelloWorldThrift;
import com.suo.thrift.HelloWorldThrift.Client;

public class HelloWorldClient {
    public static void main(String[] args) throws TException {
    	TTransport transport = new TFramedTransport(new TSocket("127.0.0.1", 9090, 5000));
        // 协议要和服务端一致
        TProtocol protocol = new TBinaryProtocol(transport);

        Client client = new HelloWorldThrift.Client(protocol);

        transport.open();

        String string = client.sayHello("Suo");

        System.out.println(string);

        transport.close();

	}
}
