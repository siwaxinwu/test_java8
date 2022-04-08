package org.roy;

import com.google.common.base.Splitter;
import jdk.internal.org.objectweb.asm.Opcodes;
import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/** description： guava测试 author：dingyawu date：created in 13:57 2020/10/28 history: */
public class GuavaTest {
  /** 测试字符串分离 测试容器和字符串互转 */
  @Test
  public void test11() {
    System.out.println(list2str2(Arrays.asList("234", "234", "567"), ","));
    System.out.println(str2list2("234, 234, 567", ","));
  }

  @Test
  public void test112() {
    System.out.println(qryZero(1));
  }

  public static Date qryZero(Integer minusDay){
    Calendar calendar = Calendar.getInstance();
    calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH) - minusDay,0,00,00);
    return calendar.getTime();
  }


  @Test
  public void test112212() {
    //System.out.println(String.valueOf(null));
  }

  @Test
  public void test22() {
    try{
      throw new NullPointerException();
    }catch (RuntimeException e){
      System.out.println("execute RuntimeException");
    }catch (Exception e){
      System.out.println("execute Exception ");
    }
  }




  public List<String> str2list2(String str, String split) {
    return Splitter.on(split).splitToList(str);
  }

  public String list2str2(List<String> list, String split) {
    return String.join(split, list);
  }
}
