package org.cloud.ssh.service;

import java.util.List;

import org.cloud.ssh.entity.Employee;

public interface EmployeeService {
	void addEmployee(Employee employee);

	List<Employee> listEmployee();

	void deleteEmployee(long employeeID);

	Employee getEmployee(long employeeID);

	void updateEmployee(Employee employee);
}
