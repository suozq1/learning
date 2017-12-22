package com.suo.thrift.service;

import org.apache.thrift.TException;

import com.suo.thrift.HelloWorldThrift.Iface;

public class HelloWorldService implements Iface{

	@Override
	public String sayHello(String username) throws TException {
		return "Hello "+username+", welcome to Thrift World!";
	}

}
