package com.linzlb.javaguide.hibernateCache;

import java.util.HashMap;
import java.util.Map;

/*
 * 模拟hibernate缓存
 */
public class Cache {
	//使用map来模拟缓存
	static Map<Integer,Student> maps=new HashMap<>();
	
	public static Student getStudent(Integer id){  //s.get()
		//先到缓存去找
		if(maps.containsKey(id)){
			//在缓存有
			System.out.println("从缓存取出---"+maps.get(id).getName());
			return maps.get(id);
		}else{
			//到数据库取
			Student stu=MyDB.getStudentFromDB(id);
			System.out.println("从数据库中取出---"+stu.getName());
			//放入缓存
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
