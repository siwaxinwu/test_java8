package org.roy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;

/**
 * description：
 * author：dingyawu
 * date：created in 21:34 2020/9/24
 * history:
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Leader {
    private String name;
    private double salary;


}
