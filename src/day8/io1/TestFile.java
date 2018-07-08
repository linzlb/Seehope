package day8.io1;

import java.io.File;
import java.io.IOException;

public class TestFile {
//	public static void main(String[] args) {
//		File file = new File("F:\\专业\\java\\没用的\\测试区\\io1");
//		try {
//			file.createNewFile();
//			String fileName = file.getName();
//			if(fileName.endsWith(".java")) {
//				System.out.println(fileName);
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		public static void main(String[] args) throws Exception{
			File file = new File("e:/HelloWorld.jva");
			file.createNewFile();
			String fileName = file.getName();
			if(fileName.endsWith(".java")){
				System.out.println(fileName);
			}
			testFile();
			
		}
		
		public static void testFile() {
			File file = new File("G:\\java\\IO流测试区\\io2.txt");
			boolean flag = true;
			
			if (file.exists()) {
				System.out.println("文件已存在");
				if(file.canRead()) {
					System.out.println("文件可读");
				}
				if(file.canWrite()) {
					System.out.println("文件可写");
				}
				if(!file.isDirectory()) {
					if(file.canExecute()){
						System.out.println("文件是可执行文件");
					}
					System.out.println("路径是：" + file.getParent());
					File parent = file.getParentFile();
					System.out.println(parent.isDirectory());
				}
//				if(file.delete()){
//					System.out.println("文件删除成功");
//				}
				
					
			}else
				//文件存在则不新建文件
				if(flag) {
					try {
						if(file.createNewFile()) {
							System.out.println("文件创建成功");
						}else{
							System.out.println("文件创建失败");
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					if(file.mkdir()){
						System.out.println("目录文件创建成功");
					}else{
						System.out.println("目录文件创建失败");
					}
				}
			}
		
		
	}

