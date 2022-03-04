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


	public boolean equals( Object obj ){

		if( this == obj ){
			return true;
		}

		if( obj == null ){
			return false;
		}

		if( !( obj instanceof TestEquals ) ){
			return false;
		}

		TestEquals test = ( TestEquals )obj;

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
