package com.training.day8.io1;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class TestReaderWriter {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//testWriter(); //��ָ��·����д�ļ�
		testReader(); //��ָ��·���µ��ļ�
	}

	public static void testWriter(){
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("D:/poem1.txt", "gbk");
			pw.println("������ɽ��");
			pw.println("�ƺ��뺣��");
			pw.println("����ǧ��Ŀ");
			pw.println("����һ��¥");
			pw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}finally{
			//IoUtil.close(pw);
			pw.close();
		}
	}
	public static void testReader(){
		InputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			fis = IoUtil.createInputStream(StreamType.FileInputStream, 
											//"G:/java/workpalce/Seehope/src/day8/note.txt");
											"D:\\poem1.txt");
			//���ֽ�����Ϊ�ַ���
			isr = new InputStreamReader(fis,"gbk");
			br = new BufferedReader(isr);
			String str = null;
			while(null != (str = br.readLine())){
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			IoUtil.close(br);
		}
		
	}
}
