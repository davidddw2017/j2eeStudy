package org.cloud.ssh.service.impl;

import java.util.List;

import org.cloud.ssh.dao.EmployeeDao;
import org.cloud.ssh.entity.Employee;
import org.cloud.ssh.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeMapper;

    @Override
    public void addEmployee(Employee employee) {
        employeeMapper.addEmployee(employee);
    }

    @Override
    public List<Employee> listEmployee() {
        return employeeMapper.listEmployee();
    }

    @Override
    public void deleteEmployee(long employeeID) {
        employeeMapper.deleteEmployee(employeeID);
    }

	@Override
	public Employee getEmployee(long employeeID) {
		return employeeMapper.getEmployee(employeeID);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeMapper.updateEmployee(employee);
	}

}
