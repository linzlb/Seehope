/*
 *  AnswerSheet类    答卷类
 *  属性：每道题的答案  
 *  提示：答卷中每道题的答案用HashMap存放，key为String，
 *  表示题号，value为学生的答案
 */

package day8.exec2;

import java.util.TreeMap;

public class AnswerSheet {
	private TreeMap<String,String> answers;

	public TreeMap<String, String> getAnswers() {
		return answers;
	}

	public void setAnswers(TreeMap<String, String> answers) {
		this.answers = answers;
	}

	public AnswerSheet(TreeMap<String, String> answers) {
		super();
		this.answers = answers;
		// TODO Auto-generated constructor stub
	}
	
}
