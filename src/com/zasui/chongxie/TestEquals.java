package com.zasui.chongxie;

public class TestEquals {
	String name;
	int age;
	int classNum;
	public TestEquals(String name, int age, int classNum) {
		super();
		this.name = name;
		this.age = age;
		this.classNum = classNum;
	}

	//重写equals方法
	public boolean equals( Object obj ){
		//步骤一：测试是否指向同一个对象
		if( this == obj ){
			return true;
		}
		
		//步骤二：测试引用obj是否为空
		if( obj == null ){
			return false;
		}
		
		//步骤三：测试obj指向的对象是否可以看做Test类型，不是返回false
		if( !( obj instanceof TestEquals ) ){
			return false;
		}
		
		//不是返回false。是的话继续。对引用进行强转
		TestEquals test = ( TestEquals )obj;
		
		//步骤四：测试相关属性的内容（自定义逻辑）
		if( this.name.equals( test.name ) && ( this.age == test.age ) && ( this.classNum == test.classNum ) ) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main( String [] args ){
		TestEquals src = new TestEquals( "lomen", 23, 2323233 );
		Object test = new TestEquals( "lomen", 23, 2323233 );
		boolean result = src.equals( test );
		System.out.println( result );
	}
}
