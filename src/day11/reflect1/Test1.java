/*
 * 得到对象的类型
 */
package day11.reflect1;

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = new String("abc");
		Class strClass = str.getClass();// 得到对象的类型
		System.out.println(strClass);
		String className = strClass.getName();// 得到指定类型的名称
		System.out.println(className);
	}

}
