package org.roy.enumstest.optimize;

/**
 * @description: 带有枚举值以及枚举名称的枚举接口
 * @author: Ding Yawu
 * @create: 2021/2/20 15:42
 */
public interface CodeMsgEnum<T> extends CodeEnum<T> {
    /**
     * 获取枚举名称
     *
     * @return 枚举名
     */
    String getMsg();
}
