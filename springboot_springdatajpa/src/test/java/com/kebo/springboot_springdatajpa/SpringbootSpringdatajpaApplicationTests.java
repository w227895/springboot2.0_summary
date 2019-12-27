package com.kebo.springboot_springdatajpa;

import com.alibaba.fastjson.JSONArray;
import com.kebo.springboot_springdatajpa.po.Employee;
import com.kebo.springboot_springdatajpa.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootSpringdatajpaApplicationTests {

	@Autowired
	private EmployeeService employeeService;

	@Test
	public void testFindAll() {
		System.out.println(employeeService.findAll());
	}

	@Test
	public void testSave(){
		employeeService.insertOne(new Employee("令狐冲",15,"思过崖"));
	}

	@Test
	public void testupdateAddress(){
		employeeService.updateAddress("光明顶",3);
	}

	@Test
	public void testFindPage(){
		Page<Employee> employeePage=employeeService.findPage(1,1,"思过崖");
		Object obj = JSONArray.toJSON(employeePage);
		String json = obj.toString();
		System.out.println(json);
	}

	@Test
	public void testDelete(){
		employeeService.delete(4);
	}

	@Test
	public void testFindPageSort(){
		Page<Employee> employeePage=employeeService.findPageSort(1,3,"思过崖");
		Object obj = JSONArray.toJSON(employeePage);
		String json = obj.toString();
		System.out.println(json);
	}

	@Test
	public void testFindPageS(){
		Page<Employee> employeePage=employeeService.findPageS(1,3,"思过崖");
		Object obj = JSONArray.toJSON(employeePage);
		String json = obj.toString();
		System.out.println(json);
	}

	@Test
	public void testFindAllSort(){
		List<Employee>employeeList=employeeService.findAllSort();
		System.out.println(employeeList);
	}

	@Test
	public void testFindAllEmployeePart(){
		Page<com.alibaba.fastjson.JSONObject> employeePage=employeeService.findAllEmployeePart(1,4);
		Object obj = JSONArray.toJSON(employeePage);
		String json = obj.toString();
		System.out.println(json);
	}
}
