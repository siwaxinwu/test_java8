package org.roy.cancelIf;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021/12/14 19:50
 */
@FunctionalInterface
public interface BranchHandle {

    /**
     * 分支操作
     *
     * @param trueHandle 为true时要进行的操作
     * @param falseHandle 为false时要进行的操作
     * @return void
     **/
    void trueOrFalseHandle(Runnable trueHandle, Runnable falseHandle);

}