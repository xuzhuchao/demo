package com.xzc.androiddemo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016-10-13.
 */
public class DateTiemUtils {

    public static String editTime(String time , boolean is){

        Date d1 = null;
        SimpleDateFormat sdf;
        String str="";
        try {

            if(is){
                d1 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(time);
                sdf = new SimpleDateFormat("M月dd日 HH:mm");//年月日 时分秒的
                str = sdf.format(d1);
                return str;

            }else {
                d1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
                sdf = new SimpleDateFormat("yyyy年MM月dd日");//年月日的

                str = sdf.format(d1);//取出特定日期d1的日
                return str ;
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return str;

    }

    public static String editTime_xiugai(String time ){

        Date d1 = null;
        SimpleDateFormat sdf;
        String str="";
        try {

                d1 = new SimpleDateFormat("yyyy-MM-ddHH:mm").parse(time);
                sdf = new SimpleDateFormat("MM/dd HH:mm");//年月日 时分秒的
                str = sdf.format(d1);
                return str;


        } catch (ParseException e) {
            e.printStackTrace();
        }

        return str;

    }
    public static String editTime(String time){

        Date d1 = null;
        SimpleDateFormat sdf;
        String str="";
        try {


                d1 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(time);
                sdf = new SimpleDateFormat("MM月dd日");//年月日 时分秒的
                str = sdf.format(d1);
                return str;


        } catch (ParseException e) {
            e.printStackTrace();
        }

        return str;

    }

    public static long dateToTime(String str){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");

        try {
            long millionSeconds = sdf.parse(str).getTime();//毫秒
            return millionSeconds;
        } catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }
    }
    public static String dateToDate(String date){

        Date d1 = null;
        SimpleDateFormat sdf;
        String str="";
        try {


            d1 = new SimpleDateFormat("yyyy年MM月dd日").parse(date);
            sdf = new SimpleDateFormat("yyyy/MM/dd");//年月日
            str = sdf.format(d1);
            return str;


        } catch (ParseException e) {
            e.printStackTrace();
        }

        return str;
    }
    public static String dateToDate_2(String date){

        Date d1 = null;
        SimpleDateFormat sdf;
        String str="";
        try {


            d1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            sdf = new SimpleDateFormat("yyyy年MM月dd日");//年月日
            str = sdf.format(d1);
            return str;


        } catch (ParseException e) {
            e.printStackTrace();
        }

        return str;
    }

    /**
     * 时间戳转化为时间格式
     * @param timeStamp
     * @return
     */
    public static String timeStampToStr(long timeStamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("M月dd日 HH:mm");
        String date = sdf.format(timeStamp);
        return date;
    }
}
