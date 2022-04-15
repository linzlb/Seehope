package com.linzlb.designpattern.jianzaozhe09.impl;

import com.linzlb.designpattern.jianzaozhe09.interface_.map_interface;
/*
 * ConcreateBuilder新建晴天地图类
 */
public class map_sun implements map_interface {

	@Override
	public void create_house() {
		// TODO Auto-generated method stub
		System.out.println("房了上玻璃发亮");
	}

	@Override
	public void create_tree() {
		// TODO Auto-generated method stub
		System.out.println("树的颜色是浅绿色");
	}

	@Override
	public void create_way() {
		// TODO Auto-generated method stub
		System.out.println("路面有些干燥");
	}

	@Override
	public void create_weather() {
		// TODO Auto-generated method stub
		System.out.println("晴天");
	}

}
