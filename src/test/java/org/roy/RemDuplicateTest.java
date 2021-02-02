package org.roy;

import org.junit.Test;
import org.roy.entity.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 16:55 2021-02-02
 */
public class RemDuplicateTest {
  /** 根据对象的某个字段去重 只会取到第一个对象，不会重复 */
  @Test
  public void testRemoveDuplicate() {
    List<Employee> data = TestDemo.createData();
    System.out.println(data.size());
    List<Employee> employees =
        data.stream()
            .collect(
                Collectors.collectingAndThen(
                    Collectors.toCollection(
                        () -> new TreeSet<>(Comparator.comparing(Employee::getName))),
                    ArrayList::new));
    System.out.println(employees.size());
    System.out.println(employees);
  }

  /** 一个对象整体去重 */
  @Test
  public void testObject() {
    List<Employee> data = TestDemo.createData();
    System.out.println(data.size());
    List<Employee> employees = data.stream().distinct().collect(Collectors.toList());
    System.out.println(employees.size());
    System.out.println(employees);
  }
}
