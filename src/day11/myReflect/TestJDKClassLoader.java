package day11.myReflect;

public class TestJDKClassLoader {

	public static void main(String[] args) {
		/*System.out.println(String.class.getClassLoader());
		System.out.println(TestJDKClassLoader.class.getClassLoader().getClass().getName());
		System.out.println(ClassLoader.getSystemClassLoader().getClass().getName());*/
		ClassLoader c=TestJDKClassLoader.class.getClassLoader();
		while(c!=null){
			System.out.println(c.getClass().getName());
			c=c.getParent();
		}
	}

}
