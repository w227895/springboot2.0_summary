package com.kebo.springboot_es;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kebo.springboot_es.dao.EmployeeRepository;
import com.kebo.springboot_es.po.Employee;
import com.kebo.springboot_es.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootEsApplicationTests {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	public void contextLoads() {
		Page<Employee> employeePage= employeeService.findPage(1,4);
		Object obj = JSONArray.toJSON(employeePage);
		String json = obj.toString();
		System.out.println(json);
	}

	@Test
	public void testUpdate(){
		Employee employee=employeeService.selectById("2");
		employee.setFirstName("柯博");
		employeeService.update(employee);
	}

	/*@Test
	public void testSort(){
		Page<Employee> employeePage= employeeService.findPageSort();
		Object obj = JSONArray.toJSON(employeePage);
		String json = obj.toString();
		System.out.println(json);
	}*/

	@Test
	public void testFindAge(){
		List<Employee>employeeList=employeeRepository.findByAge(1);
		for (Employee employee:employeeList){
			System.out.println(employee);
		}
	}
}
