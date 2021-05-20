package com.linzlb.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileTools {

    /**
	 * 读取文件内容
	 * @param fileName	文件绝对路径
	 * @return		文件内容
	 */
	public static byte[] readContent(String fileName){
		byte[] value = null;
		try {
			InputStream input = new FileInputStream(fileName);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] cache = new byte[100];
			int len = -1;
			while ((len = input.read(cache)) != -1) {
				baos.write(cache, 0, len);
			}
			value = baos.toByteArray();
			input.close();
			return value;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void writeFile(String path,byte[] value){
		File file = null;
		try {
			OutputStream out = new FileOutputStream(new File(path));
			out.write(value);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeFile2(String path,String value){
		File file = null;
		try {
			//OutputStream out = new FileOutputStream(new File(path));
			FileWriter writer = new FileWriter(path, true);//true代表追加的方式
			writer.write(value);
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeFile(String path,byte[] value,boolean appendFlag){
		File file = null;
		try {
			OutputStream out = new FileOutputStream(new File(path),appendFlag);
			
			out.write(value);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 文件内容为16进制字符串，读取内容并 转为 原始报文
	 * @param filePath	文件绝对路径
	 * @return
	 */
	public static byte[] hesStrToByte(String filePath) {
		byte[] req = FileTools.readContent(filePath);
		String str = new String(req).trim().replace("\r\n", "").replace("\r", "").replace("\n", "").replace(" ", "");
		
		String value = null;
		byte[] retByte = new byte[str.length() / 2];
		for (int i = 0; i < str.length(); i = i + 2) {
			value = str.substring(i, i + 2);
			retByte[i / 2] = (byte) Integer.parseInt(value, 16);
		}
		return retByte;
	}
	
	private static String parse(String str, String regex) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		if (m.find()) {
			return m.group();
		}
		return "";
	}
	
	public static void main(String[] args) {
		byte[] content = readContent("/Users/linzlb/Desktop/FuturePlan/杂记～");
		String contentStr = new String(content);
		System.out.println(contentStr);
//		String[] contentLine = contentStr.split("\n");
//		for(int i=0; i<contentLine.length; i++){
//			//System.out.println(contentLine[i]+"\n\n\n");
//			String result = //parse(contentLine[i], "(([a-zA-Z0-9]){2}\\s+){15}[a-zA-Z0-9]{2}");不满足少的
//				contentLine[i].substring(13, 63).replace("-0--1--2--3--4--5--6-HEX Value-A--B--C--D--E--F- ", "");
//			System.out.println(result);
//		}
	}
}