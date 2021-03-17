package com.zasui.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Test {

	//简单匹配 
	public static void meetRegexp(){
		//简单认识正则表达式的概念
		p("abc".matches("..."));//“.” 代表除行终止符外的任何字符（如果DOTALL标志置位，则表示任何字符）
		p("a8729a".replaceAll("\\d", "-"));//\d 数字：[0-9] ,,,********************

		Pattern p = Pattern.compile("[a-z]{3}");
		Matcher m = p.matcher("fgh");
		p(m.matches());
		//上面3句等价于，不过上面的效率比较高
		p("fgha".matches("[a-z]{3}"));
	}

	//初步认识. * + ?
	public static void mark(){
		p("a".matches("."));//true
		p("aa".matches("aa"));//true
		p("aaaa".matches("a*"));//true
		p("aaaa".matches("a+"));//true
		p("".matches("a*"));//true,*表示0个或者多个
		p("aaaa".matches("a?"));//false
		p("".matches("a?"));//true
		p("a".matches("a?"));//true
		p("214523145234532".matches("\\d{3,100}"));//true
		p("192.168.3.af".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"));//false
		p("192".matches("[0-2][0-9][0-9]"));//true
		p("192.168.3.23".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"));//true
	}

	//范围
	public static void scope(){

		p("a".matches("[abc]"));//true
		p("a".matches("[^abc]"));//false
		p("d".matches("[^abc]"));//true
		//下面3种一样的
		p("A".matches("[a-zA-Z]"));//true
		p("A".matches("[a-z]|[A-Z]"));//true
		p("A".matches("[a-z[A-Z]]"));//true
		//取交集
		p("R".matches("[A-Z&&[RFG]]"));//true
	}

	//认识\s \w \d \
	public static void mark2(){

		p(" \n\r\t".matches("\\s{4}"));//4个空白字符,true
		p(" ".matches("\\S"));//非空白字符,false
		p("a_8".matches("\\w{3}"));//3个单词字符,true
		p("chinese_name".matches("\\w+"));//true
		p("abc888&^%".matches("[a-z]{1,3}\\d+[&^#%]+"));//“+”一次或多次,true
		p("\\".matches("\\\\"));//true
	}

	//POSIX Style
	public static void POSIX(){
		p("A".matches("\\p{Lower}"));//false
		p("a".matches("\\p{Lower}"));//true
	}

	//boundary边界
	public static void boundary(){

		p("hello sir".matches("^h.*"));//^与整个输入序列的开头匹配
		p("hello sir".matches(".*ir$"));//$和输入序列的结尾匹配
		p("hello sir".matches("^h[a-z]{1,3}o\\b.*"));//\b 单词边界 
		p("hellosir".matches("^h[a-z]{1,3}o\\b.*"));//\b 单词边界
		//whilte lines
		p(" \n".matches("^[\\s&&[^\\n]]*\\n$"));//直接换行的不算

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
		m.reset();//恢复原来的。不然会影响find
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
		p(m.lookingAt());//每次都从头上开始找。所以全是true

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
		Pattern p = Pattern.compile("(\\d{3,5})([a-z]{2})");//X{n,m} X，至少 n 次，但是不超过 m 次 
		String s = "123aa-34345bb-234cc-00";
		Matcher m = p.matcher(s);
		while(m.find()) {		
			p(m.group(1)+"___"+m.group(2));  //打印全部就不写2，输出数字就是1.输出字母就2
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

	//non-capturing groups,拿到a后面的4个
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

	//flags的简写
	public static void flags(){

		Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
		//等价于下面的
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
		//TraverseMap.findLookingAt();//**********************这个忘记了
		//TraverseMap.replacement();
		//TraverseMap.group();
		//TraverseMap.qulifiers();
		//TraverseMap.nonCapturingGroups();
		//TraverseMap.backRefenrences();
		Test.flags();
	}


	/**
	 * 输出方法
	 * @param o
	 */
	public static void p(Object o) {
		System.out.println(o);
	}

}

