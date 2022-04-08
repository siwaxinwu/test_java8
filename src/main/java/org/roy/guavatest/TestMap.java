package org.roy.guavatest;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description:  如何让一个集合不可被修改
 * @author: Ding Yawu
 * @create: 2022/3/17 19:32
 */
public class TestMap {
    private static Map<Integer, String> map = new HashMap<>();

    static {
        map.put(1, "jack");
        map.put(2, "tom");
        map = Collections.unmodifiableMap(map);
    }

  public static void main(String[] args) {
      map.put(3, "lucy");
  }
}
