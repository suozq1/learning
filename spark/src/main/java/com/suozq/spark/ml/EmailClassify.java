package com.suozq.spark.ml;

import java.util.Arrays;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.mllib.classification.LogisticRegressionModel;
import org.apache.spark.mllib.classification.LogisticRegressionWithLBFGS;
import org.apache.spark.mllib.feature.HashingTF;
import org.apache.spark.mllib.regression.LabeledPoint;

public class EmailClassify {
	public static void main(String[] args) {
		//初始化spark环境
		SparkConf conf=new SparkConf().setAppName("EmailClassify").setMaster("local");
		JavaSparkContext sc=new JavaSparkContext(conf);
		
		//读取两类测试数据
		JavaRDD<String> user=sc.textFile("file:///G:/sparkTemp/json.txt");
		JavaRDD<String> log=sc.textFile("file:///G:/sparkTemp/jmeter.log");
		
		//提取特征向量并打标签
		HashingTF tf = new HashingTF(1000);
		JavaRDD<LabeledPoint> userLabel=user.map(x->new LabeledPoint(0, tf.transform(Arrays.asList(x.split(" |:")))));
		JavaRDD<LabeledPoint> logLabel=log.map(x->new LabeledPoint(1, tf.transform(Arrays.asList(x.split(" |:")))));
		
		//合并并缓存数据
		JavaRDD<LabeledPoint> input=userLabel.union(logLabel);
		input.cache();
		
		//用逻辑回归算法训练并得到模型
		LogisticRegressionModel model=  new LogisticRegressionWithLBFGS().run(input.rdd());
		
		//预测
		System.out.println(model.predict(tf.transform(Arrays.asList("{name:yuan,age:18}"))));
		
		sc.close();
	}
}
