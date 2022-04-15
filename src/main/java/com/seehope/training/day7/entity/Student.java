package com.seehope.training.day7.entity;

public class Student implements Comparable {
	private String name;
	private int score;
	
	@Override
	public int compareTo(Object o) {
		System.out.println("compareTo..");
		Student s = (Student)o;
		return this.score - s.score;
		
	}	
	
	@Override
	public int hashCode() {
		System.out.println("hashCode...(Student.java)");
		return this.name.hashCode() ^ this.score;
	}


	@Override
	public boolean equals(Object obj) {
		System.out.println("equals...");
		if(this == obj){
			System.out.println("true...");
			return true;
			
		}
		
		if(!obj.getClass().getName().equals(this.getClass().getName())){
			System.out.println("false...");
			return false;
		}
		
		Student s = (Student)obj;
		if(s.getName().equals(this.name) && s.getScore() == this.score){
			System.out.println("true1...");
			return true;
		}
		System.out.println("false1...");
		
		return false;
	}


	public String toString(){
		return this.name+":"+score;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
}
