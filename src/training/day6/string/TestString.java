package training.day6.string;

public class TestString {

	public static void main(String[] args) {
		Integer i = 5;
		System.out.println(i);
		testBaoZhuang2(i);
		System.out.println(i);
		System.out.println("--------------------------");
		
		testString2();
		testString();
	}
	
	public static void testBaoZhuang2(Integer a){
		a = 6;
	}
	
	public static void testBaoZhuang(){
		//1 String -> int
		String str = "1";
		int i = Integer.parseInt(str);
		
		//2.int -> String
		int i2 = 3;
		String str2 = i2+"";
		
		//3.int -> Integer
		int i3 = 5;
		Integer i4 = i3;//Integer i = new Integer(3);//1.4
		
		//4.Integer -> int;
		Integer i5 = 5;
		int i6  = i5;
		
		//5.Integer -> String
		Integer i7 = 6;
		String str3 = i7.toString();
		
		//6.String -> Integer
		String str4 = "3";
		Integer i8 = Integer.getInteger(str4);
	}
	
	public static void testString2(){
		String str = "meten";
		String str2 = new String("meten");
		System.out.println(str == str2);
	}
	public static void testString(){
		String str = "meten";
		String str2 = "meten";
		System.out.println("str == str2," + (str == str2));
		String str3 = "meten" +" is "+ " a " + "teacher";
		
		StringBuffer sb = new StringBuffer();
		sb.append("meten ");
		sb.append("is ");
		sb.append("a ");
		sb.append("teacher");
		
		System.out.println(sb.toString());
		
		StringBuilder sb2 = new StringBuilder();
		sb2.append("meten ");
		sb2.append("is ");
		sb2.append("a ");
		sb2.append("teacher");
		System.out.println(sb2.toString());
	}

}

class Student{
	int num;
}