package org.cloud.ssh.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.cloud.ssh.entity.Employee;
import org.cloud.ssh.service.EmployeeService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee> {
private static final long serialVersionUID = 1L;
    
    private EmployeeService employeeService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    private Employee employee;
    
    private Object result;

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    // list all customers
    public String listEmployee() throws Exception {
        List<Employee> listEmployee = employeeService.listEmployee();
        //ObjectMapper mapper = new ObjectMapper();
        result = listEmployee;
        return SUCCESS;
    }

    // save customer
    public String addEmployee() throws Exception {
    	employeeService.addEmployee(employee);
        return SUCCESS;
    }
    
    // delete customer
    public String deleteEmployee() throws Exception {
    	employeeService.deleteEmployee(employee.getId());
        return SUCCESS;
    }
    
    // delete customer
    public String getEmployee() throws Exception {
    	ActionContext context = ActionContext.getContext();
    	HttpServletRequest request = (HttpServletRequest) context
                .get(ServletActionContext.HTTP_REQUEST);
    	String id = request.getParameter("id");
    	result = employeeService.getEmployee(Long.parseLong(id));
        return SUCCESS;
    }
    
    // update customer
    public String updateEmployee() throws Exception {
    	employeeService.updateEmployee(employee);
        return SUCCESS;
    }

    @Override
    public Employee getModel() {
        if(employee == null){
            employee = new Employee();
        }
        return employee;
    }

}
