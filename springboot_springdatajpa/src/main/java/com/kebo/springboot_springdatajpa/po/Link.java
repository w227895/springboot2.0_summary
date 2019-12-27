package com.kebo.springboot_springdatajpa.po;

import lombok.Data;

import javax.persistence.*;

/**
 * @description:
 * @Author: kb
 * @Date: 2019-12-27 15:30
 */
@Entity
@Data
@Table(name="link")
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer linkId;
    private Integer employeeId;
    private Integer salaryId;
}
