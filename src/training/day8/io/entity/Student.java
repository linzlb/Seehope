package training.day8.io.entity;

import java.io.Serializable;

public class Student implements Serializable {
	private static final long serialVersionUID = -4496127413306500914L;
	private String name;
	private transient int age;
	
	
	public Student(String name, int age) {
		super();
		this.age = age;
		this.name = name;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		//return super.toString();
		return this.name + ":" + this.age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
