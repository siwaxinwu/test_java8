package org.roy;

import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/** description： guava测试 author：dingyawu date：created in 13:57 2020/10/28 history: */
public class GuavaTest {
  /** 测试字符串分离 测试容器和字符串互转 */
  @Test
  public void test11() {
    System.out.println(list2str2(Arrays.asList("234", "234", "567"), ","));
    System.out.println(str2list2("234, 234, 567", ","));
  }

  public List<String> str2list2(String str, String split) {
    return Splitter.on(split).splitToList(str);
  }

  public String list2str2(List<String> list, String split) {
    return String.join(split, list);
  }
}
