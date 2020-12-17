/*
 * Paper��   ������  
 * ���ԣ���������
 * ��ʾ���������HashMap��ţ�keyΪString��
 * ��ʾ��ţ�valueΪ�������
 */
package com.training.day8.exec2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

public class Paper {
	private static Paper paper = new Paper();
	
	
	private TreeMap<Integer,Question> questions = 
		new TreeMap<Integer,Question>();

	public TreeMap<Integer, Question> getQuestions() {
		return questions;
	}

	public void setQuestions(TreeMap<Integer, Question> questions) {
		this.questions = questions;
	}

	private Paper(){
		
	}
	
	public String toString(){
		Set<Integer> ids = questions.keySet();
		StringBuilder sb = new StringBuilder();
		for(Integer id : ids){
			sb.append(questions.get(id).toString());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public static Paper createPaper() {
		//��������
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		is = Paper.class.getClassLoader().getResourceAsStream("com/training/day8/exec2/paper.txt");
		isr = new InputStreamReader(is);
		br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		String st = null;
		try{
			while(null != (st = br.readLine())) {
				sb.append(st);
			}
			st = sb.toString();
			String questions[] = st.split("#");
			for (String question : questions) {
				String s[] = question.split("\\?");
				Question q = new Question();
				q.setId(Integer.parseInt(s[0].trim().split("\\.")[0].trim()));
				q.setDesc(s[0].trim().split("\\.")[1].trim());
				
				String choices[] = s[1].trim().split("\\*")[0].trim().split("\\|");
				ArrayList<String> choice = new ArrayList<String>();
				for(String c : choices) {
					choice.add(c);
				}
				q.setChoice(choice);
				String keys[] = s[1].trim().split("\\*")[1].trim().split("-");
				ArrayList<String> key = new ArrayList<String>();
				for(String k : keys){
					key.add(k);
				}
				q.setKeys(key);
				
				
				Paper.paper.questions.put(q.getId(), q);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return Paper.paper;
	}
	
	
}
