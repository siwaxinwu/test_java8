package org.roy.testenum;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2022/2/16 10:45
 */
public enum StatusEnum1 {
    RED(1) ,
    GREEN(2) ,
    YELLOW(3) ;
    private Integer code;

    private StatusEnum1(Integer code){
        this.code = code;
    }
}
