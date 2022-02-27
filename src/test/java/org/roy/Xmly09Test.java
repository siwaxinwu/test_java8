package org.roy;

import org.junit.Test;
import org.roy.entity.Employee;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Xmly09Test {
  /**
   * 测试atomicinteger
   *
   */
  @Test
  public void test1() {
    HashMap<Integer, AtomicInteger> hashMap = new HashMap<>();
    hashMap.put(1, new AtomicInteger(1));
    System.out.println(hashMap.get(1));
    hashMap.get(1).set(2);
    System.out.println(hashMap.get(1));
  }
  @Test
  public void test11() {
    // 把byte 转化为两位十六进制数


  }
  public static String toHex(byte b) {
    String result = Integer.toHexString(b & 0xFF);
    if (result.length() == 1) {
      result = '0' + result;
    }
    return result;
  }
  @Test
  public void testHex4() throws UnsupportedEncodingException {
    byte tByte = 23;
    byte[] bytes = new byte[2];
    bytes[0] = 40;
    bytes[1] = 41;
    /*String tString = Integer.toBinaryString((tByte & 0xFF) + 0x100).substring(5);
    Integer integer = Integer.valueOf(tString, 2);
    System.out.println(integer);*/

    String s=new String(bytes,"ascii");//第二个参数指定编码方式
    System.out.print(s);
  }



}
