package day8.fanxing;
import java.util.ArrayList;

import day8.io.entity.Student;

public class TestFanXing {
	public static void main(String[] args) {
		ArrayList<Student> stus = new ArrayList<Student>();
		stus.add(new Student("meten",11));
		stus.add(new Student("lin",22));
		stus.add(new Student("linlin",33));
		for(Student stu : stus) {
			System.out.println(stu.getName()+"--"+stu.getAge());
		}
	}

}
