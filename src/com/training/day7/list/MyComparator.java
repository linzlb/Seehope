package com.training.day7.list;

import java.util.Comparator;
import com.training.day7.entity.Student;

public class MyComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Student s1 = (Student)o1;
		Student s2 = (Student)o2;
		return s2.getScore() - s1.getScore();
		
	}

}
