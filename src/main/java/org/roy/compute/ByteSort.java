package org.roy.compute;

import java.io.File;

/**
 * description：字节排序，给定一个数组，[2345KB, 20M, 1T, 300G] 按照字节数排序 author：dingyawu date：created in 22:13
 * 2020/11/5 history:
 */
public class ByteSort {
  public static boolean success = false;

  public static void main(String[] args) throws InterruptedException {

    new Thread(
            new Runnable() {
              @Override
              public void run() {
                while (!success) {
                  // System.out.println("准备中。。。。。");
                  File file = new File("d:\\");
                }
                System.out.println("好了");
              }
            })
        .start();

    Thread.sleep(2000);

    new Thread(
            new Runnable() {
              @Override
              public void run() {
                success = true;
                System.out.println("准备好了");
              }
            })
        .start();

    Thread.sleep(5000);
    System.out.println("game over");
  }

  private static String[] sort11(String[] arrs) {
    for (int i = 0, length = arrs.length - 1; i < length - 1; i++) {
      for (int j = 0; j < length - i - 1; j++) {
        Long m = TurnstrToByte(arrs[j]);
        Long n = TurnstrToByte(arrs[j + 1]);
        if (m < n) {
          String str = arrs[j];
          arrs[j] = arrs[j + 1];
          arrs[j + 1] = str;
        }
      }
    }
    return arrs;
  }

  private static Long TurnstrToByte(String arr) {
    if ("M".equals(arr.lastIndexOf(arr.charAt(arr.length() - 1)))) {
      return Long.valueOf(arr.substring(0, arr.length() - 1)) * 1024 * 1024;
    }
    if ("KB".equals(arr.substring(arr.length() - 2))) {
      return Long.valueOf(arr.substring(0, arr.length() - 2)) * 1024;
    }
    if ("T".equals(arr.lastIndexOf(arr.charAt(arr.length() - 1)))) {
      return Long.valueOf(arr.substring(0, arr.length() - 1)) * 1024 * 1024 * 1024 * 1024;
    }
    if ("G".equals(arr.lastIndexOf(arr.charAt(arr.length() - 1)))) {
      return Long.valueOf(arr.substring(0, arr.length() - 1)) * 1024 * 1024 * 1024;
    }
    return Long.valueOf(arr.substring(0, arr.length() - 1));
  }
}
