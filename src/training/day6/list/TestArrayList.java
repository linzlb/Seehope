package training.day6.list;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import training.day6.list.entity.Student;

public class TestArrayList {
	public static void main(String[] args) {
		test2();
	}

	public static void test2() {
		List l = new ArrayList();
		Student stu = new Student("meten", 20);
		l.add(stu);
		l.add(stu);
		l.add(stu);
		l.add(stu);
		l.add(stu);

		// �±����
		for (int i = 0; i < l.size(); i++) {
			System.out.println("l.get(i)Ϊ  "+l.get(i));
		}
		Student stu2 = new Student("meten",20);
		l.set(1, stu2);
		System.out.println(l.contains(stu));
		System.out.println(l.contains(stu2));
	}

	public static void test1() {
		List l = new ArrayList();
		l.add(1);
		l.add(2);
		l.add(2);

		// �ɱ���
		Iterator it = l.iterator();
		while (it.hasNext()) {
			Object o = null;
			Integer i = (Integer) it.next();
			System.out.println("����i= " +i);
		}
		// �±����
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
		}
		
		System.out.println("l.contains(2) Ϊ " + l.contains(2));
	}

}
