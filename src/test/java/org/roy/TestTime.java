package org.roy;

import org.junit.Test;
import org.roy.entity.Employee;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/** description： author：dingyawu date：created in 16:09 2020/7/30 history: */
public class TestTime {
  @Test
  public void test1() {
    System.out.println(LocalDateTime.now());
    // 2019-10-27T13:45:10
    LocalDateTime dateTime = LocalDateTime.of(2019, 10, 27, 13, 45, 10);
    System.out.println(dateTime);
    System.out.println(dateTime.plusYears(3).minusMonths(3));
    System.out.println(dateTime.getYear());
    System.out.println(dateTime.withDayOfMonth(10)); // 2019-10-10T13:45:10
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
  public void test2() {
    LocalTime time1 = LocalTime.now();
    LocalTime time2 = time1.minusHours(2); // 当前时间减去2小时，返回新的时间对象
    long l = Duration.between(time1, time2).toMinutes();
    System.out.println(l);
    System.out.println(Duration.between(time1, time2)); // PT-2H
    System.out.println(Duration.between(time1, time2).abs()); // PT2H

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
    long diffday = diff / nd;
    if (diffhour + (24 * diffday) > period) {
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
    System.out.println(compareVersion("3.2.1", "3.2.0")); // 1
    System.out.println(compareVersion("3.2.1", "3.2.4")); // -1
    System.out.println(compareVersion("3.2.1", "3.1.1.9")); // 1
    System.out.println(compareVersion("3.2.1", "3.2.2.6")); // -1
    System.out.println(compareVersion("3.2.1", "3.2.1")); // 0
  }

  @Test
  public void getCurrentDate() {
    LocalDate today = LocalDate.now();
    System.out.println("Today's Local date : " + today);

    // 这个是作为对比
    Date date = new Date();
    System.out.println(date);
  }

  // 获取年、月、日信息
  @Test
  public void getDetailDate() {
    LocalDate today = LocalDate.now();
    int year = today.getYear();
    int month = today.getMonthValue();
    int day = today.getDayOfMonth();

    System.out.printf("Year : %d  Month : %d  day : %d t %n", year, month, day);
  }

  // 处理特定日期
  @Test
  public void handleSpecilDate() {
    LocalDate dateOfBirth = LocalDate.of(2018, 01, 21);
    System.out.println("The specil date is : " + dateOfBirth);
  }

  public static Date test45(Date date) {
    try {
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(date);
      calendar.get(Calendar.HOUR_OF_DAY);
      calendar.get(Calendar.MINUTE);
      String timestr =
          String.valueOf(calendar.get(Calendar.HOUR_OF_DAY))
              + ":"
              + String.valueOf(calendar.get(Calendar.MINUTE));
      return new SimpleDateFormat("HH:mm").parse(timestr);
    } catch (ParseException e) {
      // logger.error("解析日期报错", e);
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
        && (diff = Long.parseLong(version1Array[index]) - Long.parseLong(version2Array[index]))
            == 0) {
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

  @Test
  public void test1111() {
    Date date1 = new Date();
    Date date2 = new Date();
    matchSameMonth(date1, date2);
  }

  private boolean matchSameMonth(Date date1, Date date2) {
    if (null == date1 || null == date2) {
      return false;
    }
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM");
    String str1 = simpleDateFormat.format(date1);
    String str2 = simpleDateFormat.format(date2);
    if (str1.equals(str2)) {
      return true;
    }
    return false;
  }

  @Test
  public void matchSameMont1h() {
    long l = System.currentTimeMillis();
    System.out.println(l);
  }

  @Test
  public void matchSameMont1h1() {
    DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM");
    DateTimeFormatter formatter =
        new DateTimeFormatterBuilder()
            .appendPattern("yyyy-MM")
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter();
    LocalDate date = LocalDate.parse("2020-11", formatter);
    System.out.println(date);

    System.out.println(date.format(formatter1));
    /*DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM");
    YearMonth ym = YearMonth.parse("2020-04", fmt);
    LocalDate dt = ym.atEndOfMonth();
      System.out.println(dt);*/
  }

  @Test
  public void testRemObjectWithSeq() {
    List<Employee> data = TestDemo.createData();
    for (int i = 0; i < data.size(); i++) {
      Employee employee = data.get(i);
      String name = employee.getName();
      System.out.println(name);
    }
  }

  /** 测试bigdecimal是否是整数并且小于等于99999999 */
  @Test
  public void testBigecimalvalue() {
    Boolean result = isValidNum(new BigDecimal("99999999"));
    System.out.println(result);
  }

  @Test
  public void testFori() {
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 7, 8, 9, 23, 23, 453);
    List<List<Integer>> lists = splitList(list, 3);
  }

  @Test
  public void testFor22() {
    System.out.println(0x05 << 24 | 0x69 << 16 | 0x7b << 8 | 0x22);
  }

  public static List<List<Integer>> splitList(List<Integer> list, int len) {
    if (list == null || list.size() == 0 || len < 1) {
      return null;
    }

    List<List<Integer>> result = new ArrayList<List<Integer>>();

    int size = list.size();
    int count = (size + len - 1) / len;

    for (int i = 0; i < count; i++) {
      List<Integer> subList = list.subList(i * len, (Math.min((i + 1) * len, size)));
      result.add(subList);
    }
    return result;
  }

  private Boolean isValidNum(BigDecimal number) {
    if (null == number) {
      return false;
    }
    if (new BigDecimal(number.intValue()).compareTo(number) == 0) {
      // 整数
      if (new BigDecimal(number.intValue()).compareTo(new BigDecimal("99999999")) <= 0) {
        return true;
      }
    }
    return false;
  }
}
