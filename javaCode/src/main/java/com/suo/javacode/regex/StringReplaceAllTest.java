package com.suo.javacode.regex;

public class StringReplaceAllTest {
	public static void main(String[] args) {
		String s="sdfsdfasdfsdfasdfadf";
		s=s.replaceAll("(sdf.*)(a)", "$2");
		System.out.println(s);
		s=s.replaceAll("b", null);//因为没有匹配到所以正常运行没有报错
		System.out.println(s);
		//s=s.replaceAll("a", null);//有匹配，报错
		
		
		
	}
}
