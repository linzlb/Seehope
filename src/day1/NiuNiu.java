package day1;
//有一头母牛，第五年成年，成年那一年开始生小牛每年生一个，小牛全部是母牛，问20年后，有多少头牛

public class NiuNiu {

	public static void main(String[] args) {		
		System.out.println(fun(20));
	}
	
	public static int fun(int year){
		if (year < 5){
			return 1;
		}
		return fun(year - 1) + fun(year - 4);	
	}

}
