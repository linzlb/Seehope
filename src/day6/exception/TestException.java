package day6.exception;

public class TestException {
	public static void main(String[] args) {
		//test1();//java.lang.NullPointerException
		test2();
		chufa(1,0);//java.lang.ArithmeticException: / by zero
	}

	public static void test1(){
		Student s =null;
		s.study();
	}
	
	public static void test2(){
		try {
			Class c = Class.forName("day6.exception.Studen");
			//Class c = Class.forName("day6.exception.Student");
			System.out.println("--------");
		} catch (Exception e) {
			System.out.println("类没有找到...");
		} finally {
			System.out.println("释放资源....");//一定会执行
		}

		System.out.println("继续执行");
	}
	
	public static void chufa(int a, int b){
		System.out.println(a/b);
	}
}


class Student {
	public void study() {
		System.out.println("study方法");
	}
}