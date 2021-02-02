package org.roy;

import org.junit.Test;
import org.roy.entity.Employee;
import org.roy.entity.Light;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

/** description： 开发额外测试 author：dingyawu date：created in 13:57 2020/10/28 history: */
public class ExtTest {
  @Test
  public void test11() {
    Employee employee = (Employee) null;
    System.out.println(employee);
  }

  @Test
  public void test111() {
    System.out.println(Light.YELLOW.ordinal());
  }

  @Test
  public void testFormat() {
    System.out.println(String.format("%-10s", "jack356555585868975").replace(' ', '_'));
  }

  @Test
  public void testScale() {
    BigDecimal bigDecimal1 = new BigDecimal(Double.toString(100));
    BigDecimal bigDecimal2 = new BigDecimal(String.valueOf(100d));
    BigDecimal bigDecimal3 = BigDecimal.valueOf(100d);
    BigDecimal bigDecimal4 = new BigDecimal("100");
    BigDecimal bigDecimal5 = new BigDecimal(String.valueOf(100));

    print(bigDecimal1);
    System.out.println(bigDecimal1.scale() + "  and " + bigDecimal1.precision());
    print(bigDecimal2);
    print(bigDecimal3);
    print(bigDecimal4);
    print(bigDecimal5);

    BigDecimal num1 = new BigDecimal("3.35");
    // 小数点后1位，向下舍入
    BigDecimal num2 = num1.setScale(1, BigDecimal.ROUND_DOWN);
    System.out.println(num2);
    // 小数点后1位，四舍五入
    BigDecimal num3 = num1.setScale(1, BigDecimal.ROUND_HALF_UP);
    System.out.println(num3);
  }

  private static void print(BigDecimal bigDecimal) {
    System.out.println(
        String.format(
            "scale %s precision %s result %s",
            bigDecimal.scale(),
            bigDecimal.precision(),
            bigDecimal.multiply(new BigDecimal("1.001"))));
  }

  @Test
  public void testScale1() {
    System.out.println(new BigDecimal(String.valueOf(new Random().nextInt(1000000) * 0.01)));
  }

  /** 测试日期localDateFormat和date之间的转换 */
  @Test
  public void testLocalDateTransferdate() {
    Date from =
        Date.from(
            LocalDate.now().minusDays(1).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    System.out.println(from);

    Date from1 =
        Date.from(LocalDateTime.now().minusDays(1L).atZone(ZoneId.systemDefault()).toInstant());
    System.out.println(from1);

    String s =
        new BigDecimal(String.valueOf(new Random().nextInt(100)))
                .multiply(BigDecimal.valueOf(100))
                .setScale(2, BigDecimal.ROUND_HALF_UP)
                .toString()
            + "%";
    System.out.println(s);
  }

  /** 随机产生一个xx，xx% */
  @Test
  public void testXXXX() {
    String s =
        new BigDecimal(String.valueOf(new Random().nextInt(10000)))
                .divide(BigDecimal.valueOf(100))
                .setScale(2, BigDecimal.ROUND_HALF_UP)
                .toString()
            + "%";
    System.out.println(s);
  }

  @Test
  public void testLocaldate() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
    String format = LocalDate.now().format(formatter);
    System.out.println(format);
    /*int monthValue = now.getMonthValue();
    System.out.println(monthValue);

    int dayOfMonth = now.getDayOfMonth();
    System.out.println(dayOfMonth);*/
  }

  @Test
  public void testLocaldate1() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
    System.out.println(LocalDate.now().format(formatter));
  }
}
