package com.suozq.spark.io;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import com.suozq.spark.SparkContextHolder;

public class TxtFileReader {
	public static void main(String[] args) {
		JavaSparkContext sc = SparkContextHolder.getSparkContext();
		JavaRDD<String> xmlRdd = sc.textFile(TxtFileReader.class.getResource("/file/db.txt").toString());
		JavaRDD<String> filterRdd = xmlRdd.filter(x -> x.contains("groupId")).map(x-> x.replaceAll("</?groupId>", ""));
		filterRdd.saveAsTextFile(SparkContextHolder.SPARK_TEMP_DIR+"/groupId");
	}
}
