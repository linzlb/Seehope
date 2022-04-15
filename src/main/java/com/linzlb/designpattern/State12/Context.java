package com.linzlb.designpattern.State12;
//Context
/*定义客户感兴趣的接口。
维护一个ConcreteState子类的实例，这个实例定义当前状态。*/
public class Context {
	private Weather weather;
    public void setWeather(Weather weather) {
        this.weather = weather;
    }
    public Weather getWeather() {
        return this.weather;
    }
    public String weatherMessage() {
        return weather.getWeather();
    }
}
