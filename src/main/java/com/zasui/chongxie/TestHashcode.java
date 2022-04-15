package com.zasui.chongxie;

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

	public boolean equals( Object obj ){

		if( this == obj ){
			return true;
		}

		if( obj == null ){
			return false;
		}

		if( !( obj instanceof TestHashcode ) ){
			return false;
		}

		TestHashcode test = ( TestHashcode )obj;

		if( this.name.equals( test.name ) && ( this.age == test.age ) && ( this.classNum == test.classNum ) ) {
			return true;
		} else {
			return false;
		}
	}
	

	public int hashCode(){
		return 7 * this.name.hashCode() + 
				13 * Integer.valueOf( this.age ).hashCode() +
				17 * Integer.valueOf( this.classNum ).hashCode();
	}
	
	public static void main( String [] args ){
		TestHashcode src = new TestHashcode( "lomen", 23, 2323233 );
		Object test = new TestHashcode( "lomen", 23, 2323233 );
		

		if( src.equals( test ) ){
			System.out.print( "src.hashCode()=" + src.hashCode() + ", " );
			System.out.print( "test.hashCode()=" + test.hashCode() );
		} else {
			System.out.println( "else" );
		}
	}
}