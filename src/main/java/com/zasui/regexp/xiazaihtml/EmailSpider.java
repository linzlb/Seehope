package com.zasui.regexp.xiazaihtml;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailSpider {

	public static void main(String[] args) {
		String url = "G:\\java\\1.htm";
		List l = getEmail(url);
		for(int i = 0; i<l.size(); i++){
			System.out.println(l.get(i));
		}
	}

	private static List getEmail(String url){
		List emailList = new ArrayList();
		try {
			BufferedReader br = new BufferedReader(new FileReader(url));
			String line = "";

			while((line=br.readLine()) != null) {
				List l = parse(line);
				for(int i = 0; i<l.size(); i++){
					emailList.add(l.get(i));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return emailList;
	}
	

	private static List parse(String line) {
		Pattern p = Pattern.compile("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+");
		Matcher m = p.matcher(line);
		List<String> l = new ArrayList<String>();
		while(m.find()) {
			//System.out.println(m.group());
			l.add(m.group());
		}
		return l;
	}

}
