package org.roy;

import org.junit.Test;
import org.roy.entity.Employee;
import org.roy.entity.Leader;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** description：对流的操作做一次强化和进阶 author：dingyawu date：created in 0:04 2020/9/24 history: */
public class TestPlus {
  @Test
  public void test() {
    List<Employee> data = TestDemo.createData();
    Predicate<Employee> predicate = ele -> ele.getSalary() > 15000;
    Stream<Employee> stream = data.stream().filter(predicate);
    List<Employee> result = stream.peek(System.out::println).collect(Collectors.toList());
    System.out.println(result);
  }

  @Test
  public void test11() {
    List<Employee> data = TestDemo.createData();
    List<Leader> result =
        data.stream()
            .filter(emp -> emp.getSalary() > 20000)
            .map(
                emp -> {
                  Leader leader = new Leader();
                  leader.setName(emp.getName());
                  leader.setSalary(emp.getSalary());
                  return leader;
                })
            .peek(System.out::println)
            .collect(Collectors.toList());
    System.out.println(result);
  }

  @Test
  public void test12() {
    List<Employee> data = TestDemo.createData();
    data.stream()
        .sorted(Comparator.comparing(Employee::getSalary).reversed())
        .peek(System.out::println)
        .collect(Collectors.toList());
  }

  @Test
  public void test13() {
    List<Employee> data = TestDemo.createData();
    double result = data.stream().mapToDouble(Employee::getSalary).max().orElse(0.00);
    System.out.println(result);
    Employee employee = data.stream().max(Comparator.comparing(Employee::getSalary)).orElse(null);
    System.out.println(employee);
  }

  @Test
  public void test14() {
    List<Employee> data = TestDemo.createData();
    Predicate<Employee> predicate = ele -> ele.getSalary() > 10000;
    boolean b = data.stream().allMatch(predicate);
    System.out.println(b);
  }

  @Test
  public void test15() {
    List<Employee> data = TestDemo.createData();
    //        List<Employee> result =
    // Stream.of(data).distinct(Employee::getSalary).collect(Collectors.toList());
    //        data.stream().filter(disti);

  }

  @Test
  public void test16() {
    List<Employee> data = TestDemo.createData();
    Double result = data.stream().map(Employee::getSalary).reduce(Double::sum).get();
    System.out.println(result);

    Double result1 =
        data.stream()
            .map(Employee::getSalary)
            .reduce(
                (a, b) -> {
                  return a + b;
                })
            .get();
    System.out.println(result1);

    Double result2 = data.stream().map(Employee::getSalary).reduce(AddUtils::add).get();
    System.out.println(result2);

    Double result3 = data.stream().map(Employee::getSalary).reduce(1.00, AddUtils::add);
    System.out.println(result3);
  }

  static class AddUtils {
    public static Double add(Double a, Double b) {
      return a + b;
    }
  }

  @Test
  public void test17() {
    List<Employee> data = TestDemo.createData();
    String result = data.stream().map(Employee::getName).collect(Collectors.joining(","));
    System.out.println(result);

    Set<String> result1 = data.stream().map(Employee::getName).collect(Collectors.toSet());
    System.out.println(result1);

    Map<String, Double> result2 =
        data.stream().collect(Collectors.toMap(Employee::getName, Employee::getSalary));
    System.out.println(result2);
  }

  @Test
  public void test18() {
    List<Employee> data = TestDemo.createData();
    System.out.println(data.stream().count());
    System.out.println(data.stream().filter(ele -> ele.getSalary() > 10000).count());
  }

  @Test
  public void test19() {
    List<Employee> data = TestDemo.createData();
    DoubleSummaryStatistics statistics =
        data.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
    System.out.println(statistics);

    DoubleSummaryStatistics statistics1 =
        data.stream().mapToDouble(Employee::getSalary).summaryStatistics();
    System.out.println(statistics1);
  }

  @Test
  public void test20() {
    // partition只能分成两部分
    List<Employee> data = TestDemo.createData();
    Map<Boolean, List<Employee>> result =
        data.stream().collect(Collectors.partitioningBy(ele -> ele.getSalary() >= 10000));
    System.out.println(result.get(Boolean.TRUE));
    System.out.println(result.get(Boolean.FALSE));
  }

  @Test
  public void test21() {
    List<Employee> data = TestDemo.createData();
    Map<Double, List<Employee>> result =
        data.stream().collect(Collectors.groupingBy(Employee::getSalary));
    Map<Double, Long> result1 =
        data.stream().collect(Collectors.groupingBy(Employee::getSalary, Collectors.counting()));
    System.out.println(result1);
    Map<Double, Double> result2 =
        data.stream()
            .collect(
                Collectors.groupingBy(
                    Employee::getSalary, Collectors.summingDouble(Employee::getSalary)));
    System.out.println(result2);
    Map<Double, List<Employee>> result3 =
        data.stream().collect(Collectors.groupingBy(Employee::getSalary, Collectors.toList()));
    System.out.println(result3);
  }

  @Test
  public void test22() {
    List<Employee> data = TestDemo.createData();
    data.stream().parallel().forEach(ele -> cal(ele));
  }

  public static void cal(Employee emp) {
    try {
      long value = Double.valueOf(emp.getSalary()).longValue();
      TimeUnit.MICROSECONDS.sleep(value);
      System.out.println(Thread.currentThread().getName() + emp.getName());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void test23() throws IOException {
    List<Employee> data = TestDemo.createData();
    PrintWriter printWriter = new PrintWriter(Files.newBufferedWriter(Paths.get("E:\\txt.txt")));
    data.stream().forEach(printWriter::println);
    printWriter.close();
    List<String> result =
        Files.lines(Paths.get("E:\\txt.txt"))
            .peek(System.out::println)
            .collect(Collectors.toList());
  }

  @Test
  public void test23222() throws IOException {
    BigDecimal compute = compute(26665L, 451396L);
    System.out.println(compute);
  }

  @Test
  public void test2322222() throws IOException {
    boolean startWithNumber = TestPlus.isStartWithNumber("a23245");
  }

  private BigDecimal compute(Long v1, Long v2) {
    if (v2 == null || v2.equals(0)) {
      return BigDecimal.valueOf(1);
    }
    BigDecimal bigDecimal1 = BigDecimal.valueOf(v1);
    BigDecimal bigDecimal2 = BigDecimal.valueOf(v2);
    return bigDecimal1.divide(bigDecimal2, 4, BigDecimal.ROUND_HALF_UP);
  }

  public static boolean isStartWithNumber(String str) {
    Pattern pattern = Pattern.compile("[0-9].*"); // 一定记住加“.”
    Matcher isNum = pattern.matcher(str.charAt(0) + "");
    if (!isNum.matches()) {
      return false;
    }
    return true;
  }
}
