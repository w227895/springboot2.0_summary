package com.kebo.springboot_springdatajpa.service;

import com.alibaba.fastjson.JSONObject;
import com.kebo.springboot_springdatajpa.dao.EmployeeDao;
import com.kebo.springboot_springdatajpa.po.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description:
 * @Author: kb
 * @Date: 2019-12-27 09:47
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public List<Employee> findAll(){
        return employeeDao.findAll();
    }

    public void insertOne(Employee employee){
        employeeDao.save(employee);
    }

    //修改删除需要加上事务处理
    @Transactional
    public void updateAddress(String address,Integer id){
        employeeDao.updateAddress(address,id);
    }

    public Page<Employee> findPage(int page, int size,String address){
        //jpa的分页默认从第0页开始，有点反人类，所以这里-1
        Pageable pageable= PageRequest.of(page-1,size);
        return employeeDao.findPage(pageable,address);
    }

    public void delete(Integer id){
        employeeDao.deleteById(id);
    }

    public Page<Employee> findPageSort(int page, int size,String address){
        //jpa的分页默认从第0页开始，有点反人类，所以这里-1
        Pageable pageable= PageRequest.of(page-1,size);
        return employeeDao.findPageSort(pageable,address);
    }

    public Page<Employee> findPageS(int page, int size,String address){
        //不知道为啥，这里是表的字段，下面是类的属性（可能是因为我这里调用的是sql语句，而下面的是jpa内置语句）
       /* Hibernate: select * from employee where employee_address like ? order by employee_age asc limit ?
          Hibernate: select count(*) from employee where employee_address like ?*/
        Sort sort = new Sort(Sort.Direction.ASC, "employee_age");
        //jpa的分页默认从第0页开始，有点反人类，所以这里-1
        Pageable pageable= PageRequest.of(page-1,size,sort);
        return employeeDao.findPage(pageable,address);
    }

    public List<Employee> findAllSort(){
        /*Hibernate: select employee0_.employee_id as employee1_0_, employee0_.employee_address as employee2_0_,
        employee0_.employee_age as employee3_0_, employee0_.employee_name as employee4_0_ from employee employee0_
        order by employee0_.employee_age desc*/
        Sort sort = new Sort(Sort.Direction.DESC, "employeeAge");
        return employeeDao.findAll(sort);
    }

    public Page<JSONObject> findAllEmployeePart(int page, int size){
        Pageable pageable= PageRequest.of(page-1,size);
        return employeeDao.findAllEmployeePart(pageable);
    }


}
