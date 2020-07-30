package org.roy;

import org.junit.Rule;
import org.junit.Test;
import org.roy.entity.Employee;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * description：
 * author：dingyawu
 * date：created in 10:56 2020/7/30
 * history:
 */
public class TestOptional {
    @Test
    public void test1(){
        //创建一个空的optional
        Optional<String> empty = Optional.empty();
        String name = "roy";
        Optional<String> name1 = Optional.of(name);
        System.out.println(name1.toString()); //Optional[roy]
        //传递给of()的值不可以为空，否则会抛出空指针异常。例如，下面的程序会抛出空指针异常。
        System.out.println("------------------------");
        String string = null;
        Optional<String> string1 = Optional.ofNullable(string);
        System.out.println(string1);//Optional.empty
        System.out.println("------------------------------------------------");
        //我们可以使用这个isPresent()方法检查一个Optional对象中是否有值，只有值非空才返回true。
        System.out.println(string1.isPresent());
        System.out.println("------------------------------------------------");
        Optional.ofNullable("dingyawu").ifPresent(System.out::println);
        Optional.ofNullable("dingyawu").ifPresent((name2) -> { System.out.println(name2.length()); });
    }

    @Test
    public void test2(){
        String name = null;
        String result = Optional.ofNullable(name).orElse("dingyawu");
        System.out.println(result);
        System.out.println("------------------------------------------------");
        String string = "roy";
        String orElse = Optional.ofNullable(string).orElse(getDefaultName());
        String orElseGet = Optional.ofNullable(string).orElseGet(this::getDefaultName);
        System.out.println("------------------------------------------------");
        String str = null;
        /*String s = Optional.ofNullable(str).orElseThrow(IllegalArgumentException::new);
        System.out.println(s);*/
        //String s1 = Optional.ofNullable(str).orElseThrow(() -> {return new IllegalArgumentException();});
    }

    public String getDefaultName(){
        System.out.println("execute getDefaultName............. ");
        return "default";
    }

    @Test
    public void  test3(){
        //使用get()方法也可以返回被包裹着的值。但是值必须存在。当值不存在时，会抛出一个
        //NoSuchElementException异常。
        /*Optional<String> result = Optional.ofNullable(null);
        String s = result.get();*/
        System.out.println("------------------------------------------------");
        Optional<List<Employee>> result = Optional.ofNullable(TestDemo.createEnumData());
        boolean present = result.filter((ele) -> ele.size() < 5).isPresent();
        System.out.println(present);

    }



}
