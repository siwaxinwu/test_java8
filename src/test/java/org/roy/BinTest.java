package org.roy;

import org.junit.Test;

import java.math.BigDecimal;

public class BinTest {

    /**
     * 判断一个数是不是奇偶数
     *
     */
    @Test
    public void test1Scale() {
        int n = 77;
        System.out.println(n & 1);
        if ((n & 1) == 1){
        System.out.println("n是个奇数");
        }
    }


    /**
     * 交换两个数
     *
     */@Test
    public void swap() {
        System.out.println(Double.longBitsToDouble(0x4073A7851EB851ECL));
    }

    @Test
    public void swap1() {
        for (int i = 0; i < 3; i++) {
            while (true){
                break;
            }
            System.out.println("skip while");
        }
        System.out.println("skip for");
    }
}
