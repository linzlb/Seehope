package day6.exception3;


import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		Test t = new Test();
		try {
			t.fun1();
			t.fun2();
			t.fun3();
			t.fun4();
			t.fun5();
		} catch (IOException e) {
			System.out.println("1");
		} catch (CloneNotSupportedException e) {
			System.out.println("2");
		} catch (InstantiationException e) {
			System.out.println("3");
		} catch (Exception e) {
			System.out.println("4");
		} 
		
	
	}
	public void fun1() throws IOException{
		//throw new IOException("文件名不存在");
	}
	public void fun2()throws CloneNotSupportedException{
		throw new CloneNotSupportedException("该类不支持克隆");
	}

	public void fun3()throws InstantiationException{
		throw new InstantiationException("不能实例化");
	}
	public void fun4()throws EarthquakeException{
		throw new EarthquakeException("地震了");
	}
	public void fun5()throws CardException{
		throw new CardException("余额不足");
	}
}
class EarthquakeException extends Exception{
	public EarthquakeException(String message){
		super(message);
	}
}
class CardException extends Exception{
	public CardException(String message) {
		super(message);
	}
}
