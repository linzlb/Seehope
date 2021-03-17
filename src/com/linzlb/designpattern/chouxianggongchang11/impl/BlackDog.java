package com.linzlb.designpattern.chouxianggongchang11.impl;

import com.linzlb.designpattern.chouxianggongchang11.interface_.IDog;
/*
 * Product
 * 产品的具体实现
 */
public class BlackDog implements IDog {
    public void eat() {
        System.out.println("The black dog is eating");
    }
}
