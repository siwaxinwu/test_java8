package org.roy.net;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2022/1/26 10:57
 */
public class NetTest {

    /**
     * 测试获取本机IP
     *
     */
    @Test
    public void test1() {
        String localIp = NetUtils.getLocalIp();
        System.out.println(localIp);
    }

    @Test
    public void test2() {
        String str = "【话题回听】测试渠道";
        String substring = str.substring(6);
    System.out.println(substring);
    }



}
