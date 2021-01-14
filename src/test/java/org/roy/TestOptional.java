package org.roy;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Rule;
import org.junit.Test;
import org.roy.entity.Employee;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.LongStream;
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

	@Test
	public void  test4(){
		ArrayList<Long> longs = new ArrayList<>();
		longs.add(1L);
		longs.add(12L);
		longs.add(13L);
		ArrayList<Integer> integers = new ArrayList<>();
		integers.add(1);
		integers.add(12);
		integers.add(13);
		boolean b = integers.containsAll(longs);
		System.out.println(b);


	}


	@Test
	public void  test422(){
		BigDecimal d = new BigDecimal("2.225").setScale(2, BigDecimal.ROUND_HALF_UP);

		System.out.println(d);


	}

	@Test
	public void  test4221(){
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);

		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		boolean b = list.containsAll(list1);
		System.out.println(b);


	}

	@Test
	public void  test42211(){
		Long aLong = Long.valueOf("3");
		Long aLong1 = Long.valueOf(3);
		System.out.println(aLong + "   " + aLong1);
		System.out.println(aLong1.compareTo(1L) );
	}



}
