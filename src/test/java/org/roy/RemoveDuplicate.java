package org.roy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 21:46 2021-03-22
 */
public class RemoveDuplicate {
  @Test
  public void testRemove() {
    List<String> stringList =
        new ArrayList<String>() {
          {
            add("A");
            add("A");
            add("B");
            add("B");
            add("C");
          }
        };
    System.out.print("去重前：");

    for (String s : stringList) {
      System.out.print(s);
    }
    System.out.println("");
    stringList = stringList.stream().distinct().collect(Collectors.toList());
    System.out.print("去重后：");
    for (String s : stringList) {
      System.out.print(s);
    }
    System.out.println();
  }
}
