package com.suozq.spark.ml;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.mllib.recommendation.ALS;
import org.apache.spark.mllib.recommendation.Rating;

public class ALSTest {
	public static void main(String[] args) {
	   JavaRDD<Rating> input=null;
	   new ALS().run(input);
	}
}
