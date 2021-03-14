package org.roy;

import org.junit.Test;
import org.roy.entity.Employee;

import java.math.BigDecimal;
import java.util.*;

/** description： author：dingyawu date：created in 10:56 2020/7/30 history: */
public class TestOptional {
  @Test
  public void test1() {
    // 创建一个空的optional
    Optional<String> empty = Optional.empty();
    String name = "roy";
    Optional<String> name1 = Optional.of(name);
    System.out.println(name1.toString()); // Optional[roy]
    // 传递给of()的值不可以为空，否则会抛出空指针异常。例如，下面的程序会抛出空指针异常。
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
     String s1 = Optional.ofNullable(str).orElseThrow(() -> {return new
     IllegalArgumentException();});
  }

  public String getDefaultName() {
    System.out.println("execute getDefaultName............. ");
    return "default";
  }

  @Test
  public void test3() {
    // 使用get()方法也可以返回被包裹着的值。但是值必须存在。当值不存在时，会抛出一个
    // NoSuchElementException异常。
    /*Optional<String> result = Optional.ofNullable(null);
    String s = result.get();*/
    System.out.println("------------------------------------------------");
    Optional<List<Employee>> result = Optional.of(TestDemo.createEnumData());
    boolean present = result.filter((ele) -> ele.size() < 5).isPresent();
    System.out.println(present);
  }


  /**
   * 测试containsAll
   *
   */
  @Test
  public void test4() {
    List<Long> longs = new ArrayList<>();
    longs.add(1L);
    longs.add(12L);
    longs.add(13L);
    List<Integer> integers = new ArrayList<>();
    integers.add(1);
    integers.add(12);
    integers.add(13);
    boolean b = integers.containsAll(longs);
    System.out.println(b);
  }

	@Test
	public void test4221() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);

		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		boolean b = list.containsAll(list1);
		System.out.println(b);
	}


  @Test
  public void testBigDecimal() {
    BigDecimal d = new BigDecimal("2.225").setScale(2, BigDecimal.ROUND_HALF_UP);
    System.out.println(d);
  }



  /**
   * compareTo比较两个long返回0
   * 测试split，
   */
  @Test
  public void testLong() {
    Long aLong = Long.valueOf("3");
    Long aLong1 = 3L;
    System.out.println(aLong + "   " + aLong1);
    System.out.println(aLong1.compareTo(aLong1));

    String string = "are,you,ok";
    String[] split = string.split(",");
    List<String> list = Arrays.asList(split);
    System.out.println(list);
  }

  @Test
  public void testflatmap() {
    // 创建 map 对象
    Map<String, String> userMap = new HashMap<>();
    userMap.put("name", "mysql");
    userMap.put("sex", "男");

    Optional<Map<String, String>> optional1 = Optional.ofNullable(userMap);

     Optional optional2 = optional1.flatMap(value -> Optional.ofNullable(value.get("name")));
     optional1.map(map2 -> map2.get("name")).orElse("default");
     System.out.println("获取的 Optional 的值：" + optional2.get());
  }

  @Test
  public void testMap() {
    // 创建 map 对象
    Map<String, String> userMap = new HashMap<>();
    userMap.put("name1", "mydlq");
    userMap.put("name2", null);

    // 传入 Map 对象参数，获取一个 Optional 对象，获取 name1 属性
    Optional<String> optional1 = Optional.of(userMap).map(map -> map.get("name1"));

    // 传入 Map 对象参数，获取一个 Optional 对象，获取 name2 属性
    Optional<String> optional2 = Optional.of(userMap).map(map -> map.get("name2"));

    // 获取 Optional 的值
    System.out.println("获取的 name1 的值：" + optional1.orElse("默认值"));
    System.out.println("获取的 name2 的值：" + optional2.orElse("默认值"));
  }

  @Test
  public void testMap1() {
    // 创建一个对象，设置姓名属性而不设置性别，这时候性别为 null
    Student student = new Student("dingyawu", "29", "2020-01");
    Student student1 = new Student();

    Optional<String> s = Optional.of(student1).map(Student::getUserName);

    // 获取对象的 name 属性值
    String name1 = Optional.of(student).map(Student::getUserName).orElse("未填写");
    String name2 = Optional.of(student1).map(Student::getUserName).orElse("未填写");

    // 输出结果
    System.out.println("获取的名称：" + name1);
    System.out.println("获取的名称：" + name2);
  }

  @Test
  public void testFilter() {
    // 创建一个对象，设置姓名属性而不设置性别，这时候性别为 null
    Student student = new Student("dingyawu", "29", "2020-01");
    Optional<String> optional =
        Optional.of(student).map(Student::getUserName).filter(name -> name.length() > 23);
    System.out.println(optional.isPresent());
    String string = "";
  }

  @Test
  public void testOptional1() {
    List<Student> list = new ArrayList<>();
    List<String> nameList = new ArrayList<>();
    list.forEach(
            student ->
                nameList.add(
                    Optional.ofNullable(student)
                        .map(Student::getUserName)
                        .filter(student1 -> student1.startsWith("a"))
                        .orElse("未填写")));
    System.out.println(nameList);
  };

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
}
