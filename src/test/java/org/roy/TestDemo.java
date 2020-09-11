package org.roy;


import org.junit.Test;
import org.roy.entity.Employee;
import org.roy.entity.Status;
import org.roy.inter.MyFunction;

import javax.management.remote.rmi._RMIConnection_Stub;
import javax.sound.midi.Soundbank;
import java.security.Key;
import java.security.PublicKey;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * description：
 * author：dingyawu
 * date：created in 16:52 2020/7/29
 * history:
 */
public class TestDemo {
    @Test
    //注意比较匿名表达式带大括号的时候的写法，获取年纪大于30，35的员工记录
    public void test1(){
        List<Employee> data = TestDemo.createData();
        List<Employee> result = data.stream().filter((Employee ele) -> ele.getAge() > 30).collect(Collectors.toList());
        System.out.println(result);
        System.out.println("------------------------------------------------------------");
        List<Employee> result2 = data.stream().filter((Employee ele) -> { return ele.getAge() > 35; }).collect(Collectors.toList());
        System.out.println(result2);

    }

    //工资大于或者等于5000的员工姓名
    @Test
    public void test2(){
        List<Employee> data = TestDemo.createData();
        data.stream().filter((Employee ele) -> {return ele.getSalary() > 5000;}).map(Employee::getName).forEach(System.out::println);

    }

    @Test
    public void test3() {
        TreeSet<Integer> set = new TreeSet<>((o1, o2) -> {
            return Integer.compare(o1, o2);
        });
        Runnable runnable = () -> {
            System.out.println("lambda.....");
        };
        new Thread(runnable).start();

        Consumer<String> consumer = (s) -> {
            System.out.println(s);
        };
        Consumer<String> consumer1 = System.out::println;
        consumer.accept("ok");
        consumer1.accept("ok1");
    }

    //可以采用这种静态方法当作比较器
    /*
    *   上述 Lambda 表达式中的参数类型都是由编译器推断得出的。 Lambda 表达式中无需指定类型，程序
        依然可以编译，这是因为 javac 根据程序的上下文，在后台推断出了参数的类型。 Lambda 表达式的类
        型依赖于上下文环境，是由编译器推断出来的。这就是所谓的“类型推断”。
    * */
    @Test
    public void test4() {
        BinaryOperator<Integer> operator = (a, b) ->{return  (a + b)*(a - b);};
        System.out.println(operator.apply(4, 3));
        System.out.println("----------------------------------------------");
        BinaryOperator<Integer> operator1 = BinaryOperator.minBy(Comparator.naturalOrder());
        System.out.println(operator1.apply(20, 3));
        System.out.println("----------------------------------------------");
        BinaryOperator<Integer> operator2 = BinaryOperator.minBy((a, b) -> {return (a -b)*(a + b);});
        operator2.apply(2, 4);
    }

    @Test
    public void test5() {
        TestDemo.createData().stream().sorted((a, b) -> {
            if (a.getAge() == b.getAge()){
                return (int) (a.getSalary() - b.getSalary());
            }
            return Integer.compare(a.getAge(), b.getAge());
        }).forEach(System.out::println);
    }

    @Test
    public void test6() {
        String get = TestDemo.stringHandler("get", (str) -> {
            return str + "a";
        });
        System.out.println(get);
        System.out.println("---------------------------------------");
        String get1 = TestDemo.stringHandlerDefault("get", (str) -> {
            return str + "b";
        });
        System.out.println(get1);
    }


    public static String stringHandler(String str, MyFunction myFunction){
        String value = myFunction.getValue(str);
        return value;
    }
    public static String stringHandlerDefault(String str, Function<String, String> function){
        String apply = function.apply(str);
        return apply;
    }

    @Test
    public void test7(){
        List<Employee> list = getList(() -> {
            return new Employee();
        }, 2);
        System.out.println(list);
    }


