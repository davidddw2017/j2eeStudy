package org.cloud.ssm.mapper;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath*:spring/applicationContext.xml"})  
public class EmployeeMapperTest {
	
	@Resource  
    private EmployeeMapper employeeMapper;

	@Test
	public void testAddEmployee() {
		
	}

}
