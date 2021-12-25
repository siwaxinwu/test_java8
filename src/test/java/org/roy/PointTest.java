package org.roy;

import org.jboss.netty.util.internal.ByteBufferUtil;
import org.junit.Test;

import java.io.*;
import java.math.BigInteger;
import java.net.URL;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;


/**
 * description： 读取文件的N种方式，按行读取
 * author：dingyawu
 * date： created in 13:57 2020/10/28
 * history: */
public class PointTest {


  @Test
  public void testFile() throws Exception {
    FileInputStream input = new FileInputStream("/Users/xmly/Desktop/ximawork/chh.mp4");
    byte[] buffer = new byte[1024];
    int len = input.read(buffer);
    System.out.println(Arrays.toString(buffer));
    String str = new String(buffer);
    System.out.println(str);
    System.out.println(len);
    input.close();
  }

  @Test
  public void testFile1() throws Exception {
    //文件内容：Hello World|Hello Zimug
    //先用FileReader去读取文件，然后再在他的外面套上一层Scanner，默认按照行去读取，也可以按照自定义分隔符读取
    String fileName = "/Users/xmly/Desktop/test/roy.txt";

    try (Scanner sc = new Scanner(new FileReader(fileName))) {
      while (sc.hasNextLine()) {  //按行读取字符串
        String line = sc.nextLine();
      }
    }

    try (Scanner sc = new Scanner(new FileReader(fileName))) {
      sc.useDelimiter("\\|");  //分隔符
      while (sc.hasNext()) {   //按分隔符读取字符串
        String str = sc.next();
        System.out.println(str);
      }
    }

    //sc.hasNextInt() 、hasNextFloat() 、基础数据类型等等等等。
    //文件内容：1|2
    fileName = "/Users/xmly/Downloads/";
    try (Scanner sc = new Scanner(new FileReader(fileName))) {
      sc.useDelimiter("\\|");  //分隔符
      while (sc.hasNextInt()) {   //按分隔符读取Int
        int intValue = sc.nextInt();
        System.out.println(intValue);
      }
    }
  }


  @Test
  public void testFile2() throws Exception {
    String fileName = "/Users/xmly/Downloads/f0.flv";

    // 读取文件内容到Stream流中，按行读取
    /*
    * 如果你是需要按行去处理数据文件的内容，这种方式是我推荐大家去使用的一种方式，
    * 代码简洁，使用java 8的Stream流将文件读取与文件处理有机融合。
    * 读取成流的好处就是不要一次性吧文件加载到我们的内存之中
    * forEach获取Stream流中的行数据不能保证顺序，但速度快。如果你想按顺序去处理文件中的行数据，
    * 可以使用forEachOrdered，但处理效率会下降。
    * 或者利用CPU多和的能力，进行数据的并行处理parallel()，适合比较大的文件。
    * 也可以把Stream<String>转换成List<String>,但是要注意这意味着你要将所有的数据一次性加载到内存，
    * 要注意java.lang.OutOfMemoryError
     *
    * */
    Stream<String> lines = Files.lines(Paths.get(fileName));

    // 随机行顺序进行数据处理
    //lines.forEach(System.out::println);
    //lines.forEachOrdered(System.out::println);
    lines.parallel().forEachOrdered(System.out::println);
  }

  @Test
  public void testFile3() throws Exception {
    String fileName = "/Users/xmly/Desktop/test/roy.txt";
    /*
    * 这种方法仍然是java8 为我们提供的，如果我们不需要Stream<String>,
    * 我们想直接按行读取文件获取到一个List<String>，就采用下面的方法。
    * 同样的问题：这意味着你要将所有的数据一次性加载到内存，要注意java.lang.OutOfMemoryError
    * 适合文件不是很大，然后按行去读取
    * */
    List<String> lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
    lines.forEach(System.out::println);

  }

  @Test
  public void testFile4() throws Exception {

    String fileName = "/Users/xmly/Desktop/test/roy.txt";

    //如果是JDK11用上面的方法，如果不是用这个方法也很容易
    /*
    * 一次性的快速读取一个文件的内容转为String，
    * 该怎么办？先将数据读取为二进制数组，然后转换成String内容
    * */
    byte[] bytes = Files.readAllBytes(Paths.get(fileName));
    System.out.println(Arrays.toString(bytes));
    String content = new String(bytes, StandardCharsets.UTF_8);
    System.out.println(content);
  }

