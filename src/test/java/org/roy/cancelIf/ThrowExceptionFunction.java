package org.roy.cancelIf;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021/12/14 19:40
 */
@FunctionalInterface
public interface ThrowExceptionFunction {

    /**
     * 抛出异常信息
     *
     * @param message 异常信息
     * @return void
     **/
    void throwMessage(String message);
}


