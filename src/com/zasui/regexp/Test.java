package com.zasui.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Test {

	//��ƥ�� 
	public static void meetRegexp(){
		//����ʶ������ʽ�ĸ���
		p("abc".matches("..."));//��.�� ���������ֹ������κ��ַ������DOTALL��־��λ�����ʾ�κ��ַ���
		p("a8729a".replaceAll("\\d", "-"));//\d ���֣�[0-9] ,,,********************

		Pattern p = Pattern.compile("[a-z]{3}");
		Matcher m = p.matcher("fgh");
		p(m.matches());
		//����3��ȼ��ڣ����������Ч�ʱȽϸ�
		p("fgha".matches("[a-z]{3}"));
	}

	//������ʶ. * + ?
	public static void mark(){
		p("a".matches("."));//true
		p("aa".matches("aa"));//true
		p("aaaa".matches("a*"));//true
		p("aaaa".matches("a+"));//true
		p("".matches("a*"));//true,*��ʾ0�����߶��
		p("aaaa".matches("a?"));//false
		p("".matches("a?"));//true
		p("a".matches("a?"));//true
		p("214523145234532".matches("\\d{3,100}"));//true
		p("192.168.3.af".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"));//false
		p("192".matches("[0-2][0-9][0-9]"));//true
		p("192.168.3.23".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"));//true
	}

	//��Χ
	public static void scope(){

		p("a".matches("[abc]"));//true
		p("a".matches("[^abc]"));//false
		p("d".matches("[^abc]"));//true
		//����3��һ����
		p("A".matches("[a-zA-Z]"));//true
		p("A".matches("[a-z]|[A-Z]"));//true
		p("A".matches("[a-z[A-Z]]"));//true
		//ȡ����
		p("R".matches("[A-Z&&[RFG]]"));//true
	}

	//��ʶ\s \w \d \
	public static void mark2(){

		p(" \n\r\t".matches("\\s{4}"));//4���հ��ַ�,true
		p(" ".matches("\\S"));//�ǿհ��ַ�,false
		p("a_8".matches("\\w{3}"));//3�������ַ�,true
		p("chinese_name".matches("\\w+"));//true
		p("abc888&^%".matches("[a-z]{1,3}\\d+[&^#%]+"));//��+��һ�λ���,true
		p("\\".matches("\\\\"));//true
	}

	//POSIX Style
	public static void POSIX(){
		p("A".matches("\\p{Lower}"));//false
		p("a".matches("\\p{Lower}"));//true
	}

	//boundary�߽�
	public static void boundary(){

		p("hello sir".matches("^h.*"));//^�������������еĿ�ͷƥ��
		p("hello sir".matches(".*ir$"));//$���������еĽ�βƥ��
		p("hello sir".matches("^h[a-z]{1,3}o\\b.*"));//\b ���ʱ߽� 
		p("hellosir".matches("^h[a-z]{1,3}o\\b.*"));//\b ���ʱ߽�
		//whilte lines
		p(" \n".matches("^[\\s&&[^\\n]]*\\n$"));//ֱ�ӻ��еĲ���

		p("aaa 8888c".matches(".*\\d{4}."));
		p("aaa 8888c".matches(".*\\b\\d{4}."));
		p("aaa8888c".matches(".*\\d{4}."));
		p("aaa8888c".matches(".*\\b\\d{4}."));
	}

	//email
	public static void matchEmail(){
		p("asdfasdfsafsf@dsdfsdf.com".matches("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+"));

		//linzlb,20150922
		p("asdfasdfsafsf@dsdfsdf.com".matches(".+@.+\\.\\w+"));
	}

	//matches find lookingAt
	public static void findLookingAt(){

		Pattern p = Pattern.compile("\\d{3,5}");
		String s = "123-34345-234-00";
		Matcher m = p.matcher(s);
		p(m.matches());
		m.reset();//�ָ�ԭ���ġ���Ȼ��Ӱ��find
		p(m.find());
		p(m.start() + "-" + m.end());
		p(m.find());
		p(m.start() + "-" + m.end());
		p(m.find());
		p(m.start() + "-" + m.end());
		p(m.find());
		//p(m.start() + "-" + m.end());
		p(m.lookingAt());
		p(m.lookingAt());
		p(m.lookingAt());
		p(m.lookingAt());//ÿ�ζ���ͷ�Ͽ�ʼ�ҡ�����ȫ��true

	}

	//replacement
	public static void replacement(){
		Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
		String str = "java Java JAVa JaVa IloveJAVA you hateJava afasdfasdf";
		Matcher m = p.matcher(str);

		StringBuffer buf = new StringBuffer();
		int i=0;
		while(m.find()) {
			i++;
			if(i%2 == 0) {
				m.appendReplacement(buf, "java");
			} else {
				m.appendReplacement(buf, "JAVA");
			}
		}
		m.appendTail(buf);
		p(buf);
	}

	//group
	public static void group(){
		Pattern p = Pattern.compile("(\\d{3,5})([a-z]{2})");//X{n,m} X������ n �Σ����ǲ����� m �� 
		String s = "123aa-34345bb-234cc-00";
		Matcher m = p.matcher(s);
		while(m.find()) {		
			p(m.group(1)+"___"+m.group(2));  //��ӡȫ���Ͳ�д2��������־���1.�����ĸ��2
		}
	}

	//qulifiers
	public static void qulifiers(){

		Pattern p = Pattern.compile(".{3,10}+[0-9]");
		String s = "aaaa5bbbb68";
		Matcher m = p.matcher(s);
		if(m.find()){
			p(m.start() + "-" + m.end());
		}
		else{ 
			p("not match!");
		}

	}

	//non-capturing groups,�õ�a�����4��
	public static void nonCapturingGroups(){
		//Pattern p = Pattern.compile(".{3}(?=a)");
		Pattern p = Pattern.compile("(?=a).{4}");
		String s = "444a66bfa23sv";
		Matcher m = p.matcher(s);
		while(m.find()) {
			p(m.group());
		}

	}

	//back refenrences
	public static void backRefenrences(){
		
		Pattern p = Pattern.compile("(\\d(\\d))\\2");
		String s = "122";
		Matcher m = p.matcher(s);
		p(m.matches());
		
	}

	//flags�ļ�д
	public static void flags(){

		Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
		//�ȼ��������
		p("Java".matches("(?i)(java)"));
	}
	
	public static void main(String[] args) {

		//TraverseMap.meetRegexp();
		//TraverseMap.mark();
		//TraverseMap.scope();
		//TraverseMap.mark2();
		//TraverseMap.POSIX();
		//TraverseMap.boundary();
		//TraverseMap.matchEmail();
		//TraverseMap.findLookingAt();//**********************���������
		//TraverseMap.replacement();
		//TraverseMap.group();
		//TraverseMap.qulifiers();
		//TraverseMap.nonCapturingGroups();
		//TraverseMap.backRefenrences();
		Test.flags();
	}


	/**
	 * �������
	 * @param o
	 */
	public static void p(Object o) {
		System.out.println(o);
	}

}

