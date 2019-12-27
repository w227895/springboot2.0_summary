package com.kebo.springboot_springdatajpa.dao;

import com.alibaba.fastjson.JSONObject;
import com.kebo.springboot_springdatajpa.po.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @Author: kb
 * @Date: 2019-12-27 09:44
 */
@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {
    //@Query是用来配置自定义SQL的注解，后面参数nativeQuery = true才是表明了使用原生的sql，如果不配置，默认是false，则使用HQL查询方式。
    //HRL查询，查询全部信息，注意HRL查询的是实体类的名称，不是数据表的名称，特别注意这一点
    @Modifying//修改和删除一定要加这个标签
    @Query(value = "update employee set employee_address=?1 where employee_id =?2",nativeQuery = true)
    int updateAddress(String address,Integer id);

    @Query(value = "select * from employee where employee_address like %:address%",nativeQuery = true)
    Page<Employee> findPage(Pageable pageable, @Param("address")String address);

    @Query(value = "select * from employee where employee_address like %:address% ORDER by employee_age",nativeQuery = true)
    Page<Employee> findPageSort(Pageable pageable, @Param("address")String address);

    @Query(value = "SELECT employee.*,salary.salary_amount\n" +
            "FROM employee ,salary,link \n" +
            "WHERE employee.employee_id=link.employee_id\n" +
            "AND salary.salary_id=link.salary_id",nativeQuery = true)
    Page<JSONObject> findAllEmployeePart(Pageable pageable);
}
