/*
 *  AnswerSheet��    �����
 *  ���ԣ�ÿ����Ĵ�  
 *  ��ʾ�������ÿ����Ĵ���HashMap��ţ�keyΪString��
 *  ��ʾ��ţ�valueΪѧ���Ĵ�
 */

package training.day8.exec2;

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
