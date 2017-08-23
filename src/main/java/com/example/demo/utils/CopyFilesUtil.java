package com.example.demo.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class CopyFilesUtil {
	
	public static void main(String[] args) {
		copyVideo("E:\\test1.txt","d:\\test2.txt");
	};
	private static void copyVideo(String srcFile,String destFile){
		// 源File对象
        File source = new File(srcFile);
        // 备份的File对象
        File target = new File(destFile);
        System.out.println(source + "," + target);
       
        //通过JVM读取java.io.tmpdir属性取得临时文件夹
        File targetDir = new File(System.getProperty("java.io.tmpdir"));
       
        try
        {
            //在同一个文件夹复制文件
            FileUtils.copyFile(source, target);
            // 根据指定的文件夹复制
            FileUtils.copyFileToDirectory(source, targetDir);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
	}
}
