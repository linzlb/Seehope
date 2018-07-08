package com.hibernateCache;

import java.util.HashMap;
import java.util.Map;

/*
 * ģ��hibernate����
 */
public class Cache {
	//ʹ��map��ģ�⻺��
	static Map<Integer,Student> maps=new HashMap<Integer,Student>();
	
	public static Student getStudent(Integer id){  //s.get()
		//�ȵ�����ȥ��
		if(maps.containsKey(id)){
			//�ڻ�����
			System.out.println("�ӻ���ȡ��---"+maps.get(id).getName());
			return maps.get(id);
		}else{
			//�����ݿ�ȡ
			Student stu=MyDB.getStudentFromDB(id);
			System.out.println("�����ݿ���ȡ��---"+stu.getName());
			//���뻺��
			maps.put(id, stu);
			return stu;
		}
	}
	
	public static void main(String[] args) {
		getStudent(1);
		getStudent(1);
		getStudent(1);
		getStudent(1);
		getStudent(2);
		getStudent(2);
		getStudent(2);
		getStudent(1);
		getStudent(3);
		getStudent(3);
	}
}
