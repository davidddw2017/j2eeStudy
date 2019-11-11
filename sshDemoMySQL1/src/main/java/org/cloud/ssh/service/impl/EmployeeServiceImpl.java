package org.cloud.ssh.service.impl;

import java.util.List;

import org.cloud.ssh.dao.EmployeeDao;
import org.cloud.ssh.entity.Employee;
import org.cloud.ssh.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public void addEmployee(Employee employee) {
    	employeeDao.addEmployee(employee);
    }

    @Override
    public List<Employee> listEmployee() {
        return employeeDao.listEmployee();
    }

    @Override
    public void deleteEmployee(long employeeID) {
    	employeeDao.deleteEmployee(employeeID);
    }

	@Override
	public Employee getEmployee(long employeeID) {
		return employeeDao.getEmployee(employeeID);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}

}
