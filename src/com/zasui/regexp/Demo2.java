package com.zasui.regexp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo2 {
	public static void main(String[] args) {
		Pattern pattern = null;
		List<String> list = new ArrayList<>();
		String data = "12345是否加咖453453啡就是大方612334512333";
		//System.out.println( data.replace("123","asss") );
		try {

			pattern = Pattern.compile( "\\d+" );
			Matcher matcher = pattern.matcher( data );

			while (matcher.find()) {
				int start = matcher.start();
				int end = matcher.end();
				String match = data.substring(start, end);
				System.out.println( match );
				list.add(match);
			}
			System.out.println( list );
			System.out.println( data );
			for (String str : list) {
				data = data.replace("match", "aaa");
			}
			System.out.println( data );
		} catch (Exception e) {e.printStackTrace();}
	}
}
