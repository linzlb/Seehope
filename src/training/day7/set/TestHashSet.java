package training.day7.set;

import java.util.HashSet;
import java.util.Set;

import training.day7.entity.Animal;
import training.day7.entity.Student;

public class TestHashSet {
	public static void main(String[] args) {
		
		Student stu = new Student("eric",100);
		Student stu2 = new Student("meten",20);
		Student stu3 = new Student("janet",130);
		Student stu4 = new Student("kacy",30);
		Student stu5 = new Student("jarry",50);
		Student stu6 = new Student("jarry",50);
		Animal a = new Animal("jarry",50);
		
		
		
		Set set = new HashSet();
		set.add(stu);
		set.add(stu2);
		set.add(stu3);
		set.add(stu4);
		set.add(stu5);
		set.add(stu6);
		System.out.println();
		set.add(a);
		System.out.println();
		for(Object o : set){
			System.out.println(o);
		}
	}
}
