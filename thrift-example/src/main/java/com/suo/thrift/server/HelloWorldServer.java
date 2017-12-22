package com.suo.thrift.server;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.TTransportFactory;

import com.suo.thrift.HelloWorldThrift;
import com.suo.thrift.service.HelloWorldService;

public class HelloWorldServer {
	public static void simpleServer() throws TTransportException{
		TProcessor processor = new HelloWorldThrift.Processor<HelloWorldThrift.Iface>(new HelloWorldService());

        TServerSocket serverTransport = new TServerSocket(9090);

        TTransportFactory transportFactory = new TFramedTransport.Factory();

        Factory factory = new TBinaryProtocol.Factory();

        TServer.Args tArgs = new TServer.Args(serverTransport);
        tArgs.protocolFactory(factory);
        tArgs.transportFactory(transportFactory);
        tArgs.processor(processor);
        
        // 简单的单线程服务模型，一般用于测试
        TServer server = new TSimpleServer(tArgs);

        server.serve();
	}
	public static void main(String[] args) throws TTransportException {
		HelloWorldServer.simpleServer();
	}
}
