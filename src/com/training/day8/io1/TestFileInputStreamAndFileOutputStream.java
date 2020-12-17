package com.training.day8.io1;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileInputStreamAndFileOutputStream {

	public static void main(String[] args) {
		testFileOutputStream();
		testFileInputStream();
	}

	public static void testFileOutputStream(){
		FileOutputStream fos = null;
		try {
			fos = (FileOutputStream)IoUtil.createOutputStream(
							StreamType.FileOutputStream,
							true,
							"D:/data");
			
			fos.write(99);
//			fos.write(98);
//			fos.write(97);
			fos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			IoUtil.close(fos);
		}
		System.out.println("�ɹ�");
	}
	public static void testFileInputStream() {
		FileInputStream fis = null;
		try {
			fis = (FileInputStream) IoUtil.createInputStream(
					StreamType.FileInputStream, "D:/data");
			int data = -1;
			while (-1 != (data = fis.read())) {
				System.out.println("data: " +data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IoUtil.close(fis);
		}
	}

}
