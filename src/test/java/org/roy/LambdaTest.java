package org.roy;

import org.junit.Test;
import org.roy.entity.StudentPlus;

import java.math.BigDecimal;
import java.util.function.*;

/** description： 测试lambda表达式 author：dingyawu date：created in 13:57 2020/10/28 history: */
public class LambdaTest {

  @Test
  public void testLambda() {

    /** 判断我们的integer */
    Predicate<Integer> predicate = x -> x > 185;
    StudentPlus student = new StudentPlus("9龙", 23, 175);
    System.out.println("9龙的身高高于185吗？：" + predicate.test(student.getHeight()));

    /** 消费我们的string */
    Consumer<String> consumer = System.out::println;
    consumer.accept("命运由我不由天");

    /** 将StudentPlus转化成string */
    Function<StudentPlus, String> function = StudentPlus::getName;
    String name = function.apply(student);
    System.out.println(name);

    /** 空手套白狼，没有输出，转化成integer */
    Supplier<Integer> supplier = () -> Integer.valueOf(BigDecimal.TEN.toString());
    System.out.println(supplier.get());

    UnaryOperator<Boolean> unaryOperator = uglily -> !uglily;
    Boolean apply2 = unaryOperator.apply(true);
    System.out.println(apply2);

    BinaryOperator<Integer> operator = (x, y) -> x * y;
    Integer integer = operator.apply(2, 3);
    System.out.println(integer);

    /** jdk本身没有提供这样的空的consumer */
    test(() -> "我是一个演示的函数式接口");

    Consumer<String> consumer1 = System.out::println;
    consumer1.accept("自己写的一个lambda");
  }

  public static void test(Worker worker) {
    String work = worker.work();
    System.out.println(work);
  }
}
