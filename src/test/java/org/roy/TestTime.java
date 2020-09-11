package org.roy;

import com.sun.media.jfxmedia.events.NewFrameEvent;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;

/**
 * description：
 * author：dingyawu
 * date：created in 16:09 2020/7/30
 * history:
 */
public class TestTime {
    @Test
    public void test1(){
        System.out.println(LocalDateTime.now());
        //2019-10-27T13:45:10
        LocalDateTime dateTime = LocalDateTime.of(2019, 10, 27, 13, 45, 10);
        System.out.println(dateTime);
        System.out.println(dateTime.plusYears(3).minusMonths(3));
        System.out.println(dateTime.getYear());
        System.out.println(dateTime.withDayOfMonth(10)); //2019-10-10T13:45:10
        LocalDateTime now = LocalDateTime.now();
        Long newSecond = now.toEpochSecond(ZoneOffset.of("+8"));
        System.out.println("---------------------------------------------");
        System.out.println(now);
        System.out.println(System.currentTimeMillis());
        System.out.println("---------------------------------------------");
        long time0 = System.currentTimeMillis();
        long time1 = new Date().getTime();
        long time2 = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        long time3 = Calendar.getInstance().getTimeInMillis();
        System.out.println(time0);
        System.out.println(time1);
        System.out.println(time2);
        System.out.println(time3);

    }


    @Test
    public void test2(){
        LocalTime time1= LocalTime.now();
        LocalTime time2=time1.minusHours(2);//当前时间减去2小时，返回新的时间对象
        long l = Duration.between(time1, time2).toMinutes();
        System.out.println(l);
        System.out.println(Duration.between(time1, time2));//PT-2H
        System.out.println(Duration.between(time1, time2).abs());//PT2H

        System.out.println(System.currentTimeMillis());
    }


    @Test
    public void test3() throws ParseException {
        Date date = new Date();
        System.out.println(date);

        String date1 = "2020-08-19 10:18:16";
        String date2 = "2020-08-20 10:18:16";
        boolean b = checkDateValid(date1, date2, 24L);
        System.out.println(b);

    }

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private static final long nd = 1000 * 24 * 60 * 60;
    private static final long nh = 1000 * 60 * 60;
    private boolean checkDateValid(String date1, String date2, long period) throws ParseException {
        long diff = sdf.parse(date2).getTime() - sdf.parse(date1).getTime();
        long diffhour = diff % nd / nh;
        long diffday = diff/nd;
        if (diffhour + (24 * diffday) > period){
            return true;
        }
        return false;
    }
    @Test
    public void test44() throws ParseException {
        Date date1 = sdf.parse("2020-08-19 10:18:16");
        String format = sdf.format(new Date());
        String[] s = format.split(" ");
        String s1 = s[0] + " 01:30" + ":00";
        Date parse = sdf.parse(s1);
        System.out.println(parse);

        Date date2 = sdf.parse("2020-08-20 10:18:20");
    }


    @Test
    public void test4343() throws ParseException {
        /*System.out.println(test45(new Date()));*/
        System.out.println(compareVersion("3.2.1","3.2.0")); //1
        System.out.println(compareVersion("3.2.1","3.2.4"));//-1
        System.out.println(compareVersion("3.2.1","3.1.1.9"));//1
        System.out.println(compareVersion("3.2.1","3.2.2.6"));//-1
        System.out.println(compareVersion("3.2.1","3.2.1"));//0

    }


    public static Date test45(Date date)  {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.get(Calendar.HOUR_OF_DAY);
            calendar.get(Calendar.MINUTE);
            String timestr = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)) +":" +  String.valueOf(calendar.get(Calendar.MINUTE));
            return new SimpleDateFormat("HH:mm").parse(timestr);
        } catch (ParseException e) {
            //logger.error("解析日期报错", e);
            return null;
        }
    }


    public static int compareVersion(String v1, String v2) {
        if (v1.equals(v2)) {
            return 0;
        }
        String[] version1Array = v1.split("\\.");
        String[] version2Array = v2.split("\\.");
        int index = 0;
        int minLen = Math.min(version1Array.length, version2Array.length);
        long diff = 0;

        while (index < minLen
                && (diff = Long.parseLong(version1Array[index])
                - Long.parseLong(version2Array[index])) == 0) {
            index++;
        }
        if (diff == 0) {
            for (int i = index; i < version1Array.length; i++) {
                if (Long.parseLong(version1Array[i]) > 0) {
                    return 1;
                }
            }

            for (int i = index; i < version2Array.length; i++) {
                if (Long.parseLong(version2Array[i]) > 0) {
                    return -1;
                }
            }
            return 0;
        } else {
            return diff > 0 ? 1 : -1;
        }
    }



}





