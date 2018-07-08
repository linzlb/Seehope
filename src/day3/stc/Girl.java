package day3.stc;
//执行完静态代码块之后就意味着类加载完成。
public class Girl {
	public static int nums = 5;
	
	static {
		System.out.println("Girl类被加载了、、");
	}
	{
		System.out.println("Girl类被创建、、");
	}
	
	public Girl(){
		System.out.println("Girl()方法..");
	}
	
	public static void action(){
		System.out.println("action..");
	}

}