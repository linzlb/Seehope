package com.zasui.neibulei;

public class Demo1 {
	private String userName = "Frederic";

	private void printInner() {
		Inner i = new Inner();
		i.doInner();
	}
	//�Ǿ�̬�ڲ���Inner
/*���Է����ⲿ��ĳ�Ա�����ͷ��������Է����ⲿ�������private�ı����ͷ���*/
	public class Inner {
		void doInner() {
			System.out.println( Demo1.this.userName );// �����ⲿ��ĳ�Ա
			//System.out.println( Demo1.userName );�����Ļ�ֻ�ܷ���static�ı���
		}
	}

	public static void main( String [] args ) throws Exception {
		Demo1 t = new Demo1();
		t.printInner();
	}
}
