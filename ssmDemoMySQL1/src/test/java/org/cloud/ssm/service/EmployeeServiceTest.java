package org.cloud.ssm.service;

import javax.annotation.Resource;

import org.cloud.ssm.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath*:spring/applicationContext.xml"})  
public class EmployeeServiceTest {

	@Resource  
    private EmployeeService employeeService;

	@Test
	public void testAddEmployee() {
		employeeService.save(new Employee(null, "zhangshan", "beijing1", 30));
	}

}
