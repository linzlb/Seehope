/*
 * 删除指定目录下面的所有指定文件(txt文件)
 */

package day8.exec;

import java.io.File;

public class DeleteAllFile {
	public static void main(String[] args) {
		String str = "G:/java/测试区1";
		deleteAllFile(new File(str));
	}

	public static void deleteAllFile(File file) {
		if(file.isFile()) {
			if(file.getName().endsWith(".txt")){
				file.delete();
			}
			return;
		}
		
		File[] files = file.listFiles();
		//System.out.println(files.length);
		for(File f : files) {
			deleteAllFile(f);
		}
	}
}

/*要从文件"file.dat"中读出第10个字节到变量c中,下列哪个方法适合? （D）
A、 FileInputStream in=new FileInputStream("file.dat"); in.skip(9); int c=in.read(); 
B、 FileInputStream in=new FileInputStream("file.dat"); in.skip(10); int c=in.read(); 
C、 FileInputStream in=new FileInputStream("file.dat"); int c=in.read(); 
D、 RandomAccessFile in=new RandomAccessFile("file.dat"); in.skip(9); int c=in.readByte();*/ 
