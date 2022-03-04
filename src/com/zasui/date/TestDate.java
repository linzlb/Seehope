package com.zasui.date;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author jiangwan.lin@tuya.com
 * @since 2021-10-19 3:38 下午 / V1.0
 */
public class TestDate {

    public static void main(String[] args) throws ParseException {

        page();


        for(int q=-7; q<1; q++){
            System.out.println(getDate(q));
        }
        for (int i=-2;i>-8;i--){
            System.out.println(getDate(i));
        }
    }

    private static void page() {
        Integer pageNum = 5;//每页条数
        Integer pageIndex = 3;//页码

        Integer pageNumTmp = (pageNum == null || pageNum < 1) ? 10 : pageNum;
        Integer pageIndexTmp = (pageIndex == null || pageIndex < 1) ? 1 : pageIndex;

        int i = (pageIndexTmp - 1) * pageNumTmp;
        int j = pageIndexTmp*pageNumTmp;
        List<Integer> result = new ArrayList<>();
        result.add(1);
        result.add(2);
        result.add(3);
        result.add(4);
        result.add(5);
        result.add(6);
        result.add(7);
        result.add(8);
        result.add(9);
        result.add(10);
        result.add(11);
        result.add(12);
        result.add(13);
        result.add(14);
        result.add(15);
        result.add(16);
        result.add(17);
        result.add(18);
        result.add(19);
        result.add(20);


        List<Integer> dealResult = new ArrayList<>();
        dealResult = result.subList(i,j);
        dealResult.forEach(System.out::println);
    }

    private static void showtime() throws ParseException {
        System.out.println( System.currentTimeMillis());
        //hqtime为原时间戳 s为原时间戳和当前时间戳中间相隔的分钟数
        Long s = (System.currentTimeMillis() - 1634629808116L) / (1000 * 60); //15:50:08.161
        System.out.println(Long.valueOf("20220101" + "000000"));
        System.out.println(getTime(Long.valueOf("20220101" + "000000").toString()));
    }

    private static long getTime(String date) throws ParseException {
        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return Timestamp.valueOf(sdf2.format(sdf.parse(date))).getTime();
    }

    private static String getDate(int dlt) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, dlt);
        Date time = cal.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        return formatter.format(time);
    }

}
