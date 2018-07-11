/*
 * �õ����������
 */
package training.day11.reflect1;

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = new String("abc");
		Class strClass = str.getClass();// �õ����������
		System.out.println(strClass);
		String className = strClass.getName();// �õ�ָ�����͵�����
		System.out.println(className);
	}

}
