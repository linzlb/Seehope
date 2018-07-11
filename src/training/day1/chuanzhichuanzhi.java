package training.day1;
/**
 * javaֻ�ᰴֵ�����Ա��������������ò���ı��Ա�����ֵ��
 * ������ʵ����Ϊ�Ա������͸�����ʱ���Ա�����ֵ�ǶԶ�������ã�
 * Ҳ����˵�����͸�������������ֵ��
 * �ڷ����ڣ��������ֵ���ᱻ�ı䣬���ǿ����޸ĸ�����ָ��Ķ������ݡ�
 */
public class chuanzhichuanzhi {
	float ptValue;

	public void changeInt(int value) {
		value = 55;
	}
	public void changeStr(String value) {
		value = new String("different");
		
	}
	public void changeObjValue(chuanzhichuanzhi ref){
		ref.ptValue = 99;
	}
	public static void main(String[] args) {
		String str;
		int val;
		//�������ʵ��
		chuanzhichuanzhi pt = new chuanzhichuanzhi();
		//�������ھֲ�����val��ֵ
		val = 11;
		pt.changeInt(val);
		//��ӡval��ֵ
		System.out.println("Int=" +val);
		
		
		str = new String("hello");
		//�ַ�������str��ΪchangeStr�Ĳ������������ڡ����ӷ������˳������ݲ��䡣
		pt.changeStr(str);
		System.out.println("Str=" +str);
		
		
		pt.ptValue = 101f;
		//�޸ĸ�����ָ��Ķ������ݡ�
		pt.changeObjValue(pt);
		System.out.println("ptValue=" +pt.ptValue);
	}
}