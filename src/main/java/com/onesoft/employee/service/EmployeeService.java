package com.onesoft.employee.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onesoft.employee.Exception.GenderNotFoundException;
import com.onesoft.employee.Exception.InvalidAgeException;
import com.onesoft.employee.Exception.SalaryNotFoundException;
import com.onesoft.employee.Exception.InvalidAgeException;
import com.onesoft.employee.dao.EmployeeDao;
import com.onesoft.employee.entity.Employee;
@Service
public class EmployeeService {
 @Autowired
 EmployeeDao employeedao;
 
	public String insertEmployee(Employee e) throws InvalidAgeException {
		try {
		if(e.getAge()>=18) {
			return employeedao.insertEmployee(e);
		}
		else {
			 throw new InvalidAgeException("not eligible to vote");
		}
		}
		catch(InvalidAgeException f) {
			return "you are not allowed";
		}
		
	}

	public String addallEmployee(List<Employee> f)throws SalaryNotEligibleException {
		List<Employee> l=f.stream().filter(s->s.getSalary()>50000).toList();
		try {
			if(l.isEmpty()) {
				return employeedao.addallEmployee(f);
			}
			else {
				 throw new  SalaryNotEligibleException("You r not eleigible");
			}
		}
		catch(SalaryNotEligibleException a) {
			return a.getMessage();
		}
	}

	public Employee getones(int x) {
		return employeedao.getones(x);
	}

	public List<Employee> getbyall() {
		return employeedao.getbyall();
	}

	public List<Employee> getbybrand(String a) {
		List<Employee>c=getbyall();
		List<Employee>z=c.stream().filter(x->x.getName().equalsIgnoreCase(a)).collect(Collectors.toList());
		return z;
	}

	public Employee getmax() {
		List<Employee>c=getbyall();
		Employee d=c.stream().max(Comparator.comparingInt(Employee::getSalary)).get();
		return d;
		}

	public Employee getmin() {
		List<Employee>c=getbyall();
		Employee g=c.stream().min(Comparator.comparingInt(Employee::getSalary)).get();
		return g;
	}
	public String getimprove(Employee update) {
		return employeedao.getimprove(update);
	}

	public String del(int a) {
		return employeedao.del(a);
	}

	public List<Employee> getage(int age) {
		List<Employee>x=getbyall();
		return x.stream().filter(y->y.getAge()>=age).collect(Collectors.toList());
		
	}

	public List<Employee> getgender(String gender) {
       List<Employee>x=getbyall();
		return x.stream().filter(y->y.getGender().equals(gender)).collect(Collectors.toList());
	}

	public List<Employee> getsalary(int salary) {
		List<Employee>x=getbyall();
		return x.stream().filter(n->n.getSalary()==salary).collect(Collectors.toList());
	}

	public List<Employee> getsal(int a, int b) {
		return employeedao.getSal(a,b);
	}

	public List<Employee> getbyage(int a) {
		return employeedao.getbyage(a);
	}

	public List<Employee> getname(String name) throws NameNotFoundException {
		List<Employee> temp= employeedao.getname(name);
			if(temp.isEmpty()) {
		
			throw new NameNotFoundException("name is not there");
			}
		 else {
				return temp;
		}
	
}
	public List<Employee> getbygender(String gender) throws GenderNotFoundException {
		List<Employee> temp1= employeedao.getbygender(gender);
		if(temp1.isEmpty()) {
			throw new GenderNotFoundException("nee kodutha gender anga illa");
		}
		else {
			return temp1;
		}
	}

	public List<Employee> getbysalary(int salary) throws SalaryNotFoundException {
		List<Employee> temp2=employeedao.getbysalary(salary);
		if(temp2.isEmpty()) {
			throw new SalaryNotFoundException("salary illa daa");
		}
		else {
			return temp2;
		}
	}
	
}
