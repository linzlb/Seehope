/*
 * 根据类型名称得到对应类型
 */
package day11.reflect1;

public class Test2 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class myClass = Class.forName("java.lang.String");
			System.out.println( myClass.getName() );
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
