package com.zasui.neibulei;
//��̬�ڲ���
//���Է����ⲿ��ľ�̬��Ա�����ͷ���
//���Է����ⲿ�������private�ľ�̬�����ͷ���
public class Demo2 {
	private static String userName = "Frederic";

	private void printInner() {
		Inner i = new Inner();
		i.doInner();
	}

	public static class Inner {
		public void doInner() {
			System.out.println( Demo2.userName );// �����ⲿ��ĳ�Ա
		}
	}

	public static void main( String [] args ) throws Exception {
		Demo2 t = new Demo2();
		t.printInner();
	}
}
