package com.suozq.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

public class SparkContextHolder {
	
	public static final String SPARK_TEMP_DIR="G:/sparkTemp";
	
	private static  JavaSparkContext sc;
	
	public static JavaSparkContext getSparkContext(){
		if(sc==null){
			SparkConf conf=new SparkConf().setMaster("local").setAppName("SparkTest");
			sc=new JavaSparkContext(conf);
		}
		return sc;
	}

}
