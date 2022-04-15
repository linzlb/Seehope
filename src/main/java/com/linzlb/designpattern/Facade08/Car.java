package com.linzlb.designpattern.Facade08;
/*
 * 外观类
 * 知道哪些子系统类负责处理请求
 * 将客户的请求适当的代理给子系统对象
 */
public class Car {
	
	public void start(){
		System.out.println("车子已启动");
	}
	public void check_stop(){
		System.out.println("刹车检查");
	}
	public void check_box(){
		System.out.println("检查油箱");
	}
	public void check_console(){
		System.out.println("检查仪表盘是否异常");
	}
}
