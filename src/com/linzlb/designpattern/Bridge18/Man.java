package com.linzlb.designpattern.Bridge18;
/*
 * RefinedAbstraction
 * 被提炼的抽象
 */
public class Man extends Person {
    public Man() {
        setType("男人");
    }
    @Override
    public void dress() {
        Clothing clothing = getClothing();
        clothing.personDressCloth(this);
    }
}