package org.roy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * description：
 * author：dingyawu
 * date：created in 9:11 2020/10/29
 * history:
 */

@AllArgsConstructor
@ToString
public enum Light {

    RED(1, "红色") ,

    GREEN(2, "绿色") ,

    YELLOW(3, "黄色") ;

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}