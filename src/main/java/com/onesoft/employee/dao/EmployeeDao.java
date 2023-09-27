package com.onesoft.employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onesoft.employee.entity.Employee;
import com.onesoft.employee.repository.EmployeeRepository;
@Repository
public class EmployeeDao {
@Autowired
EmployeeRepository employeerepository;
	public String insertEmployee(Employee e) {
		 employeerepository.save(e);
		 return "ADD PANNITAN ";
	}
	public String addallEmployee(List<Employee> f) {
		employeerepository.saveAll(f);
		return "ELLAM SAVE PANNITAN ";
	}
	
	public Employee getones(int x) {
		return employeerepository.findById(x).get();
	}
	public List<Employee> getbyall() {
		return employeerepository.findAll();
	}
	public String getimprove(Employee update) {
		 employeerepository.save(update);
		 return "inga enna pakkura update pannitan poi paru";
	}
	public String del(int a) {
		employeerepository.deleteById(a);
		return "inna thala delete pannitan thala";
	}
	public List<Employee> getSal(int a, int b) {
		return employeerepository.getSal(a,b);
	}
	public List<Employee> getbyage(int a) {
		return employeerepository.getbyage(a);
	}
	public List<Employee> getname(String name) {
		return employeerepository.getname(name);
	}
	public List<Employee> getbygender(String gender) {
		return employeerepository.getbygender(gender);
	}
	public List<Employee> getbysalary(int salary) {
		return employeerepository.getbysalary(salary);
	}
	
    
}
