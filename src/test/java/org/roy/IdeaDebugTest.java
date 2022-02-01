package org.roy;

import org.junit.Test;
import org.roy.entity.Employee;
import org.roy.entity.Light;
import org.roy.entity.Status;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** description： 演示idea稍微高级一些的调试技巧
 * 1.返回上一步(方框上边加个X)。从子方法退到父方法 drop frame：丢弃当前栈帧，调用链回退
 * 2.for循环条件断点,条件表达式判断
 * 3.多线程调试:psvm
 * 4.流的调试
 * 5.打印某个点的堆栈信息
 * 6.在某个点强制结束当前栈，停止不行，只能在frame当中force return
 * 7.异常断点的运用
 * plus.方法断点的应用，有时候能够提高效率
 * 8.字段断点，监控写
 * 10.可以在debug的时候改变变量值（右击set value）
 * author：dingyawu
 * date：created in 13:57 2020/10/28
 * history:
 *
 * */
public class IdeaDebugTest {
  @Test
  public void test1() {
    System.out.println(23);
    testInner1();
  }

  private void  testInner1(){
    System.out.println("inner");
  }
  @Test
  public void test2() {
    for (int i = 0; i < 50; i++) {
      System.out.println(i);
    }
  }

  public static void main(String[] args) {
    new Thread(new TaskTest1(), "线程1").start();
    new Thread(new TaskTest2(), "线程2").start();
    System.out.println("主线程");
  }

  @Test
  public void test4() {
    List<Employee> datas = TestDemo.createData();
    List<Integer> ages = datas
            .stream()
            .filter(data -> data.getName().startsWith("陈")).filter(data -> data.getSalary() > 250000)
            .sorted()
            .map(Employee::getAge)
            .collect(Collectors.toList());
    System.out.println(ages);
  }

  @Test
  public void test5() {
    List<Employee> datas = TestDemo.createData();
    List<Integer> ages = datas.stream().filter(data -> data.getName().startsWith("陈")).filter(data -> data.getSalary() > 250000).map(Employee::getAge).collect(Collectors.toList());
    System.out.println(ages);
  }

  @Test
  public void test6() {
    System.out.println("error");
    System.out.println("save to db");
    System.out.println("send msg to other");
  }

  @Test
  public void test7() {
    System.out.println("prepare start-----");
    System.out.println(222);
    throw new NullPointerException();
  }

  @Test
  public void test8() {
    Employee roy = new Employee("roy", 23, 200000.0, Status.WORKING);
    roy.setAge(20);
    System.out.println(roy);
  }

  @Test
  public void test10() {
    Employee roy = new Employee("roy", 23, 200000.0, Status.WORKING);
    roy.setAge(20);
    System.out.println(roy);
  }
}
