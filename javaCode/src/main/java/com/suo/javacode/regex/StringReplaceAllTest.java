package com.suo.javacode.regex;

public class StringReplaceAllTest {
	public static void main(String[] args) {
		String s="sdfsdfasdfsdfasdfadf";
		s=s.replaceAll("(sdf.*)(a)", "$2");
		System.out.println(s);
		s=s.replaceAll("b", null);//��Ϊû��ƥ�䵽������������û�б���
		System.out.println(s);
		//s=s.replaceAll("a", null);//��ƥ�䣬����
		
		
		
	}
}
