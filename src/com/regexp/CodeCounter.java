package com.regexp;

/**
 * @author 林政利
 * @Date 2015.07.10修改
 * @function 计算某文件夹下.java结尾的代码行数
 * add to git in 20180708pm
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CodeCounter {

	private static long normalLines = 0;//正常代码
	private static long commentLines = 0;//注释代码
	private static long whiteLines = 0;//空白行
	private static String url;

	public static void main(String[] args) {
		//url = "E:\\myeclipse8\\workplace_SE_WEB\\Seehope";//utl为目标文件夹地址
		//String str = "G:\\java\\workpalce\\Seehope\\src";
		//url = "E:\\myeclipse8";
		url = "/Users/linzlb/eclipse_workspace/Seehope";
		CodeCounter.show();
	}
	
	//展示：
	private static void show(){
		System.out.println(new SimpleDateFormat("yyyy年MM月dd日，HH:mm:ss.SSS").format(new Date()) + ",开始计算");
		cp(url);
		//System.out.println(new SimpleDateFormat("yyyy年MM月dd日，HH:mm:ss.SSS").format(new Date()) + ",完成计算，开始显示");
		
		//测试发现打印少量还是很快的，1毫秒内可以完成
		System.out.println(url+"文件夹下共有Java代码：");
		System.out.println("代码normalLines:" + normalLines +"行");
		System.out.println("注释commentLines:" + commentLines +"行");
		System.out.println("空白行whiteLines:" + whiteLines +"行");
		System.out.println(new SimpleDateFormat("yyyy年MM月dd日，HH:mm:ss.SSS").format(new Date()) + ",完成");
	
	}
	
	//将传进来的路径转化为文件形式并调用计算方法。
	private static void cp(String url){
		File f = new File(url);
		compute(f);
	}
	
	//将传进来的文件夹中的文件和子文件夹中的文件挨个传给算代码行数的方法
	private static void compute(File file){
		if(file.isFile()) {
			//下面2种写法都可以
			//if(file.getName().endsWith(".java")){
			if(file.getName().matches(".*\\.java$")) {
				parse(file);
			}
			return;
		}
		
		File[] codeFiles = file.listFiles();
		assert codeFiles != null;
		for(File child : codeFiles) {
			compute(child);
		}
		
		/*
		 *原始代码，只能看一个文件夹下的。文件夹下文件夹的就看不到，为什么？？
		 * File[] codeFiles = file.listFiles();
			for(File child : codeFiles){
			if(child.getName().matches(".*\\.java$")) {
				System.out.print("1");
				parse(child);
			}
		}*/
	}
	
	//读传进来的文件中的代码行数
	private static void parse(File f) {
		BufferedReader br = null;
		boolean comment = false;//判断是否为注释
		try {
			br = new BufferedReader(new FileReader(f));
			String line;
			while(null != (line = br.readLine())) {
				line = line.trim();//防止tab键，空格后才开始注释的句子被算成代码
				if(line.matches("^[\\s&&[^\\n]]*$")) {
					whiteLines ++;
				} else if (line.startsWith("/*") && !line.endsWith("*/")) {
					commentLines ++;
					comment = true;
				} else if (line.startsWith("/*") && !line.endsWith("*/")) {
					//考虑只用这个注释了1行的
					commentLines ++;
				} else if (comment) {
					commentLines ++;
					if(line.endsWith("*/")) {
						comment = false;
					}
				} else if (line.startsWith("//")) {
					commentLines ++;
				} else {
					normalLines ++;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null) {
				try {
					br.close();
					br = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}