package com.suozq.spark.streaming;

import org.apache.spark.SparkConf;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

public class JavaStreamingTest {
	public static void main(String[] args) {
		SparkConf conf=new SparkConf().setAppName("JavaSteaming").setMaster("local");
		JavaStreamingContext jsc=new JavaStreamingContext(conf, Durations.seconds(1));
		JavaDStream<String> user=jsc.textFileStream("file:///G:/sparkTemp/json.txt");
		
	}
}
