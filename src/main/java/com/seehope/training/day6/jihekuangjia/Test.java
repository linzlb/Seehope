package com.seehope.training.day6.jihekuangjia;

public class Test {
	public static void main (String[] args) {
		testSortList();
	}
	
	public static void testSortList(){
		SortList sl = new SortList(100);
		for(int i = 0; i < 101; i++){
			int score = (int)(Math.random() * 100);
			sl.add(new Student("stu"+i, score));
		}
		
		for(int i = 0; i < sl.size(); i++){
			Student stu = (Student)sl.get(i);
			System.out.println(stu);
		}
	}
	
	public static void testNormalList(){
		NormalList nl = new NormalList(10);
		for(int i = 0; i < 101; i++){
			int score = (int)(Math.random() * 100);
			nl.add(new Student("stu"+i, score));
		}
		
		System.out.println(nl.size());
		
		for(int i = 0; i < nl.size(); i++){
			Student stu = (Student)nl.get(i);
			System.out.println(stu);
		}
	}

}

class Student implements Comparable {
	private String name;
	private int score;
	public Student(){
	}
	
	protected int getScore() {
		return score;
	}

	protected void setScore(int score) {
		this.score = score;
	}

	public String toString(){
		return this.name + ":" + this.score;
	}
	
	public Student(String name, int score){
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int comparat(Object o) {
		return -(this.getScore() - ((Student)o).getScore());
	}
	
}
