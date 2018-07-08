package day6.exception4;

public class WomenWc {
	public void fangbian(Human h){
		if(h instanceof Man){
			throw new ColorWolfException("ÓÐÉ«ÀÇ");
		}
	}
}
