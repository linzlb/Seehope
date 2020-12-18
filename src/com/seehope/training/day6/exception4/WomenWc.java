package com.seehope.training.day6.exception4;

public class WomenWc {
	public void fangbian(Human h){
		if(h instanceof Man){
			throw new ColorWolfException("��ɫ��");
		}
	}
}
