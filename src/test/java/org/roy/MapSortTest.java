package org.roy;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/** description： 开发额外测试 author：dingyawu date：created in 13:57 2020/10/28 history: */
public class MapSortTest {

  /** 测试Hashmap是无序的 */
  @Test
  public void testHashMap() {
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "tom1");
    map.put(2, "tom2");
    map.put(6, "tom6");
    map.put(4, "tom4");
    map.put(5, "tom5");
    for (Map.Entry entry : map.entrySet()) {
      System.out.println(entry.getKey());
    }
  }

  /** LinkedHashMap的插入是有序的 */
  @Test
  public void testLinedHashMap() {
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

  /** TreeMap中的元素默认按照keys的自然排序排列 （对Integer来说，其自然排序就是数字的升序；对String来说，其自然排序就是按照字母表排序） */
  @Test
  public void testTreeMap() {
    Map<Integer, String> map = new TreeMap<>();
    map.put(1, "tom1");
    map.put(2, "tom2");
    map.put(6, "tom3");
    map.put(4, "tom4");
    map.put(5, "tom5");
    for (Map.Entry entry : map.entrySet()) {
      System.out.println(entry.getKey());
    }
  }

  @Test
  public void testMapStr() {
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "tom1");
    map.put(2, "tom2");
    map.put(6, "tom3");
    map.put(4, "tom4");
    map.put(5, "tom5");
    Map<Integer, String> map1 = null;
    map.putAll(map1);


  }


}
