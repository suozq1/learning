package com.suo.javacode.jvm;

import java.util.LinkedList;
import java.util.List;

public class HeapOOM {
    public static class OOMObject{
    	
    }
    public static void main(String[] args) {//10分钟左右OOM
		List<OOMObject> list = new LinkedList<>();
		for(;;) {
			list.add(new OOMObject());
		}
	}
}
