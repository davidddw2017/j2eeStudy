package org.cloud.hadoop.utils;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class FileUtils {
	public static void setJobPath(String filePath, Job job, Configuration conf) throws IOException {
		// 指定本次mr 输入的数据路径 和最终输出结果存放在什么位置
		FileInputFormat.setInputPaths(job, filePath + "\\input");
		Path path = new Path(filePath + "\\output");
		FileOutputFormat.setOutputPath(job, path);
		// 如果出现0644错误或找不到winutils.exe,则需要设置windows环境和相关文件.
		FileSystem fileSystem = path.getFileSystem(conf);
		if (fileSystem.exists(path)) {
			fileSystem.delete(path, true);// true的意思是，就算output有东西，也一带删除
		}
	}
}
