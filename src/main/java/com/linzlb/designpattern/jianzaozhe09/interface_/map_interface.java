package com.linzlb.designpattern.jianzaozhe09.interface_;
/*
 * Builder 新建地图接口
 * 为创建一个Product对象的各个部件指定接口
 */
public interface map_interface {
	public void create_weather();
	public void create_house();
	public void create_tree();
	public void create_way();
}
