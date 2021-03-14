package org.roy;

import org.junit.Test;

import java.util.StringJoiner;

/** description： author：dingyawu date：created in 16:09 2020/7/30 history: */
public class TestStringJoiner {
  @Test
  public void test1() {
    StringJoiner sj = new StringJoiner(":", "[", "]");
    sj.add("George").add("Sally").add("Fred");
    String join = sj.toString();
    System.out.println(join);
  }

  @Test
  public void test2() {
    StringJoiner sj = new StringJoiner(":");
    sj.add("George").add("Sally").add("Fred");
    String join = sj.toString();
    System.out.println(join);
  }
}
