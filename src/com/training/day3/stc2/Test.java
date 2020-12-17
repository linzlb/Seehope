package com.training.day3.stc2;

public class Test {

	public static void main(String[] args) {
		Girl g = new Girl();
		g.name = "zhengli";
		g.nums = 5;
		
		Girl g2 = new Girl();
		g2.name = "linlin";
		g2.nums = 10;
		

		System.out.println(g.name);
		System.out.println(g2.name);
		
		System.out.println(g.nums);
		System.out.println(g2.nums);
		
		Student[] stus = new Student[3];
		for (int i = 0; i<stus.length; i++){
			stus[i] = new Student("������" + (i+1) + "��");
		}
		for (int i = 0; i<stus.length; i++){
			//System.out.println("name:" +stus[i]);
			System.out.println("name:" +stus[i].getName());
		}
		System.out.println("��������"+Student.getNums()+"��ͬѧ");
	}

}
