package org.roy;

import org.junit.Test;

import java.util.*;

/** description： 开发额外测试 author：dingyawu date：created in 13:57 2020/10/28 history: */
public class MapTest {

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
    // map.computeIfAbsent("java", key -> new ArrayList<>()).add("Spring");
    map.computeIfAbsent("java1", key -> new ArrayList<>());
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

  /** merge的用法，等价于上一个 ，统计字符串的用法 */
  @Test
  public void testMap3() {
    Map<String, Integer> countMap = new HashMap();
    /*countMap.merge("java", 1, Integer::sum);
    System.out.println(countMap);*/
    String str = "abcdabcdae";
    for (int i = 0; i < str.length(); i++) {
      countMap.merge(str.substring(i, i + 1), 1, Integer::sum);
    }
    System.out.println(countMap);
  }

  /** 测试map.getOrDefault
   * 曾经看到有同学这样写的，没必要
   *
   * */
  @Test
  public void testMap4() {
    Map<String, Integer> map = new HashMap();
    map.put("java", 1);
    map.put("mysql", 2);
    Integer result = map.getOrDefault("java1", 6);
    System.out.println(result);
    Integer roy = map.get("roy");
    //Integer roy1 = map.getOrDefault("roy", null);
    System.out.println(roy);
  }

  @Test
  public void testMap5() {
    System.out.println(MapTest.class.getName());
  }

  @Test
  public void testMap6() {
    Map<Integer, String> map = new LinkedHashMap<>();
    map.put(1, "tom1");
    map.put(2, "tom2");
    map.put(6, "tom3");
    map.put(4, "tom4");
    map.put(5, "tom5");
    for (Map.Entry entry : map.entrySet()) {
      System.out.println(entry.getKey());
    }
  }
}
