package com.seehope.training.day7.set;

import java.util.HashSet;
import java.util.Set;

import com.seehope.training.day7.entity.Student;

public class TestTreeSet {
	public static void main(String[] args) {
		
		Student stu = new Student("eric",100);
		Student stu2 = new Student("meten",20);
		Student stu3 = new Student("janet",130);
		Student stu4 = new Student("kacy",30);
		Student stu5 = new Student("jarry",100);
		
	 //   Set set = new TreeSet();
		Set set = new HashSet();
		set.add(stu);
		set.add(stu2);
		set.add(stu3);
		set.add(stu4);
		set.add(stu5);
		
		for(Object o : set){
			System.out.println(o);
		}
	}
}
