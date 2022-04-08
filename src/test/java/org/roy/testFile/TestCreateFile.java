package org.roy.testFile;

import java.io.File;
import java.io.IOException;

/**
 * @description: 创建一个文件有两个步骤
 * 1.创建文件对象
 * 2.创建真正的文件
 * 绝对路径：完整路径，从根目录开始
 * @author: Ding Yawu
 * @create: 2022/3/11 21:09
 */
public class TestCreateFile {
  public static void main(String[] args) throws IOException {
      //创建文件对象的时候，文件还没有创建，构造参数绝对路径和相对路径多可以，只要不是完整的路径都是相对路径
      File file = new File("/Users/xmly/Desktop/coderepo/test_java8/sql/newTest.txt");
      //创建真正的文件
      file.createNewFile();
      System.out.println(file.getAbsolutePath());

      //默认的是当前项目的目录，而不是这个类文件的目录
      File file1 = new File("test1.txt");
      System.out.println(file1.getAbsolutePath());
  }
}
