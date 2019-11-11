package org.cloud.ssh.dao.impl;

import java.util.List;

import org.cloud.ssh.dao.EmployeeDao;
import org.cloud.ssh.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(employee);
		tx.commit();
		session.close();
	}

	@Override
	public List<Employee> listEmployee() {
		Session session = sessionFactory.openSession();
		// HQL
		String hql = "from Employee s order by s.id";
		List<Employee> res = session.createQuery(hql, Employee.class).list();
		session.close();
		return res;
	}

	@Override
	public void deleteEmployee(long employeeID) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		// SQL
		String sql = "select * from t_employee where id = :id";
		Query<Employee> query = session.createNativeQuery(sql, Employee.class).setParameter("id", employeeID);
		Employee employee = query.uniqueResult();
		session.delete(employee);
		tx.commit();
		session.close();
	}

	@Override
	public void updateEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(employee);
		tx.commit();
		session.close();
	}

	@Override
	public Employee getEmployee(long employeeID) {
		Session session = sessionFactory.openSession();
		//Query<Employee> query = session.createNamedQuery("getEmployeeById", Employee.class);
		Query<Employee> query = session.createNamedQuery("getEmployeeByID", Employee.class);
        query.setParameter("id", employeeID);
        Employee employee = query.uniqueResult();
		session.close();
		return employee;
	}

}
