package org.roy;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.MapUtils;
import org.junit.Test;
import org.roy.entity.Menu;

import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * 队列的测试
 *
 * @author xmly
 * @date 2021/09/22
 */
public class QueueTest {
  /**
   * 默认自然排序
   *
   */
  @Test
  public void testQueue() {
      PriorityBlockingQueue<Integer> queue=new PriorityBlockingQueue<Integer>(5);
      Random random = new Random();
      System.out.println("add:");
      for (int i = 0; i < 5; i++) {
          int j = random.nextInt(100);
          System.out.print(j+"  ");
          queue.offer(j);
      }
    // 查看运行结果，可以看到输出顺序与插入顺序是不同的，默认情况下最终会按照自然排序的顺序进行输出：
    System.out.println("\r\npoll:");
      for (int i = 0; i < 5; i++) {
          System.out.print(queue.poll()+"  ");
      }
  }

    /**
     * 队列降序排序
     *
     */
    @Test
    public void testQueue1() {
        PriorityBlockingQueue queue=new PriorityBlockingQueue<Integer>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        Random random = new Random();
        System.out.println("add:");
        for (int i = 0; i < 5; i++) {
            int j = random.nextInt(100);
            System.out.print(j+"  ");
            queue.offer(j);
        }
        // 查看运行结果，可以看到输出顺序与插入顺序是不同的，默认情况下最终会按照自然排序的顺序进行输出：
        System.out.println("\r\npoll:");
        for (int i = 0; i < 5; i++) {
            System.out.print(queue.poll()+"  ");
        }
    }

    @Test
    public void test12(){
        AtomicLong a = new AtomicLong(1L);
        AtomicLong b = new AtomicLong(2L);
        long l = a.addAndGet(b.get());
    System.out.println(l);
    System.out.println(a.get());
    }

    @Test
    public void test23(){
        Map<String, String> onlineUserMap = null;
        if (MapUtils.isNotEmpty(onlineUserMap)){
            System.out.println(1);
        }
    }


}
