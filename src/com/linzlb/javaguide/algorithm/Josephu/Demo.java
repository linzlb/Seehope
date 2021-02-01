package com.linzlb.javaguide.algorithm.Josephu;

/**
 * 丢手帕问题，约瑟夫问题
 * 1 建立一个链表类，并根据输入的个数建立链表
   2 链表类里面两个属性k(从第几个小孩开始数数)，m （每次数几个小孩）
   3 链表类的play()方法，用temp作为指针，将第二个nextChileChild链成第一个nextChileChild
 */
public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CycLink cycLink = new CycLink();
		cycLink.setLen(5);
		cycLink.createLink();//初始化环形链表
		cycLink.setK(2);
		cycLink.setM(2);
		//cycLink.show();
		cycLink.play();
	}

}

class Child{
	int no;//编号
	Child nextChild = null;//指向下个小孩
	public Child(int no){
		//给小孩个编号
		this.no = no;
	}
}

//环形链表
class CycLink{
	//先定义一个指向链表,第一个小孩的引用
	//指向第一个小孩的引用不能动
	Child firstChild = null;
	Child temp = null;//定义个游标,一直指向下一个小孩
	int len = 0;//表示共有几个小孩
	int k = 0;//从第几个开始数数
	int m = 0;//数m下
	
	//设置链表大小
	public void setLen(int len){
		this.len = len;
	}
	//设置从第几个人开始数数
	public void setK(int k){
		this.k = k;
	}
	//设置数m下
	public void setM(int m){
		this.m = m;
	}
	
	//开始play
	public void play(){
		Child temp = this.firstChild;
		
		//1.先找到开始数数的人,自己也数一下。所以-1
		for(int i=1; i<=k-1; i++){
			temp = temp.nextChild;
		}
		
		
		  while(this.len!=1){
			//2.数m次,也不能带等号
			for(int j=1; j<m; j++){
				temp = temp.nextChild;
			}
			
			
			Child temp2 = temp;//找到要出圈的前一个小孩
			System.out.println("要出圈的小孩："+(temp2.no));
			while(temp2.nextChild!=temp){
				temp2 = temp2.nextChild;
			}
			//3.讲数到m的小孩退出圈,就是让nextChild指向下下个
			temp2.nextChild = temp.nextChild;
			//让temp指向下一个数数的小孩
			temp = temp.nextChild;
			
			         
		   
			//this.show();
			this.len--;
		}
		
		
		//最后一个小孩
		System.out.println("最后一个小孩:"+temp.no);
	}
	
	
	//初始化环形链表
	public void createLink(){
		//按小孩循环
		for(int i=1;i<=len;i++){
			if(i == 1){
				//创建第一个小孩
				Child ch = new Child(i);
				this.firstChild =ch;//指向第一个小孩的引用
				this.temp = ch;//定义游标
			}else{
				if(i == len){
					//创建最后一个小孩
					Child ch = new Child(i);
					temp.nextChild = ch;
					temp = ch;
					temp.nextChild = this.firstChild;
				}else{
					//继续创建小孩
					Child ch = new Child(i);
					temp.nextChild = ch;
					temp=ch;
				}
				
			}
			
		}
	}
	
	//打印该环形链表
	public void show(){
		//定义一个跑龙套的
		Child temp = this.firstChild;
		do{
			System.err.print(temp.no+"---");
			temp = temp.nextChild;
		}while(temp!=this.firstChild);
	}
}
