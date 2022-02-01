package org.roy.guavatest;

import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2022/1/21 23:23
 */
public class SetOperationTest {
    public void testDifference(){
        Set<String> set = Sets.newHashSet("tom", "jack", "roy");
        Set<String> set1 = Sets.newHashSet("jack", "lucy", "roy");
        Sets.SetView<String> difference = Sets.difference(set, set1);

    }
}
