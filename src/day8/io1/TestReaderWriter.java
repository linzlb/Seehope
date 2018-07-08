package day8.io1;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class TestReaderWriter {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//testWriter(); //在指定路径下写文件
		testReader(); //读指定路径下的文件
	}

	public static void testWriter(){
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("D:/poem1.txt", "gbk");
			pw.println("白日依山尽");
			pw.println("黄河入海流");
			pw.println("欲穷千里目");
			pw.println("更上一层楼");
			pw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}finally{
			//IoUtil.close(pw);
			pw.close();
		}
	}
	public static void testReader(){
		InputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			fis = IoUtil.createInputStream(StreamType.FileInputStream, 
											//"G:/java/workpalce/Seehope/src/day8/note.txt");
											"D:\\poem1.txt");
			//将字节流变为字符流
			isr = new InputStreamReader(fis,"gbk");
			br = new BufferedReader(isr);
			String str = null;
			while(null != (str = br.readLine())){
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			IoUtil.close(br);
		}
		
	}
}
