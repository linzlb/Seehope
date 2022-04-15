package com.linzlb.javaguide.algorithm.paixu;


public class Demo3 {
	public static void main(String[] args) {
		 String[] s={"a","b","c","d","m","f"};
	      for(int i=s.length-1;i>=1;i--){
	          for(int j=0;j<=i-1;j++) {
	              if(s[j].compareTo(s[j+1])<0) {
	                  String temp=null;
	                  temp=s[j];
	                  s[j]=s[j+1];
	                  s[j+1]=temp;
	              }
	          }
	      }
	      for(String a:s){
	          System.out.print(a+"  ");
	      }
	}
}
