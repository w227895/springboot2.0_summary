package com.kebo.springboot_es.dao;

import com.alibaba.fastjson.JSONObject;
import com.kebo.springboot_es.po.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description:
 * @Author: kb
 * @Date: 2020-01-02 16:30
 */
@Component
public interface EmployeeRepository extends ElasticsearchRepository<Employee,String> {
    Employee queryEmployeeById(String id);

    Page<Employee> findAll(Pageable pageable);

    List<Employee> findByAge(Integer age);



}
