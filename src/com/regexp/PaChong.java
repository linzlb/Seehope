package com.regexp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 * 网络爬虫，，，运行时间太久
 */
public class PaChong {
//}
//public class GetEamil {	
	/**
	 * @param 这是Main方法,里面调用了其它方法....
	 */
	public static void main(String[] args){
		//注释：有些网站里面会有很多网站地址，所以时间会慢一下.但回报很大的.
		//url路径是必须先保证网站能访问....
		String url="http://bbs.sina.com.cn/";
		
		List list=getUrl(url);//调用这个方法获取所有网站地址
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		int countUrl=list.size();//这是接收共有多少路径
		int countEmal=0;//这是接收共有多少邮箱
		System.out.println("countUrl:"+countUrl+"   countEmal:"+countEmal);
		
		List listEmail=new ArrayList();//这是保存在网站里找到多少邮箱
		for(int i=0;list.size()>0&&i<list.size();i++ ){
			listEmail.add(getEmail(list.get(i).toString()));//循环有多少网站，在每个网站里面找到邮箱，返回的是邮箱集合，
		}
		System.out.println("listEmail.size()"+listEmail.size());
		
		//这里是二次循环，listEmail里面装的还是list，list里面装的才是邮箱
		for(int i=0;listEmail.size()>0&&i<listEmail.size();i++){
			List lm=(List) listEmail.get(i);
			for(int j=0;j<lm.size();j++){
				System.out.println(lm.get(j));//打印邮箱
				countEmal++;//累计有多少邮箱
			}
		}
		List li=getEmail(url);//最后再查一下你输入的根目录网站里的邮箱
		for(int i=0;li.size()>0&&i<li.size();i++){
			System.out.println(li.get(i));//打印，，
			countEmal++;//
		}
		//根据自己的需求去改里面的内容，方法就是这么几个.也可以把上面的代码再封装一下，最后返回需要的邮箱集合就OK了。
		System.out.println("完了！共搜到网站  "+countUrl+"  个.其中全部网站加起来的邮箱  "+countEmal+"  个");
	}
	
	
	
	/**
	 * @param 这是根据路网站地址获取邮箱
	 * @return List集合里面装的都是邮箱，
	 */
	public static List getEmail(String urll){
		List arr=new ArrayList();	
		URL url = null;
		try {
			url = new URL(urll);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//路径
		URLConnection conn = null;
		try {
			conn = url.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader bufIn = null;
		try {
			//写在buff里
			bufIn = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} catch (IOException e1) {

		}
		String line=null;
		//这是正则表达式.表示邮箱的
		String mailreg="\\w+@\\w+(\\.\\w+)+";
		Pattern p=Pattern.compile(mailreg);
		try {
			//如果网站不存在或是403这些的话 bufIn就是空的，必须判断一下
			if(bufIn!=null){
				while((line=bufIn.readLine())!=null){
					Matcher m=p.matcher(line);
					//System.out.println(line);
					while(m.find()){
							//System.out.println(m.group());
							//添加到集合里
							arr.add(m.group());
					}
				}
			}
			//把集合里重复的邮箱都删除掉...否则有很多重复的邮箱
			for (int i = 0;arr!=null&&i < arr.size() - 1; i++) {  
				for (int j = arr.size() - 1; j > i; j--) {  
				    if(arr.get(j).toString().equals(arr.get(i).toString())){  
				           arr.remove(j);  
				         }  
				 }  
		    } 
			
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//返回集合
		return arr;
	}
	
	/**
	 * @param 这是根据一个网站地址找到该页面所有网站
	 * @return List集合里面装的都是网站
	 */
	public static List getUrl(String urll){
		List arr=new ArrayList();	
		URL url = null;
		try {
			url = new URL(urll);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}//路径
		URLConnection conn = null;
		try {
			conn = url.openConnection();
		} catch (IOException e) {
		}
		BufferedReader bufIn = null;
		try {
			bufIn = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} catch (IOException e1) {
		}
		String line=null;
		//这是表达式
		String mailreg="http://([A-Za-z0-9]+(-[A-Za-z0-9]+)*\\.)+[A-Za-z]{2,}/";
		Pattern p=Pattern.compile(mailreg);
		try {
			if(bufIn!=null){
			while((line=bufIn.readLine())!=null){
				Matcher m=p.matcher(line);
				//System.out.println(line);
				
				while(m.find()){
						//System.out.println(m.group());
						arr.add(m.group());
				}
			}
			//删除重复
			for (int i = 0;arr!=null&&i < arr.size() - 1; i++) {  
				for (int j = arr.size() - 1; j > i; j--) {  
					 if(arr.get(j).toString().equals(arr.get(i).toString())){  
					         arr.remove(j);  
					      }  
					 }  
			    } 
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//返回
		return arr;
	}
}
