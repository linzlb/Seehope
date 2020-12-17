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

	//��дequals����
	public boolean equals( Object obj ){
		//����һ�������Ƿ�ָ��ͬһ������
		if( this == obj ){
			return true;
		}
		
		//���������������obj�Ƿ�Ϊ��
		if( obj == null ){
			return false;
		}
		
		//������������objָ��Ķ����Ƿ���Կ���Test���ͣ����Ƿ���false
		if( !( obj instanceof TestEquals ) ){
			return false;
		}
		
		//���Ƿ���false���ǵĻ������������ý���ǿת
		TestEquals test = ( TestEquals )obj;
		
		//�����ģ�����������Ե����ݣ��Զ����߼���
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
