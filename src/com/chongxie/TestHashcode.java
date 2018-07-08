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

	//name��age��classNumֵ�����ʱ�����
	public boolean equals( Object obj ){
		//����һ�������Ƿ�ָ��ͬһ������
		if( this == obj ){
			return true;
		}
		
		//���������������obj�Ƿ�Ϊ��
		if( obj == null ){
			return false;
		}
		
		//������������objָ��Ķ����Ƿ���Կ���Test����
		if( !( obj instanceof TestHashcode ) ){
			return false;
		}
		
		//�����ý���ǿת
		TestHashcode test = ( TestHashcode )obj;
		
		//�����ģ�����������Ե����ݣ��Զ����߼���
		if( this.name.equals( test.name ) && ( this.age == test.age ) && ( this.classNum == test.classNum ) ) {
			return true;
		} else {
			return false;
		}
	}
	
	//��дhashCode����
	public int hashCode(){
		//����һ���µĹ�ϣ�룬�������Ա�����й�
		return 7 * this.name.hashCode() + 
				13 * Integer.valueOf( this.age ).hashCode() +
				17 * Integer.valueOf( this.classNum ).hashCode();
	}
	
	public static void main( String [] args ){
		//����������Ա������ͬ��ѧ������
		TestHashcode src = new TestHashcode( "lomen", 23, 2323233 );
		Object test = new TestHashcode( "lomen", 23, 2323233 );
		
		//ʹ��equals������������ѧ�������Ƿ���ͬ
		if( src.equals( test ) ){
			System.out.println( "src������test��������ȵģ����ϣ��ֱ�Ϊ��" );
			//��ӡ��������Ĺ�ϣ��
			System.out.print( "src.hashCode()=" + src.hashCode() + ", " );
			System.out.print( "test.hashCode()=" + test.hashCode() );
		} else {
			System.out.println( "src������test�����ǲ��ȼ۵ģ���" );
		}
	}
}
/*
��java�ļ����У��ж����������Ƿ���ȵĹ����ǣ�
		1���ж����������hashCode�Ƿ����
		�������ȣ���Ϊ��������Ҳ����ȣ����
		�����ȣ�ת��2
		2���ж�����������equals�����Ƿ����
		�������ȣ���Ϊ��������Ҳ�����
		�����ȣ���Ϊ�����������
		=====================================

		1�� ΪʲôҪ����equal������

		�𰸣���ΪObject��equal����Ĭ����������������õıȽϣ���˼����ָ��ͬһ�ڴ�,��ַ����ȣ�������ȣ������������Ҫ���ö��������ֵ���ж��Ƿ���ȣ�������equal������

		2�� Ϊʲô����hashCode������

		�𰸣�һ��ĵط�����Ҫ����hashCode��ֻ�е�����Ҫ����HashTable��HashMap��HashSet�ȵ�hash�ṹ�ļ���ʱ�Ż�����hashCode����ôΪʲôҪ����hashCode�أ���HashMap��˵���ñ�HashMap����һ�����ڴ�飬�����кܶ�С�ڴ�飬С�ڴ��������һϵ�еĶ��󣬿�������hashCode������С�ڴ��hashCode%size(С�ڴ������)�����Ե�equal���ʱ��hashCode������ȣ����������object���󣬱�������hashCode��equal������

		3�� Ϊʲôequals()��ȣ�hashCode��һ��Ҫ��ȣ���hashCode��ȣ�ȴ��Ҫ��equals���?

		�𰸣�1����Ϊ�ǰ���hashCode������С�ڴ�飬����hashCode������ȡ�
			 2��HashMap��ȡһ�������ǱȽ�key��hashCode��Ⱥ�equalΪtrue��

		֮����hashCode��ȣ�ȴ����equal���ȣ��ͱ���ObjectA��ObjectB���Ƕ�������name����ôhashCode����name���㣬����hashCodeһ�������������������ڲ�ͬ���ͣ�����equalΪfalse��

		4�� Ϊʲô��ҪhashCode?

		1�� ͨ��hashCode���Ժܿ�Ĳ鵽С�ڴ�顣
		2�� ͨ��hashCode�Ƚϱ�equal�����죬��getʱ�ȱȽ�hashCode�����hashCode��ͬ��ֱ�ӷ���false��
*/
