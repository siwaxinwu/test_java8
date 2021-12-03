package org.roy;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.roy.entity.Employee;
import org.roy.entity.User;

import java.math.BigDecimal;
import java.util.*;
import java.util.logging.Logger;

/**
 * description： optional的用法
 * author：dingyawu
 * date：created in 10:56 2020/7/30 history: */
public class TestOptional {



  /**
   * optional的简单使用
   *
   */
  @Test
  public void test1() {
    // 创建一个空的optional
    Optional<String> empty = Optional.empty();
    String name = "roy";
    Optional<String> name1 = Optional.of(name);
    System.out.println(name1.toString()); // Optional[roy]
    // 传递给of()的值不可以为空，否则会抛出空指针异常。
    System.out.println("------------------------");
    String string = null;
    Optional<String> string1 = Optional.empty();
    System.out.println(string1); // Optional.empty
    System.out.println("------------------------------------------------");
    Optional.ofNullable("mysql").ifPresent(System.out::println);
    System.out.println(Optional.ofNullable(null).orElse("default"));
  }

  @Test
  public void test2() {
    String name = null;
    String result = Optional.ofNullable(name).orElse("dingyawu");
    System.out.println(result);
    System.out.println("------------------------------------------------");
    //这样传入的是supplier
    String string = "roy";
    String orElse = Optional.ofNullable(string).orElse(getDefaultName());
    String orElseGet = Optional.ofNullable(string).orElseGet(this::getDefaultName);
    System.out.println("------------------------------------------------");
    String str = null;
    String s = Optional.ofNullable(str).orElseThrow(IllegalArgumentException::new);
    System.out.println(s);
  }

  public String getDefaultName() {
    System.out.println("execute getDefaultName............. ");
    return "default";
  }

  /**
   * 使用get()方法也可以返回被包裹着的值。但是值必须存在。当值不存在时，
   * 会抛出一个 NoSuchElementException异常。 */
  @Test
  public void test3() {
    Optional<List<Employee>> result = Optional.of(TestDemo.createEnumData());
    boolean present = result.filter((ele) -> ele.size() > 5).isPresent();
    System.out.println(present);
  }


  @Test
  public void testOptionalMap() {
      Map<String, String> map = new HashMap<>();
      map.put("mysql", "zto");
      map.put("oracle", "chinasoft");
      map.put("gausedb", "jioatong");
      Optional<String> mysql = Optional.of(map).map(map1 -> map1.get("tomcat"));
      System.out.println(
      mysql.orElseGet(
          () -> {
            return "default";
          }));
  };

  /**
   * 当user值不为null时，orElse函数依然会执行createUser()方法，
   * 而orElseGet函数并不会执行createUser()方法，
   *
   */
  @Test
  public void test111() {
    User user = null;
    user = Optional.ofNullable(user).orElse(createUser());
    user = Optional.ofNullable(user).orElseGet(() -> createUser());
  }
  public User createUser(){
    User user = new User();
    user.setName("zhangsan");
    return user;
  }

  /**
   * 测试orElseThrow的用法
   *
   * @throws Exception 异常
   */
  @Test
  public void test11123() throws Exception {
    User user = null;
    Optional.ofNullable(user).orElseThrow(()->new Exception("用户不存在"));
  }

  /**
   * map和flatmap的区别就是一个返回要得到的类型，一个要返回optional
   *
   * @throws Exception 异常
   */
  @Test
  public void test1112343() throws Exception {
    String str = "newretail-anchor-10-live-nil-liveSessionId*193894|type*1|uid*203504|sessionId*1008676";
    String[] split = str.split("\\|");
    System.out.println(Arrays.toString(split));
  }

  @Test
  public void test111234322() throws Exception {
    System.out.println(2 < 1 ? -1 : 3 > 2 ? 2 : 1);
  }



  public Boolean judgevalidTime(){
    long time = new Date().getTime();
    String  startTime = "1636473500000";
    if (time > Long.parseLong(startTime) ){
      return true;
    }
    return false;
  }


  public Boolean macthConditiion(String anchorId){

    Map<Long, Integer> map = new HashMap<>();
    map.put(1L, 200);
    map.put(3L, 200);

    return map.keySet().stream().anyMatch(item -> Objects.equals(anchorId, String.valueOf(item)));

  }


}
