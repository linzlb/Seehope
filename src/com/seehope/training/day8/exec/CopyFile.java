package com.seehope.training.day8.exec;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.seehope.training.day8.io1.IoUtil;
import com.seehope.training.day8.io1.StreamType;

public class CopyFile {
	static String srcurl = "G:\\java\\IO��������\\���Ƹ���\\1\\������ - ���ֻ�������.mp3";
	static String descurl = "G:\\java\\IO��������\\���Ƹ���\\2\\������ - ���ֻ�������copy.mp3";
		
	public static void copyfile(){
		FileInputStream fis = null;
		FileOutputStream fos = null;
	
		try{
			fis = (FileInputStream) IoUtil.createInputStream(
					StreamType.FileInputStream,
					srcurl);
			fos = (FileOutputStream) IoUtil.createOutputStream(
					StreamType.FileOutputStream, 
					false, 
					descurl);
		
			int data = -1;
			byte[] buf = new byte[1024];
			//byte[] buf = new byte[1024*1024];
			while(-1 != (data = fis.read(buf))) {
				fos.write(buf, 0, data);
			}
			fos.flush();
			
		}catch(FileNotFoundException e){
			
		}catch(IOException e) {
			
		}finally {
			IoUtil.close(fis);
			IoUtil.close(fos);
		}
	}
	
	public static void main(String[] args) {
		CopyFile.copyfile();
	}
}
