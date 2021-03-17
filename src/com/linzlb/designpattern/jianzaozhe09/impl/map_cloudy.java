package com.linzlb.designpattern.jianzaozhe09.impl;

import com.linzlb.designpattern.jianzaozhe09.interface_.map_interface;
/*
 * ConcreateBuilder新建阴天地图类
 */
public class map_cloudy implements map_interface {

	@Override
	public void create_house() {
		// TODO Auto-generated method stub
		System.out.println("房了上玻璃发暗");
	}

	@Override
	public void create_tree() {
		// TODO Auto-generated method stub
		System.out.println("树的颜色是深绿色");
	}

	@Override
	public void create_way() {
		// TODO Auto-generated method stub
		System.out.println("路面有些潮湿");
	}

	@Override
	public void create_weather() {
		// TODO Auto-generated method stub
		System.out.println("阴天");
	}

}
