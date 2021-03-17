package com.linzlb.designpattern.Bridge18;
/*
 * RefinedAbstraction
 * 被提炼的抽象
 */
public class Lady extends Person {
    public Lady() {
        setType("女人");
    }  
    @Override
    public void dress() {
        Clothing clothing = getClothing();
        clothing.personDressCloth(this);
    }
}
