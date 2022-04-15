/*
 *  Question��    ������
 *  ���ԣ���� ��Ŀ����    ����ѡ��    ��ȷ��(��ѡ)
 *  ��ʾ������ѡ����ArrayList
 */

package com.seehope.training.day8.exec2;

import java.util.ArrayList;

/**
 * Question��    ������
	���ԣ���� ��Ŀ����    ����ѡ��    ��ȷ��(��ѡ)
	��ʾ������ѡ����ArrayList
 * @author meten
 *
 */
public class Question {
	private Integer id;
	private String desc;
	private ArrayList<String> choice;
	private ArrayList<String> keys;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(this.id);
		sb.append(".");
		sb.append(this.desc);
		sb.append("?");
		sb.append("\n");
		for(String c : this.choice){
			sb.append(c);
			sb.append(" ");
		}
		return sb.toString();
	}
	public ArrayList<String> getChoice() {
		return choice;
	}
	public void setChoice(ArrayList<String> choice) {
		this.choice = choice;
	}
	public ArrayList<String> getKeys() {
		return keys;
	}
	public void setKeys(ArrayList<String> keys) {
		this.keys = keys;
	}
}
