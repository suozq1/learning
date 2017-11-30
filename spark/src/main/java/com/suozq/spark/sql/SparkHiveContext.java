package com.suozq.spark.sql;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.api.java.JavaSchemaRDD;
import org.apache.spark.sql.hive.api.java.JavaHiveContext;

public class SparkHiveContext {
	public static void main(String[] args) {
		SparkConf conf=new SparkConf().setAppName("test").setMaster("local");
		JavaSparkContext sc=new JavaSparkContext(conf);
		JavaHiveContext hiveContext=new JavaHiveContext(sc);
		
		
		//JavaHiveContext hiveContext=new JavaHiveContext(new JavaSparkContext("local", "testHive"));
		JavaSchemaRDD json=hiveContext.jsonFile("file:///G:/sparkTemp/json.txt");
		json.registerTempTable("user");
		JavaSchemaRDD sRdd= hiveContext.sql("select spouse.id from user where age=18");
		sRdd.printSchema();
		
		//JavaRDD<Integer> ss=sRdd.map(row->{return row.getInt(0);});
		System.out.println(sRdd.collect());
		
		
		
	}
}
