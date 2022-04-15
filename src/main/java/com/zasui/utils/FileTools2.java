package com.zasui.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 类的详细说明
 * @author jiangwan.lin@tuya.com
 * @since 2021-05-20 11:48 上午 / V1.0
 */
public class FileTools2 {

    private static Map<String, String> codeandmsgMap = new HashMap<>();
    private static Map<String, String> codeandnameMap = new HashMap<>();
    private static Set<String> codeandmsgSet = new HashSet<>();
    private static Set<String> codeandnameSet = new HashSet<>();

    /**
     *  按行处理
     */
    public static void readContent(String fileName, String type){
        byte[] value = null;
        try {
            //BufferedReader是可以按行读取文件
            FileInputStream inputStream = new FileInputStream(fileName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String str = null;
            while((str = bufferedReader.readLine()) != null) {
//                System.out.println(str);
                if (type.equals("msg")){
                    String[] arry = dealLine(str);
                    codeandmsgMap.put(arry[0], arry[1]);
                    codeandmsgSet.add(arry[0]);
                }else if (type.equals("name")){
                    String[] arry = dealLine(str);
                    codeandnameMap.put(arry[0], arry[1]);
                    codeandnameSet.add(arry[0]);
                }
            }
            inputStream.close();
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String[] dealLine(String line){
        return line.split("------");
    }

    public static void main(String[] args) {
        readContent("/Users/jiangwan/Desktop/codeandmsg", "msg");
        readContent("/Users/jiangwan/Desktop/codeandname", "name");
        //交集
        codeandnameSet.retainAll(codeandmsgSet);
        System.out.println("交集个数是 "+codeandmsgSet.size());
    }
}

class MyFile{
    public String errorName;
    public String errorMsg;
}