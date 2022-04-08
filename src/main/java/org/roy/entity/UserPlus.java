package org.roy.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2022/3/22 15:04
 */
@Data
@Getter
@Setter
@ToString
public class UserPlus {
    private String name;
    private User user;

}
