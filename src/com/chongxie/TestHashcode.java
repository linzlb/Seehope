package com.chongxie;

public class TestHashcode {
	String name;
	int age;
	int classNum;

	public TestHashcode(String name, int age, int classNum) {
		super();
		this.name = name;
		this.age = age;
		this.classNum = classNum;
	}

	//name、age和classNum值都相等时才相等
	public boolean equals( Object obj ){
		//步骤一：测试是否指向同一个对象
		if( this == obj ){
			return true;
		}
		
		//步骤二：测试引用obj是否为空
		if( obj == null ){
			return false;
		}
		
		//步骤三：测试obj指向的对象是否可以看做Test类型
		if( !( obj instanceof TestHashcode ) ){
			return false;
		}
		
		//对引用进行强转
		TestHashcode test = ( TestHashcode )obj;
		
		//步骤四：测试相关属性的内容（自定义逻辑）
		if( this.name.equals( test.name ) && ( this.age == test.age ) && ( this.classNum == test.classNum ) ) {
			return true;
		} else {
			return false;
		}
	}
	
	//重写hashCode方法
	public int hashCode(){
		//返回一个新的哈希码，该码与成员属性有关
		return 7 * this.name.hashCode() + 
				13 * Integer.valueOf( this.age ).hashCode() +
				17 * Integer.valueOf( this.classNum ).hashCode();
	}
	
	public static void main( String [] args ){
		//创建两个成员属性相同的学生对象
		TestHashcode src = new TestHashcode( "lomen", 23, 2323233 );
		Object test = new TestHashcode( "lomen", 23, 2323233 );
		
		//使用equals方法测试两个学生对象是否相同
		if( src.equals( test ) ){
			System.out.println( "src对象与test对象是相等的，其哈希码分别为：" );
			//打印两个对象的哈希码
			System.out.print( "src.hashCode()=" + src.hashCode() + ", " );
			System.out.print( "test.hashCode()=" + test.hashCode() );
		} else {
			System.out.println( "src对象与test对象是不等价的！！" );
		}
	}
}
/*
在java的集合中，判断两个对象是否相等的规则是：
		1，判断两个对象的hashCode是否相等
		如果不相等，认为两个对象也不相等，完毕
		如果相等，转入2
		2，判断两个对象用equals运算是否相等
		如果不相等，认为两个对象也不相等
		如果相等，认为两个对象相等
		=====================================

		1、 为什么要重载equal方法？

		答案：因为Object的equal方法默认是两个对象的引用的比较，意思就是指向同一内存,地址则相等，否则不相等；如果你现在需要利用对象里面的值来判断是否相等，则重载equal方法。

		2、 为什么重载hashCode方法？

		答案：一般的地方不需要重载hashCode，只有当类需要放在HashTable、HashMap、HashSet等等hash结构的集合时才会重载hashCode，那么为什么要重载hashCode呢？就HashMap来说，好比HashMap就是一个大内存块，里面有很多小内存块，小内存块里面是一系列的对象，可以利用hashCode来查找小内存块hashCode%size(小内存块数量)，所以当equal相等时，hashCode必须相等，而且如果是object对象，必须重载hashCode和equal方法。

		3、 为什么equals()相等，hashCode就一定要相等，而hashCode相等，却不要求equals相等?

		答案：1、因为是按照hashCode来访问小内存块，所以hashCode必须相等。
			 2、HashMap获取一个对象是比较key的hashCode相等和equal为true。

		之所以hashCode相等，却可以equal不等，就比如ObjectA和ObjectB他们都有属性name，那么hashCode都以name计算，所以hashCode一样，但是两个对象属于不同类型，所以equal为false。

		4、 为什么需要hashCode?

		1、 通过hashCode可以很快的查到小内存块。
		2、 通过hashCode比较比equal方法快，当get时先比较hashCode，如果hashCode不同，直接返回false。
*/
