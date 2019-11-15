package org.cloud.ssm.service.impl;

import org.cloud.ssm.entity.Employee;
import org.cloud.ssm.mapper.EmployeeMapper;
import org.cloud.ssm.service.EmployeeService;
import org.cloud.ssm.utils.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends BaseServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
