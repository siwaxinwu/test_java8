package org.roy;

/**
 * 枚举实现单例模式
 * @author dingyawu
 * @version 1.0
 * @date created in 2021-08-17 19:48
 */
public enum SingleEnum {
    INSTANCE;

    public void print(String word) {
        System.out.println(word);
    }
}

