package com.linzlb.designpattern.ChainOfResponsibility20;
//全局变量，接口类型  
/**  
 * 使用Java中的interface定义全局变量，可根据具体需要在   
 * 具体的包中使用静态导入相关的全局变量，语法如下：   
 * import static package01.package02.*;  
 */ 
public interface Lever {
	public static final int LEVEL_01 = 1;  
    public static final int LEVEL_02 = 2;  
    public static final int LEVEL_03 = 3;
    public static final int LEVEL_04 = 4;
}
