package org.roy;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;
import org.roy.entity.Employee;
import org.roy.entity.Light;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * description：  开发额外测试
 * author：dingyawu
 * date：created in 13:57 2020/10/28
 * history:
 */
public class RandomTest {
	/**
	 * 测试生成随机数
	 * 产生的随机数是 0 - 1 之间的一个 double，即 0 <= random <= 1
	 */
    @Test
    public void test(){
	    for (int i = 0; i < 10; i++) {
		    System.out.println(Math.random());
	    }
    }

	@Test
	public void test111(){
    System.out.println(getResult(new Integer[] {1, 2}));
	}

	public static List<Integer> getResult(Integer ... params){
		 return Arrays.stream(params).map(param -> param + 1).collect(Collectors.toList());

	}

	@Test
	public void test11(){
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			System.out.println(random.nextInt());
		}
	}

	@Test
	public void test22(){
		// Creates a 64 chars length random string of number.
		String result = RandomStringUtils.random(4, true, true);
		System.out.println("random = " + result);

		// Creates a 64 chars length of random alphabetic string.
		result = RandomStringUtils.randomAlphabetic(64);
		System.out.println("random = " + result);

		// Creates a 32 chars length of random ascii string.
		result = RandomStringUtils.randomAscii(32);
		System.out.println("random = " + result);

		// Creates a 32 chars length of string from the defined array of
		// characters including numeric and alphabetic characters.
		result = RandomStringUtils.random(32, 0, 20, true, false, "qw32rfHIJk9iQ8Ud7h0X".toCharArray());
		System.out.println("random = " + result);
	}














}
