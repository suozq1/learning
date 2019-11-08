package com.suo.javacode.pattern.prototype;

public class Produce implements Cloneable{
	
	private String name;
	
	
	public Object createClone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Produce p = new Produce();
		p.setName("suo");
		Produce pro = (Produce) p.clone();
		Produce pr = (Produce) p.createClone();
		Object b = new Object();
		System.out.println(pro.name+":"+pro);
		System.out.println(pr.name+":"+pr);
		System.out.println(p.name+":"+p);
		
	}
	
}
