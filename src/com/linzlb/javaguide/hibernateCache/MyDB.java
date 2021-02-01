package com.linzlb.javaguide.hibernateCache;

import java.util.ArrayList;
import java.util.List;

public class MyDB {
	private static List<Student> list = new ArrayList<Student>();

	//初始化数据库,假设有三个学生
	static{
		Student s1 = new Student();
		s1.setId(1);
		s1.setName("aaa");
		Student s2 = new Student();
		s2.setId(2);
		s2.setName("bbb");
		Student s3=new Student();
		s3.setId(3);
		s3.setName("ccc");
		list.add(s1);
		list.add(s2);
		list.add(s3);
	}
	
	static Student getStudentFromDB(Integer id){
		for(Student s: list){
			if(s.getId().equals(id)){
				return s;
			}
		}
		return null;// 在数据库中没有.
	}
}
