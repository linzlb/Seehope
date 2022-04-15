/*
 * ɾ��ָ��Ŀ¼���������ָ���ļ�(txt�ļ�)
 */

package com.seehope.training.day8.exec;

import java.io.File;

public class DeleteAllFile {
	public static void main(String[] args) {
		String str = "G:/java/������1";
		deleteAllFile(new File(str));
	}

	public static void deleteAllFile(File file) {
		if(file.isFile()) {
			if(file.getName().endsWith(".txt")){
				file.delete();
			}
			return;
		}
		
		File[] files = file.listFiles();
		//System.out.println(files.length);
		for(File f : files) {
			deleteAllFile(f);
		}
	}
}

/*Ҫ���ļ�"file.dat"�ж�����10���ֽڵ�����c��,�����ĸ������ʺ�? ��D��
A�� FileInputStream in=new FileInputStream("file.dat"); in.skip(9); int c=in.read(); 
B�� FileInputStream in=new FileInputStream("file.dat"); in.skip(10); int c=in.read(); 
C�� FileInputStream in=new FileInputStream("file.dat"); int c=in.read(); 
D�� RandomAccessFile in=new RandomAccessFile("file.dat"); in.skip(9); int c=in.readByte();*/ 
