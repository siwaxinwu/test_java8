package org.roy;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;
import org.roy.entity.Employee;
import org.roy.entity.Light;
import org.roy.entity.User;

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

	@Test
	public void test23(){
		byte[] bytes=new byte[3];
		bytes[0] = (byte) 0;
		bytes[1] = (byte) 3;
		bytes[2] = (byte) 34;
		Integer result = byteArray2Int(bytes[0],bytes[1], bytes[2]);
		System.out.println(result);
		byte[] result1 = int2Bytes(result);
		System.out.println(Arrays.toString(result1));

	}


	public static byte[] int2Bytes(int param) {
		byte[] bytes=new byte[4];
		bytes[0] = (byte) (param>>24);
		bytes[1] = (byte) (param>>16);
		bytes[2] = (byte) (param>>8);
		bytes[3] = (byte) (param);
		return bytes;
    }

	public static Integer byteArray2Int(Byte ... bytes){
		String tmpStr = Arrays.stream(bytes)
				.map(byteEle -> Integer.toBinaryString((byteEle & 0xFF) + 0x100).substring(1))
				.collect(Collectors.joining());
		return Integer.parseInt(tmpStr, 2);
	}


	public static void testtt(int number){
		number = 10;
	}

	public static void testUser(User user){
		user.setName("roy");
	}

	@Test
	public void test232(){
    	String userName = "tom";
		User user = new User();
		user.setName(userName);
		testUser(user);
		System.out.println(user);
    	System.out.println(userName);
	}














}
