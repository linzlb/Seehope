package com.seehope.training.day8.io1;

import java.io.File;
import java.io.IOException;

public class TestFile {
//	public static void main(String[] args) {
//		File file = new File("F:\\רҵ\\java\\û�õ�\\������\\io1");
//		try {
//			file.createNewFile();
//			String fileName = file.getName();
//			if(fileName.endsWith(".java")) {
//				System.out.println(fileName);
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		public static void main(String[] args) throws Exception{
			File file = new File("e:/HelloWorld.jva");
			file.createNewFile();
			String fileName = file.getName();
			if(fileName.endsWith(".java")){
				System.out.println(fileName);
			}
			testFile();
			
		}
		
		public static void testFile() {
			File file = new File("G:\\java\\IO��������\\io2.txt");
			boolean flag = true;
			
			if (file.exists()) {
				System.out.println("�ļ��Ѵ���");
				if(file.canRead()) {
					System.out.println("�ļ��ɶ�");
				}
				if(file.canWrite()) {
					System.out.println("�ļ���д");
				}
				if(!file.isDirectory()) {
					if(file.canExecute()){
						System.out.println("�ļ��ǿ�ִ���ļ�");
					}
					System.out.println("·���ǣ�" + file.getParent());
					File parent = file.getParentFile();
					System.out.println(parent.isDirectory());
				}
//				if(file.delete()){
//					System.out.println("�ļ�ɾ���ɹ�");
//				}
				
					
			}else
				//�ļ��������½��ļ�
				if(flag) {
					try {
						if(file.createNewFile()) {
							System.out.println("�ļ������ɹ�");
						}else{
							System.out.println("�ļ�����ʧ��");
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					if(file.mkdir()){
						System.out.println("Ŀ¼�ļ������ɹ�");
					}else{
						System.out.println("Ŀ¼�ļ�����ʧ��");
					}
				}
			}
		
		
	}

