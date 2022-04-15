package com.zasui.regexp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PaChong {

	public static void main(String[] args){

		String url="http://bbs.sina.com.cn/";
		
		List list=getUrl(url);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		int countUrl=list.size();
		int countEmal=0;
		System.out.println("countUrl:"+countUrl+"   countEmal:"+countEmal);
		
		List listEmail=new ArrayList();
		for(int i=0;list.size()>0&&i<list.size();i++ ){
			listEmail.add(getEmail(list.get(i).toString()));
		}
		System.out.println("listEmail.size()"+listEmail.size());
		

		for(int i=0;listEmail.size()>0&&i<listEmail.size();i++){
			List lm=(List) listEmail.get(i);
			for(int j=0;j<lm.size();j++){
				System.out.println(lm.get(j));
				countEmal++;
			}
		}
		List li=getEmail(url);
		for(int i=0;li.size()>0&&i<li.size();i++){
			System.out.println(li.get(i));
			countEmal++;//
		}
	}
	

	public static List getEmail(String urll){
		List arr=new ArrayList();	
		URL url = null;
		try {
			url = new URL(urll);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//·��
		URLConnection conn = null;
		try {
			conn = url.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader bufIn = null;
		try {
			bufIn = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} catch (IOException e1) {

		}
		String line=null;

		String mailreg="\\w+@\\w+(\\.\\w+)+";
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
			}

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

		return arr;
	}

	public static List getUrl(String urll){
		List arr=new ArrayList();	
		URL url = null;
		try {
			url = new URL(urll);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}//·��
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
		return arr;
	}
}
