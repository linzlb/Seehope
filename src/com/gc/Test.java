package com.gc;

public class Test {
	public static void main( String [] args ){
		for( int i = 0; i < 5; i ++ ){
			Car c = new Car();
			//System.gc()方法,能建议JVM进行垃圾回收,但是不能强制垃圾回收（回收时间由JVM决定）
			//可以看到每次执行的结果都不一样，回收car变量都次数不是固定的
			System.gc();
		}
	}
}

class Car{
	static int count = 0;
	//finalize方法，这个方法会在对象被回收时自动被调用
	protected void finalize() throws Throwable
	{
		this.count ++;
		System.out.println( "回收Car类型变量" + this.count + "次" );
	}
}
