package com.linzlb.designpattern.jianzaozhe09.impl;
import com.linzlb.designpattern.jianzaozhe09.interface_.map_interface;
/*
 * 新建高画质builder建造类
 */
public class map_build_adv {
	private map_interface map_interface_ref;

	public map_build_adv(map_interface mapInterfaceRef) {
		super();
		map_interface_ref = mapInterfaceRef;
	}
	public void create_map() {
		System.out.println("创建一个高画质的地图");
		// 创建的顺序很重要 从天空往路面创建
		map_interface_ref.create_weather();
		map_interface_ref.create_house();
		map_interface_ref.create_tree();
		map_interface_ref.create_way();
	}
}
