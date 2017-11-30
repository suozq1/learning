package com.suozq.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

public class SparkContextHolder {
	
	public static final String SPARK_TEMP_DIR="G:/sparkTemp";
	
	private static  JavaSparkContext sc;
	
	public static JavaSparkContext getSparkContext(){
		if(sc==null){
			SparkConf conf=new SparkConf().setMaster("spark://10.99.35.23:7077").setAppName("SparkApp");
			
			//引入效率更高的序列化代码类，比java序列化速度更快压缩率更高
			//conf.set("spark.serializer","org. apache. spark. serializer. KryoSerializer");
			//conf.set("spark. kryo. registrationRequired","true");
			//conf.registerKryoClasses(new Class<?>[]{String.class});


			sc=new JavaSparkContext(conf);
		}
		return sc;
	}

}
