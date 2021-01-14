package org.roy.entity;

import lombok.*;

import java.io.Serializable;

/**
 * description：
 * author：dingyawu
 * date：created in 16:42 2020/7/29
 * history:
 */
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Employee implements Serializable {

    private static final long serialVersionUID = 7023397158191542673L;
    private String name;
    private Integer age;
    private Double salary;
    private Status status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Employee(String name, Integer age, Double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}
