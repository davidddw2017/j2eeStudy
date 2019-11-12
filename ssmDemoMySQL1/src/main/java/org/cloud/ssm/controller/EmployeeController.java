package org.cloud.ssm.controller;

import java.util.List;

import org.cloud.ssm.entity.Employee;
import org.cloud.ssm.service.EmployeeService;
import org.cloud.ssm.utils.PageResultBean;
import org.cloud.ssm.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping("/list")
	public @ResponseBody 
	PageResultBean<Employee> listEmployee(
			@RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "10") int limit) {
		List<Employee> emps = service.getAllByPage(page, limit);
		long count = service.getCount();
		return new PageResultBean<Employee>(count, emps);
	}

	@PostMapping
	public @ResponseBody ResultBean addEmployee(@RequestBody Employee employee) {
		service.addEmployee(employee);
		return ResultBean.success();
	}

	@DeleteMapping("/{id}")
	public @ResponseBody ResultBean deleteEmployee(@PathVariable Long id) {
		service.deleteEmployee(id);
		return ResultBean.success();
	}
	
	@GetMapping("/get")
	public @ResponseBody Employee getEmployee(Employee employee) {
		return service.getEmployee(employee.getId());
	}
	
	@PutMapping
	public @ResponseBody ResultBean updateEmployee(@RequestBody Employee employee) {
		service.updateEmployee(employee);
		return ResultBean.success();
	}
	
	@PostMapping("delete")
    @ResponseBody
    public ResultBean removeEmp(@RequestBody List<String> ids) {
        for (String id : ids) {
        	service.deleteEmployee(Long.parseLong(id));
        }
        return ResultBean.success();
    }
	
}
