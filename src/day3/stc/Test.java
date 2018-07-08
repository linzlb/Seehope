package day3.stc;

public class Test {

	public static void main(String[] args) throws Exception{	
		//System.out.println(Girl.nums);
		Class.forName("day3.stc.Girl"); //要双引号！！只加载静态代码块，代表类加载完成
		
		
		//会加载静态代码块。非静态代码块，构造方法。
		//Girl g = new Girl();	
	}
}
