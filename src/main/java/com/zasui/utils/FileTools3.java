package com.zasui.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * uid统计
 * @author jiangwan.lin@tuya.com
 * @since 2022-03-20 11:48 上午 / V1.0
 */
public class FileTools3 {

    private static Set<String> aSet = new HashSet<>();
    private static Set<String> bSet = new HashSet<>();
    private static Set<String> result = new HashSet<>();

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
            if ("a".equals(type)){
                while((str = bufferedReader.readLine()) != null) {
                    //System.out.println(str);
                    aSet.add(str);
                }
            }
            if ("b".equals(type)){
                while((str = bufferedReader.readLine()) != null) {
                    //System.out.println(str);
                    bSet.add(str);
                }
            }
            inputStream.close();
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        readContent("/Users/jiangwan/Desktop/zhonghai_uid.txt","a");
        readContent("/Users/jiangwan/Desktop/tuya_uid.txt","b");
        System.out.println("中海个数是 "+aSet.size());
        System.out.println("涂鸦个数是 "+bSet.size());

        //交集
//        aSet.retainAll(bSet);
//        System.out.println("交集个数是 "+aSet.size());
        result.clear();
        result.addAll(aSet);
        result.removeAll(bSet);
        System.out.println("差集 中海减涂鸦：" + result.size());
        System.out.println(result);

        result.clear();
        result.addAll(bSet);
        result.removeAll(aSet);
        System.out.println("差集 涂鸦减中海：" + result.size());
        System.out.println(result);

        System.out.println("=======================");
        result.clear();
        result.addAll(aSet);
        result.retainAll(bSet);
        System.out.println("交集：" + result.size());
        System.out.println(result);

        System.out.println("=======================");

//        result.clear();
//        result.addAll(set1);
//        result.addAll(set2);
//        System.out.println("并集：" + result);
    }
}
