package com.suozq.spark.streaming;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.OutputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.Time;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

import scala.Tuple2;

public class JavaStreamingTest {
	public static void main(String[] args) {
		SparkConf conf=new SparkConf().setAppName("JavaSteaming").setMaster("local[2]");
		JavaStreamingContext jsc=new JavaStreamingContext(conf, Durations.seconds(1));
		JavaStreamingContext jsct=JavaStreamingContext.getOrCreate("checkpointDir", ()->{jsc.checkpoint("checkpointDir");return jsc;});
		JavaDStream<String> user=jsc.textFileStream("file:///G:/sparkTemp/json.txt");
		user.print();
		user.window(Durations.seconds(2));
		user.reduceByWindow(new Function2<String,String,String>() {
			@Override
			public String call(String v1, String v2) throws Exception {
				return v1+v2;
			}
		}, null, Durations.seconds(2),Durations.seconds(2));
		JavaPairDStream<String, Integer> savePair=user.mapToPair(new PairFunction<String, String, Integer>() {
			@Override
			public Tuple2<String, Integer> call(String t) throws Exception {
				return new Tuple2<String, Integer>(t, t.length());
			}
		});
		savePair.saveAsHadoopFiles("G://sparkTemp/stream/", "txt");
		savePair.saveAsHadoopFiles("G://sparkTemp/stream/", "txt", Text.class, LongWritable.class, (Class<? extends OutputFormat<?, ?>>) new TextOutputFormat<String,Long>().getClass());
		savePair.foreach(new Function2<JavaPairRDD<String, Integer>,Time,Void>() {

			@Override
			public Void call(JavaPairRDD<String, Integer> v1, Time v2) throws Exception {
				// TODO Auto-generated method stub
				return null;
			}
			
		});
		
		savePair.foreach(new Function<JavaPairRDD<String,Integer>, Void>() {
			
			@Override
			public Void call(JavaPairRDD<String, Integer> v1) throws Exception {
				// TODO Auto-generated method stub
				return null;
			}
		});
		
		savePair.foreachRDD(new Function2<JavaPairRDD<String, Integer>,Time,Void>() {
			@Override
			public Void call(JavaPairRDD<String, Integer> v1, Time v2) throws Exception {
				// TODO Auto-generated method stub
				return null;
			}
		});
		
		savePair.foreachRDD(new Function<JavaPairRDD<String,Integer>, Void>() {

			@Override
			public Void call(JavaPairRDD<String, Integer> v1) throws Exception {
				// TODO Auto-generated method stub
				return null;
			}
		});
		
		jsc.start();
		jsc.awaitTermination();
		jsc.close();
		
	}
}
