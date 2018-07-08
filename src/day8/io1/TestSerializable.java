package day8.io1;


import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import day8.io.entity.Student;

public class TestSerializable {
	public static void main(String[] args) {
		testObjectOutputStream();
		testObjectInputStream();
	}

	public static void testObjectInputStream() {
		InputStream is = null;
		ObjectInputStream ois = null;
		try {
			is = IoUtil.createInputStream(StreamType.FileInputStream,
					"G:/java/workpalce/Seehope/src/day8/data");
			ois = new ObjectInputStream(is);
			try {
				while (true) {
					ArrayList al = (ArrayList)ois.readObject();
					for(Object o : al){
						System.out.println(o);
					}
				}
			} catch (EOFException e) {
				System.out.println("文件读完了");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void testObjectOutputStream() {
		OutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = IoUtil.createOutputStream(StreamType.FileOutputStream, false,
					"G:/java/workpalce/Seehope/src/day8/data");
			oos = new ObjectOutputStream(fos);
			ArrayList al = new ArrayList();
			Student s = new Student("meten", 30);
			Student s2 = new Student("eric", 18);
			Student s3 = new Student("janet", 19);
			al.add(s);
			al.add(s2);
			al.add(s3);
			oos.writeObject(al);
			oos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
