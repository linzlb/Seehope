package com.zasui.neibulei;

public class Demo1 {
	private String userName = "Frederic";

	private void printInner() {
		Inner i = new Inner();
		i.doInner();
	}
	//非静态内部类Inner
/*可以访问外部类的成员变量和方法，可以访问外部类的甚至private的变量和方法*/
	public class Inner {
		void doInner() {
			System.out.println( Demo1.this.userName );// 访问外部类的成员
			//System.out.println( Demo1.userName );这样的话只能访问static的变量
		}
	}

	public static void main( String [] args ) throws Exception {
		Demo1 t = new Demo1();
		t.printInner();
	}
}
