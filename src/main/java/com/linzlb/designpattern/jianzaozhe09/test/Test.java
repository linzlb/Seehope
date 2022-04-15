package com.linzlb.designpattern.jianzaozhe09.test;

import com.linzlb.designpattern.jianzaozhe09.impl.map_build_adv;
import com.linzlb.designpattern.jianzaozhe09.impl.map_build_low;
import com.linzlb.designpattern.jianzaozhe09.impl.map_cloudy;
import com.linzlb.designpattern.jianzaozhe09.impl.map_sun;

public class Test {
	public static void main(String[] args) {
		map_cloudy map_cloudy = new map_cloudy();
		map_build_adv map_build_adv = new map_build_adv(map_cloudy);
		map_build_adv.create_map();
		System.out.println("--------------------------------------");
		map_sun map_sun = new map_sun();
		map_build_low map_build_low = new map_build_low(map_sun);
		map_build_low.create_map();
	}
}
