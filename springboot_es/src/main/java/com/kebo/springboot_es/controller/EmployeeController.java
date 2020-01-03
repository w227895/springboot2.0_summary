package com.kebo.springboot_es.controller;

import com.kebo.springboot_es.po.Employee;
import com.kebo.springboot_es.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @Author: kb
 * @Date: 2020-01-02 16:34
 */
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("add")
    public String add(/*@RequestBody Employee employee*/) {
        Employee employee = new Employee();
        for (int i = 1; i < 50; i++) {
            employee.setId(i+"");
            employee.setAge(i);
            employee.setFirstName("kebo");
            employee.setLastName("huanghui");
            employee.setAbout("kamoji");
            employeeService.add(employee);
        }
        return "success";
    }

    @DeleteMapping("delete")
    public String delete() {
        employeeService.delete("1");
        return "success";
    }

}
