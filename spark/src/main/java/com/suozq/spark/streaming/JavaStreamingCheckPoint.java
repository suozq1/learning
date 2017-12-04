package com.suozq.spark.streaming;

import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.api.java.JavaStreamingContextFactory;

public class JavaStreamingCheckPoint {
	public static void main(String[] args) {
		JavaStreamingContext jsc = JavaStreamingContext.getOrCreate("checkpointDir", new JavaStreamingContextFactory() {
			public JavaStreamingContext create() {
				JavaStreamingContext jsc = new JavaStreamingContext("local[2]", "checkpoint",Durations.seconds(1));
				jsc.checkpoint("checkpointDir");
				return jsc;
			}
		} );
		
		
		jsc = JavaStreamingContext.getOrCreate("checkpointDir",()->{
				JavaStreamingContext jscs = new JavaStreamingContext("local[2]", "checkpoint",Durations.seconds(1));
				jscs.checkpoint("checkpointDir");
				return jscs;
		});
		
		
		
		
	}
}
