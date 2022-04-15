package com.linzlb.designpattern.chouxianggongchang11.impl;

import com.linzlb.designpattern.chouxianggongchang11.interface_.IAnimalFactory;
import com.linzlb.designpattern.chouxianggongchang11.interface_.ICat;
import com.linzlb.designpattern.chouxianggongchang11.interface_.IDog;

/*
 * ConcreteFactory 
 * 具体工厂，创建具有特定实现的产品对象
 */
public class BlackAnimalFactory implements IAnimalFactory {

	@Override
	public ICat createCat() {
		// TODO Auto-generated method stub
		return new BlackCat();
	}

	@Override
	public IDog createDog() {
		// TODO Auto-generated method stub
		return new BlackDog();
	}

}
