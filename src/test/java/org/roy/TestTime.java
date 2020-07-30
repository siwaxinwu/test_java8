package org.roy;

import org.junit.Test;

import java.time.LocalDateTime;

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



    }
}
