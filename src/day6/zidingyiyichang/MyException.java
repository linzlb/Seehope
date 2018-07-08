package day6.zidingyiyichang;

public class MyException extends Exception{
	private int detail;
	public MyException(int a){
		detail = a;
	}
	public String toString(){
		return "LinZhengli-Exception["+ detail +"]";//到时抛出这个异常的报错信息
	}
}
