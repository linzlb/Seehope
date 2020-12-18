package com.seehope.training.day8.exec2;
/*
 * Student��     ѧ����
 * ���ԣ�����   һ�Ŵ��   һ�ſ��� 
 */
public class Student {
	//private String name;
	private Paper paper;
	private AnswerSheet answerSheet;
	
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}

	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	public AnswerSheet getAnswerSheet() {
		return answerSheet;
	}

	public void setAnswerSheet(AnswerSheet answerSheet) {
		this.answerSheet = answerSheet;
	}

	public Student() {
		super();
		this.paper = paper;
		this.answerSheet = answerSheet;
		// TODO Auto-generated constructor stub
	}
	
}
