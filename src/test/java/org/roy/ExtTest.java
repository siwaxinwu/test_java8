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
    String str = "{\"content\":{\"mic\": 2,\n" +
            "\"micno\":0,\n" +
            "\"ts\":\n" +
            "1 \n" +
            ".\n" +
            "6\n" +
            "3\n" +
            "7\n" +
            "6\n" +
            "3\n" +
            "7\n" +
            "7\n" +
            "7\n" +
            "4\n" +
            "1\n" +
            "6\n" +
            "9\n" +
            "E\n" +
            "1\n" +
            "2\n" +
            ",\n" +
            "\"\n" +
            "u\n" +
            "i\n" +
            "d\n" +
            "\"\n" +
            ":\n" +
            "3\n" +
            "3\n" +
            "5\n" +
            "5\n" +
            "5\n" +
            "2\n" +
            "1\n" +
            "1\n" +
            "2\n" +
            ",\n" +
            "\"\n" +
            "u\n" +
            "s\n" +
            "e\n" +
            "r\n" +
            "T\n" +
            "y\n" +
            "p\n" +
            "e\n" +
            "\"\n" +
            ":\n" +
            "0\n" +
            ",\n" +
            "\"\n" +
            " v\n" +
            "o\n" +
            "l\n" +
            "u\n" +
            "m\n" +
            " e\n" +
            "\"\n" +
            ":\n" +
            "0\n" +
            ".\n" +
            "0\n" +
            "}\n" +
            ",\n" +
            "\"\n" +
            "t\n" +
            "y\n" +
            "p\n" +
            "e\n" +
            "\"\n" +
            ":\n" +
            "1\n" +
            "}";
    String replace = str.replace("\n", "");
    System.out.println(replace);
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
  public void stringDorpn() {
    String string = ",73113839,100021667,134110598\n" +
            ",26551693\n" +
            ",220688155\n" +
            ",86120578\n" +
            ",32531300\n" +
            ",28744595\n" +
            ",16352733\n" +
            ",52526813\n" +
            ",203168160\n" +
            ",75159747\n" +
            ",62027518\n" +
            ",108744841\n" +
            ",42031999\n" +
            ",91049126\n" +
            ",44151903\n" +
            ",19992292\n" +
            ",5823630\n" +
            ",173765831\n" +
            ",15238794\n" +
            ",78229212\n" +
            ",102405749\n" +
            ",2031802\n" +
            ",3362884\n" +
            ",49314528\n" +
            ",46455196\n" +
            ",113532878\n" +
            ",1897897\n" +
            ",8948718\n" +
            ",14542491\n" +
            ",18242377\n" +
            ",38175839\n" +
            ",11978656\n" +
            ",82634766\n" +
            ",84902311\n" +
            ",82062969\n" +
            ",15979684\n" +
            ",55275873\n" +
            ",58597977\n" +
            ",36136739\n" +
            ",2966909\n" +
            ",122427326\n" +
            ",53204323\n" +
            ",1012680\n" +
            ",91307683\n" +
            ",28536879\n" +
            ",82066955\n" +
            ",37838060\n" +
            ",22591868\n" +
            ",3568012\n" +
            ",139567074\n" +
            ",108677343\n" +
            ",175811680\n" +
            ",90151648\n" +
            ",48063880\n" +
            ",37782644\n" +
            ",166441008\n" +
            ",119380079\n" +
            ",44473239\n" +
            ",174359902\n" +
            ",18315940\n" +
            ",45621336\n" +
            ",26032091\n" +
            ",82617681\n" +
            ",21356079\n" +
            ",68438115\n" +
            ",52770628\n" +
            ",5824838\n" +
            ",17110499\n" +
            ",77341519\n" +
            ",16157224\n" +
            ",34038662\n" +
            ",125242522\n" +
            ",81204370\n" +
            ",29838293\n" +
            ",25024278\n" +
            ",237614207\n" +
            ",51634298\n" +
            ",37077454\n" +
            ",91787022\n" +
            ",62571955\n" +
            ",147289761\n" +
            ",257384664\n" +
            ",268234849\n" +
            ",165992410\n" +
            ",47470573\n" +
            ",145189507\n" +
            ",2595027\n" +
            ",17397632\n" +
            ",48433042\n" +
            ",17591325\n" +
            ",43607232\n" +
            ",69463223\n" +
            ",102575511\n" +
            ",51641779\n" +
            ",137325613\n" +
            ",129944045\n" +
            ",27990464\n" +
            ",203581885\n" +
            ",11642928\n" +
            ",185435424\n" +
            ",166332552\n" +
            ",17260502\n" +
            ",32940714\n" +
            ",114603209\n" +
            ",234346130\n" +
            ",1853954\n" +
            ",303028998\n" +
            ",22134215\n" +
            ",65517453\n" +
            ",126019461\n" +
            ",88486882\n" +
            ",31963992\n" +
            ",146015268\n" +
            ",98473952\n" +
            ",129296858\n" +
            ",47891139\n" +
            ",237159389\n" +
            ",54420117\n" +
            ",78344002\n" +
            ",296253447\n" +
            ",40166561\n" +
            ",242471350\n" +
            ",31559574\n" +
            ",56020963\n" +
            ",28933414\n" +
            ",9072871\n" +
            ",7893767\n" +
            ",149970573\n" +
            ",39011759\n" +
            ",166608813\n" +
            ",45747846\n" +
            ",44829156\n" +
            ",256471567\n" +
            ",6382061\n" +
            ",6820043\n" +
            ",244009652\n" +
            ",146141576\n" +
            ",17359851\n" +
            ",66755639\n" +
            ",104630800\n" +
            ",45270562\n" +
            ",51077061\n" +
            ",314833733\n" +
            ",301361251\n" +
            ",37964246\n" +
            ",118405893\n" +
            ",88134133\n" +
            ",28995300\n" +
            ",327363446\n" +
            ",52932074\n" +
            ",251227339\n" +
            ",160761911\n" +
            ",286258767\n" +
            ",6105487\n" +
            ",177858495\n" +
            ",32515165\n" +
            ",95777990\n" +
            ",27811654\n" +
            ",295305826\n" +
            ",74283450\n" +
            ",126139436\n" +
            ",52263620\n" +
            ",112630504\n" +
            ",64138704\n" +
            ",124310157\n" +
            ",122768722\n" +
            ",151890596\n" +
            ",201083201\n" +
            ",118157530\n" +
            ",104286597\n" +
            ",34428115\n" +
            ",33942996\n" +
            ",62329228\n" +
            ",20032349\n" +
            ",7247941\n" +
            ",37258509\n" +
            ",9480066\n" +
            ",107483479\n" +
            ",16149214\n" +
            ",67180088\n" +
            ",3675746\n" +
            ",99976689\n" +
            ",112683067\n" +
            ",6314314\n" +
            ",1012254\n" +
            ",4448301\n" +
            ",37274728\n" +
            ",27003515\n" +
            ",201053117\n" +
            ",165068618\n" +
            ",3142351\n" +
            ",35541425\n" +
            ",86640535\n" +
            ",3317615\n" +
            ",135924843\n" +
            ",122830938\n" +
            ",19082764\n" +
            ",24709969\n" +
            ",51342012\n" +
            ",32744669\n" +
            ",4510996\n" +
            ",62737330\n" +
            ",42798112\n" +
            ",3362884\n" +
            ",10805155\n" +
            ",7655685\n" +
            ",62811993\n" +
            ",15827296\n" +
            ",27553887\n" +
            ",8889234\n" +
            ",15782911\n" +
            ",177546186\n" +
            ",3205937\n" +
            ",1374220\n" +
            ",203011940\n" +
            ",212583127\n" +
            ",167935834\n" +
            ",194313301\n" +
            ",13081763\n" +
            ",252640074\n" +
            ",248801137\n" +
            ",52662906\n" +
            ",39496787\n" +
            ",79973036\n" +
            ",12495477\n" +
            ",32160470\n" +
            ",37206315\n" +
            ",70618528\n" +
            ",147647136\n" +
            ",227035007\n" +
            ",313344659\n" +
            ",203012033\n" +
            ",147770569\n" +
            ",62231336\n" +
            ",3799496\n" +
            ",83317519\n" +
            ",286709145\n" +
            ",128355917\n" +
            ",338379823\n" +
            ",301587814\n" +
            ",187149270\n" +
            ",344628147\n" +
            ",76354344\n" +
            ",41855169\n" +
            ",48101193\n" +
            ",3992735\n" +
            ",302635799\n" +
            ",247000676\n" +
            ",195506757\n" +
            ",48536908\n" +
            ",258739869\n" +
            ",235196490\n" +
            ",66512890\n" +
            ",78355982\n" +
            ",38826030\n" +
            ",15874143\n" +
            ",29332115\n" +
            ",96527700\n" +
            ",70493056\n" +
            ",28355917\n" +
            ",201224016\n" +
            ",96687603\n" +
            ",163213747\n" +
            ",91246187\n" +
            ",259518159\n" +
            ",139245226\n" +
            ",81443246\n" +
            ",96637702\n" +
            ",73127038,";
    String replace = string.replace("\n", "");
    System.out.println(replace);
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
