package org.cloud.ssh.dao;

import java.util.List;

import org.cloud.ssh.entity.Employee;

public interface EmployeeDao {
	void addEmployee(Employee employee);

    List<Employee> listEmployee();
    
    void deleteEmployee(long employeeID);
    
    void updateEmployee(Employee employee);

    Employee getEmployee(long employeeID);
}
