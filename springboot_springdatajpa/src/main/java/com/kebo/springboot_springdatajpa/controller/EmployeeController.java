package com.kebo.springboot_springdatajpa.controller;

import com.kebo.springboot_springdatajpa.po.Employee;
import com.kebo.springboot_springdatajpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @Author: kb
 * @Date: 2019-12-27 11:06
 */
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/findAll")
    public Page<Employee> findAll(int page, int size,String address){
        return employeeService.findPage(page,size,address);
    }
}
