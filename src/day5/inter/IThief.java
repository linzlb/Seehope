package day5.inter;

public interface IThief {
	int a = 5;
	//static int a = 5;//ok
	//static final int a = 5;//ok
	//public static final a = 5;//ok
	//说明接口中的属性都是static  final  public
	
	void thief();
	//abstract void thief();//ok
	//public abstract void thief();//ok
	//说明接口中的方法都是public   abstract
}
