package org.cloud.ssm.controller;

import org.cloud.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employeeList")
	public String employeeList() {
		return "employeeList";
	}

	@GetMapping("/employeeChange")
	public String employeeAddChange() {
		return "employeeChange";
	}

	@GetMapping("/employeeChange/{id}")
	public String employeeUpdateChange(ModelMap model, @PathVariable("id") Long id) {
		model.addAttribute("employee", employeeService.getEmployee(id));
		return "employeeChange";
	}
}
