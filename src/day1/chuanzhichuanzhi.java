package day1;
/**
 * java只会按值传送自变量，即方法调用不会改变自变量的值。
 * 当变量实例作为自变量传送给方法时，自变量的值是对对象的引用，
 * 也就是说，传送给方法的是引用值。
 * 在方法内，这个引用值不会被改变，但是可以修改该引用指向的对象内容。
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
		//创建类的实例
		chuanzhichuanzhi pt = new chuanzhichuanzhi();
		//给方法内局部变量val赋值
		val = 11;
		pt.changeInt(val);
		//打印val的值
		System.out.println("Int=" +val);
		
		
		str = new String("hello");
		//字符串变量str作为changeStr的参数传进方法内。当从方法中退出后。内容不变。
		pt.changeStr(str);
		System.out.println("Str=" +str);
		
		
		pt.ptValue = 101f;
		//修改该引用指向的对象内容。
		pt.changeObjValue(pt);
		System.out.println("ptValue=" +pt.ptValue);
	}
}