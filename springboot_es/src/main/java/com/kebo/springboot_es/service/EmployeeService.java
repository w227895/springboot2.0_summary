package com.kebo.springboot_es.service;

import com.alibaba.fastjson.JSONObject;
import com.kebo.springboot_es.dao.EmployeeRepository;
import com.kebo.springboot_es.po.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @Author: kb
 * @Date: 2020-01-02 16:31
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public void add(Employee employee){
        employeeRepository.save(employee);
    }

    public void delete(String id){
        employeeRepository.deleteById(id);
    }

    public Page<Employee> findPage(int page, int size){
        //jpa的分页默认从第0页开始，有点反人类，所以这里-1
        Pageable pageable= PageRequest.of(page-1,size);
        return employeeRepository.findAll(pageable);
    }

    public void update(Employee employee){
        employeeRepository.save(employee);
    }

    public Employee selectById(String id){
        return employeeRepository.queryEmployeeById(id);
    }

   /* public Page<Employee> findPageSort(){
        Sort sort = new Sort(Sort.Direction.ASC, "age");
        //jpa的分页默认从第0页开始，有点反人类，所以这里-1
        Pageable pageable= PageRequest.of(page-1,size);
        return employeeRepository.f
    }*/
}
