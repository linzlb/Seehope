package com.zasui.regexp;

/**
 * @author ������
 * @Date 2015.07.10�޸�
 * @function ����ĳ�ļ�����.java��β�Ĵ�������
 * add to https://github.com/linzlb/Seehope in 20180708pm by 798648334@qq.com
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CodeCounter {

	private static long normalLines = 0;//��������
	private static long commentLines = 0;//ע�ʹ���
	private static long whiteLines = 0;//�հ���
	private static String url;

	public static void main(String[] args) {
		url = "/Users/linzlb/intellij_idea_workspace/Seehope";
		CodeCounter.show();
	}
	
	//չʾ��
	private static void show(){
		System.out.println(new SimpleDateFormat("yyyy��MM��dd�գ�HH:mm:ss.SSS").format(new Date()) + ",��ʼ����");
		cp(url);
		//System.out.println(new SimpleDateFormat("yyyy��MM��dd�գ�HH:mm:ss.SSS").format(new Date()) + ",��ɼ��㣬��ʼ��ʾ");
		
		//���Է��ִ�ӡ�������Ǻܿ�ģ�1�����ڿ������
		System.out.println(url+"�ļ����¹���Java���룺");
		System.out.println("����normalLines:" + normalLines +"��");
		System.out.println("ע��commentLines:" + commentLines +"��");
		System.out.println("�հ���whiteLines:" + whiteLines +"��");
		System.out.println(new SimpleDateFormat("yyyy��MM��dd�գ�HH:mm:ss.SSS").format(new Date()) + ",���");
	
	}
	
	//����������·��ת��Ϊ�ļ���ʽ�����ü��㷽����
	private static void cp(String url){
		File f = new File(url);
		compute(f);
	}
	
	//�����������ļ����е��ļ������ļ����е��ļ�������������������ķ���
	private static void compute(File file){
		if(file.isFile()) {
			//����2��д��������
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
		 *ԭʼ���룬ֻ�ܿ�һ���ļ����µġ��ļ������ļ��еľͿ�������Ϊʲô����
		 * File[] codeFiles = file.listFiles();
			for(File child : codeFiles){
			if(child.getName().matches(".*\\.java$")) {
				System.out.print("1");
				parse(child);
			}
		}*/
	}
	
	//�����������ļ��еĴ�������
	private static void parse(File f) {
		BufferedReader br = null;
		boolean comment = false;//�ж��Ƿ�Ϊע��
		try {
			br = new BufferedReader(new FileReader(f));
			String line;
			while(null != (line = br.readLine())) {
				line = line.trim();//��ֹtab�����ո��ſ�ʼע�͵ľ��ӱ���ɴ���
				if(line.matches("^[\\s&&[^\\n]]*$")) {
					whiteLines ++;
				} else if (line.startsWith("/*") && !line.endsWith("*/")) {
					commentLines ++;
					comment = true;
				} else if (line.startsWith("/*") && !line.endsWith("*/")) {
					//����ֻ�����ע����1�е�
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