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
 * �������棬��������ʱ��̫��
 */
public class PaChong {
//}
//public class GetEamil {	
	/**
	 * @param ����Main����,�����������������....
	 */
	public static void main(String[] args){
		//ע�ͣ���Щ��վ������кܶ���վ��ַ������ʱ�����һ��.���ر��ܴ��.
		//url·���Ǳ����ȱ�֤��վ�ܷ���....
		String url="http://bbs.sina.com.cn/";
		
		List list=getUrl(url);//�������������ȡ������վ��ַ
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		int countUrl=list.size();//���ǽ��չ��ж���·��
		int countEmal=0;//���ǽ��չ��ж�������
		System.out.println("countUrl:"+countUrl+"   countEmal:"+countEmal);
		
		List listEmail=new ArrayList();//���Ǳ�������վ���ҵ���������
		for(int i=0;list.size()>0&&i<list.size();i++ ){
			listEmail.add(getEmail(list.get(i).toString()));//ѭ���ж�����վ����ÿ����վ�����ҵ����䣬���ص������伯�ϣ�
		}
		System.out.println("listEmail.size()"+listEmail.size());
		
		//�����Ƕ���ѭ����listEmail����װ�Ļ���list��list����װ�Ĳ�������
		for(int i=0;listEmail.size()>0&&i<listEmail.size();i++){
			List lm=(List) listEmail.get(i);
			for(int j=0;j<lm.size();j++){
				System.out.println(lm.get(j));//��ӡ����
				countEmal++;//�ۼ��ж�������
			}
		}
		List li=getEmail(url);//����ٲ�һ��������ĸ�Ŀ¼��վ�������
		for(int i=0;li.size()>0&&i<li.size();i++){
			System.out.println(li.get(i));//��ӡ����
			countEmal++;//
		}
		//�����Լ�������ȥ����������ݣ�����������ô����.Ҳ���԰�����Ĵ����ٷ�װһ�£���󷵻���Ҫ�����伯�Ͼ�OK�ˡ�
		System.out.println("���ˣ����ѵ���վ  "+countUrl+"  ��.����ȫ����վ������������  "+countEmal+"  ��");
	}
	
	
	
	/**
	 * @param ���Ǹ���·��վ��ַ��ȡ����
	 * @return List��������װ�Ķ������䣬
	 */
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
			//д��buff��
			bufIn = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} catch (IOException e1) {

		}
		String line=null;
		//����������ʽ.��ʾ�����
		String mailreg="\\w+@\\w+(\\.\\w+)+";
		Pattern p=Pattern.compile(mailreg);
		try {
			//�����վ�����ڻ���403��Щ�Ļ� bufIn���ǿյģ������ж�һ��
			if(bufIn!=null){
				while((line=bufIn.readLine())!=null){
					Matcher m=p.matcher(line);
					//System.out.println(line);
					while(m.find()){
							//System.out.println(m.group());
							//��ӵ�������
							arr.add(m.group());
					}
				}
			}
			//�Ѽ������ظ������䶼ɾ����...�����кܶ��ظ�������
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
		//���ؼ���
		return arr;
	}
	
	/**
	 * @param ���Ǹ���һ����վ��ַ�ҵ���ҳ��������վ
	 * @return List��������װ�Ķ�����վ
	 */
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
		//���Ǳ��ʽ
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
			//ɾ���ظ�
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
		//����
		return arr;
	}
}
