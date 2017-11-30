package com.suozq.spark.sql;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.api.java.DataType;
import org.apache.spark.sql.api.java.UDF1;
import org.apache.spark.sql.hive.api.java.JavaHiveContext;

public class SparkSqlUDFTest {
	public static void main(String[] args) {
		SparkConf conf=new SparkConf().setAppName("UDF").setMaster("local");
		JavaSparkContext sc=new JavaSparkContext(conf);
		JavaHiveContext hsc=new JavaHiveContext(sc);
		hsc.registerFunction("udf_lengh", new UDF1<String, Integer>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Integer call(String t1) throws Exception {
				return t1.length();
			}
		}, DataType.IntegerType);
		
		
	}
}
