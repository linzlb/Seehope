package day7.list;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import day7.entity.Student;

public class TestList {

	public static void main(String[] args) {
		Student stu = new Student("eric",100);
		Student stu2 = new Student("meten",20);
		Student stu3 = new Student("janet",130);
		Student stu4 = new Student("kacy",30);
		Student stu5 = new Student("jarry",50);
		
		List l = new ArrayList();
		
		l.add(stu);
		l.add(stu2);
		l.add(stu3);
		l.add(stu4);
		l.add(stu5);
		
		for(Object o : l){            //foreach—≠ª∑
			System.out.println(o);
		}
		
		System.out.println("≈≈–Ú∫Û...");
		Collections.sort(l, new MyComparator());

		for(Object o : l){             //foreach—≠ª∑
			System.out.println(o);
		}
	}

}
