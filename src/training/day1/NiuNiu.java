package training.day1;
//��һͷĸţ����������꣬������һ�꿪ʼ��Сţÿ����һ����Сţȫ����ĸţ����20����ж���ͷţ

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
