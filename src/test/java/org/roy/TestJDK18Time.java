package org.roy;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/** description： author：dingyawu date：created in 16:09 2020/7/30 history: */
public class TestJDK18Time {

  @Test
  public void test11() {
    LocalDate today = LocalDate.now();
    System.out.println("今天的日期:" + today);
  }

  @Test
  public void test12() {
    LocalDate today = LocalDate.now();
    int year = today.getYear();
    int month = today.getMonthValue();
    int day = today.getDayOfMonth();

    System.out.println("year:" + year);
    System.out.println("month:" + month);
    System.out.println("day:" + day);
  }

  @Test
  public void test13() {
    LocalDate date = LocalDate.of(2018, 2, 6);
    System.out.println("自定义日期:" + date);
  }

  @Test
  public void test14() {
    LocalDate date1 = LocalDate.now();
    LocalDate date2 = LocalDate.of(2021, 1, 14);

    if (date1.equals(date2)) {
      System.out.println("时间相等");
    } else {
      System.out.println("时间不等");
    }
  }

  /** 如何从一个年月日中提取出来月日 */
  @Test
  public void test15() {
    LocalDate date1 = LocalDate.now();
    LocalDate date2 = LocalDate.of(2018, 1, 14);
    MonthDay birthday = MonthDay.of(date2.getMonth(), date2.getDayOfMonth());
    MonthDay currentMonthDay = MonthDay.from(date1);
    if (currentMonthDay.equals(birthday)) {
      System.out.println("是你的生日");
    } else {
      System.out.println("你的生日还没有到");
    }
  }

  @Test
  public void test16() {
    LocalTime time = LocalTime.now();
    System.out.println("获取当前的时间,不含有日期:" + time);
  }

  @Test
  public void test17() {
    LocalTime time = LocalTime.now();
    LocalTime newTime = time.plusHours(3);
    System.out.println(newTime.getHour());
    System.out.println("三个小时后的时间为:" + newTime);
  }

  /** Java 8如何计算一周后的日期 */
  @Test
  public void test18() {
    LocalDate today = LocalDate.now();
    System.out.println("今天的日期为:" + today);
    LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
    System.out.println("一周后的日期为:" + nextWeek);
  }

  @Test
  public void test19() {
    LocalDate today = LocalDate.now();

    LocalDate previousYear = today.minus(1, ChronoUnit.YEARS);
    System.out.println("一年前的日期 : " + previousYear);

    LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
    System.out.println("一年后的日期:" + nextYear);
  }

  /**
   * Java 8增加了一个Clock时钟类用于获取当时的时间戳，或当前时区下的日期时间信息。以前用到System.currentTimeInMillis()
   * 和TimeZone.getDefault()的地方都可用Clock替换。
   */
  @Test
  public void test20() {
    // Returns the current time based on your system clock and set to UTC.
    Clock clock = Clock.systemUTC();
    System.out.println("Clock : " + clock.millis());

    // Returns time based on system clock zone
    Clock defaultClock = Clock.systemDefaultZone();
    System.out.println("Clock : " + defaultClock.millis());
  }

  @Test
  public void test21() {
    LocalDate today = LocalDate.now();
    LocalDate tomorrow = LocalDate.of(2018, 2, 6);
    if (tomorrow.isAfter(today)) {
      System.out.println("之后的日期:" + tomorrow);
    }

    LocalDate yesterday = today.minus(1, ChronoUnit.DAYS);
    if (yesterday.isBefore(today)) {
      System.out.println("之前的日期:" + yesterday);
    }
  }

  @Test
  public void test22() {
    // Date and time with timezone in Java 8
    ZoneId america = ZoneId.of("America/New_York");
    LocalDateTime localtDateAndTime = LocalDateTime.now();
    ZonedDateTime dateAndTimeInNewYork = ZonedDateTime.of(localtDateAndTime, america);
    System.out.println("Current date and time in a particular timezone : " + dateAndTimeInNewYork);
  }

  @Test
  public void test23() {
    YearMonth currentYearMonth = YearMonth.now();
    System.out.printf(
        "Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());
    YearMonth creditCardExpiry = YearMonth.of(2019, Month.FEBRUARY);
    System.out.printf("Your credit card expires on %s %n", creditCardExpiry);
  }

  @Test
  public void test24() {
    LocalDate today = LocalDate.now();
    if (today.isLeapYear()) {
      System.out.println("This year is Leap year");
    } else {
      System.out.println("2018 is not a Leap year");
    }
  }

  /** 计算两个日期之间的天数、周数或月数 */
  @Test
  public void test25() {
    LocalDate today = LocalDate.now();

    LocalDate java8Release = LocalDate.of(2018, 12, 14);

    Period periodToNextJavaRelease = Period.between(today, java8Release);
    System.out.println(
        "Months left between today and Java 8 release : " + periodToNextJavaRelease.getMonths());
  }

  @Test
  public void test26() {
    Instant timestamp = Instant.now();
    System.out.println("What is value of this instant" + timestamp.toEpochMilli());
  }

  @Test
  public void test27() {
    String dayAfterTommorrow = "20180205";
    LocalDate formatted = LocalDate.parse(dayAfterTommorrow, DateTimeFormatter.BASIC_ISO_DATE);
    System.out.println(dayAfterTommorrow + "  格式化后的日期为:  " + formatted);
  }

  @Test
  public void test28() {
    LocalDateTime date = LocalDateTime.now();
    DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    // 日期转字符串
    String str = date.format(format1);
    System.out.println("日期转换为字符串:" + str);
    DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    // 字符串转日期
    LocalDate date2 = LocalDate.parse(str, format2);
    System.out.println("日期类型:" + date2);
  }
}
