package com.suozq.spark.sql;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.api.java.JavaSchemaRDD;
import org.apache.spark.sql.api.java.Row;
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
		
		JavaRDD<Integer> ss=sRdd.map(row-> row.getInt(0));
		sRdd.map(new Function<Row, Integer>() {
			@Override
			public Integer call(Row v1) throws Exception {
				// TODO Auto-generated method stub
				return null;
			}
		});
		System.out.println(sRdd.collect());
		
		
		
	}
}
