package org.cloud.ssm.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-mvc.xml", "classpath:spring/applicationContext.xml" })
@WebAppConfiguration("src/main/webapp")
public class EmployeeControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testListEmployee() throws Exception {
		// 发送请求，获取请求结果
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/rest/employee/listEmployee")
				.contentType("text/html")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
		System.out.println(mvcResult.getResponse().getContentAsString());
	}
	
	@Test
	public void testAddEmployee() throws Exception {
		// 发送请求，获取请求结果
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/rest/employee/addEmployee")
				.param("id", "")
				.param("name", "sun")
				.param("address", "shanghai")
				.param("age", "40")
				.contentType("text/html")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
		System.out.println(mvcResult.getResponse().getContentAsString());
	}
	
	@Test
	public void testDeleteEmployee() throws Exception {
		// 发送请求，获取请求结果
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/rest/employee/deleteEmployee")
				.param("id", "1")
				.contentType("text/html")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
		System.out.println(mvcResult.getResponse().getContentAsString());
	}
	
	@Test
	public void testGetEmployee() throws Exception {
		// 发送请求，获取请求结果
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/rest/employee/getEmployee")
				.param("id", "2")
				.contentType("text/html")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
		System.out.println(mvcResult.getResponse().getContentAsString());
	}
	
	@Test
	public void testUpdateEmployee() throws Exception {
		// 发送请求，获取请求结果
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/rest/employee/updateEmployee")
				.param("id", "2")
				.param("name", "sun2")
				.param("address", "shanghai2")
				.param("age", "40")
				.contentType("text/html")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
		String result = mvcResult.getResponse().getContentAsString();
		Assert.assertEquals("success", result);
		System.out.println(mvcResult.getResponse().getContentAsString());
	}

}
