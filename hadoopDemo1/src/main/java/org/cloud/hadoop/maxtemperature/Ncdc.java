package org.cloud.hadoop.maxtemperature;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.cloud.hadoop.utils.FileUtils;

public class Ncdc {

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf);
		FileUtils.setJobPath("d:\\hadoop\\temperature", job, conf);
		job.setJarByClass(Ncdc.class);
		
		//job.setInputFormatClass(ZipFileInputFormat.class);
		//job.setOutputFormatClass(TextOutputFormat.class);
		
		job.setMapperClass(MaxTemperatureMapper.class);
		job.setReducerClass(MaxTemperatureReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		System.exit(job.waitForCompletion(true) ? 0 : 1);

	}

}
