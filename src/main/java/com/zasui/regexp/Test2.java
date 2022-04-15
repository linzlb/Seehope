package com.zasui.regexp;

/**
 * 网址某个字段的替换
 * @author jiangwan.lin@tuya.com
 * @since 2022-03-07 6:25 下午 / V1.0
 */
public class Test2 {

    public static void main(String[] args) {
        String str1="http://www.baidu.com?showType=2&aaa=2";
        String str2="http://www.baidu.com?aaa=2&showType=2";
        String str3="http://www.baidu.com?showType=2";
        String str4="http://www.baidu.com?aaa=2&showType=2&bbb=2";
        String str5="http://www.baidu.com?aa=2&aaaa=2&showType=2";
        String str6="http://www.baidu.com?showType=2&aa=2&aaaa=2";

        String regex = "(showType=\\d+&)|(&showType=\\d+$)|(\\?showType=\\d+$)";
        System.out.println(str1.replaceAll(regex, ""));
        System.out.println(str2.replaceAll(regex, ""));
        System.out.println(str3.replaceAll(regex,  ""));
        System.out.println(str4.replaceAll(regex, ""));
        System.out.println(str5.replaceAll(regex, ""));
        System.out.println(str6.replaceAll(regex, ""));

        String str = "aa<div>test1</div>bb<div>test2</div>cc ";
        String reg = "<div>.*?</div>";
        String reg2 = "<div>.*</div>";
        System.out.println(str.replaceAll(reg, ""));
        System.out.println(str.replaceAll(reg2, ""));
    }
}