  @Test
  public void testFile5() throws Exception {

    String fileName = "/Users/xmly/Downloads/f0.flv";
    /*
    * 带缓冲的流读取，默认缓冲区8k
    * 经典的管道流的方式
    * 比较适合去读取比较大的文件
    * */
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
      String line;
      while ((line = br.readLine()) != null) {
        byte[] tmpBytes = line.getBytes("UTF-8");
        for (int i = 0; i < tmpBytes.length; i++) {
          System.out.println(tmpBytes[i]);
        }
      }
    }


  }

  @Test
  public void testFile6() throws Exception {
    String fileName = "/Users/xmly/Downloads/f0.flv";
    try (BufferedReader br =
        new BufferedReader(
            new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) {
      char[] buffer = new char[1024];
      int count = br.read(buffer);
      for (int i = 0; i < 8; i++) {
        System.out.println(String.valueOf(buffer[i]));
      }

    }
  }

  @Test
  public void testFile8() throws Exception {
    String fileName = "/Users/xmly/Downloads/f0.flv";
    try (BufferedReader br =
                 new BufferedReader(
                         new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) {
      char[] buffer = new char[1024];
      int count = br.read(buffer);
      for (int i = 0; i < 8; i++) {
        System.out.println(String.valueOf(buffer[i]));
      }

    }
  }

  /**
   * 42250050:总字节数
   * @throws Exception
   */

  @Test
  public void testFile7() throws Exception {

    ByteBuffer byteBuf = ByteBuffer.allocate(24);
    FileChannel channel = new RandomAccessFile("/Users/xmly/Downloads/f0.flv","r").getChannel();
    FileOutputStream fileOutputStream = new FileOutputStream("result.flv");
    FileChannel resultChannel = fileOutputStream.getChannel();
    byteBuf.clear(); //清空buffer
    channel.read(byteBuf);
    byteBuf.flip();
    Integer tmpInt = byte2Int(byteBuf.get(14), byteBuf.get(15), byteBuf.get(16));
    resultChannel.write(byteBuf);
    byteBuf.clear();
    byteBuf = ByteBuffer.allocate(tmpInt + 4);
    channel.read(byteBuf);
    byteBuf.flip();
    resultChannel.write(byteBuf);
    while (true){
      byteBuf.clear();
      byteBuf = ByteBuffer.allocate(11);
      int readCount = channel.read(byteBuf);
      if (readCount == -1){
        break;
      }
      //解析tag类型
      byte b0 = byteBuf.get(0);
      Integer tmpResult = byte2Int(byteBuf.get(1), byteBuf.get(2), byteBuf.get(3));
      //resultChannel.write(byteBuf);
      byteBuf = ByteBuffer.allocate(tmpResult + 4);
      //resultChannel.write(byteBuf);

      /*String s=new String(bytes,"ascii");//第二个参数指定编码方式
      System.out.print(s);*/
    }
  }

    @Test
    public void testFile100() throws Exception {
      int bufSize = 17775;
      byte[] bs = new byte[105];
      ByteBuffer byteBuf = ByteBuffer.allocate(17775);
      FileChannel channel = new RandomAccessFile("/Users/xmly/Downloads/f0.flv","r").getChannel();
      while(channel.read(byteBuf) != -1) {
        //123
        //byte b = byteBuf.get(17669);
        byteBuf.position(17669);
        ByteBuffer byteBuffer = byteBuf.get(bs, 0, 105);
        String s=new String(bs,"ascii");//第二个参数指定编码方式
        System.out.print(s);

        // 把文件当字符串处理，直接打印做为一个例子。

      System.out.print(new String(bs, 17670, 17775));

      }

  }

  /**
   * byte字节转化十进制
   *
   * @param b1 b1
   * @param b2 b2
   * @param b3 b3
   * @return {@link Integer}
   */
  private Integer byte2Int(byte b1, byte b2, byte b3){

    String str1 = Integer.toBinaryString((b1 & 0xFF) + 0x100).substring(1);
    String str2 = Integer.toBinaryString((b2 & 0xFF) + 0x100).substring(1);
    String str3 = Integer.toBinaryString((b3 & 0xFF) + 0x100).substring(1);
    String tmpStr = str1 + str2 + str3;
    //17488
    return Integer.parseInt(tmpStr, 2);
  }

  @Test
  public void  test111(){
    String fileName = "/Users/xmly/Downloads/f0.flv";
    readFileByBytes(fileName);
  }

  public  void readFileByBytes(String fileName) {
    File file = new File(fileName);
    InputStream in = null;

    try {
      System.out.println("以字节为单位读取文件内容，一次读多个字节：");
      // 一次读多个字节
      byte[] tempbytes = new byte[100];
      int byteread = 0;
      in = new FileInputStream(fileName);
      showAvailableBytes(in);
      // 读入多个字节到字节数组中，byteread为一次读入的字节数
      while ((byteread = in.read(tempbytes)) != -1) {
        System.out.write(tempbytes, 0, byteread);
      }
    } catch (Exception e1) {
      e1.printStackTrace();
    } finally {
      if (in != null) {
        try {
          in.close();
        } catch (IOException e1) {
        }
      }
    }
  }
  /**
   * 显示输入流中还剩的字节数
   *
   * @param in
   */
  private  void showAvailableBytes(InputStream in) {
    try {
      System.out.println("当前字节输入流中的字节数为:" + in.available());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


}