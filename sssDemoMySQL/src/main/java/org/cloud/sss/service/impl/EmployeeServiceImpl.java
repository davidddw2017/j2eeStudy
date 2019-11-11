package org.cloud.sss.service.impl;

import java.util.List;

import org.cloud.sss.dao.EmployeeDao;
import org.cloud.sss.entity.Employee;
import org.cloud.sss.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public void addEmployee(Employee employee) {
    	employeeDao.save(employee);
    }

    @Override
    public List<Employee> listEmployee() {
        return employeeDao.findAll();
    }

    @Override
    public void deleteEmployee(long employeeID) {
    	employeeDao.deleteById(employeeID);
    }

	@Override
	public Employee getEmployee(long employeeID) {
		return employeeDao.getOne(employeeID);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.save(employee);
	}

}