    public List<Employee> getList(Supplier<Employee> supplier, int num){
        ArrayList<Employee> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(supplier.get());
        }
        return list;
    }

    @Test
    public void test8(){
        BinaryOperator<Double> pow = Math::pow;
        Double apply = pow.apply(2.0, 3.0);
        System.out.println(apply);
        System.out.println("--------------------------------------------");
        Function<String,Employee> function = (str) ->{return new Employee(str, 24,23.5);};
        Employee roy = function.apply("roy");
        System.out.println(roy);
    }

    @Test
    public void test9(){
        Stream.iterate(0, (x) -> x + 2).limit(10).forEach(System.out::println);
        Stream.generate((Math::random)).limit(10).forEach(System.out::println);
    }

    @Test
    public void test10(){
        List<String> result = TestDemo.createData().stream().map(Employee::getName).collect(Collectors.toList());
        System.out.println(result);
        System.out.println("-----------------------------------");
        List<Integer> collect = TestDemo.createData().stream().map(Employee::getName).map(String::length).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void test11(){
        boolean b = TestDemo.createEnumData().stream().allMatch((ele) -> {
            return Status.WORKING.equals(ele.getStatus());
        });
        System.out.println(b);
        System.out.println("-----------------------------------------------");
        boolean c = TestDemo.createEnumData().stream().anyMatch((ele) -> {
            return Status.WORKING.equals(ele.getStatus());
        });
        System.out.println(c);
        System.out.println("------------------------------------------------");
        boolean d = TestDemo.createEnumData().stream().noneMatch((ele) -> {
            return Status.WORKING.equals(ele.getStatus());
        });
        System.out.println(d);
    }

    @Test
    public void test12(){
        Optional<Employee> optionalEmployee = TestDemo.createEnumData().stream().sorted((a, b) -> {
            return Double.compare(a.getSalary(), b.getSalary());
        }).findFirst();
        System.out.println(optionalEmployee.get());
        System.out.println("-------------------------------------------------");
        long count = TestDemo.createEnumData().stream().count();
        System.out.println(count);
        System.out.println("-------------------------------------------------");
        Employee employee = TestDemo.createEnumData().stream().max((a, b) -> {
            return Double.compare(a.getSalary(), b.getSalary());
        }).get();
        System.out.println(employee);
        System.out.println("-------------------------------------------------");
        Double aDouble = TestDemo.createEnumData().stream().map(Employee::getSalary).reduce(Double::sum).get();
        System.out.println(aDouble);
        System.out.println("-------------------------------------------------");
    }

    @Test
    public void test13(){
        Optional<Double> result = TestDemo.createEnumData().stream().map(Employee::getSalary).collect(Collectors.maxBy(Double::compare));
        System.out.println(result.get());
        DoubleSummaryStatistics result1 = TestDemo.createEnumData().stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("max----" + result1.getMax() + "---min---" + result1.getMin() + "---avg---" + result1.getAverage());
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println(result1.getCount() + result1.getSum());
    }

    //测试分组
    @Test
    public void test14(){
        Map<Integer, List<Employee>> map = TestDemo.createEnumData().stream().collect(Collectors.groupingBy((ele) -> {
            return ele.getAge();
        }));
        map.forEach((key, value) -> {
            System.out.println("----------------");
            System.out.println(key);
            System.out.println(value);
        });

    }


    @Test
    public void test15(){
        System.out.println(Integer.parseInt("01"));

    }

    public static List<Employee> createData() {
        List<Employee> employees = Arrays.asList(
                new Employee("张三", 18, 9999.99),
                new Employee("李四", 38, 5555.55),
                new Employee("王五", 60, 6666.66),
                new Employee("赵六", 16, 7777.77),
                new Employee("范恒杰", 30, 8652.23),
                new Employee("古耀", 31, 12768.98),
                new Employee("单春华", 23, 3323.33),
                new Employee("李鹏飞", 29, 16754.00),
                new Employee("陆中军", 37, 5623.58),
                new Employee("吴银伟", 26, 15230.22),
                new Employee("陈静", 45, 25014.32),
                new Employee("赵庆明", 76, 8652.96),
                new Employee("陈宏杰", 34, 36258.00),
                new Employee("陈龙", 67, 53273.21),
                new Employee("李连杰", 45, 12386.21),
                new Employee("张艺兴", 32, 5632.55),
                new Employee("黄渤", 25, 4532.66)

        );
        return employees;
    }


    public static List<Employee> createEnumData() {
        List<Employee> employees = Arrays.asList(
                new Employee("张三", 18, 9999.99, Status.WORKING),
                new Employee("李四", 38, 5555.55, Status.VOCATION),
                new Employee("王五", 60, 6666.66, Status.SLEEPING),
                new Employee("赵六", 16, 7777.77, Status.VOCATION),
                new Employee("范恒杰", 30, 8652.23, Status.WORKING),
                new Employee("古耀", 31, 12768.98, Status.SLEEPING),
                new Employee("单春华", 23, 3323.33, Status.WORKING),
                new Employee("李鹏飞", 29, 16754.00, Status.VOCATION),
                new Employee("陆中军", 37, 5623.58, Status.WORKING),
                new Employee("吴银伟", 26, 15230.22, Status.WORKING),
                new Employee("陈静", 45, 25014.32, Status.VOCATION),
                new Employee("赵庆明", 76, 8652.96, Status.WORKING),
                new Employee("陈宏杰", 34, 36258.00, Status.SLEEPING),
                new Employee("陈龙", 67, 53273.21, Status.VOCATION),
                new Employee("李连杰", 45, 12386.21, Status.SLEEPING),
                new Employee("张艺兴", 32, 5632.55, Status.WORKING),
                new Employee("黄渤", 25, 4532.66, Status.SLEEPING)

        );
        return employees;
    }
}
