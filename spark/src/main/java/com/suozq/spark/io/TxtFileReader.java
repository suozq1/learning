package com.suozq.spark.io;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;

public class TxtFileReader {
	public static void main(String[] args) {
		SparkConf conf=new SparkConf().setAppName("SparkApp").setMaster("spark://10.99.35.23:7077");
		SparkContext sc=new SparkContext(conf);
		//SparkSession spark = SparkSession.builder().appName("Simple Application").master("spark://10.99.35.23:7077").getOrCreate();
		
		//System.out.println(spark);
	/*	//JavaSparkContext sc = SparkContextHolder.getSparkContext();
		JavaRDD<String> xmlRdd = sc.textFile(TxtFileReader.class.getResource("/file/db.txt").toString());
		JavaRDD<String> filterRdd = xmlRdd.filter(x -> x.contains("groupId")).map(x-> x.replaceAll("</?groupId>", ""));
		filterRdd.saveAsTextFile(SparkContextHolder.SPARK_TEMP_DIR+"/groupId");*/
		sc.stop();
		
	}
}
