package com.zasui.neibulei;
//静态内部类
//可以访问外部类的静态成员变量和方法
//可以访问外部类的甚至private的静态变量和方法
public class Demo2 {
	private static String userName = "Frederic";

	private void printInner() {
		Inner i = new Inner();
		i.doInner();
	}

	public static class Inner {
		public void doInner() {
			System.out.println( Demo2.userName );// 访问外部类的成员
		}
	}

	public static void main( String [] args ) throws Exception {
		Demo2 t = new Demo2();
		t.printInner();
	}
}
