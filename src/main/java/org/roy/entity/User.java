package org.roy.entity;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021/11/6 22:21
 */
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
