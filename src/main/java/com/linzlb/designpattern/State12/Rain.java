package com.linzlb.designpattern.State12;
/*ConcreteStatesubclasses
每一子类实现一个与Context的一个状态相关的行为。*/
public class Rain implements Weather {
    public String getWeather() {
        return "下雨";
    }
}