package org.roy;

import org.junit.Test;
import org.roy.entity.Employee;
import org.roy.entity.Light;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

/** description： 开发额外测试 author：dingyawu date：created in 13:57 2020/10/28 history: */
public class ExtTest {
  @Test
  public void test11() {
    Employee employee = (Employee) null;
    System.out.println(employee);
  }

  @Test
  public void test111() {
    System.out.println(getTodayMills());
    System.out.println(Light.YELLOW.ordinal());
  }

  public static long getTodayMills() {
    //设置时区
    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    return calendar.getTimeInMillis();
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

  @Test
  public void testString() {
    Integer integer = null;
    String s = String.valueOf(integer);
    System.out.println(s);
    String string = integer.toString();
    System.out.println(string);
  }

  @Test
  public void testMap() {
    Map<String, List<String>> map = new HashMap();

    List<String> classify = map.get("java框架");
    if (Objects.isNull(classify)) {
      classify = new ArrayList<>();
      classify.add("Spring");
      map.put("java框架", classify);
    } else {
      classify.add("Spring");
    }
    System.out.println(map);
  }

  /** computeIfAbsent的方法，实际上都是一个计算，当你拿到的value是空的，自己new一个 ，等价于上一个 */
  @Test
  public void testMap1() {
    Map<String, List<String>> map = new HashMap();
    List<String> list = new ArrayList<>();
    list.add("roy");
    map.put("java", list);
    map.computeIfAbsent("java1", key -> new ArrayList<>()).add("Spring");
    System.out.println(map);
  }

  @Test
  public void testMap2() {
    Map<String, Integer> countMap = new HashMap();
    Integer count = countMap.get("java");
    if (Objects.isNull(count)) {
      countMap.put("java", 1);
    } else {
      countMap.put("java", count++);
    }
  }

  /** merge的用法，等价于上一个 */
  @Test
  public void testMap3() {
    Map<String, Integer> countMap = new HashMap();
    Integer count = countMap.getOrDefault("java", 0);
    countMap.put("java", count + 1);

    countMap.merge("java", 1, Integer::sum);
    System.out.println(countMap);
  }

  /** 测试map.getOrDefault */
  @Test
  public void testMap4() {
    Map<String, Integer> map = new HashMap();
    map.put("java", 1);
    map.put("mysql", 2);
    Integer result = map.getOrDefault("java1", 6);
    System.out.println(result);
  }

  @Test
  public void testMap5() {
    HashMap map = new HashMap();
  }

  @Test
  public void test234() {
    System.out.println(new Random().nextInt(4));
    System.out.println(ExtTest.getRandomBigDecimal(new BigDecimal("10"), new BigDecimal("20")));

    System.out.println(ExtTest.getPercent(new Random().nextInt(100), new Random().nextInt(100)));
  }

  /** 测试长参数 */
  @Test
  public void testLongStr() {
    String[] strings = {"Holis", "Hollis", "www.hollischuang.com", "QQ907607222"};

    print(strings);
    String[] strings1 = new String[2];
    strings1[0] = "jack";
    strings1[1] = "tom";
    print(strings1);
  }

  @Test
  public void testBigDecimalRemoveZero() {
    BigDecimal bigDecimal = new BigDecimal("1000.000");
    System.out.println(bigDecimal.stripTrailingZeros().toPlainString());

    DecimalFormat df = new DecimalFormat("0.00%");
    BigDecimal d = new BigDecimal(0.666);
    String percent = df.format(d);
  }

  @Test
  public void testPercent() {
    DecimalFormat df = new DecimalFormat("###.##%");
    BigDecimal d = new BigDecimal("66");
    String percent = df.format(d);
    System.out.println(percent);
  }

  @Test
  public void testPercent1() {
    DecimalFormat decimalFormat = new DecimalFormat("#.##");
    System.out.println(decimalFormat.format(12.0));
  }

  public static void print(String... strs) {
    for (int i = 0; i < strs.length; i++) {
      System.out.println(strs[i]);
    }
  }

  @Test
  public void stringTest() {

    Integer[] array = {1, 2, 3, 4, 5};
    List<Integer> list = Arrays.asList(array);
    int size = list.size();
    List<String> result = new ArrayList<>();
    DFS(list, "", result, size);
    System.out.println(result);
  }

  @Test
  public void stringTest1() {

    String string = "12345";
    System.out.println(string.indexOf("1"));
    char c = string.charAt(0);
    Integer integer = Integer.valueOf(c);
  }

  public static void DFS(List<Integer> list, String prefix, List<String> result, Integer size) {
    if (prefix.length() == size) {
      result.add(prefix);
    }

    for (int i = 0; i < list.size(); i++) {
      List<Integer> temp = new LinkedList<Integer>(list);
      int item = (int) temp.remove(i); // 取出被删除的元素，这个元素当作一个组合用掉了
      DFS(temp, prefix + item, result, size);
    }
  }

  /**
   * 获取任意的bigdecimal
   *
   * @param min 最小值
   * @param max 马克斯
   * @return {@link BigDecimal}
   */
  public static BigDecimal getRandomBigDecimal(BigDecimal min, BigDecimal max) {
    float minF = min.floatValue();
    float maxF = max.floatValue();

    // 生成随机数
    BigDecimal db = new BigDecimal(Math.random() * (maxF - minF) + minF);

    // 返回保留两位小数的随机数。不进行四舍五入
    return db.setScale(2, BigDecimal.ROUND_DOWN);
  }

  /**
   * 获取百分比
   *
   * @param x x
   * @param y y
   * @return {@link String}
   */
  public static String getPercent(int x, int y) {
    double d1 = x * 1.0;
    double d2 = y * 1.0;
    NumberFormat percentInstance = NumberFormat.getPercentInstance();
    // 设置保留几位小数，这里设置的是保留两位小数
    percentInstance.setMinimumFractionDigits(2);
    return percentInstance.format(d1 / d2);
  }

  public List<String> combination(List<String> inputList) {
    List<String> resList = new ArrayList<>();
    combinationInt(inputList, resList, 0, new char[inputList.size()]);
    return resList;
  }

  private void combinationInt(List<String> inputList, List<String> resList, int ind, char[] arr) {
    if (ind == inputList.size()) {
      resList.add(new String(arr));
      return;
    }
    for (char c : inputList.get(ind).toCharArray()) {
      arr[ind] = c;
      combinationInt(inputList, resList, ind + 1, arr);
    }
  }
}
