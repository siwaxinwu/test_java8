package org.roy.enumstest.optimize;

/**
 * @description: 最简单的枚举类，即只含code的枚举
 * @author: Ding Yawu
 * @create: 2021/2/20 15:42
 */
public interface CodeEnum<T> {

    /**
     * 获取枚举值
     *
     * @return 枚举值
     */
    T getCode();
}