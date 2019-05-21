package com.suo.javacode.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class GetDeclaredTest {
	public static class Shape{
		private String a;
		@SuppressWarnings("unused")
		private void getPrivate() {
			System.out.println("private");
		}
		void getDefault(){
			System.out.println("default");
		}
		protected void getProtected() {
			System.out.println("protected");
		}
		public void getPublic() {
			System.out.println("public");
		}
		@Override
		public String toString() {
			return a;
		}
	}
	
	public static class Circle extends Shape{
		
	}
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Shape shape = new Shape();
		System.out.println("父类getMethods");
		for(Method m : shape.getClass().getMethods()) {
			System.out.println(m.getName());
		}
		System.out.println("-------------------\n父类getDeclaredMethods");
		for(Method m : shape.getClass().getDeclaredMethods()) {
			System.out.println(m.getName());
		}
		System.out.println("---------华丽的分割线------------\n子类getMethods");
		shape = new Circle();
		for(Method m : shape.getClass().getMethods()) {
			System.out.println(m.getName());
		}
		System.out.println("-------------------\n子类getDeclaredMethods");
		for(Method m : shape.getClass().getDeclaredMethods()) {
			System.out.println(m.getName());
		}
		System.out.println("-------------------\n设置父类私有字段");
		Shape s=new Shape();
		Field f=shape.getClass().getSuperclass().getDeclaredField("a");
		f.setAccessible(true);
		f.set(s, "sdf");
		System.out.println(s);
	}
}
