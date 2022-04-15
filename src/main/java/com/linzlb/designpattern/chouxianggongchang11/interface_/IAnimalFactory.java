package com.linzlb.designpattern.chouxianggongchang11.interface_;
/*
 * abstractFactory
 * 抽象工厂接口，包含所有产品创建的方法
 */
public interface IAnimalFactory {
	ICat createCat();	
    IDog createDog();
}
