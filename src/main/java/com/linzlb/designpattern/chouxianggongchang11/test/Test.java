package com.linzlb.designpattern.chouxianggongchang11.test;

import com.linzlb.designpattern.chouxianggongchang11.impl.BlackAnimalFactory;
import com.linzlb.designpattern.chouxianggongchang11.impl.WhiteAnimalFactory;
import com.linzlb.designpattern.chouxianggongchang11.interface_.IAnimalFactory;
import com.linzlb.designpattern.chouxianggongchang11.interface_.ICat;
import com.linzlb.designpattern.chouxianggongchang11.interface_.IDog;

public class Test {
	public static void main(String[] args) {
	    IAnimalFactory blackAnimalFactory = new BlackAnimalFactory();
	    ICat blackCat = blackAnimalFactory.createCat();
	    blackCat.eat();
	    IDog blackDog = blackAnimalFactory.createDog();
	    blackDog.eat();
	    IAnimalFactory whiteAnimalFactory = new WhiteAnimalFactory();
	    ICat whiteCat = whiteAnimalFactory.createCat();
	    whiteCat.eat();
	    IDog whiteDog = whiteAnimalFactory.createDog();
	    whiteDog.eat();
	}
}
