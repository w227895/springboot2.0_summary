package com.kebo.springboot_springdatajpa.po;

import lombok.Data;

import javax.persistence.*;

/**
 * @description:
 * @Author: kb
 * @Date: 2019-12-27 15:26
 */
@Entity
@Data
@Table(name="salary")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*JPA为开发人员提供了四种主键生成策略,其被定义在枚举类GenerationType中,
    包括GenerationType.TABLE,GenerationType.SEQUENCE,GenerationType.IDENTITY
    和GenerationType.AUTO*/
    private Integer salaryId;

    private double salaryAmount;

    private String salaryName;

    public Salary(Integer salaryId,double salaryAmount, String salaryName) {
        this.salaryId=salaryId;
        this.salaryAmount = salaryAmount;
        this.salaryName = salaryName;
    }

    public Salary() {
    }
}
