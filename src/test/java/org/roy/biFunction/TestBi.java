package org.roy.biFunction;

import org.junit.Test;

import java.security.cert.X509Certificate;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;

/**
 * description：
 * test BiFunction
 *
 * author：dingyawu
 * date：created in 23:13 2020/9/23
 * history:
 */
public class TestBi {
    /**
     * test BiFunction
     */
    @Test
    public void test(){
        BiFunction<String, String, Integer> biFunction = (s1, s2) -> s1.length() + s2.length();
        Integer count = biFunction.apply("hello", "world");
        System.out.println("count =" + count);
        Function<Integer, Integer> function = ele -> ele * ele;
        Integer result = biFunction.andThen(function).apply("hello", "world");
        System.out.println(result);
    }


    /**
     * test BiConsumer
     */
    @Test
    public void test12(){
        BiConsumer<Integer, Integer> consumer = (ele1, ele2) -> System.out.println(ele1 + ele2);
        consumer.accept(23, 24);
    }

    /**
     * test BiPredicate
     */
    @Test
    public void test13(){
        BiPredicate<String, String> biPredicate = (ele1, ele2) -> ele1.equals(ele2);
        System.out.println(biPredicate.test("hello", "world"));
    }
}
