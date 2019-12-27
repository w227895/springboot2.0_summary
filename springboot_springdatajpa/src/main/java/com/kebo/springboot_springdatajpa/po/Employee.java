package com.kebo.springboot_springdatajpa.po;

import lombok.Data;

import javax.persistence.*;

/**
 * @description:
 * @Author: kb
 * @Date: 2019-12-27 09:33
 */
@Entity
@Data
//Lombok的data标签不能加构造方法，所以需要自己加
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*JPA为开发人员提供了四种主键生成策略,其被定义在枚举类GenerationType中,
    包括GenerationType.TABLE,GenerationType.SEQUENCE,GenerationType.IDENTITY
    和GenerationType.AUTO*/
    private Integer employeeId;

    private String employeeName;

    private Integer employeeAge;

    private String employeeAddress;

    public Employee(String employeeName, Integer employeeAge, String employeeAddress) {
        this.employeeName = employeeName;
        this.employeeAge = employeeAge;
        this.employeeAddress = employeeAddress;
    }

    public Employee() {
    }
}
