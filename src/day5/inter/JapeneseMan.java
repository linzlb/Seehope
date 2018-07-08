package day5.inter;

public class JapeneseMan extends Animal implements IThief , ICityManager{
	
	public void thief(){
		System.out.println("偷手机");
	}
	public void manager(){
		System.out.println("执法");
	}
	
	public void eat(){
		System.out.println("吃东西");
	}
	
}
